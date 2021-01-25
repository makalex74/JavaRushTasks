package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = "file1.txt file2.txt".split(" ");

        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        String str = null;
        String res = "";
        boolean isFirstWord = true;
        while (true) {
            str = bufferedReader.readLine();
            if (str == null) break;
            String[] arrStr = str.split(" ");
            for (int i = 0; i < arrStr.length ; i++) {
                if (arrStr[i].length() > 6) {
                    if (isFirstWord) {
                        res += arrStr[i];
                        bufferedWriter.write(arrStr[i]);
                        isFirstWord = false;
                    }
                    else {
                        res += "," + arrStr[i];
                        bufferedWriter.write("," + arrStr[i]);
                    }
                }
            }
        }
        bufferedReader.close();
        fileReader.close();
        bufferedWriter.close();
        fileWriter.close();

        //System.out.println(res);

    }
}
