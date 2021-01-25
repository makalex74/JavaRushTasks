package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // Найти минимум тут
        int res = 0;
        for (int i = 0; i < array.size(); i++) {
            if (i==0)
                res = array.get(0);
            else
                res = res < array.get(i) ? res : array.get(i);
        }
        return res;
    }

    public static List<Integer> getIntegerList() throws IOException {
        // Создать и заполнить список тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Integer> res = new ArrayList<Integer>();
        for (int i=0; i<n; i++){
            res.add(Integer.parseInt(reader.readLine()));
        }
        return res;
    }
}
