package com.javarush.task.task36.task3608.model;

/*
MVC (4)
Пора заменять нашу фейковую Модель на реальную, которая будет получать данные из DataSource.
В пакет model.service я добавил сервис для работы с пользователями.
Также в корне этой задачи ты найдешь утильный класс Util.

1. Аналогично FakeModel создай модель MainModel.

2. Т.к. Модель обращается к сервисам, то в MainModel создай поле UserService userService, инициализируй объектом.

3. Реализуй логику метода loadUsers:
3.1. Достань всех пользователей между 1 и 100 уровнями. (Метод getUsersBetweenLevels(1, 100)).
3.2. Положи всех пользователей в modelData.

4. Обнови Solution.main: замени FakeModel на MainModel.
Преимущества MVC в том, что в любой момент времени легко можно заменить любую часть паттерна.


Требования:
1. Класс MainModel, реализующий интерфейс Model, должен быть создан в пакете model.
2. В классе MainModel должно быть создано и инициализировано приватное поле ModelData modelData.
3. В классе MainModel должно быть создано и инициализировано приватное поле UserService userService.
4. В классе MainModel необходимо реализовать метод getModelData.
5. Метод loadUsers класса MainModel должен быть реализован согласно условию.
6. В методе main класса Solution должен создаваться объект класса MainModel вместо объекта класса FakeModel.
 */

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    private ModelData modelData;
    private UserService userService;

    public MainModel() {
        this.modelData = new ModelData();
        this.userService = new UserServiceImpl();
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

/*
MVC (8)
3. Выполни рефакторинг класса MainModel. Теперь, когда есть удаленные пользователи, часть методов стала работать неправильно.
Почти во всех методах, где требуется список пользователей, нужно работать только с активными(живыми) пользователями.
Вынеси в отдельный приватный метод List<User> getAllUsers() получение списка всех активных пользователей.
Фильтрация активных пользователей у тебя уже есть - метод List<User> filterOnlyActiveUsers(List<User> allUsers).
Отрефактори все методы, которые используют список пользователей. Они должны использовать список живых пользователей.

Требования:
6. Необходимо реализовать приватный метод List<User> getAllUsers() в классе MainModel.
7. Необходимо выполнить рефакторинг: все методы класса MainModel, которые используют список пользователей, должны использовать список живых пользователей.
 */

    private List<User> getAllUsers(){
        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
        return userService.filterOnlyActiveUsers(modelData.getUsers());
    }


    @Override
    public void loadUsers() {
        modelData.setUsers(getAllUsers());
        modelData.setDisplayDeletedUserList(false);
    }

    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    public void deleteUserById(long id){
        userService.deleteUser(id);
        modelData.setUsers(getAllUsers());
    }

    public void changeUserData(String name, long id, int level){
        userService.createOrUpdateUser(name, id, level);
        modelData.setUsers(getAllUsers());
    }
}

