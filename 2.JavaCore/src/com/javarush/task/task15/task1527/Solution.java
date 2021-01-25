package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
Пример 1
Ввод:
http:/javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name
Пример 2
Ввод:
http:/javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double: 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String urlString = reader.readLine();
        int indexQuestion = urlString.indexOf("?");
        //System.out.println(indexQuestion);
        String substringAfterQuestion = urlString.substring(indexQuestion+1);
        //System.out.println(substringAfterQuestion);

        ArrayList<Integer> posFirstLetters = new ArrayList<>();
        ArrayList<Integer> posLastLetters = new ArrayList<>();
        posFirstLetters.add(0);
        char[] chArr = substringAfterQuestion.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] == '&') /*&& (i != chArr.length -1))*/ {
                posLastLetters.add(i);
                posFirstLetters.add(i+1);
            }
        }
        posLastLetters.add(substringAfterQuestion.length());

/*        for (Integer item: posFirstLetters) {
            System.out.println(item);
        }
        for (Integer item: posLastLetters) {
            System.out.println(item);
        }*/

        ArrayList<String> list = new ArrayList<>();
        String str = "";
        for (int i = 0; i < posFirstLetters.size()  ; i++) {
            str = substringAfterQuestion.substring(posFirstLetters.get(i),posLastLetters.get(i));
            //System.out.println("str = "+ str);
            list.add(str);
        }
        String strFinal = "";
        for (String item: list) {
            if (item.contains("="))
                strFinal = strFinal + item.substring(0, item.indexOf("=")) + " ";
            else
                strFinal = strFinal + item + " ";
        }
        System.out.println(strFinal.trim());
        String numberStr = "";
        for (String item: list) {
            if (item.contains("obj=")) {
                numberStr = item.substring(item.indexOf("=") + 1);
                if (isDouble(numberStr))
                    alert(Double.parseDouble(numberStr));
                else
                    alert(numberStr);
            }
        }
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }


    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
