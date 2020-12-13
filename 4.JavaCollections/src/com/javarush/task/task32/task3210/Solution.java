package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        //args = "ztest//task3202//source_file1.txt 20 Hello!".split(" ");
        String fileName = args[0];
        long number = Long.parseLong(args[1]);
        String text = args[2];
        try (RandomAccessFile raf = new RandomAccessFile(fileName,"rw")) {
            raf.seek(number);
            byte[] b = new byte[text.length()];
            raf.read(b, 0, text.length());
            String readString = new String(b);
            //System.out.println("readString = " + readString);
            raf.seek(raf.length());
            if (readString.equals(text)){
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
