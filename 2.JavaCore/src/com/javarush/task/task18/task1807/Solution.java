package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine(); //file2.txt
        reader.close();
        FileInputStream inputStream = new FileInputStream(fileName);
        int cntComma = 0;
        Integer asciiComma = 44;
        while (inputStream.available() > 0){
            Integer data = inputStream.read();
            //System.out.print(data + " ");
            if (data.equals(asciiComma)) cntComma++ ;
        }
        inputStream.close();
        //System.out.println("");
        System.out.println(cntComma);
    }
}
