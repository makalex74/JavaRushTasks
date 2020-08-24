package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.beans.beancontext.BeanContextChild;
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sSum = reader.readLine();
        //float nSum = Float.parseFloat(sSum);
        double nSum = Double.parseDouble(sSum);
        //System.out.println("nSum % 5 = "+nSum);
        if (((nSum % 5) >= 0) && ((nSum % 5) < 3)) System.out.println("зелёный");
        if (((nSum % 5) >= 3) && ((nSum % 5) < 4)) System.out.println("жёлтый");
        if (((nSum % 5) >= 4) && ((nSum % 5) < 5)) System.out.println("красный");

/*
        for (int i=0;i<1000000;i++) {
            if ((nSum >= (0 + 5*i)) && (nSum < (3 + 5*i))) System.out.println("зелёный");
            if ((nSum >= (3 + 5*i)) && (nSum < (4 + 5*i))) System.out.println("жёлтый");
            if ((nSum >= (4 + 5*i)) && (nSum < (5 + 5*i))) System.out.println("красный");
/*
            if ((nSum >= 5) && (nSum < 8)) System.out.println("зелёный");
            if ((nSum >= 8) && (nSum < 9)) System.out.println("жёлтый");
            if ((nSum >= 9) && (nSum < 10)) System.out.println("красный");
*/
/*
        }
*/
    }

}