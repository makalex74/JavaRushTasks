package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<FileInputStream> list = new ArrayList<>();
        while (true) {
            String fileName = reader.readLine(); //file1.txt
            list.add(new FileInputStream(fileName));
            if (list.get(list.size()-1).available() < 1000) {
                for (FileInputStream item: list){
                    item.close();
                }
                reader.close();
                throw new DownloadException();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
