package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
/*        String greetings = "file1.txt\n";
        byte[] bytes = greetings.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);*/

        BufferedReader readerCon = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = readerCon.readLine();
        readerCon.close();

        FileReader fileReader = new FileReader(fileName1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String str = null;
        String res = "";
        while (true) {
            str = bufferedReader.readLine();
            if (str == null) break;
            //System.out.println(str);
            String[] arrStr = str.split(" ");
            for (int i = 0; i < arrStr.length ; i++) {
                if (Pattern.matches("[0-9]+",arrStr[i]) && map.containsKey(Integer.parseInt(arrStr[i]))) {
                    //res += arrStr[i]+ " ";
                    arrStr[i] = map.get(Integer.parseInt(arrStr[i]));
                }
                res += arrStr[i]+ " ";
            }
            res = res.trim();
            System.out.println(res);
            res = "";
        }
        bufferedReader.close();
        fileReader.close();
    }
}
