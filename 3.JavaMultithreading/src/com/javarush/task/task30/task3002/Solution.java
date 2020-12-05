package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/

import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        int number = 0;
        if (s.startsWith("0x")) {
            number = Integer.parseInt(s.substring(2),16);
        } else if (s.startsWith("0") && Character.isDigit(s.charAt(1))) {
            number = Integer.parseInt(s.substring(1),8);
        } else if (s.startsWith("0b")) {
            number = Integer.parseInt(s.substring(2),2);
        } else if (s.charAt(0) != '0') {
            number = Integer.parseInt(s);
        }
        //напишите тут ваш код
        return number + "";
    }
}
