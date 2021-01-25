package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;
        int n = Integer.parseInt(reader.readLine());
        if (n > 0) {
            int cnt=1;
            while (cnt <= n) {
                int i = Integer.parseInt(reader.readLine());
                if (cnt == 1) maximum = i;
                maximum = maximum > i ? maximum : i;
                cnt++;
            }
            //напишите тут ваш код
            System.out.println(maximum);
        }
    }
}
