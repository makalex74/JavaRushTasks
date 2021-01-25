package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        strings = new ArrayList<String>();
        int maxLen = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<5; i++){
            strings.add(reader.readLine());
        //    if (i == 0)
        //        maxLen = strings.get(i).length();
        //    else
                maxLen = maxLen >  strings.get(i).length() ? maxLen : strings.get(i).length();
        }
        for (int i=0; i<strings.size(); i++){
            if (strings.get(i).length() == maxLen)
                System.out.println(strings.get(i));
        }
    }
}
