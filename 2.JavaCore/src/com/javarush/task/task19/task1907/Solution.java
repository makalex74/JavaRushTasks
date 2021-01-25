package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
/*        String greetings = "file1.txt\n";
        byte[] bytes = greetings.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);*/

        BufferedReader readerCon = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = readerCon.readLine();

        readerCon.close();

        FileReader reader = new FileReader(fileName1);

        String longString = "";
        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            Character ch = (char)reader.read();
            longString += ch.toString();
        }
        //longString = longString.replaceAll("[^a-zA-Z ]", " ");
        //System.out.println(longString);

        int indexWorld = -1;
        int cntWorld = 0;
        while (true) {
            indexWorld = longString.indexOf("world",++indexWorld);
            //System.out.println(indexWorld);
            if (indexWorld == -1)  break;
            int indexBefore = -1;
            int indexAfter = -1;
            if (indexWorld != 0) //слово world не в начале файла
                indexBefore = indexWorld - 1;
            if (indexWorld != longString.length()-5) //слово world не в конце файла
                indexAfter = indexWorld + 5;
            Character symbolBefore = indexBefore != -1 ? longString.charAt(indexBefore) : ' ';
            Character symbolAfter = indexAfter != -1 ? longString.charAt(indexAfter) : ' ';
            //System.out.println("|"+symbolBefore+"world"+symbolAfter+"|");
            //if (symbolBefore.equals(' ') && symbolAfter.equals(' ')) cntWorld++;
            if (!Character.isLetter(symbolBefore) && !Character.isLetter(symbolAfter)) cntWorld++;
        }
        System.out.println(cntWorld);
        //закрываем потоки после использования
        reader.close();
    }
}
