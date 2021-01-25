package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
/*        try {*/
            int a = Integer.parseInt(reader.readLine());
            if (a <= 0) throw new NotAPositiveNumber();
            int b = Integer.parseInt(reader.readLine());
            if (b <= 0) throw new NotAPositiveNumber();
            System.out.println(gcd(a, b));
/*        } catch (NumberFormatException e)
        {
            System.out.println("Ошибка ввода числа (чисел): "+e.toString());
        } catch (NotAPositiveNumber e)
        {
            System.out.println(e.toString());
        }*/
    }

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static class NotAPositiveNumber extends Exception{
        public String toString()
        {
            return "Ошибка. Число (числа) должны быть положительными.";
        }
    }
}
