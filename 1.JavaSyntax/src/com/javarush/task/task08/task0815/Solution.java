package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        Map<String, String> map = new HashMap<String, String>();
        map.put("А", "Aлик");
        map.put("Б", "A");
        map.put("Вр", "Б");
        map.put("Г", "A");
        map.put("Д", "Aлик");
        map.put("Е", "В");
        map.put("Ж", "A");
        map.put("З", "A");
        map.put("И", "Г");
        map.put("К", "A");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        //напишите тут ваш код
        int cnt = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();            //ключ
            String value = pair.getValue();        //значение
            if (value.equals(name)) {
//                System.out.println(key + ":" + value);
                cnt++;
            }
        }
        return cnt;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int cnt = 0;
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<String, String> pair = iterator.next();
            String key = pair.getKey();            //ключ
            String value = pair.getValue();        //значение
            if (key.equals(lastName)) {
//                System.out.println(key + ":" + value);
                cnt++;
            }
        }
        return cnt;    }

    public static void main(String[] args) {
        Map<String, String> map = createMap();
//        System.out.println(getCountTheSameFirstName(map,"Aлик"));
//        System.out.println(getCountTheSameLastName(map,"Вр"));
    }
}
