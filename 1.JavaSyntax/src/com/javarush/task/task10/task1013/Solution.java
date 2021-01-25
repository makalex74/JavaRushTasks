package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private String name;
        private String middleName;
        private String family;
        private String nationality;
        private int age;
        private boolean sex;

        public Human(String name, String family) {
            this.name = name;
            this.family = family;
        }

        public Human(String name, String family, String middleName, int age) {
            this.name = name;
            this.middleName = middleName;
            this.family = family;
            this.age = age;
        }


        public Human(String name, String family, int age, boolean sex, String nationality) {
            this.name = name;
            this.family = family;
            this.nationality = nationality;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, String family, int age, boolean sex) {
            this.name = name;
            this.family = family;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, String family, boolean sex) {
            this.name = name;
            this.family = family;
            this.sex = sex;
        }

        public Human(String name, String family, String middleName, int age, boolean sex) {
            this.name = name;
            this.middleName = middleName;
            this.family = family;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, String family, String middleName, boolean sex) {
            this.name = name;
            this.middleName = middleName;
            this.family = family;
            this.sex = sex;
        }

        public Human(String name, String family, String middleName, int age, boolean sex, String nationality) {
            this.name = name;
            this.middleName = middleName;
            this.family = family;
            this.age = age;
            this.sex = sex;
            this.nationality = nationality;
        }

        public Human(String family) {
            this.family = family;
        }

        public Human(String name, String middleName, String family, boolean sex, int age, String nationality) {
            this.name = name;
            this.middleName = middleName;
            this.family = family;
            this.nationality = nationality;
            this.age = age;
            this.sex = sex;
        }
    }
}
