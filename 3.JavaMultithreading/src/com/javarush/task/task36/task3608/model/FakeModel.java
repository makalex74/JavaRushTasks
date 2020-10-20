package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.*;

/*
MVC (1)
Привет! Эта задача будет на паттерн MVC - Model-View-Controller.
Мы вместе построим архитектуру используя MVC. Разберись подробно, что и почему нужно реализовывать так, как я тебе покажу.
Прочти дополнительную литературу, которую дает профессор в конце уровня.
Тебя, скорее всего, на собеседовании спросят об этом паттерне либо дадут задание, в котором нужно будет его реализовать.

Итак...
У тебя есть два пакета: bean, содержащий единственный класс User, и dao, в котором хранится эмуляция базы данных в пакете mock и UserDao. UserDao - это уровень ДАО, т.е. уровень доступа к базе.
В нем размещают различные методы по сохранению и получению объектов из базы данных.
В реальном приложении строку private DataSource dataSource = DataSource.getInstance() не встретить.
Я реализовал DataSource в виде синглтона. В действительности, у тебя будет что-то такое:
@Autowired
private DataSource dataSource;

Фреймворк, которым ты будешь пользоваться, сам создаст объект базы данных и инициализирует поле dataSource.

Запомни, с ДАО уровнем работают сервисы. Никакие другие классы в ДАО не лезут. В сервисах описана бизнес логика.
Сервисы забирают данные из базы используя ДАО, обрабатывают их и отдают тому, кто данные запросил.
Однако не все данные хранятся в базе. Например, залогиненый пользователь будет храниться в специальном объекте - Модели.
Объект, который содержит в себе данные, необходимые для отображения информации на клиенте, называется Моделью.
Также этот объект Модель содержит ссылки на все необходимые сервисы.
Если данных для отображения очень много, то их выделяют в отдельный объект.

Напишем приложение, которое будет показывать список пользователей и что-то делать с ними, например, обновлять их данные и удалять.

1. Создай пакет model, в котором создай класс ModelData.
ModelData - это объект, который будет хранить необходимые данные для отображения на клиенте.
Создай поле с геттером и сеттером List<User> users - это будет список пользователей для отображения.

2. Используя любую модель должна быть возможность получить все необходимые данные для отображения. Поэтому в пакете model создай интерфейс Model, который должен содержать метод ModelData getModelData().

3. В пакете model создай класс FakeModel, реализующий Model. Он нам понадобится на начальном этапе.
В нем создай поле ModelData modelData, которое инициализируй объектом.

4. В интерфейсе Model создай метод void loadUsers().
Реализуй его в FakeModel: инициализируй список пользователей modelData любыми данными. Они не влияют на тестирование.

У меня такие данные:
User{name='A', id=1, level=1}
User{name='B', id=2, level=1}

Думаю, ты помнишь, что все методы интерфейса являются public-ами, поэтому модификатор указывать не нужно.
Программисты часто мОкают данные на начальном этапе. Получение реальных данных реализуется на последних этапах.
Мокать - это подменять реальные объекты на хардкоженные, тестовые данные.


Требования:
1. Класс ModelData должен быть создан в пакете model.
2. В классе ModelData должно быть создано приватное поле List<User> users, геттер и сеттер для него.
3. Интерфейс Model должен быть создан в пакете model. В интерфейсе Model должен быть объявлен метод ModelData getModelData().
4. Класс FakeModel, реализующий интерфейс Model, должен быть создан в пакете model.
5. В классе FakeModel должно быть создано и инициализировано приватное поле ModelData modelData.
6. В интерфейсе Model должен быть объявлен метод void loadUsers().
7. Метод void loadUsers() в классе FakeModel должен инициализировать список пользователей в объекте modelData любыми данными.

 */
public class FakeModel implements Model {
    private ModelData modelData;

    public FakeModel() {
        this.modelData = new ModelData();
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = new LinkedList<>();
        users.add(new User("A",1,1));
        users.add(new User("B",2,1));
        users.add(new User("C",3,1));
        users.add(new User("D",4,2));
        users.add(new User("E",5,1));
        users.add(new User("F",6,3));
        users.add(new User("G",7,1));
        modelData.setUsers(users);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

}