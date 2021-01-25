package com.javarush.task.task09.task0905;

/* 
Там, в синих глубинах стек-трейса…
*/

public class Solution {
    public static void main(String[] args) {
        int deep = getStackTraceDepth();
    }

    public static int getStackTraceDepth() {
        //напишите тут ваш код
        int stackTraceDepth = 0;
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement element : stackTraceElements)
        {
            stackTraceDepth++;
        }
        System.out.println(stackTraceDepth);
        return stackTraceDepth;
    }
}

