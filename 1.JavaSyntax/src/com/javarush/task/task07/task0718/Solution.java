package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // Считать строки с консоли и объявить ArrayList list тут
        ArrayList<String> list = new ArrayList<String>();
        //ArrayList<Integer> listLen = new ArrayList<Integer>();
        ArrayList<String> listSorted = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            list.add(reader.readLine());
            //listLen.add(list.get(i).length());
        }
        listSorted.addAll(list);
        Collections.sort(listSorted,new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.length() < o2.length() ? -1 : 0 ;
            }
        });
/*
        for (String x : listSorted)   //быстрый for по всем элементам, только для коллекций
        {
            System.out.println(x);
        }
*/
        if (!list.equals(listSorted)){
/*            for (int i = 0; i < list.size(); i++) {
               if (list.get(i).length() != listSorted.get(i).length()) {
                   System.out.println(i);
                   break;
               }
*/
            for (int i = 1; i < list.size(); i++) {
               if (list.get(i-1).length() > list.get(i).length()) {
                   System.out.println(i);
                   break;
               }

            }
        }

    }
}

