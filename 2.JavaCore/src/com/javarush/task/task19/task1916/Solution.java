package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        String greetings = "file1.txt\nfile2.txt\n";
        byte[] bytes = greetings.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);

        BufferedReader readerCon = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = readerCon.readLine();
        String fileName2 = readerCon.readLine();
        readerCon.close();

        ArrayList<String> list1 = new ArrayList<>();
        FileReader fileReader1 = new FileReader(fileName1);
        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
        String str;
        while (true){
            str = bufferedReader1.readLine();
            if (str == null) break;
            list1.add(str);
        }
        bufferedReader1.close();
        fileReader1.close();

        //System.out.println(list1);

        ArrayList<String> list2 = new ArrayList<>();
        FileReader fileReader2 = new FileReader(fileName2);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
        while (true){
            str = bufferedReader2.readLine();
            if (str == null) break;
            list2.add(str);
        }
        bufferedReader2.close();
        fileReader2.close();

        //System.out.println(list2);

/*        for (int i = 0; i < list2.size(); i++) {
            if (list1.contains(list2.get(i))){ //в list1 есть строка из list2
                lines.add(new LineItem(Type.SAME,list2.get(i)));
            } else { //в list1 нет строки из list2
                lines.add(new LineItem(Type.ADDED,list2.get(i)));
            }
        }


        for (int i = 0; i < list1.size(); i++) {
            if (! list2.contains(list1.get(i))){ //в list2 нет строки из list1
                if ((i > 0) && lines.get(i - 1).type.equals(Type.SAME))
                  lines.add(i, new LineItem(Type.REMOVED,list1.get(i)));
                else
                  lines.add(i+1, new LineItem(Type.REMOVED,list1.get(i)));
            }
        }
*/

        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).equals(list2.get(j))) {
                lines.add(new LineItem(Type.SAME, list1.get(i)));
                i++;
                j++;
            } else {
                if (j + 1 < list2.size() && list1.get(i).equals(list2.get(j + 1))) {
                    lines.add(new LineItem(Type.ADDED, list2.get(j)));
                    j++;
                } else {
                    lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                    i++;
                }
            }
        }
        if (i < list1.size()) lines.add(new LineItem(Type.REMOVED, list1.get(i)));
        if (j < list2.size()) lines.add(new LineItem(Type.ADDED, list2.get(j)));

        for (LineItem item: lines) {
            System.out.println(item.type + " " + item.line);
        }

    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
