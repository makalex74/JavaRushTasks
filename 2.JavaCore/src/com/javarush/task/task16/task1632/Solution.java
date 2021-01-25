package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static{
        Thread1 thread1 = new Thread1();
        threads.add(thread1);
        Thread2 thread2 = new Thread2();
        threads.add(thread2);
        Thread3 thread3 = new Thread3();
        threads.add(thread3);
        Thread4 thread4 = new Thread4();
        threads.add(thread4);
        Thread5 thread5 = new Thread5();
        threads.add(thread5);
    }

    public static void main(String[] args) throws InterruptedException {
/*        //1
        threads.get(0).start();
        //2
        threads.get(1).start();
        //Thread.sleep(300);
        //2
        if (threads.get(1).isAlive()) threads.get(1).interrupt();
        //3
        threads.get(2).start();*/
        //4
        //threads.get(3).start();
        //Thread.sleep(200);
        //if (threads.get(3).isAlive()) ((Thread4) threads.get(3)).showWarning();
        //5
        //threads.get(4).start();

    }

    public static class Thread1 extends Thread{
        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(1000);
                    System.out.println(getName()+" #1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread2 extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(0);
                System.out.println(getName()+" #2");
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message{
        @Override
        public void run() {

                try {
                    while (true) {
                      Thread.sleep(100);
                      System.out.println(getName() + " #4");
                    }
                } catch (InterruptedException e) {
                    System.out.println(getName() + " InterruptedException");
                }

        }

        @Override
        public void showWarning() {
            System.out.println(getName() + " Warning!!!");
            interrupt();
        }
    }
    public static class Thread5 extends Thread{
        @Override
        public void run() {
            //System.out.println(getName()+" #5");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Integer sum = 0;
            while (true){
                try {
                    String strVal = reader.readLine();
                    if (strVal.equals("N")) break;
                    Integer intVal = Integer.parseInt(strVal);
                    sum += intVal;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            System.out.println(sum);
        }
    }

}