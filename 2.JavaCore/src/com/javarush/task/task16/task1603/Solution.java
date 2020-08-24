package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);


    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут
        SpecialThread specialThread1 = new SpecialThread();
        Thread thread1 = new Thread(specialThread1);
        list.add(thread1);
        thread1.start();
        SpecialThread specialThread2 = new SpecialThread();
        Thread thread2 = new Thread(specialThread2);
        list.add(thread2);
        thread2.start();
        SpecialThread specialThread3 = new SpecialThread();
        Thread thread3 = new Thread(specialThread3);
        list.add(thread3);
        thread3.start();
        SpecialThread specialThread4 = new SpecialThread();
        Thread thread4 = new Thread(specialThread4);
        list.add(thread4);
        thread4.start();
        SpecialThread specialThread5 = new SpecialThread();
        Thread thread5 = new Thread(specialThread5);
        list.add(thread5);
        thread5.start();


    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
