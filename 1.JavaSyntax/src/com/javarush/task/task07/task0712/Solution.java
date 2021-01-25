package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] lens = new int[10];
        int minLen = 0;
        int maxLen = 0;
        for (int i=0; i<10; i++){
            strings.add(reader.readLine());
            lens[i] = strings.get(i).length();
            if (i == 0) {
                minLen = lens[i];
                maxLen = lens[i];
            }
            else {
                minLen = minLen < lens[i] ? minLen : lens[i];
                maxLen = maxLen > lens[i] ? maxLen : lens[i];
            }
        }
        for (int i=0; i<10; i++){
           if ((lens[i] == minLen) || (lens[i] == maxLen)) {
               System.out.println(strings.get(i));
               break;
           }

        }
    }
}
