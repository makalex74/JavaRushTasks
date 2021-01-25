package com.javarush.task.task09.task0919;

/* 
Деление на ноль
*/

public class Solution {
    public static void divideByZero(){
        double div = 1/0;
        System.out.println(div);
    };


    public static void main(String[] args) {
        try {
            divideByZero();
        }
        catch (ArithmeticException e)
        {
            //System.out.println("Деление на НОЛЬ!");
            e.printStackTrace();
        }
    }
}
