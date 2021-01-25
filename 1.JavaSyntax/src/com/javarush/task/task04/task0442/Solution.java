package com.javarush.task.task04.task0442;

/* 
Суммирование
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i=0;
        while (true) {
            int a = Integer.parseInt(reader.readLine());
            i += a;
            if (a == -1) break;
        }
        System.out.println(i);
    }
}
