package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Проход по дереву файлов
1. На вход метода main() подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат.
2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(), и, если понадобится, FileUtils.isExist()).
3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
3.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
3.2. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 3.1. После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".
Для создания файлов используй конструктор File(String pathname).


Требования:
1. Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
2. Нужно создать поток для записи в переименованный файл.
3. Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt в отсортированном по имени файла порядке.
4. Поток для записи в файл нужно закрыть.
5. Не используй статические переменные.
*/

public class Solution {
/*
    public static void main(String[] args) {
        args = "D://IdeaProjects//JavaRushTasks//zip_test// D://IdeaProjects//JavaRushTasks//zip_test//resultFileAbsolutePath.txt".split(" ");
        try {
            File path = new File(args[0]);
            System.out.println(path.getAbsolutePath());
            File resultFileAbsolutePath = new File(args[1]);
            System.out.println(resultFileAbsolutePath.getAbsoluteFile());
            File allFilesContent = new File("D://IdeaProjects//JavaRushTasks//zip_test//allFilesContent.txt");
            try {
                resultFileAbsolutePath.renameTo(allFilesContent);
            } catch (Exception e) {
                System.out.println("Ошибка при переимновании файла!");
            }
            System.out.println(allFilesContent.getAbsoluteFile());

            System.out.println("List directory " + path.getAbsolutePath() + " recursive: ");
            Path pathSource = Paths.get(path.getAbsolutePath());
            Files.walkFileTree(pathSource, new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static class MyFileVisitor extends SimpleFileVisitor<Path> {
        public FileVisitResult visitFile(Path path,
                                         BasicFileAttributes fileAttributes) {
            System.out.println("file name:" + path);
            return FileVisitResult.CONTINUE;
        }
    }
    */

    public static void main(String[] args) {
        //args = "D://IdeaProjects//JavaRushTasks//zip_test// D://IdeaProjects//JavaRushTasks//zip_test//resultFileAbsolutePath.txt".split(" ");
        String path = args[0];
        String resultFileAbsolutePath = args[1];
        try {
            File resultFile = new File(resultFileAbsolutePath);
            File dest = new File(resultFile.getParentFile() + "/allFilesContent.txt");
            if (FileUtils.isExist(dest)) {
                FileUtils.deleteFile(dest);
            }
            FileUtils.renameFile(resultFile, dest);

            Map<String, byte[]> fileTree = getFileTree(path);
            try (FileOutputStream fileOutputStream = new FileOutputStream(dest)) {
                for (byte[] bytes : fileTree.values()) {
                    fileOutputStream.write(bytes);
                    fileOutputStream.write("\n".getBytes());
                }
            }
        } catch (IOException ignored) {
        }
    }

    public static Map<String, byte[]> getFileTree(String root) throws IOException {
        Map<String, byte[]> result = new TreeMap<>();

        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(result));

        return result;
    }

    private static class GetFiles extends SimpleFileVisitor<Path> {
        private Map<String, byte[]> result;

        public GetFiles(Map<String, byte[]> result) {
            this.result = result;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            File file = path.toFile();
            if (file.isFile()) {
                if (file.length() <= 50) {
                    result.put(path.getFileName().toString(), Files.readAllBytes(path));
                }
            }
            return FileVisitResult.CONTINUE;//return super.visitFile(path, basicFileAttributes);
        }
    }
}
