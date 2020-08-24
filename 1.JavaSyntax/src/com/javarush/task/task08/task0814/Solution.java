package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> setInt = new HashSet<Integer>();
        for (int i = 0; i < 20; i++) {
             setInt.add(i);
        }
        return setInt;
    }

    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        Iterator itr = set.iterator();
        Integer num = 10;
        while (itr.hasNext()){
            if (Integer.getInteger(itr.next().toString()) > 10){
                itr.remove();
            }
        }
        return set;
    }

    public static void main(String[] args) {
        Set<Integer> setInt = createSet();
        System.out.println("Before Delete");
        Iterator itr = setInt.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        removeAllNumbersGreaterThan10(setInt);
        System.out.println("After Delete");

    }
}
