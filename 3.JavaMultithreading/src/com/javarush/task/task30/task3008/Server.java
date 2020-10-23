package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.*;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap();

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> connection:connectionMap.entrySet()) {
            try {
                connection.getValue().send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Не смогли отправить сообщение " + connection.getValue().getRemoteSocketAddress());
            }
        }

    }

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

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            while (true){
              connection.send(new Message(MessageType.NAME_REQUEST, "Введите имя пользователя: "));
              Message messageReseive = connection.receive();
              if (messageReseive.getType() != MessageType.USER_NAME) {
                  ConsoleHelper.writeMessage("Получено сообщение от "+connection.getRemoteSocketAddress()+ ". Запрошенный тип сообщения != MessageType.USER_NAME, повторяем запрос.");
                  continue;
              }
              String userName = messageReseive.getData();
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
                    if (!userName.equals(conn.getKey())) {
                        connection.send(new Message(MessageType.USER_ADDED, conn.getKey()));
                    }
                } catch (IOException e) {
                    ConsoleHelper.writeMessage("Сервер не смог отправить сообщение MessageType.USER_ADDED адресату " + conn.getValue().getRemoteSocketAddress());
                }
            }
        } //notifyUsers

    }

}

/*
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

