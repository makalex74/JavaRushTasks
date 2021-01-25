package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = "3333".split(" ");
        String idStr = args[0];
        //System.out.println(fileName);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();//products.txt
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        List<String> list = new ArrayList<>();
        String stringLine = "";
        while ((stringLine = bufferedReader.readLine()) != null){
            list.add(stringLine);
        }
        for (String item: list) {
            if (item.startsWith(idStr + " "))
              System.out.println(item);
        }
        bufferedReader.close();
        fileInputStream.close();
    }
}
