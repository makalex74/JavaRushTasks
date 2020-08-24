package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine(); //file1.txt
        String fileName2 = reader.readLine(); //file2.txt

/*        String fileName1 = "file1.txt";
        String fileName2 = "file2.txt";*/
        //Создаем поток-чтения-байт-из-файла
        FileInputStream inputStream = new FileInputStream(fileName1);
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream(fileName2);
        ArrayList<Integer> list = new ArrayList<>();
        while (inputStream.available() > 0)
        {
            list.add(inputStream.read());
        }
        inputStream.close();
        //System.out.println(list);
        //System.out.println(list.size());
        for (int i = list.size()-1; i >= 0; i--) {
            //System.out.println(i);
            //System.out.println(list.get(i)+" ");
            outputStream.write(list.get(i));
        }
        outputStream.close();
    }
}
