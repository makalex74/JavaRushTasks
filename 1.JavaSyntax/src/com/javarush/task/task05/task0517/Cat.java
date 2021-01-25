package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    private String name;
    private int age;
    private int weight;
    private String address;
    private String color;

    public Cat(String name) {
        this.name = name;
        this.age = 1;
        this.weight = 1;
        //this.address = null;
        this.color = "Grey";
    }

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        //this.address = null;
        this.color = "Grey";
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = 1;
        //this.address = null;
        this.color = "Grey";
    }

    public Cat(int weight, String color) {
        //this.name = "NoName";
        this.age = 1;
        this.weight = weight;
        //this.address = null;
        this.color = color;
    }

    public Cat(int weight, String color, String address) {
        //this.name = "NoName";
        this.age = 1;
        this.weight = weight;
        this.address = address;
        this.color = color;
    }


    /*
Создать класс Cat (кот) с пятью конструкторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст - неизвестные. Кот - бездомный)
- вес, цвет, адрес (чужой домашний кот)

У класса должен быть конструктор, принимающий в качестве параметров вес, цвет, адрес и инициализирующий все переменные класса, кроме имени.
     */
/*
    public Cat(String name, int age, int weight, String address, String color) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.address = address;
        this.color = color;
    }
*/
    public static void main(String[] args) {

    }
}
