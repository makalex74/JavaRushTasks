package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sSum = reader.readLine();
        int nSum = Integer.parseInt(sSum);
        if (nSum > 0) nSum = nSum * 2;
        if (nSum < 0) nSum++;
        System.out.println(nSum);
    }

}