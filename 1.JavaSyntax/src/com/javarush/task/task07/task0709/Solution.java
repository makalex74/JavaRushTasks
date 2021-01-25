package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>();
        int minLen = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<5; i++){
            strings.add(reader.readLine());
                if (i == 0)
                    minLen = strings.get(i).length();
                else
                    minLen = minLen <  strings.get(i).length() ? minLen : strings.get(i).length();
        }
        for (int i=0; i<strings.size(); i++){
            if (strings.get(i).length() == minLen)
                System.out.println(strings.get(i));
        }
    }
}
