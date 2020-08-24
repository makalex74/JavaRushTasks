package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

/*        String greetings = "file1.txt\nfile2.txt\nfile3.txt\n";
        byte[] bytes = greetings.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        ArrayList<String> fileList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            str = reader.readLine();
            fileList.add(str);
        }
        reader.close();
        //System.out.println(fileList);

        FileOutputStream fileOutputStream1 = new FileOutputStream(fileList.get(0),true);
        BufferedOutputStream bufferedOutputStream1 = new BufferedOutputStream(fileOutputStream1,300);

        FileInputStream fileInputStream2 = new FileInputStream(fileList.get(1));
        //BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream2,300);

        byte[] buffer = new byte[1000];
        while (fileInputStream2.available() > 0) //пока есть еще непрочитанные байты
        {
            // прочитать очередной блок байт в переменную buffer и реальное количество в count
            int count = fileInputStream2.read(buffer);
            bufferedOutputStream1.write(buffer, 0, count); //записать блок(часть блока) во второй поток
        }

        FileInputStream fileInputStream3 = new FileInputStream(fileList.get(2));
//        BufferedInputStream bufferedInputStream3 = new BufferedInputStream(fileInputStream2, 300);

        while (fileInputStream3.available() > 0) //пока есть еще непрочитанные байты
        {
            // прочитать очередной блок байт в переменную buffer и реальное количество в count
            int count = fileInputStream3.read(buffer);
            bufferedOutputStream1.write(buffer, 0, count); //записать блок(часть блока) во второй поток
        }

        bufferedOutputStream1.close();
        //bufferedInputStream2.close();
//        bufferedInputStream3.close();
        fileOutputStream1.close();
        fileInputStream2.close();
        fileInputStream3.close();
    }
}
