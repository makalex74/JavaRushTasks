package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }

        String[] array = list.toArray(new String[0]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        // напишите тут ваш код
        //Список строк
        List<String> listStr = new ArrayList<>();
        //Список чисел
        List<Integer> listDgt = new ArrayList<>();
        //Список порядка чисел, строк
        List<Integer> listFlagIsDgt = new ArrayList<>();
        for (int i = 0; i < array.length ; i++) {
            if (isNumber(array[i])) {
                listDgt.add(Integer.parseInt(array[i]));
                listFlagIsDgt.add(1);
            }
            else {
                listStr.add(array[i]);
                listFlagIsDgt.add(0);
            }
        }


        //Сортируем строки
        Collections.sort(listStr,new Comparator<String>() {
            public int compare(String s1, String s2) {
                return isGreaterThan(s1, s2) ? 1 : -1;
            }});

/*        System.out.println("Отсортированные строки:");
        System.out.println("------------------------");
        for (String x : listStr) {
            System.out.println(x);
        }*/

        //Сортируем числа
        Collections.sort(listDgt);
        Collections.reverse(listDgt);

/*        System.out.println("Отсортированные числа:");
        System.out.println("------------------------");
        for (Integer x : listDgt) {
            System.out.println(x);
        }*/


/*        System.out.println("listFlagIsDgt:");
        System.out.println("------------------------");
        for (Integer x : listFlagIsDgt) {
            System.out.println(x);
        }*/

/*        System.out.println("все вместе:");
        System.out.println("------------------------");*/


        for (int i = 0; i < array.length ; i++) {
            if (listFlagIsDgt.get(i) == 0) {
                array[i] = listStr.get(0);
                listStr.remove(0);
            }
            else{
                array[i] = String.valueOf(listDgt.get(0));
                listDgt.remove(0);
            }

        }

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                    || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                    || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
