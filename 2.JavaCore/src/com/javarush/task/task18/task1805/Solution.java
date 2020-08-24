package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
        //Запихиваем в мапу
        //key - байт
        for (Integer item: list) {
            map.put(item,0);
        }
        //System.out.println(map);
        //Очищаем список;
        list.clear();
        //Записываем keys мапы обратно в список но без повторов )
        for (HashMap.Entry item: map.entrySet()) {
                list.add((Integer) item.getKey());
        }
        Collections.sort(list);
        //System.out.println(list);
        String stringOutput = "";
        for (Integer item: list) {
                stringOutput += item + " ";
        }
        System.out.print(stringOutput.trim());
    }
}
