package com.javarush.task.task09.task0903;

/* 
Кто меня вызывал?
*/

public class Solution {
    public static void main(String[] args) {
        method1();
    }

    public static int method1() {
        method2();
        int resultInt = 0;
        int cnt=0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            if (cnt == 2)
                resultInt =  element.getLineNumber();
            //System.out.println(element.getMethodName() +" " + element.getLineNumber());
            //System.out.println(cnt);
            cnt++;
        }
        //System.out.println(resultInt);
        return resultInt;
    }

    public static int method2() {
        method3();
        int resultInt = 0;
        int cnt=0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            if (cnt == 2)
                resultInt =  element.getLineNumber();
            //System.out.println(element.getMethodName() +" " + element.getLineNumber());
            //System.out.println(cnt);
            cnt++;
        }
        //System.out.println(resultInt);
        return resultInt;
    }

    public static int method3() {
        method4();
        int resultInt = 0;
        int cnt=0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            if (cnt == 2)
                resultInt =  element.getLineNumber();
            //System.out.println(element.getMethodName() +" " + element.getLineNumber());
            //System.out.println(cnt);
            cnt++;
        }
        //System.out.println(resultInt);
        return resultInt;
    }

    public static int method4() {
        method5();
        int resultInt = 0;
        int cnt=0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            if (cnt == 2)
                resultInt =  element.getLineNumber();
            //System.out.println(element.getMethodName() +" " + element.getLineNumber());
            //System.out.println(cnt);
            cnt++;
        }
        //System.out.println(resultInt);
        return resultInt;
    }

    public static int method5() {

        int resultInt = 0;
        int cnt=0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            if (cnt == 2)
                resultInt =  element.getLineNumber();
            //System.out.println(element.getMethodName() +" " + element.getLineNumber());
            //System.out.println(cnt);
            cnt++;
        }
        //System.out.println(resultInt);
        return resultInt;
    }
}
