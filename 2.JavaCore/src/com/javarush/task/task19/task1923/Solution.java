package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = "file1.txt file2.txt".split(" ");
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String str = null;
        String res = "";
        while (true) {
            str = bufferedReader.readLine();
            //System.out.println(str);
            if (str == null) break;
            String[] arrStr = str.split(" ");
            for (int i = 0; i < arrStr.length ; i++) {
                if (Pattern.matches("(.*[0-9]+.*)",arrStr[i]))
                    res += arrStr[i]+ " ";
            }
        }
        bufferedReader.close();
        fileReader.close();
        res = res.trim();
        System.out.println(res);
        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(res);
        bufferedWriter.close();
        fileWriter.close();
    }
}
