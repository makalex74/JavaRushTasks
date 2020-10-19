package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        ArrayList<Integer> arrlst = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            arrlst.add(array[i]);
        }
        Collections.sort(arrlst);
        for (int i=0; i < arrlst.size(); i++) {
            array[array.length-1-i] = arrlst.get(i);
        }
    }
}
