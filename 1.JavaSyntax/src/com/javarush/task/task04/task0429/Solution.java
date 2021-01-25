package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int pcnt = 0;
        if (a > 0) pcnt++;
        if (b > 0) pcnt++;
        if (c > 0) pcnt++;
        System.out.println("количество положительных чисел: " + pcnt);
        int ocnt = 0;
        if (a < 0) ocnt++;
        if (b < 0) ocnt++;
        if (c < 0) ocnt++;
        System.out.println("количество отрицательных чисел: " + ocnt);

    }
}
