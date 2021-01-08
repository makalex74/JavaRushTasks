package com.javarush.task.task32.task3202;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("ztest//task3202//source_file.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        if (is != null) {
            char[] buffer = new char[1024];
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            }
        }
        return writer;
    }
}
