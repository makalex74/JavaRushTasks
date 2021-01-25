package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String value = reader.readLine();
            if (value.equals("exit")) break;
            if (isNumeric(value) && value.contains(".")) {
                Double valDouble = Double.parseDouble(value);
                print(valDouble);
            }
            else if (isNumeric(value) && (0 < Integer.parseInt(value)) && (Integer.parseInt(value) < 128)){
                short valShort = Short.parseShort(value);
                print(valShort);
            }
            else if (isNumeric(value) && ((Integer.parseInt(value) <=0) || (Integer.parseInt(value) >= 128))){
                Integer valInteger = Integer.parseInt(value);
                print(valInteger);
            }
            else print(value);

        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
