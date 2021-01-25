package com.javarush.task.task10.task1019;

/* 
Функциональности маловато!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        while (true) {
            String idStr = reader.readLine();
            if (idStr.isEmpty()) break;
            int id = Integer.parseInt(idStr);
            String name = reader.readLine();
            map.put(name, id);
        }

        for (HashMap.Entry<String, Integer> s : map.entrySet()) {
            System.out.println(s.getValue() + " " + s.getKey());
        }
        //System.out.println("Id=" + id + " Name=" + name);
    }
}
