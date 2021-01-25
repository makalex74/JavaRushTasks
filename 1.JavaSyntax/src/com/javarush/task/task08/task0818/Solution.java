package com.javarush.task.task08.task0818;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        //напишите тут ваш код
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("А", 500);
        map.put("Б", 300);
        map.put("Вр", 200);
        map.put("Г", 1000);
        map.put("Д", 1500);
        map.put("Е", 2000);
        map.put("Ж", 2500);
        map.put("З", 350);
        map.put("И", 250);
        map.put("К", 150);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
        //напишите тут ваш код

        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<String, Integer> pair = iterator.next();
            //String key = pair.getKey();            //ключ
            Integer value = pair.getValue();        //значение
            if (value < 500) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
/*        Map<String, Integer> map = createMap();
        System.out.println("Удаляем < 500");
        removeItemFromMap(map);

        System.out.println("Вывод после удаления");
        for (Map.Entry<String, Integer> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
            Integer value = pair.getValue();                  //значение
            System.out.println(key + ":" + value);
        }
*/
    }
}