package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.*;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap();

    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)){
            ConsoleHelper.writeMessage("Чат сервер запущен.");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка создания серверного соединения или работы сервера.");
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> connection:connectionMap.entrySet()) {
            try {
                connection.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Сервер не смог отправить сообщение " + connection.getValue().getRemoteSocketAddress());
            }
        }
    } //sendBroadcastMessage


    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true){
              connection.send(new Message(MessageType.NAME_REQUEST, "Введите имя пользователя: "));
              Message messageReceive = connection.receive();
              if (messageReceive.getType() != MessageType.USER_NAME) {
                  ConsoleHelper.writeMessage("Получено сообщение от "+connection.getRemoteSocketAddress()+ ". Запрошенный тип сообщения != MessageType.USER_NAME, повторяем запрос.");
                  continue;
              }
              String userName = messageReceive.getData();
              if (userName.length() == 0) {
                  ConsoleHelper.writeMessage("Запрошенное имя пользователя пустое, повторяем запрос.");
                  continue;
              }

              if (connectionMap.containsKey(userName)) {
                  ConsoleHelper.writeMessage("Такое имя пользователя уже есть, повторяем запрос.");
                  continue;
              }

              //Если в мапе нет такого имени, то добавляем
              connectionMap.put(userName, connection);
              connection.send(new Message(MessageType.NAME_ACCEPTED, "Имя пользователя "+userName+" принято!"));
              return userName;
            }
        } //serverHandshake

        private void notifyUsers(Connection connection, String userName) throws IOException{
            for (Map.Entry<String, Connection> conn:connectionMap.entrySet()) {
                try {
                    if (! userName.equals(conn.getKey())) {
                        connection.send(new Message(MessageType.USER_ADDED, conn.getKey()));
                    }
                } catch (IOException e) {
                    ConsoleHelper.writeMessage("Сервер не смог отправить сообщение MessageType.USER_ADDED адресату " + conn.getValue().getRemoteSocketAddress());
                }
            }
        } //notifyUsers

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message messageReseive = connection.receive();
                if (messageReseive.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName +": "+messageReseive.getData()));
                }
                else{
                    ConsoleHelper.writeMessage("Ошибка: Тип сообщения от "+connection.getRemoteSocketAddress()+ " не является MessageType.TEXT.");
                }
            }
        } //serverMainLoop

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено новое соединение с удаленным адресом "+socket.getRemoteSocketAddress()+ ".");
            String userName = null;
            try (Connection connection = new Connection(socket)){
                //Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента.
                userName = serverHandshake(connection);
                //Разослать всем участникам чата информацию об имени присоединившегося участника
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                //Сообщить новому участнику о существующих участниках.
                notifyUsers(connection, userName);
                //Запустить главный цикл обработки сообщений сервером.
                serverMainLoop(connection, userName);

            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Ошибка при обмене данными с " + socket.getRemoteSocketAddress());
            }
            //Удалить запись для этого имени из connectionMap и разослать всем остальным участникам сообщение с типом USER_REMOVED и сохраненным именем.
            if (userName != null) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }
            ConsoleHelper.writeMessage("Соединение с " + socket.getRemoteSocketAddress() + " закрыто.");
        }

    } //class Handler



}

/*
Чат (11)
Пришло время написать главный метод класса Handler, который будет вызывать все вспомогательные методы, написанные ранее.
Реализуем метод void run() в классе Handler.

Он должен:
1. Выводить сообщение, что установлено новое соединение с удаленным адресом, который можно получить с помощью метода getRemoteSocketAddress().
2. Создавать Connection, используя поле socket.
3. Вызывать метод, реализующий рукопожатие с клиентом, сохраняя имя нового клиента.
4. Рассылать всем участникам чата информацию об имени присоединившегося участника (сообщение с типом USER_ADDED).
Подумай, какой метод подойдет для этого лучше всего.
5. Сообщать новому участнику о существующих участниках.
6. Запускать главный цикл обработки сообщений сервером.
7. Обеспечить закрытие соединения при возникновении исключения.
8. Отловить все исключения типа IOException и ClassNotFoundException, вывести в консоль информацию, что произошла ошибка при обмене данными с удаленным адресом.
9. После того как все исключения обработаны, если п.11.3 отработал и возвратил нам имя, мы должны удалить запись для этого имени из connectionMap и разослать всем остальным участникам сообщение с типом USER_REMOVED и сохраненным именем.
10. Последнее, что нужно сделать в методе run() - вывести сообщение, информирующее что соединение с удаленным адресом закрыто.

Наш сервер полностью готов. Попробуй его запустить.


Требования:
1. Метод run() должен выводить на экран сообщение о том, что было установлено соединение с удаленным адресом (используя метод getRemoteSocketAddress()).
2. Метод run() должен создавать новое соединение (connection) используя в качестве параметра поле socket.
3. Метод run() должен вызывать метод serverHandshake() используя в качестве параметра только что созданное соединение; результатом будет имя пользователя (userName).
4. Метод run() должен вызывать метод sendBroadcastMessage() используя в качестве параметра новое сообщение (MessageType.USER_ADDED, userName).
5. Метод run() должен вызывать метод notifyUsers() используя в качестве параметров connection и userName.
6. Метод run() должен вызывать метод serverMainLoop используя в качестве параметров connection и userName.
7. Прежде чем завершиться, метод run() должен удалять из connectionMap запись соответствующую userName, и отправлять всем участникам чата сообщение о том, что текущий пользователь был удален.
8. Метод run() должен корректно обрабатывать исключения IOException и ClassNotFoundException.


Чат (10)
Этап третий - главный цикл обработки сообщений сервером.

Добавь приватный метод void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException,
где значение параметров такое же, как и у метода notifyUsers().

Он должен:
1. Принимать сообщение клиента
2. Если принятое сообщение - это текст (тип TEXT), то формировать новое текстовое сообщение путем конкатенации: имени клиента, двоеточия, пробела и текста сообщения.
Например, если мы получили сообщение с текстом "привет чат" от пользователя "Боб", то нужно сформировать сообщение "Боб: привет чат".
3. Отправлять сформированное сообщение всем клиентам с помощью метода sendBroadcastMessage().
4. Если принятое сообщение не является текстом, вывести сообщение об ошибке
5. Организовать бесконечный цикл, внутрь которого перенести функционал пунктов 10.1-10.4.


Требования:
1. В классе Handler должен быть создан метод private void serverMainLoop(Connection connection, String userName).
2. Метод serverMainLoop() должен в бесконечном цикле получать сообщения от клиента (используя метод receive() класса Connection).
3. Если сообщение, полученное методом serverMainLoop(), имеет тип MessageType.TEXT, то должно быть отправлено новое сообщение всем участникам чата используя метод sendBroadcastMessage() (форматирование сообщения описано в условии).
4. Если сообщение, полученное методом serverMainLoop(), имеет тип отличный от MessageType.TEXT, метод sendBroadcastMessage() не должен быть вызван, и должно быть выведено сообщение об ошибке.

Чат (9)
Этап второй, но не менее важный - отправка клиенту (новому участнику) информации об остальных клиентах (участниках) чата.

Для этого добавь приватный метод void notifyUsers(Connection connection, String userName) throws IOException,
где connection - соединение с участником, которому будем слать информацию, а userName - его имя.
Метод должен:
1) Пройтись по connectionMap.
2) У каждого элемента из п.1 получить имя клиента, сформировать команду с типом USER_ADDED и полученным именем.
3) Отправить сформированную команду через connection.
4) Команду с типом USER_ADDED и именем равным userName отправлять не нужно, пользователь и так имеет информацию о себе.


Требования:
1. В классе Handler должен быть создан метод private void notifyUsers(Connection connection, String userName).
2. Метод notifyUsers() должен отправлять через connection сообщение о том, что был добавлен пользователь с именем name для каждого имени из connectionMap.
3. Метод notifyUsers() НЕ должен отправлять сообщение о добавлении пользователя, если имя пользователя совпадает со вторым параметром метода (userName).


Чат (8)
Класс Handler должен реализовывать протокол общения с клиентом.
Выделим из протокола отдельные этапы и реализуем их с помощью отдельных методов:

Этап первый - это этап рукопожатия (знакомства сервера с клиентом).
Реализуем его с помощью приватного метода String serverHandshake(Connection connection) throws IOException, ClassNotFoundException.
Метод в качестве параметра принимает соединение connection, а возвращает имя нового клиента.

Реализация метода должна:
1) Сформировать и отправить команду запроса имени пользователя
2) Получить ответ клиента
3) Проверить, что получена команда с именем пользователя
4) Достать из ответа имя, проверить, что оно не пустое и пользователь с таким именем еще не подключен (используй connectionMap)
5) Добавить нового пользователя и соединение с ним в connectionMap
6) Отправить клиенту команду информирующую, что его имя принято
7) Если какая-то проверка не прошла, заново запросить имя клиента
8) Вернуть принятое имя в качестве возвращаемого значения

Требования:
1. В классе Handler должен присутствовать метод private String serverHandshake(Connection connection).
2. Метод serverHandshake должен отправлять запрос имени используя метод send класса Connection.
3. До тех пор, пока тип сообщения полученного в ответ не будет равен MessageType.USER_NAME, запрос имени должен быть выполнен снова.
4. В случае, если в ответ пришло пустое имя, запрос имени должен быть выполнен снова.
5. В случае, если имя уже содержится в connectionMap, запрос имени должен быть выполнен снова.
6. После успешного проведения всех проверок, метод serverHandshake должен добавлять новую пару (имя, соединение) в connectionMap и отправлять сообщение о том, что имя было принято.
7. Метод serverHandshake должен возвращать имя нового клиента с которым было установлено соединение.


Чат (7)
Т.к. сервер может одновременно работать с несколькими клиентами, нам понадобится метод для отправки сообщения сразу всем.

Добавь в класс Server:

1. Статическое поле Map<String, Connection> connectionMap, где ключом будет имя клиента, а значением - соединение с ним.
2. Инициализацию поля из п.7.1 с помощью подходящего Map из библиотеки java.util.concurrent,
т.к. работа с этим полем будет происходить из разных потоков и нужно обеспечить потокобезопасность.
3. Статический метод void sendBroadcastMessage(Message message), который должен отправлять сообщение message всем соединениям из connectionMap.
Если при отправке сообщение произойдет исключение IOException, нужно отловить его и сообщить пользователю, что не смогли отправить сообщение.


Требования:
1. В классе Server должно существовать статическое приватное поле connectionMap типа Map.
2. Поле connectionMap должно быть инициализировано потокобезопасной реализаций интерфейса Map из пакета java.util.concurrent.
3. В классе Server должен быть корректно реализован статический метод sendBroadcastMessage(Message message),
отправляющий сообщение всем соединениям из connectionMap.

Чат (6)
Приступим к самому важному - написанию класса Server.
Сервер должен поддерживать множество соединений с разными клиентами одновременно.
Это можно реализовать с помощью следующего алгоритма:

- Сервер создает серверное сокетное соединение.
- В цикле ожидает, когда какой-то клиент подключится к сокету.
- Создает новый поток обработчик Handler, в котором будет происходить обмен сообщениями с клиентом.
- Ожидает следующее соединение.

Добавь:

1) В класс Server приватный статический вложенный класс Handler, унаследованный от Thread.
2) В класс Handler поле socket типа Socket.
3) В класс Handler конструктор, принимающий в качестве параметра Socket и инициализирующий им соответствующее поле класса.
4) Метод main класса Server, должен:

а) Запрашивать порт сервера, используя ConsoleHelper.
б) Создавать серверный сокет java.net.ServerSocket, используя порт из предыдущего пункта.
в) Выводить сообщение, что сервер запущен.
г) В бесконечном цикле слушать и принимать входящие сокетные соединения только что созданного серверного сокета.
д) Создавать и запускать новый поток Handler, передавая в конструктор сокет из предыдущего пункта.
е) После создания потока обработчика Handler переходить на новый шаг цикла.
ж) Предусмотреть закрытие серверного сокета в случае возникновения исключения.
з) Если исключение Exception все же произошло, поймать его и вывести сообщение об ошибке.


Требования:
1. В классе Server должен быть создан приватный статический класс Handler, унаследованный от класса Thread.
2. В классе Handler должно быть создано поле socket типа Socket.
3. Конструктор класса Handler должен принимать один параметр типа Socket и инициализировать поле socket.
4. Метод main должен считывать с клавиатуры порт сервера используя метод readInt класса ConsoleHelper.
5. Метод main должен корректно реализовывать бесконечный цикл описанный в условии задачи.
 */

