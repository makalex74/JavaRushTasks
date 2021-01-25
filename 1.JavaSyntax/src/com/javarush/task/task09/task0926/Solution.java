package com.javarush.task.task09.task0926;

import java.util.ArrayList;

/* 
Список из массивов чисел
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList() {
        //напишите тут ваш код
        //Добавить в список пять объектов-массивов длиной 5, 2, 4, 7, 0 соответственно.
        ArrayList<int[]> resList = new ArrayList<int[]>();
        int[] arrInt1 = {5, 5, 5, 5, 5};
        resList.add(arrInt1);
        int[] arrInt2 = {2, 2};
        resList.add(arrInt2);
        int[] arrInt3 = {4, 4, 4, 4};
        resList.add(arrInt3);
        int[] arrInt4 = {7, 7, 7, 7, 7, 7, 7};
        resList.add(arrInt4);
        int[] arrInt5 = new int[0];
        resList.add(arrInt5);
        return resList;
    }

    public static void printList(ArrayList<int[]> list) {
        for (int[] array : list) {
            for (int x : array) {
                System.out.println(x);
            }
        }
    }
}
