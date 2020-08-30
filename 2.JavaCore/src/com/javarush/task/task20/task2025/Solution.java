package com.javarush.task.task20.task2025;

import java.util.*;

/*
Алгоритмы-числа
*/

public class Solution {
    private static long[][] pows;
    public static long[] getNumbers(long N) {
        long[] result = new long[0];
        if( N <= Long.MAX_VALUE) {
            TreeSet<Long> set = new TreeSet<>();
            int powIndex = String.valueOf(N).length();
            int actualPowIndex = 0;
            genPows(powIndex);
            int[] genDigit = new int[powIndex];
            boolean bool = true;
            if (powIndex == 1) { //для чисел < 10
                for(long l = N - 1; l > 0; l--) {
                    set.add(l);
                }
            } else { //для чисел > 10
                while (bool) {
                    genDigit[0] += 1;
                    for (int i = 0; i < powIndex - 1; i++) { //старт нулевого метательного блока
                        if (genDigit[i] == 10) {
                            genDigit[i] = 0;
                            if (i != genDigit.length - 1) {
                                genDigit[i + 1] += 1;
                                if (genDigit[i + 1] == 1 && i == actualPowIndex) {
                                    actualPowIndex++;
                                    break;
                                } else if (genDigit[genDigit.length - 1] == 10) {
                                    bool = false;
                                    break;
                                }
                            }
                        }
                    } //конец нулевого метательного блока
                    boolean bool1 = true; //запуск блока генерации уникальных номеров
                    int counterNine = 0;
                    int counterZero = 0;
                    if (bool) {
                        for (int i = 0; i < actualPowIndex; i++) {
                            if (genDigit[i] > genDigit[i + 1] && genDigit[i] != 0) {
                                genDigit[i] = 0;
                                genDigit[i + 1] += 1;
                            }
                            if (genDigit[i] == 9) {
                                counterNine++;
                            } else if (genDigit[i] == 0) {
                                counterZero++;
                            }
                        }
                    }
                    if (counterNine > 3 || counterZero > 3) {
                        bool1 = false;
                    }   //конец блока генерации уникальных номеров
                    if (bool && bool1) { //запуск блока проверки номера
                        long newDigit = 0;
                        for (int value : genDigit) {
                            newDigit += pows[value][actualPowIndex + 1];
                        }
                        int[] temp = digitToArray(newDigit, actualPowIndex + 1, N);
                        long tempDigit = 0;
                        for (int value : temp) {
                            if (tempDigit >= 0) {
                                tempDigit += pows[value][temp.length]; //370 = 3*3*3 + 7*7*7 + 0*0*0
                            }
                        }
                        if (tempDigit == newDigit) {
                            set.add(newDigit);
                        }
                    }
                }
            }   //конец блока проверки номера
            result = new long[set.size()];  //array filling block START
            int j = 0;
            for (long e : set) {
                if (e < N && e > 0) {
                    result[j] = e;
                    j++;
                }
            }
        }  //конец блока заполнения массива
        return result;
    }

    //способ формирования таблицы степеней
    private static void genPows(int N) {
        pows = new long[10][N + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
                //System.out.print( pows[i][j]+ " ");
            }
            //System.out.println();
        }
    }

    //способ преобразования массива в цифру (включая условия)
    public static int[] digitToArray(long num, int len, long N) {
        String temp = Long.toString(num);
        //System.out.println("temp = "+temp);
        int[] newArray = new int[0];
        if (temp.length() == len && num > 0 && num < N) {
            newArray = new int[temp.length()];
            for (int i = 0; i < temp.length(); i++) {
                newArray[i] = temp.charAt(temp.length() - 1 - i) - '0';
                //System.out.println("temp.charAt(temp.length() - 1 - i) = "+temp.charAt(temp.length() - 1 - i));
                //System.out.println("temp.charAt(temp.length() - 1 - i) - '0' = "+(temp.charAt(temp.length() - 1 - i) - '0'));
            }
        }
        //System.out.println("newArray = "+Arrays.toString(newArray));
        return newArray;
    }



    public static void main(String[] args) {
/*        long [] result = getNumbers(Long.MAX_VALUE);
        long [] result1 = getNumbers(100);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));*/

        long start = System.currentTimeMillis();
        //long[] result = getNumbers(Long.MAX_VALUE);
        long[] result = getNumbers(1000);
/*        for (long l : result) {
            System.out.println(l);
        }*/
        long finish = System.currentTimeMillis();
        System.out.println("Time consumed: " + (finish - start) + " ms");
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
    }
}