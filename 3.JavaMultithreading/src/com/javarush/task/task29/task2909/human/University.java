package com.javarush.task.task29.task2909.human;


/*
Рефакторинг (4)
4.1. Замена наследования делегированием.
4.1.1. Класс University не должен наследоваться от Student.
4.1.2. Класс University должен содержать список students. Не забудь его инициализировать.
4.1.3. Добавь сеттер и геттер для students.
4.1.4. Университет имеет название (name) и возраст (age). Добавь необходимые поля, сеттеры и геттеры для них.
4.2. Извлечение суперкласса.
4.2.1. Создай класс UniversityPerson в пакете human.
4.2.2. Перенеси в него поле university.
4.2.3. Перенеси сеттер и геттер для поля university.
4.2.4. Унаследуй необходимые классы от UniversityPerson.
4.3. Замена простого поля объектом. Измени тип поля university на University.


Требования:
1. Класс University не должен наследоваться от Student.
2. В классе University необходимо создать поле name, сеттер и геттер для него.
3. В классе University необходимо создать поле age, сеттер и геттер для него.
4. В классе University необходимо создать приватное поле List<Student> students.
5. В классе University необходимо создать сеттер и геттер для поля students.
6. Необходимо создать публичный класс UniversityPerson в пакете human и унаследовать его от класса Human.
7. Необходимо перенести поле university из классов Teacher и Student в класс UniversityPerson.
8. Необходимо перенести сеттер и геттер поля university из классов Teacher и Student в класс UniversityPerson.
9. Необходимо унаследовать классы Teacher и Student от класса UniversityPerson.
10. Необходимо изменить тип поля university на University.
 */

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students;
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student:students) {
            if (student.getAverageGrade() == averageGrade) return student;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double maxAverageGrade = students.size() == 0 ? 0 : students.get(0).getAverageGrade();
        for (Student student:students) {
            maxAverageGrade = maxAverageGrade > student.getAverageGrade() ? maxAverageGrade : student.getAverageGrade();
        }
        for (Student student:students) {
            if (student.getAverageGrade() == maxAverageGrade) return student;
        }
        return null;
    }

/*    public void getStudentWithMinAverageGradeAndExpel() {
        //TODO:
    }*/

/*
Рефакторинг (6)
6.4. Разделение запроса и модификатора. Раздели метод getStudentWithMinAverageGradeAndExpel на Student getStudentWithMinAverageGrade()
и void expel(Student student).
Первый метод должен возвратить студента с минимальным средним балом,
а второй - отчислить переданного студента (удалять из списка students).
 */
    public Student getStudentWithMinAverageGrade(){
        //TODO:
        double minAverageGrade = students.size() == 0 ? 0 : students.get(0).getAverageGrade();
        for (Student student:students) {
            minAverageGrade = minAverageGrade < student.getAverageGrade() ? minAverageGrade : student.getAverageGrade();
        }
        for (Student student:students) {
            if (student.getAverageGrade() == minAverageGrade) return student;
        }
        return null;
    }

    public void expel(Student student){
        students.remove(student);
    }

}

/*
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
