package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {
    private double averageGrade;
    private Date beginningOfSession;
    private Date endOfSession;

    /*
    Рефакторинг (3)
    3.1. Спуск поля. Спусти поле course в соответствующий класс. Сделай его приватным.
    3.2. Спуск метода. Спусти геттер для поля course в соответствующий класс.
    Требования:
    1. Необходимо спустить поле course в нужный класс и сделать его приватным.
    2. Необходимо спустить геттер для поля course в нужный класс.
     */
    private int course;

    public Student(String name, int age, double averageGrade) {
        super(name,age);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public void live() {
        learn();
    }

    public void learn() {
    }

    public int getCourse() {
        return course;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String getPosition() {
        return "Студент";
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

/*
    public void incAverageGrade(double delta){
        averageGrade += delta;
    }
*/

    public void incAverageGrade(double delta){
        setAverageGrade(getAverageGrade() + delta);
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
9.4.2. Добавь в класс BloodGroup приватное константное поле int code, приватный конструктор, принимающий int и инициализирующий поле code, геттер для поля класса.
9.4.3. Добавь в класс BloodGroup статические методы first(), second(), third() и fourth(), создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1, 2, 3 и 4 соответственно).
9.4.4. Примени в классе Human новый тип BloodGroup.


Требования:
1. Необходимо изменить метод incAverageGrade() класса Student с использованием сеттера и геттера для доступа к averageGrade.
2. Необходимо заменить массив int[] size класса Human объектом нового типа Size.
3. Необходимо изменить модификатор доступа поля company в классе Worker на приватный. Необходимо добавить сеттер и геттер для этого поля.
4. Необходимо создать публичный класс BloodGroup внутри пакета human.
5. Необходимо добавить в класс BloodGroup константное поле int code, приватный конструктор, принимающий int и инициализирующий поле code, геттер для поля класса.
6. Необходимо добавить в класс BloodGroup статические методы first(), second(), third() и fourth(), создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1, 2, 3 и 4 соответственно).
7. Необходимо изменить тип поля bloodGroup класса Human на BloodGroup, обновить сеттер и геттер.
8. Необходимо удалить из класса Human константы: FIRST, SECOND, THIRD, FOURTH.


Рефакторинг (7)
7.1. Параметризация метода. Замени методы incAverageGradeBy01() и incAverageGradeBy02() одним методом incAverageGrade(double delta).
7.2. Передача всего объекта. Перепиши метод addInfoAboutStudent(), чтобы он в качестве параметра принимал объект типа Student.
7.3. Замена параметра вызовом метода. Перепиши метод printInfoAboutStudent(), чтобы он не требовал в качестве параметра имя студента, а получал его, вызвав соответствующий метод у переданного объекта.
7.4. Замена параметров объектом. Перепиши методы setBeginningOfSession и setEndOfSession,чтобы они вместо набора параметров принимали по одному объекту даты.


Требования:
1. Необходимо заменить методы incAverageGradeBy01() и incAverageGradeBy02() класса Student одним методом incAverageGrade(double delta).
2. Необходимо изменить метод addInfoAboutStudent(String, int, double) класса StudentsDataBase, чтобы он в качестве параметра принимал объект типа Student.
3. Необходимо изменить метод printInfoAboutStudent(String, Student) класса StudentsDataBase, чтобы он не требовал в качестве параметра имя студента.
4. Необходимо изменить метод setBeginningOfSession(int, int, int) класса Student, чтобы он принимал один параметр типа Date.
5. Необходимо изменить метод setEndOfSession(int, int, int) класса Student, чтобы он принимал один параметр типа Date.


Рефакторинг (6)
6.1. Замена параметра набором специализированных методов. Замени метод setValue() класса Student специализированными методами setCourse и setAverageGrade.
6.2. Добавление параметра. Добавить параметр с типом double в метод getStudentWithAverageGrade(), чтобы было понятно с каким средним балом нужен студент.
Реализуй метод getStudentWithAverageGrade().
6.3. Удаление параметра. Убери параметр из метода getStudentWithMaxAverageGrade().
Реализуй этот метод, он должен возвращать студента с максимальным средним балом.
6.4. Разделение запроса и модификатора. Раздели метод getStudentWithMinAverageGradeAndExpel на Student getStudentWithMinAverageGrade() и void expel(Student student). Первый метод должен возвратить студента с минимальным средним балом, а второй - отчислить переданного студента (удалять из списка students).


Требования:
1. Необходимо заменить метод setValue класса Student специализированными методами setCourse и setAverageGrade.
2. Необходимо добавить параметр с типом double в метод getStudentWithAverageGrade() класса University и реализовать метод.
3. Необходимо удалить параметр из метода getStudentWithMaxAverageGrade(double) класса University и реализовать метод.
4. Необходимо разделить метод getStudentWithMinAverageGradeAndExpel на Student getStudentWithMinAverageGrade() и void expel(Student student) и реализовать эти два метода.
 */