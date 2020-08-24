package com.javarush.task.task12.task1209;

/* 
Три метода и минимум
*/

public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
    public static int min(int a, int b){
        int res = a < b ? a : b;
        return res;
    }
    public static long min(long a, long b){
        long res = a < b ? a : b;
        return res;
    }
    public static double min(double a, double b){
        double res = a < b ? a : b;
        return res;
    }
}
