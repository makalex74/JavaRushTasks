package com.javarush.task.task31.task3107;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            fileData = new ConcreteFileData(Files.isHidden(Paths.get(pathToFile)),
                    Files.isExecutable(Paths.get(pathToFile)),
                    Files.isDirectory(Paths.get(pathToFile)),
                    Files.isWritable(Paths.get(pathToFile)));
        } catch (Exception e) {
            fileData = new NullFileData(e);
           //System.out.println(e.getMessage());
        }

    }

    public FileData getFileData() {
        return fileData;
    }

    public static void main(String[] args) {
        Solution solution = new Solution("ztest//task3107//Dir1//file1.txt");
        System.out.println(solution.getFileData().isHidden() + " " + solution.getFileData().isExecutable() +
                " " + solution.getFileData().isDirectory() + " " + solution.getFileData().isWritable());
    }
}
