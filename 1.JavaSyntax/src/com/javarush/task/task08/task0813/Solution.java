package com.javarush.task.task08.task0813;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
20 слов на букву «Л»
*/

public class Solution {
    public static Set<String> createSet() {
        //напишите тут ваш код
        Set<String> setStr = new HashSet<String>();
        for (int i = 0; i < 20; i++) {
           String str = "Л"+i;
           setStr.add(str);
        }
        return setStr;
    }

    public static void main(String[] args) {
/*            Set<String> setStr = createSet();
            Iterator itr = setStr.iterator();
            while (itr.hasNext()){
                System.out.println(itr.next());
            }
*/
    }
}
