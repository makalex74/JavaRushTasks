package com.javarush.task.task38.task3803;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Runtime исключения (unchecked exception)
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        List<Integer> list = new ArrayList<Integer>();
        ((LinkedList<Integer>) list).add(3);
    }

    public void methodThrowsNullPointerException() {
        Object obj = null;
        System.out.println(obj.getClass().getName());
    }

    public static void main(String[] args) {
        VeryComplexClass veryComplexClass = new VeryComplexClass();
        veryComplexClass.methodThrowsClassCastException();
        //veryComplexClass.methodThrowsNullPointerException();
    }
}
