package com.javarush.task.task34.task3413;

/* 
Кеш на основании SoftReference
*/

public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();

        for (long i = 0; i < 2_500_000; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }

        for (long i = 0; i < 2_500; i++) {
            System.out.println(cache.get(i));
        }

        for (long i = 0; i < 500; i++) {
            System.out.println(cache.remove(i));
        }
    }
}