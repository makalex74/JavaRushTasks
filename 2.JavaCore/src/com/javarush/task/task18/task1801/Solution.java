package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine(); //file2.txt
        reader.close();
        FileInputStream inputStream = new FileInputStream(fileName);
        int max = 0;
        while (inputStream.available() > 0){
            int data = inputStream.read();
            max = max > data ? max : data;
            //System.out.println(data);
        }
        inputStream.close();
        //System.out.println("max = "+ max);
        System.out.println(max);
    }
}
