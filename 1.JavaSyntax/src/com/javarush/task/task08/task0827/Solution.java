package com.javarush.task.task08.task0827;

/* 
Работа с датой
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws ParseException {
        System.out.println(isDateOdd("JANUARY 2 2013"));
    }

    public static boolean isDateOdd(String date) throws ParseException {

        Date endDate =new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH).parse(date);
        //System.out.println("endDate: " + endDate);

        Date beginYearDate = new Date();
        beginYearDate.setHours(23);
        beginYearDate.setMinutes(59);
        beginYearDate.setSeconds(59);

        beginYearDate.setDate(31);      // первое число
        beginYearDate.setMonth(11);     // месяц январь, нумерация для месяцев 0-11
        beginYearDate.setYear(endDate.getYear()-1);

        //System.out.println("beginYearDate: " + beginYearDate);

        long msTimeDistance = endDate.getTime() - beginYearDate.getTime();
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках

        int dayCount = (int) (msTimeDistance/msDay); //количество целых дней
        //System.out.println("Days from start of year: " + dayCount);
        if (dayCount%2 == 0)
           return true;
        else
           return false;
    }
}
