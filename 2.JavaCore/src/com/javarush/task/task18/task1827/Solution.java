package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            fileName=bufferedReader.readLine();
        }

        if(args.length != 0 && args[0].equals("-c")){
            try(BufferedReader bufferedReader1= new BufferedReader(new FileReader(fileName));
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))){
                int count=0;
                int buf=0;
                String sb;
                while ((sb=bufferedReader1.readLine())!=null){
                    if (sb.length() >0)
                     buf=Integer.parseInt(sb.substring(0,8).trim());
                    if(count<buf) count=buf;
                }

                bufferedWriter.write(String.format("%n%-8d%-30s%-8s%-4s%n",++count,args[1],args[2],args[3]));

            }
        }
    }
}
