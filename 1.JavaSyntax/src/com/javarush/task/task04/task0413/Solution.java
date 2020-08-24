package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sSum = reader.readLine();
        int nSum = Integer.parseInt(sSum);
        if (nSum == 1) System.out.println("понедельник");
        if (nSum == 2) System.out.println("вторник");
        if (nSum == 3) System.out.println("среда");
        if (nSum == 4) System.out.println("четверг");
        if (nSum == 5) System.out.println("пятница");
        if (nSum == 6) System.out.println("суббота");
        if (nSum == 7) System.out.println("воскресенье");
        if ((nSum < 1) || (nSum > 7)) System.out.println("такого дня недели не существует");
    }
}