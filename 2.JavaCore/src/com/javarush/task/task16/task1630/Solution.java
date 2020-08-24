package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fileName;
        private ArrayList<String> list = new ArrayList<>();

        @Override
        public void run() {
            try {
                ReadFileIntoList();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        //file1.txt
        //file2.txt
        public void ReadFileIntoList() throws IOException {
            InputStream inputStream = new FileInputStream(fileName);
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader1.readLine()) != null) {
                list.add(line);
            }
            //System.out.println(Thread.currentThread().getName()+" ReadFileIntoList()");
            //System.out.println(list);
        }

        @Override
        public String getFileContent() {
            String stringResult = "";
            for (String item: list) {
                stringResult += item + " ";
            }
            stringResult = stringResult.trim();
            //System.out.println(Thread.currentThread().getName()+" getFileContent()");
            //System.out.println("stringResult = " + stringResult);
            return stringResult;
        }

    }
}
