package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        String str = Integer.toString(number);
        //преобразовываем строку в массив
        char[] chArray = str.toCharArray();
        int resSum = 0;
        //перебираем все элементы массива
        for(int i = 0; i<chArray.length; i++){
            resSum = resSum + Character.getNumericValue(chArray[i]);
        }
        return resSum;
    }
}