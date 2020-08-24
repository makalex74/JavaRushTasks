package com.javarush.task.task16.task1622;

/* 
Последовательные выполнения нитей
*/

public class Solution {
    public volatile static int COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            SleepingThread sleepingThread = new SleepingThread();
            //напишите тут ваш код
            sleepingThread.join();
        }
    }

    public static class SleepingThread extends Thread {
        private static volatile int threadCount = 0;
        private volatile int countdownIndex = COUNT;

        public SleepingThread() {
            super(String.valueOf(++threadCount));
            start();
        }

        public void run() {
            while (true) {
                System.out.println(this);
                try {
                    Thread.sleep(10);
                    if (--countdownIndex == 0) {
                        return;
                    }
                } catch (InterruptedException e) {
                    System.out.println("Нить прервана");
                }
                //напишите тут ваш код
            }
        }

        public String toString() {
            return "#" + getName() + ": " + countdownIndex;
        }
    }
}
