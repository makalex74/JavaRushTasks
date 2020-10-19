package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class StudentsDataBase {
    public static List<Student> students = new ArrayList<>();

    public static void addInfoAboutStudent(Student student) {
        students.add(student);
        printInfoAboutStudent(student);
    }

    public static void printInfoAboutStudent(Student student) {
        System.out.println("Имя: " + student.getName() + " Возраст: " + student.getAge());
    }

    public static void removeStudent(int index) {
        if ((index >= 0) && (index < students.size()) && (students.size()!=0)) {
            students.remove(index);
        }
    }

    public static void findDimaOrSasha() {
        //boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            //if (!found) {
                if (students.get(i).getName().equals("Dima")) {
                    System.out.println("Студент Dima есть в базе.");
                    //found = true;
                    break;
                }

                if (students.get(i).getName().equals("Sasha")) {
                    System.out.println("Студент Sasha есть в базе.");
                    //found = true;
                    break;
                }
            //}
        }
    }


}

/*

Рефакторинг (8)
8.1. Удаление сеттера. Удали метод setId(). Поле id должно устанавливаться только в момент создания объекта.
8.2. Сокрытие метода (поля). Изменить область видимости поля nextId в соответствии с областью его использования.
8.3. Замена исключения проверкой условия. Перепиши метод removeStudent(int index),
чтобы он удалял студента из списка студентов только, если он там есть. Метод не должен кидать исключение.
8.4. Удаление управляющего флага. Перепиши метод findDimaOrSasha(), сохранив логику его работы.
В методе не должны использоваться флаги типа found, воспользуйся оператором break.


Требования:
1. Необходимо удалить метод setId(int) класса Human.
2. Необходимо изменить область видимости поля nextId класса Human с public на private.
3. Необходимо изменить метод removeStudent(int index) класса StudentsDataBase, чтобы он не бросал исключение.
4. Необходимо изменить метод findDimaOrSasha() класса StudentsDataBase, сохранив логику его работы.
Из метода нужно удалить флаг boolean found и воспользоваться оператором break.


Рефакторинг (7)
7.1. Параметризация метода. Замени методы incAverageGradeBy01() и incAverageGradeBy02() одним методом incAverageGrade(double delta).
7.2. Передача всего объекта. Перепиши метод addInfoAboutStudent(), чтобы он в качестве параметра принимал объект типа Student.
7.3. Замена параметра вызовом метода. Перепиши метод printInfoAboutStudent(), чтобы он не требовал в качестве параметра имя студента,
а получал его, вызвав соответствующий метод у переданного объекта.
7.4. Замена параметров объектом. Перепиши методы setBeginningOfSession и setEndOfSession,чтобы они вместо набора параметров принимали по одному объекту даты.


Требования:
1. Необходимо заменить методы incAverageGradeBy01() и incAverageGradeBy02() класса Student одним методом incAverageGrade(double delta).
2. Необходимо изменить метод addInfoAboutStudent(String, int, double) класса StudentsDataBase, чтобы он в качестве параметра принимал объект типа Student.
3. Необходимо изменить метод printInfoAboutStudent(String, Student) класса StudentsDataBase, чтобы он не требовал в качестве параметра имя студента.
4. Необходимо изменить метод setBeginningOfSession(int, int, int) класса Student, чтобы он принимал один параметр типа Date.
5. Необходимо изменить метод setEndOfSession(int, int, int) класса Student, чтобы он принимал один параметр типа Date.
 */