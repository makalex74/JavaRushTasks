package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.round;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = "file1.txt".split(" ");
        String fileName = args[0];
        //System.out.println(fileName);
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        int cntAllSymbols = bufferedInputStream.available();
        int cntWhitespace = 0;
        int i;
        while ((i=bufferedInputStream.read()) != -1){
            Character ch = (char)i;
            if (ch.equals(' ')) cntWhitespace++;
        }
        bufferedInputStream.close();
        fileInputStream.close();
        //System.out.println(cntWhitespace);
        //System.out.println(cntAllSymbols);
        double procent = (double)cntWhitespace/cntAllSymbols*100;
        //System.out.println(roundbd(procent,3));
        System.out.printf("%.2f %n", procent);
    }

    private static double roundbd(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
