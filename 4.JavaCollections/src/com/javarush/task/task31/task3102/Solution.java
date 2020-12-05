package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* 
Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используй очередь, рекурсию не используй.
Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.


Требования:
1. Метод getFileTree должен принимать аргументом String root, по которому нужно найти все вложенные файлы.
2. Метод getFileTree должен возвращать список строк.
3. Нужно реализовать метод getFileTree: найти все файлы по указанному пути и добавить их в список.
4. Метод getFileTree должен быть вызван только 1 раз (рекурсию не использовать).
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> resultList = new ArrayList<>();
        Files.walkFileTree(Paths.get(root), new GetFiles(resultList));
        return resultList;
    }

    public static class GetFiles extends SimpleFileVisitor<Path> {
        private List<String> list;

        public GetFiles(List<String> list) {
            this.list = list;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            list.add(file.toAbsolutePath().toString());
            return FileVisitResult.CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> list = getFileTree("D://IdeaProjects//JavaRushTasks//zip_test//");
        for (String file: list) {
            System.out.println(file);
        }
    }
}
