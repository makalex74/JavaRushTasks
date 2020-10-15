package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.FakeModel;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

/*
MVC (4)
4. Обнови Solution.main: замени FakeModel на MainModel.
Преимущества MVC в том, что в любой момент времени легко можно заменить любую часть паттерна.

Требования:
6. В методе main класса Solution должен создаваться объект класса MainModel вместо объекта класса FakeModel.
 */

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        editUserView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126);
        editUserView.fireEventUserDeleted(124L);
        editUserView.fireEventUserChanged("Ivanov", 123, 2);
        usersView.fireEventShowDeletedUsers();
    }
}

/*
MVC (9)
Это последнее задание по MVC.

1. Следуя принципу MVC аналогично реализации предыдущих методов сделай следующее:
напиши логику обновления пользователя. После обновления должен отображаться список пользователей.

Распредели методы по классам MVC, используя следующие сигнатуры публичных методов:
void fireEventUserChanged(String name, long id, int level)
void onUserChange(String name, long id, int level)
void changeUserData(String name, long id, int level)

где name и level - это новые значения для пользователя с выбранным id.

Примечание: метод, который ты собираешься добавить в Вью нужно добавить в EditUserView.

2. Добавь в main вызов fireEventUserChanged перед вызовом метода fireEventShowDeletedUsers().

3. Добавь в интерфейс Model метод, который ты поместил в Модель, реализуй его в FakeModel: выброси UnsupportedOperationException.


Требования:
1. Необходимо определить правильное расположение метода fireEventUserChanged(String name, long id, int level) и реализовать этот метод.
2. Необходимо определить правильное расположение метода onUserChange(String name, long id, int level) и реализовать этот метод.
3. Необходимо определить правильное расположение метода void changeUserData(String name, long id, int level) и реализовать этот метод.
4. В методе main необходимо вызвать метод fireEventUserChanged(String, long, int) перед вызовом метода fireEventShowDeletedUsers().
5. Интерфейс Model должен содержать объявление метода, который ты ранее реализовал в классе MainModel.
6. В классе FakeModel в теле метода, помещенного в интерфейс Model, необходимо бросить UnsupportedOperationException.


MVC (8)
1. Следуя принципу MVC аналогично реализации предыдущих методов сделай следующее:
напиши логику удаления пользователя. После удаления должен отображаться список пользователей.

Распредели следующие методы по классам MVC:
public void fireEventUserDeleted(long id)
public void onUserDelete(long id)
public void deleteUserById(long id)

Примечание: метод, который ты собираешься добавить в Вью нужно добавить в EditUserView.

2. Добавь в main вызов fireEventUserDeleted(124L) перед вызовом метода fireEventShowDeletedUsers().

3. Выполни рефакторинг класса MainModel. Теперь, когда есть удаленные пользователи, часть методов стала работать неправильно.
Почти во всех методах, где требуется список пользователей, нужно работать только с активными(живыми) пользователями.
Вынеси в отдельный приватный метод List<User> getAllUsers() получение списка всех активных пользователей.
Фильтрация активных пользователей у тебя уже есть - метод List<User> filterOnlyActiveUsers(List<User> allUsers).
Отрефактори все методы, которые используют список пользователей. Они должны использовать список живых пользователей.

4. Добавь в интерфейс Model метод, который ты поместил в Модель, реализуй его в FakeModel: выброси UnsupportedOperationException.


Требования:
1. Необходимо определить правильное расположение метода fireEventUserDeleted(long) и реализовать этот метод.
2. Необходимо определить правильное расположение метода onUserDelete(long) и реализовать этот метод.
3. Необходимо определить правильное расположение метода deleteUserById(long) и реализовать этот метод.
4. В методе main класса Solution необходимо вызвать метод fireEventUserDeleted(124L) у объекта класса EditUserView перед вызовом метода fireEventShowDeletedUsers().
5. В методе main вызов методов должен происходить в такой последовательности: fireEventShowAllUsers(), fireEventOpenUserEditForm(126L), fireEventUserDeleted(124L), fireEventShowDeletedUsers().
6. Необходимо реализовать приватный метод List<User> getAllUsers() в классе MainModel.
7. Необходимо выполнить рефакторинг: все методы класса MainModel, которые используют список пользователей, должны использовать список живых пользователей.
8. Интерфейс Model должен содержать объявление метода, который ты ранее реализовал в классе MainModel.
9. В классе FakeModel в теле метода, помещенного в интерфейс Model, необходимо бросить UnsupportedOperationException.



MVC (7)
1. Распредели методы по классам MVC:

public void onOpenUserEditForm(long userId) {
...loadUserById(userId);
...refresh(...getModelData());
}

public void fireEventOpenUserEditForm(long id) {
...onOpenUserEditForm(id);
}

public void loadUserById(long userId) {
User user = userService.getUsersById(userId);
...setActiveUser(user);
}

!!!! Пользователь видит Вью со списком пользователей, нажимает на одного из них, запрос идет на сервер, выгребаем новые данные и отображаем другую Вью, которая относится к одному выбранному пользователю.
Учти это при реализации этого задания.

2. Добавь в метод main открытие формы редактирования для пользователя с id=126 перед вызовом метода fireEventShowDeletedUsers().

3. Добавь в интерфейс Model метод, который ты поместил в Модель, реализуй его в FakeModel: выброси UnsupportedOperationException.


Требования:
1. Необходимо определить правильное расположение метода onOpenUserEditForm(long) и реализовать этот метод.
2. Необходимо определить правильное расположение метода fireEventOpenUserEditForm(long) и реализовать этот метод.
3. Необходимо определить правильное расположение метода loadUserById(long) и реализовать этот метод.
4. В методе main класса Solution необходимо вызвать метод открытия формы редактирования для пользователя с id=126 у объекта класса UsersView перед вызовом метода fireEventShowDeletedUsers().
5. Интерфейс Model должен содержать объявление метода, который ты ранее реализовал в классе MainModel.
6. В классе FakeModel в теле метода, помещенного в интерфейс Model, необходимо бросить UnsupportedOperationException.


MVC (6)
Функционал отображения удаленных пользователей есть, а самих таких пользователей нет. Давай это исправим.
Давай сделаем новую Вью, которая будет отвечать за редактирование одного конкретного пользователя.
UsersView отображает список пользователей.
EditUserView будет отображать данные о редактировании конкретного пользователя.
Для этого нам сначала нужен этот выбранный пользователь.
Как и любые данные его поместим в ModelData.

1. Создай в ModelData поле User activeUser с геттером и сеттером (Alt+Insert -> Getter and Setter).

2. Аналогично UsersView создай EditUserView.
Логика метода refresh:
2.1. Вывести в консоль "User to be edited:".
2.2. С новой строки вывести табуляцию и активного пользователя.
2.3. С новой строки вывести разделитель "===================================================".

3. Создай в контроллере поле EditUserView editUserView с сеттером.

Когда наши данные выводятся в консоль, то совсем не понятно, список каких пользователей - удаленных или нет - выводится.
Давай сделаем так, чтобы Вью отображала эту информацию. Все данные для отображения хранятся в Моделе.

Поэтому:
4. создай в ModelData поле boolean displayDeletedUserList с геттером и сеттером.

5. Измени метод refresh в UsersView так, чтобы он отображал "All users:" либо "All deleted users:"
в зависимости от того, какие пользователи находятся в списке.
Добавь в необходимые методы модели изменение displayDeletedUserList.


Требования:
1. В классе ModelData должно быть создано приватное поле User activeUser, геттер и сеттер для этого поля.
2. Класс EditUserView должен быть создан аналогично классу UsersView: он должен поддерживать интерфейс View, содержать приватное поле Controller controller и сеттер этого поля.
3. Метод refresh класса EditUserView должен быть реализован согласно условию.
4. В классе Controller должно быть создано приватное поле EditUserView editUserView и сеттер этого поля.
5. В классе ModelData должно быть создано приватное поле boolean displayDeletedUserList, геттер и сеттер для этого поля.
6. Метод refresh в классе UsersView должен быть изменен согласно условию.
7. Необходимо добавить в некоторые методы класса MainModel вызов метода setDisplayDeletedUserList(boolean) с правильным флагом.

MVC (5)
В сервисе есть метод, который возвращает всех удаленных пользователей. Давай их отобразим.

1. Распредели методы по классам MVC:

public void fireEventShowDeletedUsers() {
...onShowAllDeletedUsers();
}

public void onShowAllDeletedUsers() {
...loadDeletedUsers();
}

public void loadDeletedUsers() {
List<User> users = userService.getAllDeletedUsers();
}

Не забудь, что данные, полученные с сервера, необходимо положить в ModelData. А потом обновить view.
Добавь это самостоятельно в нужные методы.

2. Добавь в Solution.main вызов нового метода, который ты поместил в view.

3. Добавь в интерфейс Model метод, который ты поместил в Модель, реализуй его в FakeModel: выброси UnsupportedOperationException.


Требования:
1. Необходимо определить правильное расположение метода fireEventShowDeletedUsers() и реализовать этот метод.
2. Необходимо определить правильное расположение метода onShowAllDeletedUsers() и реализовать этот метод.
3. Необходимо определить правильное расположение метода loadDeletedUsers() и реализовать этот метод.
4. В методе main класса Solution необходимо вызвать метод, который ты ранее реализовал в классе UsersView.
5. Интерфейс Model должен содержать объявление метода, который ты ранее реализовал в классе MainModel.
6. В классе FakeModel в теле метода, помещенного в интерфейс Model, необходимо бросить UnsupportedOperationException.
 */