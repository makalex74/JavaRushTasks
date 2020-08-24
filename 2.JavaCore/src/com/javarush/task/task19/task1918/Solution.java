package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        args = "span".split(" ");
        if ((args.length > 0) && (args[0].length() > 0)) {
            String findTag = args[0];
          String greetings = "file.html\n";
            byte[] bytes = greetings.getBytes();
            InputStream inputStream = new ByteArrayInputStream(bytes);
            System.setIn(inputStream);

            BufferedReader readerCon = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = readerCon.readLine();
            readerCon.close();

            FileReader fileReader = new FileReader(fileName1);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String str = "";
            String longStr = "";
            while (true) {
                str = bufferedReader.readLine();
                if (str == null) break;
                //System.out.println(str);
                longStr += str;
            }
            bufferedReader.close();
            fileReader.close();
            //System.out.println();
            //System.out.println(longStr);
            //System.out.println();
            //if (Pattern.matches("(.*[0-9]+.*)",longStr))
/*        String[] arrStr = longStr.split("</"+findTag+">");
        for (int i = 0; i < arrStr.length; i++) {
            arrStr[i] += "</"+findTag+">";
            System.out.println(arrStr[i]);
        }
        System.out.println();
        for (int i = 0; i < arrStr.length; i++) {
            if (arrStr[i].indexOf("<"+findTag) != -1)
              arrStr[i] = arrStr[i].substring(arrStr[i].indexOf("<"+findTag));
            System.out.println(arrStr[i]);
        }*/
            //Pattern pattern = Pattern.compile("<"+findTag+">.+?</"+findTag+">");
            Pattern pattern = Pattern.compile("</?" + findTag);
            Matcher matcher = pattern.matcher(longStr);
            ArrayList<Integer> posList = new ArrayList<>();
            ArrayList<String> tagList = new ArrayList<>();
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                //System.out.println("Найдено совпадение " + longStr.substring(start,end) + " с "+ start + " по " + (end-1) + " позицию");
                tagList.add(longStr.substring(start, end));
                posList.add(start);
            }
/*        for (int i = 0; i < tagList.size() ; i++) {
            int level = getLevel(tagList, i, findTag);
            System.out.println(tagList.get(i)+", level = "+ level + ", pos = " + posList.get(i));
        }*/

//        System.out.println("----------------------------------");

            for (int i = 0; i < tagList.size(); i++) {
                if (tagList.get(i).equals("<" + findTag)) {
                    int idxSlesh = getIndexSlesh(tagList, i, findTag);
                    int level = getLevel(tagList, i, findTag);
/*                System.out.println(tagList.get(i) + ", level = " + getLevel(tagList, i, findTag) + ", pos = " + posList.get(i) +" "
                                   + tagList.get(idxSlesh) + ", level = " + getLevel(tagList, idxSlesh, findTag) + ", pos = " + posList.get(idxSlesh)
                );*/
                    System.out.println(longStr.substring(posList.get(i), posList.get(idxSlesh) + findTag.length() + 3));
                }
            }
        }

    }
    public static int getLevel(ArrayList<String> list, int idx, String findTag){
        int resLevel = 0;
        if (list.get(idx).equals("<"+findTag)){
            int i = idx+1;
            while (!list.get(i).equals("</"+findTag)){
                i++;
                resLevel++;
            }
        }
        if (list.get(idx).equals("</"+findTag)){
            int i = idx-1;
            while (!list.get(i).equals("<"+findTag)){
                i--;
                resLevel++;
            }
        }
        return resLevel;
    }

    public static int getIndexSlesh(ArrayList<String> list, int idx, String findTag){
        int resIndex = 0;
        int level = getLevel(list, idx, findTag);
        int i = idx + 1;
        while (true){
            if (list.get(i).equals("</"+findTag) && (getLevel(list, i, findTag) == level)){
                resIndex = i;
                break;
            }
            i++;
        }
        return resIndex;
    }

}
