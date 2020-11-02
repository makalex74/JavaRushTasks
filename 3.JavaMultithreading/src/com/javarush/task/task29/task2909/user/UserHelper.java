package com.javarush.task.task29.task2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);

    //userAnya.setMan(false);
    //userRoma.setMan(true);

    public void printUsers() {
        userAnya.printInfo();
        userAnya.printAdditionalInfo();

        userRoma.printInfo();
        userRoma.printAdditionalInfo();
    }

    public int calculateAverageAge() {
        User userUra = new User("Юра", "Карп", 28);
        return (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;
    }

/*
6. Перепиши метод calculateRate() класса UserHelper, чтобы метод не изменял входные параметры,
    а просто возвращал рассчитанное значение (метод должен возвращать int).
*/
/*
    public void calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
        base.set(base.get() + age / 100);
        base.set((int) (base.get() * (hasWork ? 1.1 : 0.9)));
        base.set((int) (base.get() * (hasHouse ? 1.1 : 0.9)));
    }
 */
public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
    int tmpBase =  base.get() + age / 100;
    tmpBase = (int) (tmpBase * (hasWork ? 1.1 : 0.9));
    tmpBase = (int) (tmpBase * (hasHouse ? 1.1 : 0.9));
    return tmpBase;
}

    public String getBossName(User user) {
        return user.getBoss();
    }

}

/*
Рефакторинг (14)
14.1. Перемещение поля. Замени поля isManAnya и isManRoma полем man в нужном классе.
Добавь сеттер и геттер для нового поля (при выборе имен методов учти тип поля).
14.2. Извлечение класса.
14.2.1. Добавь класс Address в пакет user.
14.2.2. Перенеси поля country, city и house в новый класс.
14.2.3. Добавь сеттеры и геттеры для них.
14.2.4. Перепиши класс User, используя поле класса Address address.
14.3. Встраивание класса. Класс House почти ничего не делает, избавься от него.
14.4. Сокрытие делегирования.
14.4.1. Добавь в класс User метод getBoss().
14.4.2. Перепиши реализацию метода getBossName(User user) класса UserHelper.

Требования:
1. Необходимо заменить поля isManAnya и isManRoma класса UserHelper полем boolean man в классе User. Так же добавь сеттер и геттер для нового поля.
2. Необходимо добавить класс Address в пакет user.
3. Необходимо перенести поля country, city и house из класса User в класс Address.
4. Необходимо добавить сеттеры и геттеры для полей country, city, house класса Address.
5. В классе User необходимо переписать методы: getAddress, getCountry, setCountry, getCity, setCity. И нужно добавить в класс приватное поле Address address.
6. Необходимо избавиться от класса House. Поле класса String house нужно перенести в класс Address. Необходимо обновить геттер и сеттер поля.
7. Необходимо добавить в класс User метод getBoss() и реализовать этот метод.
8. Необходимо изменить реализацию метода getBossName(User user) класса UserHelper (используй метод getBoss() класса User).


Рефакторинг (13)
Разберись с кодом пакета user (пользователь).

13.1. Извлечение метода. Добавь метод printInfo(), который будет выводить имя и фамилию
в консоль в формате

Имя: Вася
Фамилия: Пупкин

Замени повторяющийся код метода printUsers() его вызовом.
13.2. Встраивание метода. Избавься от метода ageLessThan16().
13.3. Перемещение метода. Перемести методы printInfo() и printAdditionalInfo() в класс User.
13.4. Расщепление переменной. Переменная age в методе calculateAverageAge() используется для разных промежуточных значений. Перепиши метод без использования этой переменной.
13.5. Удаление присваиваний параметрам. Перепиши метод calculateRate(), чтобы он не пытался менять входные параметры, а просто возвращал рассчитанное значение.

Требования:
1. Необходимо создать метод printInfo() в классе User, который будет выводить имя и фамилию в консоль так же, как это делается в методе printUsers() класса UserHelper.
2. Необходимо заменить в методе printUsers() класса UserHelper повторяющийся код вызовами метода printInfo().
3. Необходимо избавиться от метода ageLessThan16() класса UserHelper.
4. Необходимо переместить метод printAdditionalInfo() в класс User. Обрати внимание, что метод printAdditionalInfo
теперь не должен получать объект класса User в качестве параметра.
5. Необходимо переписать метод calculateAverageAge() класса UserHelper без использования переменной age. Переменную age - удалить.
6. Перепиши метод calculateRate() класса UserHelper, чтобы метод не изменял входные параметры, а просто возвращал рассчитанное значение (метод должен возвращать int).
 */