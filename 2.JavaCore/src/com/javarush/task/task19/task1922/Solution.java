package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
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
        while (true){
            str = bufferedReader.readLine();
            if (str == null) break;
            //System.out.println(str);
            String[] arrStr = str.split(" ");
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < arrStr.length ; i++) {
                set.add(arrStr[i]);
            }
            //System.out.println(set);
            int cnt = 0;
            for (String item: words) {
                if (set.contains(item))
                    cnt++;
            }
            if (cnt == 2)
                System.out.println(str);

        }
        bufferedReader.close();
        fileReader.close();

    }
}
