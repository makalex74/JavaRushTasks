package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {

    //напишите тут ваш код
    public static class Man {
        private String name;
        private int age;
        private String  address;

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }
    }
    public static class Woman {
        private String name;
        private int age;
        private String address;

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getAddress() {
            return address;
        }

    }

    public static void main(String[] args) {
        Man man1 = new Man("Дима", 45,  "Москва, Кремль");
        Man man2 = new Man("Вася", 45,  "Москва, Кремль");
        Woman woman1 = new Woman("Оля", 45,  "Воронеж");
        Woman woman2 = new Woman("Олеся", 45,  "Воронеж");
        System.out.println(man1.getName() + " " + man1.getAge() + " " + man1.getAddress());
        System.out.println(man2.getName() + " " + man2.getAge() + " " + man2.getAddress());
        System.out.println(woman1.getName() + " " + woman1.getAge() + " " + woman1.getAddress());
        System.out.println(woman2.getName() + " " + woman2.getAge() + " " + woman2.getAddress());
    }

}
