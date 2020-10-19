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

public class UniversityPerson extends Human{
    private University university;

    public UniversityPerson(String name, int age) {
        super(name, age);
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

}
