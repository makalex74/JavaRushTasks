package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {
    public interface CanFly{
        public void fly();
    }
    public interface CanClimb{
        public void climb();
    }
    public interface CanRun{
        public void run();
    }

    public static void main(String[] args) {

    }

    public class Cat implements CanClimb, CanRun {
        @Override
        public void climb() {
            System.out.println("Кот лезет на дерево");
        }

        @Override
        public void run() {
            System.out.println("Кот бежит");
        }
    }

    public class Dog implements CanRun{
        @Override
        public void run() {
            System.out.println("Собака бежит");
        }
    }

    public class Tiger extends Cat {
        @Override
        public void climb() {
            System.out.println("Тигр лезет на дерево");
        }

        @Override
        public void run() {
            System.out.println("Тигр бежит");
        }
    }

    public class Duck implements CanFly, CanRun{
        @Override
        public void fly() {
            System.out.println("Утка летит");
        }

        @Override
        public void run() {
            System.out.println("Утка бежит");
        }
    }
}
