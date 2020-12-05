package com.javarush.task.task30.task3007;

/* 
Найдем число 2 в максимальной степени
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(maxPowerOf2(140_000));   //131072
        System.out.println(maxPowerOf2(1026));      //1024
        System.out.println(maxPowerOf2(17));        //16
    }

    public static int maxPowerOf2(int x) {
        x |= (x >> 1);
        x |= (x >> 2);
        x |= (x >> 4);
        x |= (x >> 8);
        x |= (x >> 16);
        x |= (x >> 32);
        x |= (x >> 64);
        x |= (x >> 128);
        return (x & ~(x >> 1));
    }
}


/*
    public static int maxPowerOf2(int x) {
//        System.out.println("Before");
//        System.out.println(" x = " + Integer.toString(x,2));
        x |= (x >> 1);
//        System.out.println(" x |= (x >> 1) = " + Integer.toString(x,2));
        x |= (x >> 2);
//        System.out.println(" x |= (x >> 2) = " + Integer.toString(x,2));
        x |= (x >> 4);
//        System.out.println(" x |= (x >> 4) = " + Integer.toString(x,2));
        x |= (x >> 8);
//        System.out.println(" x |= (x >> 8) = " + Integer.toString(x,2));
        x |= (x >> 16);
//        System.out.println(" x |= (x >> 16) = " + Integer.toString(x,2));
        x |= (x >> 32);
//        System.out.println(" x |= (x >> 32) = " + Integer.toString(x,2));
        x |= (x >> 64);
//        System.out.println(" x |= (x >> 64) = " + Integer.toString(x,2));
        x |= (x >> 128);
//        System.out.println(" x |= (x >> 128) = " + Integer.toString(x,2));

//        System.out.println(" Return (x & ~(x >> 1)) = " + Integer.toString((x & ~(x >> 1)),2));
        return (x & ~(x >> 1));
    }

 */