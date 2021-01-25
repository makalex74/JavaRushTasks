package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        //FileOutputStream outputStream = null;
        //BufferedOutputStream bufferedStream = null;
        BufferedWriter writerr = null;
        BufferedReader reader = null;
        ArrayList<String> list = new ArrayList<>();
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            //outputStream = new FileOutputStream(fileName); //testFile.txt
            //bufferedStream = new BufferedOutputStream(outputStream);
            writerr = new BufferedWriter(new FileWriter(fileName));
            while (true)
            {
                String str = reader.readLine();
                list.add(str);
                if (str.equals("exit")) break;
            }

            for (String item: list) {
/*                byte[] buffer = item.getBytes();
                bufferedStream.write(buffer, 0, buffer.length);
                String s = "\n";
                byte[] buf = s.getBytes();
                bufferedStream.write(buf, 0, buf.length);*/
                writerr.write(item + "\n");
            }

        } catch(Exception e) {

            e.printStackTrace();

        } finally {
            //bufferedStream.close();
            //outputStream.close();
            writerr.close();
            reader.close();
        }
    }
}
