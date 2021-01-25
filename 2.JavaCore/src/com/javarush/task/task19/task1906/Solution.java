package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
/*        String greetings = "file1.txt\nfile2.txt\n";
        byte[] bytes = greetings.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);*/

        BufferedReader readerCon = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = readerCon.readLine();
        String fileName2 = readerCon.readLine();
        readerCon.close();

        FileReader reader = new FileReader(fileName1);
        FileWriter writer = new FileWriter(fileName2);

        int numSimbol = 1;
        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = reader.read(); //читаем один символ (char будет расширен до int)
            if (numSimbol%2 == 0) {
                writer.write(data); //пишем один символ (int будет обрезан/сужен до char)
            }
            numSimbol++;
        }

        //закрываем потоки после использования
        reader.close();
        writer.close();
    }
}
