package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] m = new int[5] ;
        m[0] = Integer.parseInt(reader.readLine());
        m[1] = Integer.parseInt(reader.readLine());
        m[2] = Integer.parseInt(reader.readLine());
        m[3] = Integer.parseInt(reader.readLine());
        m[4] = Integer.parseInt(reader.readLine());
        int buf;
        //сортировка методом пузырька
        for (int j=0; j<4; j++){
            for (int i=0; i < 4-j; i++){
                if (m[i] >  m[i+1])
                {
                    buf = m[i];
                    m[i]=m[i+1];
                    m[i+1]=buf;
                }
            }
        }
        for (int i=0; i<5; i++){
            System.out.println(m[i]);
        }

    }
}
