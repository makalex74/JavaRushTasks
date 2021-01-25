package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        TestThread testThread = new TestThread();
        testThread.start();
        //Thread.sleep(3500);
        testThread.interrupt();
    }

    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        @Override
        public void run() {
            Thread current = Thread.currentThread();
                try {
                    while (!current.isInterrupted())
                    {
                        Thread.sleep(1000);
                        System.out.println("Нить работает");
                    }
                } catch (InterruptedException e) {
                    System.out.println("Нить прервана");
                }

        }
    }
}