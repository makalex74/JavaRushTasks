package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<5; i++){
            strings.add(reader.readLine());
        }
        strings.remove(2);
        for (int i=strings.size()-1; i>=0; i--){
            System.out.println(strings.get(i));
        }
/*        System.out.println("---");
        for (String x : strings)   //быстрый for по всем элементам, только для коллекций
        {
            System.out.println(x);
        }
*/    }
}
