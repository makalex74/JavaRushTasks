package com.javarush.task.task05.task0503;


/* 
Геттеры и сеттеры для класса Dog
*/

public class Dog {
    //напишите тут ваш код
    private String name;
    private int age;
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }
    public void setName(String newName){
        this.name = newName;
    }
    public void setAge(int newAge) {
        this.age = newAge;
    }


    public static void main(String[] args) {
        Dog avva = new Dog();
        avva.setName("Avva");
        avva.setAge(10);
        System.out.println(avva.getName());
        System.out.println(avva.getAge());
    }
}
