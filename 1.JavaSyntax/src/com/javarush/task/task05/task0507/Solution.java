package com.javarush.task.task05.task0507;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Среднее арифметическое
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0.0;
        int cnt = 0;
        while (true) {
            int num = Integer.parseInt(reader.readLine());
            if (num == -1)
               break;
            sum += num;
            cnt++;
        }
        //double avg = sum/cnt;
        //System.out.println(avg);
        System.out.println(sum/cnt);
    }
}

