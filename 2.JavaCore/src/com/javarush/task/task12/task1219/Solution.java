package com.javarush.task.task12.task1219;

/* 
Создаем человека
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void swim();
    }


    public class Human implements CanRun, CanSwim{
        public void run(){
            System.out.println("Human Run");
        }
        public void swim(){
            System.out.println("Human Swim");
        }
    }

    public class Duck implements CanRun, CanSwim, CanFly {
        public void fly(){
            System.out.println("Duck Fly");
        }
        public void run(){
            System.out.println("Duck Run");
        }
        public void swim(){
            System.out.println("Duck Swim");
        }
    }

    public class Penguin implements CanRun, CanSwim{
        public void run(){
            System.out.println("Penguin Run");
        }
        public void swim(){
            System.out.println("Penguin Swim");
        }
    }

    public class Airplane  implements CanRun, CanFly {
        public void fly(){
            System.out.println("Airplane Fly");
        }
        public void run(){
            System.out.println("Airplane Run");
        }
    }
}
