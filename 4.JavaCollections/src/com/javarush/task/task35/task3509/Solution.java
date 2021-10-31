package com.javarush.task.task35.task3509;

import java.util.*;

/* 
Collections & Generics
*/

public class Solution {

    public static void main(String[] args) {
    }

    public static <T> ArrayList<T> newArrayList(T... elements) {
        ArrayList<T> arrayList = new ArrayList<>(elements.length);
        for (T item: elements) {
            arrayList.add(item);
        }
        return arrayList;
    }

    public static <T> HashSet<T> newHashSet(T... elements) {
        HashSet<T> hashSet = new HashSet<>(elements.length);
        for (T item: elements) {
            hashSet.add(item);
        }
        return hashSet;
    }

    public static <K,V> HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if (keys.size() != values.size()) {
            throw new IllegalArgumentException();
        }
        HashMap<K,V> hashMap = new HashMap<>();
        for (int i=0; i<keys.size(); i++){
            hashMap.put(keys.get(i),values.get(i));
        }
        return hashMap;
    }
}
