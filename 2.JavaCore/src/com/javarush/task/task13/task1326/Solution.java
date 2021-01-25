package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine(); //testFile.txt

        InputStream inputStream = new FileInputStream(fileName);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(inputStream));

        ArrayList<Integer> list = new ArrayList<>();

        String line;
        while ((line = reader1.readLine()) != null) {
                list.add(Integer.parseInt(line));
        }
        Collections.sort(list);
        for (Integer item : list) {
            if (item % 2 == 0) System.out.println(item);
        }
        reader.close();
        reader1.close();
        inputStream.close();
    }
}
