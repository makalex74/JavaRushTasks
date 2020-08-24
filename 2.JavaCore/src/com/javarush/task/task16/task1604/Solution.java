package com.javarush.task.task16.task1604;

/* 
Вывод стек-трейса
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SpecialThread());
        thread.start();

        System.out.println("*****************");

        //System.out.println("begin getStackTrace for main.");
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            System.out.println(element);
        }
        //System.out.println("end getStackTrace for main.");
    }
    public static class SpecialThread implements Runnable{

        @Override
        public void run() {
            //System.out.println("begin getStackTrace for SpecialThread.");
           for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
                System.out.println(element);
            }
            //System.out.println("end getStackTrace for SpecialThread.");
        }
    }
}
