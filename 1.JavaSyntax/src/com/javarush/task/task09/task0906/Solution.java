package com.javarush.task.task09.task0906;

/* 
Логирование стек-трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        String resultString = s;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int i = 0;
        for (StackTraceElement element : stackTraceElements)
        {
            if (i==2) {
                resultString = element.getClassName() + ": " + element.getMethodName() + ": " + resultString;
                //System.out.println(element.getMethodName() + ": " + element.getLineNumber());
            }
            i++;
        }
        System.out.println(resultString);
    }
}
