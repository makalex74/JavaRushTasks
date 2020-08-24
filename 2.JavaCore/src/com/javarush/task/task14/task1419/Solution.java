package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            List<Integer> list = new ArrayList<>();
            list.add(5);
            list.add(4);
            Integer n= list.get(10);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            FileInputStream fis = new FileInputStream("C2:\badFileName.txt");
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            String s = null;
            String m = s.toLowerCase();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] m = new int[2];
            m[8] = 5;
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int num = Integer.parseInt("XYZ");
            System.out.println(num);
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new RemoteException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new NoSuchFieldException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new IOException();
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            throw new ClassNotFoundException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

    }
}
