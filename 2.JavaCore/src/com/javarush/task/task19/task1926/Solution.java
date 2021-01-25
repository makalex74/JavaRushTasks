package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
/*        String greetings = "file1.txt\n";
        byte[] bytes = greetings.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);*/

        BufferedReader readerCon = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = readerCon.readLine();
        readerCon.close();

        FileReader fileReader = new FileReader(fileName1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String str = null;
        String reverseString = null;
        while (true) {
            str = bufferedReader.readLine();
            if (str == null) break;
            //System.out.println(str);
            //разворачиваем строку
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.reverse();
            reverseString = stringBuilder.toString();
            System.out.println(reverseString);
        }
        bufferedReader.close();
        fileReader.close();
    }
}
