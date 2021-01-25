package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human gFather1 = new Human("Вася", true, 65);
        Human gFather2 = new Human("Петя", true, 67);
        Human gMother1 = new Human("Люба", true, 60);
        Human gMother2 = new Human("Женя", true, 61);
        Human father = new Human("Егор", true, 35, gFather1, gMother1);
        Human mother = new Human("Федор", true, 31, gFather2, gMother2);
        Human son1 = new Human("Игорь", true, 10, father, mother);
        Human son2 = new Human("Гриша", true, 7, father, mother);
        Human daughter = new Human("Лена", true, 5, father, mother);
        System.out.println(gFather1);
        System.out.println(gFather2);
        System.out.println(gMother1);
        System.out.println(gMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(son1);
        System.out.println(son2);
        System.out.println(daughter);
    }

    public static class Human {
        // напишите тут ваш код
        public String name;
        public boolean sex;
        public int age;
        public Human father;
        public Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }

            return text;
        }

    }
}