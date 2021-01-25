package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
/*        String greetings = "file1.txt\nfile2.txt\n";
        byte[] bytes = greetings.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        ArrayList<String> fileList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            str = reader.readLine();
            fileList.add(str);
        }
        reader.close();
        //System.out.println(fileList);

        FileInputStream fileInputStream1 = new FileInputStream(fileList.get(0));

        byte[] buffer1 = new byte[fileInputStream1.available()];
        int count1 = 0;
        if (fileInputStream1.available() > 0)
        {
            count1 = fileInputStream1.read(buffer1);
        }

        FileOutputStream fileOutputStream1 = new FileOutputStream(fileList.get(0));
        FileInputStream fileInputStream2 = new FileInputStream(fileList.get(1));

        byte[] buffer2 = new byte[1000];
        while (fileInputStream2.available() > 0) //пока есть еще непрочитанные байты
        {
            // прочитать очередной блок байт в переменную buffer и реальное количество в count
            int count2 = fileInputStream2.read(buffer2);
            fileOutputStream1.write(buffer2, 0, count2); //записать блок(часть блока) во второй поток
        }

        if (count1 > 0)
            fileOutputStream1.write(buffer1, 0, count1);


        fileInputStream1.close();
        fileOutputStream1.close();
        fileInputStream2.close();

    }
}
