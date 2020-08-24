package com.javarush.task.task18.task1804;

/* 
Самые редкие байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine(); //file1.txt
        reader.close();
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        FileInputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0){
            list.add(inputStream.read());
        }
        inputStream.close();
        //System.out.println(list);
        //Запихиваем в мапу с подсчетом количества повторов:
        //key - байт, value - количество его повторов
        for (Integer item: list) {
            if (map.containsKey(item)) {
                Integer cnt = map.get(item);
                map.put(item,++cnt);
            } else map.put(item,0);
        }
        //System.out.println(map);
        Integer cntMin = 0;
        //Находим минимальное количество повторов
        for (Integer item: map.values()) {
            cntMin = cntMin < item ? cntMin : item;
        }
        //System.out.println(cntMin);
        //Выводим keys мапы c мимнимальным количеством повторов
        String stringOutput = "";
        for (HashMap.Entry item: map.entrySet()) {
            if (item.getValue().equals(cntMin))
                stringOutput += item.getKey() + " ";
        }
        System.out.print(stringOutput.trim());
    }
}
