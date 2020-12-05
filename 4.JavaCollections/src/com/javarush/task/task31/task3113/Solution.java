package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* 
Что внутри папки?
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //D:\vdisk\w10\w10
        String directoryString = reader.readLine();
        reader.close();
        Path directory = Paths.get(directoryString);
        if (!Files.isDirectory(directory)) {
            System.out.println(directory.toAbsolutePath().toString() + " - не папка");
        } else {
            AtomicInteger countDirectory = new AtomicInteger();
            AtomicInteger countFiles = new AtomicInteger();
            AtomicLong countBytes = new AtomicLong();
            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    countFiles.incrementAndGet();
                    countBytes.addAndGet(attrs.size());
                    return super.visitFile(file, attrs);
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    countDirectory.incrementAndGet();
                    return super.postVisitDirectory(dir, exc);
                }
            });
            System.out.println("Всего папок - " + countDirectory.decrementAndGet());
            System.out.println("Всего файлов - " + countFiles.get());
            System.out.println("Общий размер - " + countBytes.get());
        }
    }
}

