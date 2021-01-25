package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String,Cat> map = new HashMap<>();
        Cat cat1 = new Cat ("Васька1");
        map.put(cat1.name, cat1);
        Cat cat2 = new Cat ("Васька2");
        map.put(cat2.name, cat2);
        Cat cat3 = new Cat ("Васька3");
        map.put(cat3.name, cat3);
        Cat cat4 = new Cat ("Васька4");
        map.put(cat4.name, cat4);
        Cat cat5 = new Cat ("Васька5");
        map.put(cat5.name, cat5);
        Cat cat6 = new Cat ("Васька6");
        map.put(cat6.name, cat6);
        Cat cat7 = new Cat ("Васька7");
        map.put(cat7.name, cat7);
        Cat cat8 = new Cat ("Васька8");
        map.put(cat8.name, cat8);
        Cat cat9 = new Cat ("Васька9");
        map.put(cat9.name, cat9);
        Cat cat10 = new Cat ("Васька10");
        map.put(cat10.name, cat10);


        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> set = new HashSet<>();
        for (Map.Entry<String, Cat> entry: map.entrySet()) {
            set.add( entry.getValue());
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
