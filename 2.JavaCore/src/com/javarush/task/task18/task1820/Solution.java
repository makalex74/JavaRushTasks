package com.javarush.task.task18.task1820;

/* 
Округление чисел
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

        String readString = "";
        int i;
        while (fileInputStream1.available() > 0) //пока есть еще непрочитанные байты
        {
            i = fileInputStream1.read();
            Character ch = (char)i;
            readString += ch.toString();
        }
        //System.out.println(readString);
        String[] arrNum = readString.split(" ");
        
        String writeString = ""; 
        for (int j = 0; j < arrNum.length ; j++) {
            writeString += Math.round(Double.parseDouble(arrNum[j])) +" ";
        }
        writeString = writeString.trim();
        //System.out.println(writeString);
                
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileList.get(1));
        fileOutputStream2.write(writeString.getBytes());

        fileInputStream1.close();
        fileOutputStream2.close();
    }
}
