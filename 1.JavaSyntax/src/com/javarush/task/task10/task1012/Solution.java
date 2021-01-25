package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        // напишите тут ваш код
        Map<Character,Integer> map = new HashMap<>();
        for (Character item: alphabet) {
             map.put(item, 0);
        }

        for (String itemFromListStr: list){
            char[] chArr = itemFromListStr.toCharArray();
            for (int i = 0; i < chArr.length; i++) {
                for (Character itemFromListAlpha: alphabet) {
                    if ((int)chArr[i] == (int)itemFromListAlpha) {
                        int cntBefore = map.get(chArr[i]);
                        map.put(chArr[i], cntBefore+1);
                    }
                }

            }
        }

/*        for (Map.Entry<Character,Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }*/
        for (Character item: alphabet) {
            //map.put(item,1);
            if (map.containsKey(item))
              System.out.println(item +" "+ map.get(item));
        }


    }
}
