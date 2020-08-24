package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = "file1.txt".split(" ");
        String fileName = args[0];
        //System.out.println(fileName);
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        List<String> list =  Arrays.asList(new String[] {"a", "b", "c", "d", "e", "f",
                "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
                "u", "v", "w", "x", "y", "z"});
        //System.out.println(list);
        int cnt = 0;
        int i;
        while ((i=bufferedInputStream.read()) != -1){
            Character ch = (char)i;
            if (list.contains(ch.toString()) || list.contains(ch.toString().toLowerCase())) cnt++;
        }
        bufferedInputStream.close();
        fileInputStream.close();
        System.out.println(cnt);
    }
}
