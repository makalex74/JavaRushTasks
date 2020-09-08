package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //args = "fileWin1251.txt fileUTF8.txt".split(" ");
        //System.out.println(args[0]);
        //System.out.println(args[1]);
        String fileWin1251 = args[0];
        String fileUTF8 = args[1];
        FileInputStream fileInputStream = new FileInputStream(fileWin1251);
        FileOutputStream fileOutputStream = new FileOutputStream(fileUTF8);

        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        String s = new String(buffer, "Windows-1251");
        buffer = s.getBytes("UTF-8");
        fileOutputStream.write(buffer);

        fileInputStream.close();
        fileOutputStream.close();
    }
}
