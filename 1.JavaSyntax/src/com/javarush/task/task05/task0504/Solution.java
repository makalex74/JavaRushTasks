package com.javarush.task.task05.task0504;


/* 
Трикотаж
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Cat vaska  = new Cat("Vaska",12, 16, 11);
        Cat murzik  = new Cat("Murzik",5, 12, 9);
        Cat barsik  = new Cat("Barsik",7, 16, 13);
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int strength;

        public Cat(String name, int age, int weight, int strength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.strength = strength;
        }
    }
}