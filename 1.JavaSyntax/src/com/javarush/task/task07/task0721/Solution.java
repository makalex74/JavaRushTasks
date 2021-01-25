package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;
        int minimum = 0;
        int[] arr = new int[20];
        for (int i=0;i<20;i++){
            arr[i] = Integer.parseInt(reader.readLine());
        }
        for (int i=0; i<arr.length; i++){
            if (i==0) {
                maximum = arr[i];
                minimum = arr[i];
            }
            else {
                maximum = maximum > arr[i] ? maximum : arr[i];
                minimum = minimum < arr[i] ? minimum : arr[i];
            }
        }
        System.out.print(maximum + " " + minimum);
    }
}
