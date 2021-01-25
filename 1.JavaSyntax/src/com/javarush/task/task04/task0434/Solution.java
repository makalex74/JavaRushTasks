package com.javarush.task.task04.task0434;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int i = 1;
        while (i <= 10) {
            int j = 1;
            while (j <= 10) {
                if (j < 10)
                    System.out.print(i*j + " ");
                else
                    System.out.println(i*j);
                j++;
            }

            i++;
        }
    }
}
