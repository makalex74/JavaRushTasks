package com.javarush.task.task29.task2909.human;

public class Worker extends Human {
    private double salary;
    private String company;

    public Worker(String name, int age) {
        super(name, age);
        this.company = company;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}

/*

Рефакторинг (9)
9.3. Инкапсуляция поля. Сокрой поле company в классе Worker. Добавь сеттер и геттер для него.
Требования:
3. Необходимо изменить модификатор доступа поля company в классе Worker на приватный. Необходимо добавить сеттер и геттер для этого поля.

Рефакторинг (5)
5.2. Замена делегирования наследованием. Класс Worker должен наследоваться от Human, а не содержать его.
5.3. Переименование метода. Переименуй метод setSlr, чтобы было понятно сеттером чего является этот метод.

Требования:
6. Класс Worker должен наследоваться от класса Human, а не содержать его.
7. В классе Worker необходимо переименовать метод setSlr(double) на setSalary(double).
 */