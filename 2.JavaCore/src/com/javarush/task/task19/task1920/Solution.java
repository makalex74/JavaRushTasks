package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.DoubleBinaryOperator;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = "file1.txt".split(" ");
        FileReader fileReader = null;
        fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        HashMap<String, Double> map = new HashMap<>();
        String str = null;
        while (true){
            str = bufferedReader.readLine();
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
        bufferedReader.close();
        fileReader.close();
        ArrayList<String> list = new ArrayList<>();
        double max =0;
        boolean firstFlag = true;
        for (HashMap.Entry<String,Double> item: map.entrySet()) {
            list.add(item.getKey());
            if (firstFlag) {
                max = item.getValue();
                firstFlag = false;
            } else max = max > item.getValue() ? max : item.getValue();
        }
        Collections.sort(list);
        for (String item: list) {
            if (map.get(item).equals(max))
              System.out.println(item /*+" "+map.get(item)*/);
        }

    }
}
