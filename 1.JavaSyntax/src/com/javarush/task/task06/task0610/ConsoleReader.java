package com.javarush.task.task06.task0610;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Класс ConsoleReader
*/

public class ConsoleReader {
    public static String readString() throws Exception {
        //напишите тут ваш код
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        String res = bis.readLine();
        return res;
    }

    public static int readInt() throws Exception {
        //напишите тут ваш код
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        int res = Integer.parseInt(bis.readLine());
        return res;
    }

    public static double readDouble() throws Exception {
        //напишите тут ваш код
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double res = Double.parseDouble(bis.readLine());
        return res;
    }

    public static boolean readBoolean() throws Exception {
        //напишите тут ваш код
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        boolean res = Boolean.parseBoolean(bis.readLine());
        return res;
    }

    public static void main(String[] args) throws Exception {

    }
}
