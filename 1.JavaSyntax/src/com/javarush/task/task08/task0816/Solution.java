package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Пупкин", dateFormat.parse("JUN 1 2012"));
        map.put("Кузькин", dateFormat.parse("OCT 1 2012"));
        map.put("Форточкин", dateFormat.parse("JAN 1 2012"));
        map.put("Закускин", dateFormat.parse("FEB 1 2012"));
        map.put("Выпивохин", dateFormat.parse("MAR 1 2012"));
        map.put("Рух", dateFormat.parse("AUG 1 2012"));
        map.put("Пух", dateFormat.parse("DEC 1 2012"));
        map.put("Бух", dateFormat.parse("JUL 1 2012"));
        map.put("Главбух", dateFormat.parse("MAY 1 2012"));
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<String, Date> pair = iterator.next();
            String key = pair.getKey();            //ключ
            Date value = pair.getValue();        //значение
            if ((value.getMonth() == 5) || (value.getMonth() == 6) || (value.getMonth() == 7)) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) throws ParseException {
/*        Map<String, Date> map = createMap();

        removeAllSummerPeople(map);

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<String, Date> pair = iterator.next();
            String key = pair.getKey();            //ключ
            Date value = pair.getValue();        //значение
//            if ((value.getMonth() == 5) || (value.getMonth() == 6) || (value.getMonth() == 7)) {
                System.out.println(key + ":" + value + " " + value.getMonth());
//            }
        }*/
    }
}
