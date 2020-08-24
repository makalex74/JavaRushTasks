package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
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
        if ((a == b) && (b == c))
            System.out.println(a + " " + b + " "+ c);
        else {
            if (a == b) System.out.println(a + " " + b);
            if (a == c) System.out.println(a + " " + c);
            if (b == c) System.out.println(b + " " + c);
        }
    }
}