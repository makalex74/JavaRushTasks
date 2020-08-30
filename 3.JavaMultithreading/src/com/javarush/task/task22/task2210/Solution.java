package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")));

    }

    public static String[] getTokens(String query, String delimiter) {
        List<String> listResult = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            listResult.add(token);
        }
        if (listResult.size() > 0){
            String[] result = new String[listResult.size()];
            for (int i = 0; i < listResult.size(); i++) {
                result[i] = listResult.get(i);
            }
            return result;
        }
        else{
            return null;
        }
    }
}
