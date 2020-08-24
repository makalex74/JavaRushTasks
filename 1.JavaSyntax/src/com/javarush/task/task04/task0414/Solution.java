package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sSum = reader.readLine();
        int nSum = Integer.parseInt(sSum);
        if ((nSum % 400) == 0) System.out.println("количество дней в году: 366");
        else
          if ((nSum % 100) == 0) System.out.println("количество дней в году: 365");
          else
            if ((nSum % 4) == 0) System.out.println("количество дней в году: 366");
            else System.out.println("количество дней в году: 365");
    }
}