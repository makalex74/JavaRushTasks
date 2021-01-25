package com.javarush.task.task04.task0433;

/* 
Гадание на долларовый счет
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        int i = 1;
        while (i <= 10) {
            int j = 1;
            while (j <= 10) {
                if (j < 10)
                    System.out.print("S");
                else
                    System.out.println("S");
                j++;
            }

            i++;
        }
    }
}
