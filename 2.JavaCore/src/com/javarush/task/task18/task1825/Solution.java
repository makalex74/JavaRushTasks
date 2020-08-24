package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Solution {

    public static void main(String[] args) throws IOException, InterruptedException {
/*        String greetings = "Lion.txt.part3\nLion.txt.part5\nLion.txt.part2\nLion.txt.part1\nLion.txt.part4\nend\n";
        byte[] bytes = greetings.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        ArrayList<String> fileList = new ArrayList<>();
        while (true) {
            str = reader.readLine();
            if (str.equals("end")) break;
            fileList.add(str);
        }
        reader.close();
        Collections.sort(fileList);
        //System.out.println(fileList);

        for (String item: fileList) {
            writeThread writeThread = new writeThread(item);
            writeThread.start();
            writeThread.join();
        }

     }

    public static class writeThread extends Thread {
        private String fileName;
        private String fileNameOut;
        public writeThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            this.fileNameOut = fileName.substring(0, fileName.indexOf("part")-1);
            //System.out.println("For file "+ fileName +" fileNameOut = "+fileNameOut);
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            FileInputStream fileInputStream = null;
            FileOutputStream fileOutputStream = null;
            try {
                fileInputStream = new FileInputStream(fileName);
                fileOutputStream = new FileOutputStream(fileNameOut,true);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            byte[] buffer = new byte[1000];
            while (true)
            {
                try {
                    if (!(fileInputStream.available() > 0)) break;
                    int count = fileInputStream.read(buffer);
                    fileOutputStream.write(buffer, 0, count);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
