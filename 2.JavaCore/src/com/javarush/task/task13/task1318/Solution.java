package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        InputStream inputStream = null;
        BufferedInputStream buffer = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {

            String fileName = reader.readLine();
            //inputStream = new FileInputStream("D:/Users/UserName/someFile.txt");
            inputStream = new FileInputStream(fileName);

            buffer = new BufferedInputStream(inputStream);

            while(buffer.available()>0) {

                char c = (char)buffer.read();
                System.out.print(c);

                //System.out.println("Был прочитан символ " + c);
            }
        } catch(Exception e) {

            e.printStackTrace();

        } finally {

            inputStream.close();
            buffer.close();
            reader.close();
        }
    }
}