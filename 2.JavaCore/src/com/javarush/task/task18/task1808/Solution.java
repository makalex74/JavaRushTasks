package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine(); //file1.txt
        String fileName2 = reader.readLine(); //file2.txt
        String fileName3 = reader.readLine(); //file3.txt
/*        String fileName1 = "file1.txt";
        String fileName2 = "file2.txt";
        String fileName3 = "file3.txt";*/

        reader.close();
        FileInputStream inputStream1 = new FileInputStream(fileName1);
        FileOutputStream outputStream2 = new FileOutputStream(fileName2);
        FileOutputStream outputStream3 = new FileOutputStream(fileName3);

        /*
        Считать с консоли три имени файла: файл1, файл2, файл3.
                Разделить файл1 по следующему критерию:
        Первую половину байт записать в файл2, вторую половину байт записать в файл3.
                Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
                Закрыть потоки.*/

        if (inputStream1.available() > 0) {
            //System.out.println("cntByteInFile1 = " + inputStream1.available());
            int cntByteToFile2 = inputStream1.available()/2;
            int cntByteToFile3 = inputStream1.available()/2;
            if (inputStream1.available()%2 > 0)
                cntByteToFile2 = inputStream1.available() - inputStream1.available()/2;
            //System.out.println("cntByteToFile2 = " + cntByteToFile2);
            //System.out.println("cntByteToFile3 = " + cntByteToFile3);
            //читаем половину файла одним куском
            byte[] buffer = new byte[cntByteToFile2];
            int count = inputStream1.read(buffer);
            outputStream2.write(buffer, 0, count);
            buffer = new byte[cntByteToFile3];
            count = inputStream1.read(buffer);
            outputStream3.write(buffer, 0, count);
        }
        inputStream1.close();
        outputStream2.close();
        outputStream3.close();
    }
}
