package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args)  {
        //args = "file1.txt".split(" ");
/*        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("file1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(args[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
/*
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
*/
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        HashMap<String, Double> map = new HashMap<>();
        String str = null;
        while (true){
            try {
                str = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (str == null) break;
            String[] arrStr = str.split(" ");
            if (!map.containsKey(arrStr[0])) {
                map.put(arrStr[0], Double.parseDouble(arrStr[1]));
            }
            else {
                Double prevNum = map.get(arrStr[0]);
                map.put(arrStr[0], prevNum + Double.parseDouble(arrStr[1]));
            }
        }
        try {
            bufferedReader.close();
            fileReader.close();
/*
            inputStreamReader.close();
            fileInputStream.close();
*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> list = new ArrayList<>();
        for (HashMap.Entry<String,Double> item: map.entrySet()) {
             list.add(item.getKey());
        }
        Collections.sort(list);
        for (String item: list) {
            System.out.println(item +" "+map.get(item));
        }


    }
}
