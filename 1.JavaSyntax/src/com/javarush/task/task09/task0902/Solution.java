package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        method1();
    }

    public static String method1() {
        method2();
        //напишите тут ваш код
        String resultString = "";
        int cnt=0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            if (cnt == 2)
                resultString =  element.getMethodName();
            //System.out.println(stackTraceElements.length - 3);
            //System.out.println(cnt);
            cnt++;
        }
        System.out.println(resultString);
        return resultString;
    }

    public static String method2() {
        method3();
        //напишите тут ваш код
        String resultString = "";
        int cnt=0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            if (cnt == 2)
                resultString =  element.getMethodName();
            //System.out.println(stackTraceElements.length - 3);
            //System.out.println(cnt);
            cnt++;
        }
        System.out.println(resultString);
        return resultString;
    }

    public static String method3() {
        method4();
        //напишите тут ваш код
        String resultString = "";
        int cnt=0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            if (cnt == 2)
                resultString =  element.getMethodName();
            //System.out.println(stackTraceElements.length - 3);
            //System.out.println(cnt);
            cnt++;
        }
        System.out.println(resultString);
        return resultString;
    }

    public static String method4() {
        method5();
        //напишите тут ваш код
        String resultString = "";
        int cnt=0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            if (cnt == 2)
                resultString =  element.getMethodName();
            //System.out.println(stackTraceElements.length - 3);
            //System.out.println(cnt);
            cnt++;
        }
        System.out.println(resultString);
        return resultString;
    }

    public static String method5() {
        //напишите тут ваш код
        String resultString = "";
        int cnt=0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            if (cnt == 2)
                resultString =  element.getMethodName();
            //System.out.println(stackTraceElements.length - 3);
            //System.out.println(cnt);
            cnt++;
        }
        System.out.println(resultString);
        return resultString;
    }
}
