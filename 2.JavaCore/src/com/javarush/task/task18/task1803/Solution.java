package com.javarush.task.task18.task1803;

/* 
Самые частые байты
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
        Integer cntMax = 0;
        //Находим максимальное количество повторов
        for (Integer item: map.values()) {
            cntMax = cntMax > item ? cntMax : item;
        }
        //System.out.println(cntMax);
        //Выводим keys мапы c максимальным количеством повторов
        String stringOutput = "";
        for (HashMap.Entry item: map.entrySet()) {
            if (item.getValue().equals(cntMax))
                stringOutput += item.getKey() + " ";
        }
        System.out.print(stringOutput.trim());
    }
}
