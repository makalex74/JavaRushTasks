package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<Integer> numbers3 = new ArrayList<Integer>();
        ArrayList<Integer> numbers2 = new ArrayList<Integer>();
        ArrayList<Integer> numbersOthers = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<20; i++){
            numbers.add(Integer.parseInt(reader.readLine()));
        }
        for (int i=0; i<numbers.size(); i++) {
            Integer n = numbers.get(i);
            if ((n % 3 == 0) || (n % 2 == 0)) {
                if (n % 3 == 0) numbers3.add(n);
                if (n % 2 == 0) numbers2.add(n);
            }
               else numbersOthers.add(n);
        }
        printList(numbers3);
        printList(numbers2);
        printList(numbersOthers);

    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }

    }
}
