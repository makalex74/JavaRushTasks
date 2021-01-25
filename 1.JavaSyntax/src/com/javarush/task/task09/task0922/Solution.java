package com.javarush.task.task09.task0922;

/* 
Какое сегодня число?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dateString = reader.readLine();
        //2013-08-18
        Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(dateString);
        //System.out.println(date);
        //AUG 18, 2013

        SimpleDateFormat formatForDateNow = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println(formatForDateNow.format(date).toUpperCase());

        //System.out.println(new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH).format(date));


    }
}
