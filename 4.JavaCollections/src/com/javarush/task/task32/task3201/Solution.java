package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) {
        args = "ztest//task3202//source_file1.txt 20 Hello!".split(" ");
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];
        try (RandomAccessFile raf = new RandomAccessFile(fileName,"rw")) {
            if (raf.length() < number) {
                number = raf.length();
            }
            raf.seek(number);
            raf.write(text.getBytes());
        } catch (IOException e) {
            //System.out.println(e.getCause().getStackTrace());
        }
    }
}



