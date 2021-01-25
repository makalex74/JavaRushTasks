package com.javarush.task.task05.task0528;

/* 
Вывести на экран сегодняшнюю дату
*/

import java.util.*;
import java.text.*;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
//        DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
        DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
/*
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd 'и время' hh:mm:ss a zzz");
        System.out.println("Текущая дата " + formatForDateNow.format(dateNow));
*/
    }
}
