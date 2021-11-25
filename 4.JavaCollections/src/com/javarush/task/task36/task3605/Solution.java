package com.javarush.task.task36.task3605;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        //BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        // D:\IdeaProjects\JavaRushTasks\ztest\task3605\file1.txt
        // D:\IdeaProjects\JavaRushTasks\ztest\task3605\file2.txt
        String fileName = args[0];//reader1.readLine();
        //reader1.close();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(fileInputStream));

        Set<Character> set = new TreeSet();
        String line;
        while ((line = reader2.readLine()) != null) {
            for (Character chr: line.toLowerCase().toCharArray()) {
                if (chr >= 97 && chr <= 122) set.add(chr);
            }
        }
        reader2.close();
        fileInputStream.close();
        int counter = 1;
        for (Character chr: set) {
            if (counter > 5) break;
            System.out.print(chr);
            counter ++;
        }

    }
}
