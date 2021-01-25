package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Map<Integer, String> numberOfMonth = new HashMap<>();

        numberOfMonth.put(1, "January");
        numberOfMonth.put(2, "February");
        numberOfMonth.put(3, "March");
        numberOfMonth.put(4, "April");
        numberOfMonth.put(5, "May");
        numberOfMonth.put(6, "June");
        numberOfMonth.put(7, "July");
        numberOfMonth.put(8, "August");
        numberOfMonth.put(9, "September");
        numberOfMonth.put(10, "October");
        numberOfMonth.put(11, "November");
        numberOfMonth.put(12, "December");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputName = reader.readLine();

        if (numberOfMonth.containsValue(inputName)){
            for (Map.Entry entry: numberOfMonth.entrySet()) {
                if (entry.getValue().equals(inputName))
                    System.out.println(entry.getValue() + " is the " + entry.getKey() + " month");
            }
        }
        //else
        //    System.out.println("Такого номера месяца не сущетвует");
    }
}
