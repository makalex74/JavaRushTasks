package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive {
    private List<Human> children = new ArrayList<>();
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;
    protected Size size;

    private BloodGroup bloodGroup;

    //3. Метод getChildren в классе Human должен возвращать Collections.unmodifiableList(children).
    
    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    //5. Необходимо добавить методы addChild (Human) и removeChild (Human) в класс Human, и реализовать их.
    public void addChild (Human child){
        children.add(child);
    }

    public void removeChild (Human child){
        children.remove(child);
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
          this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    //Рефакторинг (2)
    //4. Конструктор класса Human должен принимать два параметра: String name и int age, и инициализировать соответствующие поля.
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public void live() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public String getPosition(){
        return "Человек";
    }

    public void printData() {
        System.out.println(getPosition()+": " + name);
    }

    public class Size{
        public int height;
        public int weight;
    }
}

/*

Рефакторинг (9)
9.1. Самоинкапсуляция поля. Перепиши метод incAverageGrade() используя сеттер и геттер для доступа к averageGrade.
9.2. Замена поля-массива объектом. Замени массив int[] size объектом нового типа Size,
содержащим публичные поля: рост int height и вес int weight. Публичный класс Size объяви внутри класса Human.
9.3. Инкапсуляция поля. Сокрой поле company в классе Worker. Добавь сеттер и геттер для него.
9.4. Замена кодирования типа классом.
9.4.1. Объяви публичный класс группы крови BloodGroup внутри пакета human.
9.4.2. Добавь в класс BloodGroup приватное константное поле int code, приватный конструктор,
принимающий int и инициализирующий поле code, геттер для поля класса.
9.4.3. Добавь в класс BloodGroup статические методы first(), second(), third() и fourth(),
создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1, 2, 3 и 4 соответственно).
9.4.4. Примени в классе Human новый тип BloodGroup.


Требования:
1. Необходимо изменить метод incAverageGrade() класса Student с использованием сеттера и геттера для доступа к averageGrade.
2. Необходимо заменить массив int[] size класса Human объектом нового типа Size.
3. Необходимо изменить модификатор доступа поля company в классе Worker на приватный. Необходимо добавить сеттер и геттер для этого поля.
4. Необходимо создать публичный класс BloodGroup внутри пакета human.
5. Необходимо добавить в класс BloodGroup константное поле int code, приватный конструктор,
принимающий int и инициализирующий поле code, геттер для поля класса.
6. Необходимо добавить в класс BloodGroup статические методы first(), second(), third() и fourth(),
создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1, 2, 3 и 4 соответственно).
7. Необходимо изменить тип поля bloodGroup класса Human на BloodGroup, обновить сеттер и геттер.
8. Необходимо удалить из класса Human константы: FIRST, SECOND, THIRD, FOURTH.

Рефакторинг (8)
8.1. Удаление сеттера. Удали метод setId(). Поле id должно устанавливаться только в момент создания объекта.
8.2. Сокрытие метода (поля). Изменить область видимости поля nextId в соответствии с областью его использования.
8.3. Замена исключения проверкой условия. Перепиши метод removeStudent(int index), чтобы он удалял студента из списка студентов только, если он там есть. Метод не должен кидать исключение.
8.4. Удаление управляющего флага. Перепиши метод findDimaOrSasha(), сохранив логику его работы. В методе не должны использоваться флаги типа found, воспользуйся оператором break.


Требования:
1. Необходимо удалить метод setId(int) класса Human.
2. Необходимо изменить область видимости поля nextId класса Human с public на private.
3. Необходимо изменить метод removeStudent(int index) класса StudentsDataBase, чтобы он не бросал исключение.
4. Необходимо изменить метод findDimaOrSasha() класса StudentsDataBase, сохранив логику его работы. Из метода нужно удалить флаг boolean found и воспользоваться оператором break.

Рефакторинг (5)
5.1. Создание шаблонного метода.
5.1.1. Добавь в класс Human метод String getPosition(), который должен возвращать строку "Человек".
5.1.2. Переопредели этот метод в классе Student и Teacher. Метод должен возвращать "Студент" и "Преподаватель" соответственно.
5.1.3. Замени метод printData в подклассах шаблонным методом в базовом классе, использующим getPosition().
5.2. Замена делегирования наследованием. Класс Worker должен наследоваться от Human, а не содержать его.
5.3. Переименование метода. Переименуй метод setSlr, чтобы было понятно сеттером чего является этот метод.


Требования:
1. В классе Human должен существовать метод String getPosition(), который возвращает строку "Человек".
2. В классе Student переопредели метод String getPosition(), чтобы он возвращал строку "Студент".
3. В классе Teacher переопредели метод String getPosition(), чтобы он возвращал строку "Преподаватель".
4. Необходимо заменить метод printData() в классе Student на метод printData() в классе Human. Используй getPosition().
5. Необходимо заменить метод printData() в классе Teacher на метод printData() в классе Human. Используй getPosition().
6. Класс Worker должен наследоваться от класса Human, а не содержать его.
7. В классе Worker необходимо переименовать метод setSlr(double) на setSalary(double).
 */