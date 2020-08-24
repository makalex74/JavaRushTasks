package com.javarush.task.task12.task1215;


/* 
Кошки не должны быть абстрактными!
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat extends Pet{
        public String getName(){
            return "Murka";
        }
        public Pet getChild(){
            Pet kotyonok = new Cat();
            return kotyonok;
        }
    }

    public static class Dog extends Pet{
        public String getName(){
            return "Avva";
        }
        public Pet getChild(){
            Pet schenok = new Dog();
            return schenok;
        }

    }

}
