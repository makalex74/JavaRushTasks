package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = "file1.txt".split(" ");
        String fileName = args[0];
        //System.out.println(fileName);
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        List<Integer> list = new ArrayList<>();
        int i;
        while ((i=bufferedInputStream.read()) != -1){
            //if ((i != 10) && (i != 13) && (i != 32))
                list.add(i);
        }
        bufferedInputStream.close();
        fileInputStream.close();
/*        for (Integer item: list) {
            System.out.println(item);
        }*/
        HashMap<Integer,Integer> map = new HashMap<>();
        for (Integer item: list) {
            if (!map.containsKey(item)){
                map.put(item,1);
            }
            else {
                Integer cnt = map.get(item);
                map.put(item,++cnt);
            }
        }
        list.clear();
        /*        for (HashMap.Entry item: map.entrySet()) {
            System.out.println((char)(int)item.getKey()+" "+ item.getKey()+ " " + item.getValue());
        }*/
        for (HashMap.Entry item: map.entrySet()) {
            list.add((int)item.getKey());
        }
        Collections.sort(list);
        for (Integer item: list) {
            System.out.println((char)(int)item + " " + map.get(item));
        }
    }
}
