package com.javarush.task.task05.task0516;

/* 
Друзей не купишь
*/

public class Friend {
    //напишите тут ваш код
/*
1. У класса Friend должна быть переменная name с типом String.
2. У класса Friend должна быть переменная age с типом int.
3. У класса Friend должна быть переменная sex с типом char.
 */
    private String name;
    private int age;
    private char sex;

    public Friend(String name){
        this.name = name;
    }

    public Friend(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Friend(String name, int age, char sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }


    public static void main(String[] args) {

    }
}
