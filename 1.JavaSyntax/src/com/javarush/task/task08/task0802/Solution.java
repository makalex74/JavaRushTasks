package com.javarush.task.task08.task0802;

/* 
Map из 10 пар
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        {
            //все элементы хранятся в парах
            Map<String, String> map = new HashMap<String, String>();
            map.put("арбуз", "ягода");
            map.put("банан", "трава");
            map.put("вишня", "ягода");
            map.put("груша", "фрукт");
            map.put("дыня", "овощ");
            map.put("ежевика", "куст");
            map.put("жень-шень", "корень");
            map.put("земляника", "ягода");
            map.put("ирис", "цветок");
            map.put("картофель", "клубень");

            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

            while (iterator.hasNext())
            {
                //получение «пары» элементов
                Map.Entry<String, String> pair = iterator.next();
                String key = pair.getKey();            //ключ
                String value = pair.getValue();        //значение
                System.out.println(key + " - " + value);
            }
        }
    }
}
