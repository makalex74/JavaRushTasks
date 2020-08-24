package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        testString.printSomething();

        String sourceString = byteArrayOutputStream.toString();
        String[] arrStr = sourceString.split(" ");
        int resInt = 0;
        switch (arrStr[1]){
            case ("+"):
                resInt = Integer.parseInt(arrStr[0]) + Integer.parseInt(arrStr[2]);
                break;
            case ("-"):
                resInt = Integer.parseInt(arrStr[0]) - Integer.parseInt(arrStr[2]);
                break;
            case ("*"):
                resInt = Integer.parseInt(arrStr[0]) * Integer.parseInt(arrStr[2]);
                break;
            default:
                System.out.println("Error!");
                break;
        }
        String resultStr = sourceString.replace(System.lineSeparator(),"") + resInt;

        System.setOut(consoleStream);
        //System.out.println(sourceString);
        System.out.println(resultStr);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

