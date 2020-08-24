package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int a = Integer.parseInt(str);
        str = reader.readLine();
        int b = Integer.parseInt(str);
        str = reader.readLine();
        int c = Integer.parseInt(str);
        if ((a >= (b + c)) || (b >= (a + c)) || (c >= (a + b)))
            System.out.println("Треугольник не существует.");
        else
            System.out.println("Треугольник существует.");
    }
}