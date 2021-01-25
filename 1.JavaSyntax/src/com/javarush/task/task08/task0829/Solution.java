package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,String> mapFamilyCity = new HashMap<>();
        while (true) {
            //System.out.println("Input City: ");
            String city = reader.readLine();
            if (city.isEmpty()) {
                //System.out.println("break city");
                break;
            }
            //System.out.println("Input Family: ");
            String family = reader.readLine();
            if (family.isEmpty()) {
                //System.out.println("break family");
                break;
            }
            mapFamilyCity.put(family,city);
        }
        //System.out.println(mapFamilyCity);

        //System.out.println("Read the City: ");
        String readCity = reader.readLine();

        if (mapFamilyCity.containsValue(readCity)){
            for (Map.Entry entry: mapFamilyCity.entrySet()) {
                if (entry.getValue().equals(readCity))
                    System.out.println(entry.getKey());
            }
        }
    }
}
