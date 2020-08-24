package com.javarush.task.task18.task1826;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = "-e source_file.txt encryption_file.txt".split(" ");
        //args = "-d encryption_file.txt decode_file.txt".split(" ");
        String keyName = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];
        //System.out.println(keyName +" "+fileName+" "+fileOutputName);
        switch (args[0]) {
            case ("-e"):
                //System.out.println("-e");
                FileInputStream fileInputStream1 = new FileInputStream(fileName);
                FileOutputStream fileOutputStream1 = new FileOutputStream(fileOutputName);
                BufferedInputStream bufferedInputStream1 = new BufferedInputStream(fileInputStream1);
                int i;
                while ((i=bufferedInputStream1.read()) != -1){
                    fileOutputStream1.write(i+1);
                }
                bufferedInputStream1.close();
                fileInputStream1.close();
                fileOutputStream1.close();
                break;
            case ("-d"):
                //System.out.println("-d");
                FileInputStream fileInputStream2 = new FileInputStream(fileName);
                FileOutputStream fileOutputStream2 = new FileOutputStream(fileOutputName);
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(fileInputStream2);
                int j;
                while ((j=bufferedInputStream2.read()) != -1){
                    fileOutputStream2.write(j-1);
                }
                bufferedInputStream2.close();
                fileInputStream2.close();
                fileOutputStream2.close();
                break;
            default:
                System.out.println("Use: program_name -e fileName fileOutputName");
                break;
        }
    }
}
