package com.javarush.task.task27.task2711;

import java.util.concurrent.CountDownLatch;

public class Solution {
    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        latch.await();
        retrieveValue();
        latch.countDown();
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");

    }

    public static void main(String[] args) {
/*        Solution solution = new Solution();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //solution.latch.countDown();
                    solution.someMethod();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();*/
    }
}
