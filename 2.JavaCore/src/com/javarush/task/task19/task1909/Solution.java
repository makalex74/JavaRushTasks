package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

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

        FileReader fileReader = new FileReader(fileName1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(fileName2);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String str = "";
        while ((str = bufferedReader.readLine()) != null)
        {
           str = str.replace(".","!");
           System.out.println(str);
           bufferedWriter.write(str + System.lineSeparator());
        }
        bufferedReader.close();
        fileReader.close();
        bufferedWriter.close();
        fileWriter.close();

    }
}
