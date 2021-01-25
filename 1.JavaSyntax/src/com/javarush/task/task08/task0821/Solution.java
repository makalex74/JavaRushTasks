package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleMap();
        printPeopleMap(map);
    }

    public static Map<String, String> createPeopleMap() {
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
        map.put("И", "Толик");
        return map;
    }

    public static void printPeopleMap(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
