package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[20];
        for (int i=0; i<20; i++){
            arr[i] = Integer.parseInt(reader.readLine());
        }
        int[] arrM1 = new int[10];
        for (int i=0; i<10; i++){
            arrM1[i] = arr[i];
        }
        int[] arrM2 = new int[10];
        for (int i=10; i<20; i++){
            arrM2[i-10] = arr[i];
        }
        for (int i=0; i<10; i++){
            System.out.println(arrM2[i]);
        }

    }
}
