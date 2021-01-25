package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        if ((a >= 1) && (a <= 999)) {
            if ((a >= 1) && (a <= 9) && (a % 2 == 0)) System.out.println("четное однозначное число");
            if ((a >= 1) && (a <= 9) && (a % 2 != 0)) System.out.println("нечетное однозначное число");
            if ((a >= 10) && (a <= 99) && (a % 2 == 0)) System.out.println("четное двузначное число");
            if ((a >= 10) && (a <= 99) && (a % 2 != 0)) System.out.println("нечетное двузначное число");
            if ((a >= 100) && (a <= 999) && (a % 2 == 0)) System.out.println("четное трехзначное число");
            if ((a >= 100) && (a <= 999) && (a % 2 != 0)) System.out.println("нечетное трехзначное число");
        }
    }
}
