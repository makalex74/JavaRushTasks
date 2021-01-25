package com.javarush.task.task19.task1908;

/* 
Выделяем числа
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

        String longString = "";
        while (fileReader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            Character ch = (char)fileReader.read();
            longString += ch.toString();
        }
        bufferedReader.close();
        fileReader.close();

        //System.out.println(longString);

        String outputString = "";
        String[] arr = longString.split(" ");
        for (int i = 0; i < arr.length ; i++) {
            if (isNumber(arr[i])){
                outputString += arr[i] + " ";
            }
        }
        //System.out.println(outputString);

        FileWriter fileWriter = new FileWriter(fileName2);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        //закрываем потоки после использования
        bufferedWriter.write(outputString.trim());
        bufferedWriter.close();
        fileWriter.close();
    }

    public static boolean isNumber(String s){
        try {
            Double.parseDouble(s);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }

}
