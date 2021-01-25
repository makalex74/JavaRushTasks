package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

/*    public void ReadFileIntoList(String fileName, List<String> list) throws IOException {
        InputStream inputStream = new FileInputStream(fileName);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = reader1.readLine()) != null) {
            list.add(line);
        }
        reader1.close();
        inputStream.close();
        //System.out.println(list);
    }*/

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();//file1.txt
        String fileName2 = reader.readLine();//file2.txt
        reader.close();
/*        sol.ReadFileIntoList(fileName1, allLines);
        sol.ReadFileIntoList(fileName2, forRemoveLines);*/
        InputStream inputStream1 = new FileInputStream(fileName1);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(inputStream1));

        String line;
        while ((line = reader1.readLine()) != null) {
            allLines.add(line);
        }
        reader1.close();
        inputStream1.close();
        //System.out.println(allLines);

        InputStream inputStream2 = new FileInputStream(fileName2);
        BufferedReader reader2 = new BufferedReader(new InputStreamReader(inputStream2));

        //String line;
        while ((line = reader2.readLine()) != null) {
            forRemoveLines.add(line);
        }
        reader2.close();
        inputStream2.close();
        //System.out.println(forRemoveLines);

        try {
            sol.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
            //System.out.println("CorruptedDataException!");
        }
        //System.out.println(allLines);
        //System.out.println(forRemoveLines);
    }


    public void joinData() throws CorruptedDataException {

        //Если список allLines содержит все строки из forRemoveLines,
        //то удалить из списка allLines все строки, которые есть в forRemoveLines.
        if (allLines.containsAll(forRemoveLines)){
            //System.out.println("Список allLines содержит все строки из списка forRemoveLines");
            for (String itemForRemove: forRemoveLines) {
                if (allLines.contains(itemForRemove)) allLines.remove(itemForRemove);
            }
        }
        else
        {
            //Если условие из п.3 не выполнено, то:
            //4.1. очистить allLines от данных
            //4.2. выбросить исключение CorruptedDataException
            //System.out.println("Список allLines НЕ содержит все строки из списка forRemoveLines");
            allLines.clear();
            throw new CorruptedDataException();
        }


    }


}
