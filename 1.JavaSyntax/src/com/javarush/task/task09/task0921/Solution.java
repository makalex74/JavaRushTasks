package com.javarush.task.task09.task0921;

/* 
Метод в try..catch
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        List<Integer> list = new ArrayList<Integer>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                int a = Integer.parseInt(reader.readLine());
                if (a == -1) break;
                list.add(a);
            }
        } catch (Exception e)
        {
            //System.out.println(e.getMessage());
            for (Integer x : list)   //быстрый for по всем элементам, только для коллекций
            {
                System.out.println(x);
            }
        }
    }
}
