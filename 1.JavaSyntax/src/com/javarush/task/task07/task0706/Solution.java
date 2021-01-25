package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[15];
        for (int i=0; i<15; i++){
            arr[i] = Integer.parseInt(reader.readLine());
        }
        int summChet = 0;
        int summNeChet = 0;
        for (int i=0; i<15; i++) {
            if ((i == 0) || (i % 2 == 0))
                summChet = summChet + arr[i];
            else
                summNeChet = summNeChet + arr[i];
        }
        if (summChet > summNeChet)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else
            System.out.println("В домах с нечетными номерами проживает больше жителей.");

    }
}
