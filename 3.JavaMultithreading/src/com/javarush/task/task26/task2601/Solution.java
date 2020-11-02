package com.javarush.task.task26.task2601;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
/*
        Integer[] numbers = new Integer[] {13, 8, 15, 5, 17};
        //Integer[] numbers = new Integer[] {13, 8, 15, 16, 12, 11,  5, 17};
        Integer[] sortedNumbers = sort(numbers);
        for (Integer item: numbers) {
            System.out.print(item + ", ");
        }
*/

    }

    public static int getMediana(List<Integer> list){
        Collections.sort(list);
        int median;
        if (list.size() % 2 == 0)
            median = (list.get(list.size()/2) + list.get(list.size()/2 - 1))/2;
        else
            median = list.get(list.size()/2);
        return median;
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        List<Integer> list = new ArrayList<>();
        for (Integer item: array) {
            list.add(item);
        }
        final int mediana = getMediana(list);
        //System.out.println("mediana = "+mediana);

        Comparator<Integer> medianaComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(mediana - o1) - Math.abs(mediana - o2);
            }
        };
        Collections.sort(list,medianaComparator);
        for (int i = 0; i < array.length ; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
