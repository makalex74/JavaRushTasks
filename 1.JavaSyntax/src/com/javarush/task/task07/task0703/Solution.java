package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arrS = new String[10];
        int[] arrI = new int[10];
        for (int i=0; i<10; i++){
            arrS[i] = reader.readLine();
            arrI[i] = arrS[i].length();
        }
        for (int i=0; i<10; i++){
            System.out.println(arrI[i]);
        }
    }
}
