package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
/*
            if (n < 0)
                return "0";
            else if (n == 0)
                return "1";
            else {
                double ret = 1;
                for (int i = 1; i <= n; ++i) ret *= i;
                return Double.toString(ret);
            }

*/
        BigInteger result =  BigInteger.valueOf(1);
        if (n >= 0) {
            for (int i = 1; i <= n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
        }
        else result = BigInteger.valueOf(0);
        return result +"";
    }
}
