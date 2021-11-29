package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Древний Рим
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        char[] letters = s.toCharArray();
        int[] digits = new int[letters.length];
        for (int i=0; i< letters.length; i++) {
            switch (letters[i]) {
                case 'I':
                    digits[i]=1;
                    break;
                case 'V':
                    digits[i]=5;
                    break;
                case 'X':
                    digits[i]=10;
                    break;
                case 'L':
                    digits[i]=50;
                    break;
                case 'C':
                    digits[i]=100;
                    break;
                case 'D':
                    digits[i]=500;
                    break;
                case 'M':
                    digits[i]=1000;
                    break;
            }
        }
        System.out.println(Arrays.toString(digits));
        //{I, V, X, L, C, D, M}
        return 0;
    }
}
