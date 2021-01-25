package com.javarush.task.task08.task0807;

import java.util.ArrayList;
import java.util.LinkedList;

/* 
LinkedList и ArrayList
*/

public class Solution {
    public static Object createArrayList() {
        //напишите тут ваш код
        ArrayList<Integer> aList = new ArrayList<Integer>();
        for (int i=0; i<10; i++){
            aList.add(i);
        }
        return aList;
    }

    public static Object createLinkedList() {
        //напишите тут ваш код
        LinkedList<Integer> lList = new LinkedList<Integer>();
        for (int i=0; i<10; i++){
            lList.add(i);
        }
        return lList;
    }

    public static void main(String[] args) {

    }
}
