package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        String[] betweenDots = fileName.replace('.',' ').split(" ");
/*        for (int i = 0; i < betweenDots.length ; i++) {
            System.out.println(betweenDots[i]);
        }*/
        if (!betweenDots[betweenDots.length -1].equals("txt")){
            super.close();
            throw new UnsupportedFileNameException();
        }

    }

    public static void main(String[] args) throws IOException, UnsupportedFileNameException {
/*
        String[] betweenDots = "file1.123.txt".replace('.',' ').split(" ");
        for (int i = 0; i < betweenDots.length ; i++) {
            System.out.println(betweenDots[i]);
        }
*/
        TxtInputStream txtInputStream = new TxtInputStream("file1.txt.exe");
        txtInputStream.close();
    }
}

