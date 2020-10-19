package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

/*
MVC (2)
1. Создай пакет controller, в котором создай класс Controller.
Этот класс будет получать запрос от клиента, оповещать Модель об этом, а Модель, в свою очередь, будет обновлять ModelData.

2. Добавь в контроллер поле Model model вместе с сеттером.

3. В контроллере создай публичный метод void onShowAllUsers(), который должен обратиться к модели и инициировать загрузку пользователей.

4. Создай пакет view. В нем создай интерфейс View.

5. В интерфейс View добавь два метода: void refresh(ModelData modelData) и void setController(Controller controller)


Требования:
1. Класс Controller должен быть создан в пакете controller.
2. В классе Controller должно быть создано приватное поле Model model и сеттер для этого поля.
3. В классе Controller должен быть создан публичный метод void onShowAllUsers(), в котором у модели должен вызываться метод loadUsers().
4. Интерфейс View должен быть создан в пакете view.
5. В интерфейсе View должны быть объявлены два метода: void refresh(ModelData modelData) и void setController(Controller controller).
 */

/*
MVC (3)

5. В классе Controller должно быть создано приватное поле UsersView usersView и сеттер для этого поля. Геттера для этого поля не должно быть создано.
6. В методе onShowAllUsers() класса Controller должен вызываться метод refresh у объекта usersView с параметром model.getModelData() после вызова метода loadUsers().
*/
public class Controller {
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void onShowAllUsers(){
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }

    public void onOpenUserEditForm(long userId) {
        model.loadUserById(userId);
        editUserView.refresh(model.getModelData());
    }

    public void onUserDelete(long id){
        model.deleteUserById(id);
        usersView.refresh(model.getModelData());
    }

    public void onUserChange(String name, long id, int level){
        model.changeUserData(name, id, level);
        usersView.refresh(model.getModelData());
    }

}
