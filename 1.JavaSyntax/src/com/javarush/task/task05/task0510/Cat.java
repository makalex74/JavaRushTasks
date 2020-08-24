package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
    private String name;
    private int age;
    private int weight;
    private String color;
    private String address;

    public void initialize(String name) {
        this.name = name;
        this.age = 1;
        this.weight = 1;
        this.color = "Серый";
        //this.address = "Неизвестный адрес";
    }

    public void initialize(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = "Серый";
        //this.address = "Неизвестный адрес";
    }

    public void initialize(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 1;
        this.color = "Серый";
        //this.address = "Неизвестный адрес";
    }

    public void initialize(int weight, String color) {
        //this.name = name;
        this.age = 1;
        this.weight = weight;
        this.color = color;
        //this.address = "Неизвестный адрес";
    }

    public void initialize(int weight, String color, String address) {
        //this.name = name;
        this.age = 1;
        this.weight = weight;
        this.color = color;
        this.address = address;
    }

    /*
                У класса Cat должна быть переменная name с типом String.
                У класса Cat должна быть переменная age с типом int.
                У класса Cat должна быть переменная weight с типом int.
                У класса Cat должна быть переменная address с типом String.
                У класса Cat должна быть переменная color с типом String.
    */
    public static void main(String[] args) {

    }
}
