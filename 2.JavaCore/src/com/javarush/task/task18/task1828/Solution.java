package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
/*        String greetings = "products.txt\n";
        byte[] bytes = greetings.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);*/

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine(); //products.txt
        bufferedReader.close();

        //args = new String[]{"-d", "19847983"};
        //args = new String[]{"-u", "19847983 " , "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", "799.00", "17"};

        if (args.length != 0){
            ArrayList<String> list = new ArrayList<>();
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(fileName));
            String str;
            while ((str = bufferedReader1.readLine()) != null) {
                list.add(str);
            }
            bufferedReader1.close();
            int strNum = -1; //Номер строки
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).length() > 0) {
                    String strID = list.get(i).substring(0, 8).trim();
                    if (strID.equals(args[1].trim())) {
                        strNum = i;
                    }
                }
            }
            if (strNum >= 0){
             switch (args[0]) {
             case ("-d"):
                 list.remove(strNum);
                 break;
             case ("-u"):
                 list.set(strNum,String.format("%-8.8s%-30.30s%-8.8s%-4.4s",args[1],args[2],args[3],args[4]));
                 break;
             }
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
             for (int i = 0; i < list.size() ; i++) {
                 if (i < list.size() - 1)
                   bufferedWriter.write(list.get(i)+"\n");
                else
                   bufferedWriter.write(list.get(i));
             }
               bufferedWriter.close();
           }

        }
    }
}
