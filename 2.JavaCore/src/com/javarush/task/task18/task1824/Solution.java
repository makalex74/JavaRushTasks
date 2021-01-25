package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
/*        String greetings = "file1.txt\nfile2.txt\nfile3.txt\nexit\n";
        byte[] bytes = greetings.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String strFileName;
//        ArrayList<String> fileList = new ArrayList<>();
        FileInputStream fileInputStream = null;
        while (true) {
            strFileName = reader.readLine();
            try {
                fileInputStream = new FileInputStream(strFileName);
                //System.out.println("Закрываем поток");
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                System.out.println(strFileName);
                //System.out.println(fileInputStream);
                reader.close();
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
