package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("А", "Aлик");
        map.put("Б", "Толик");
        map.put("Вр", "Мишка");
        map.put("Г", "Кузьма");
        map.put("Д", "Aлик");
        map.put("Е", "Рустик");
        map.put("Ж", "Aлик");
        map.put("З", "Мишка");
        map.put("И", "Гришка");
        map.put("К", "Толик");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        //System.out.println("Заполняем еще одну карту списком дубликатов:");
        Map<String, String> mapDublicates = new HashMap<String, String>();
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            if (getCountTheSameFirstName(map, value) > 1)
                mapDublicates.put(key,value);
        }
/*
        System.out.println("Карта со списком дубликатов:");
        for (Map.Entry<String, String> pair : mapDublicates.entrySet())
        {
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            System.out.println(key + ":" + value);
        }
*/
        for (Map.Entry<String, String> pair : mapDublicates.entrySet())
        {
            //String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            removeItemFromMapByValue(map, value);
        }
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int cnt = 0;
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            if (value.equals(name)) {
//                System.out.println(key + ":" + value);
                cnt++;
            }
        }
        return cnt;
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
/*
        Map<String, String> map = createMap();
        System.out.println("Удаляем дубликаты");
        removeTheFirstNameDuplicates(map);

        System.out.println("Вывод после удаления");
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            System.out.println(key + ":" + value);
        }
*/
    }
}
