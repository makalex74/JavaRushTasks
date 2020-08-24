package com.javarush.task.task12.task1218;

/* 
Есть, летать и двигаться
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanMove {
        public void move();
    }

    public interface CanEat {
        public void eat();
    }

    public class Dog implements CanMove, CanEat {
        public void move(){
            System.out.println("Dog Run");
        }
        public void eat(){
            System.out.println("Dog Eat");
        }
    }

    public class Duck implements CanFly, CanMove, CanEat{
        public void fly(){
            System.out.println("Duck Fly");
        }
        public void move(){
            System.out.println("Duck Run");
        }
        public void eat(){
            System.out.println("Duck Eat");
        }
    }

    public class Car implements CanMove {
        public void move(){
            System.out.println("Car Move");
        }
    }

    public class Airplane implements CanMove, CanFly {
        public void fly(){
            System.out.println("Airplane Fly");
        }
        public void move(){
            System.out.println("Airplane Move");
        }
    }
}
