package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        ArrayList<String> list = new ArrayList<String>();
        //ArrayList<String> listM = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            list.add(reader.readLine());
            //if (i < m) listM.add(list.get(i));
        }
        for (int i = 0; i < m; i++) {
            list.add(list.get(i));
        }
        Iterator<String> listIterator = list.iterator();//создаем итератор
        int j = 0;
        while(listIterator.hasNext()) {//до тех пор, пока в списке есть элементы
            String nextElement = listIterator.next();//получаем следующий элемент
            if (j < m)  listIterator.remove(); //Удаляем текущий элемент
            j++;
        }
        //list.addAll(listM);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
