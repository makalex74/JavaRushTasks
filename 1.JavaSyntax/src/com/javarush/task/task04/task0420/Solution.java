package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] m = new int[3] ;
        m[0] = Integer.parseInt(reader.readLine());
        m[1] = Integer.parseInt(reader.readLine());
        m[2] = Integer.parseInt(reader.readLine());
        int buf;
        //сортировка методом пузырька
        for (int j=0; j<2; j++){
            for (int i=0; i < 2-j; i++){
                if (m[i] <  m[i+1])
                {
                  buf = m[i];
                  m[i]=m[i+1];
                  m[i+1]=buf;
                }
            }
        }
        System.out.println(m[0] +" "+ m[1] +" "+ m[2]);
    }

}
