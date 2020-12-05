package com.javarush.task.task30.task3010;

import java.math.BigInteger;
import java.util.regex.Pattern;

/* 
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try {
            //args = "12AS08z".split(" ");
            String number = args[0];
            //System.out.println(number);
            if (checkCorrect(number)) {
                for (int numberSystem = 2; numberSystem <= 36; numberSystem++) {
                    try {
                        BigInteger bigInteger = new BigInteger(number, numberSystem);
                        String convertedDigitString = bigInteger.toString(numberSystem);
                        System.out.println(numberSystem);
                        break;
                    } catch (NumberFormatException e) {
                    }
                }
            } else System.out.println("incorrect");
        } catch (Exception e) {

        }
    }

    public static boolean checkCorrect(String number) {
        boolean result = true;
        char[] arrayChar = number.toCharArray();
        for (int i = 0; i < arrayChar.length; i++) {
            if (!Character.isLetterOrDigit(arrayChar[i])) result = false;
        }
        return result;
    }
}