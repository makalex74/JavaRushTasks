package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int i=0; i<10; i++){
            arrayList.add(Integer.parseInt(reader.readLine()));
        }
        int maxLength = 1;
        int length = 1;
        for (int i=1; i < arrayList.size(); i++){
            if (arrayList.get(i).compareTo(arrayList.get(i-1)) == 0) {
                length++;
                maxLength = maxLength > length ? maxLength : length;
            } else length = 1;
            //System.out.println(arrayList.get(i-1) + " "+  arrayList.get(i) + " "+ length + " "+ maxLength);
        }
        System.out.println(maxLength);
    }
}