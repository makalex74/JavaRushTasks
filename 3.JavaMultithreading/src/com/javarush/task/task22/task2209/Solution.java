package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String greetings = "city.txt\n";
        byte[] bytes = greetings.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //System.out.println(fileName);
        reader.close();
        System.setIn(System.in);

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> listWords = new ArrayList<>();
        String str;
        while((str = bufferedReader.readLine()) != null){
            //System.out.println(str);
            for (String item:str.split(" ")) {
                listWords.add(item);
            }
        }
        bufferedReader.close();
        fileReader.close();
        //System.out.println(listWords);

        String[] words = new String[listWords.size()];
        for (int i = 0; i < listWords.size(); i++) {
            words[i] = listWords.get(i);
        }
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder resultSB = new StringBuilder();
        if (words.length == 0) {return resultSB;}
        if (words == null) {return resultSB;}
        List<String> list = new LinkedList<>();
        for (int i = 0; i < words.length ; i++) {
            list.add(words[i]);
        }
        //System.out.println(list);
        //System.out.println(listCopy);
        while (true) {
            rearrangeWords(list);
/*            String beforeLastWord = list.get(list.size() - 2);
            String LastWord = list.get(list.size() - 1);
            char lastLetterBeforeLastWord = Character.toLowerCase(beforeLastWord.charAt(beforeLastWord.length() - 1));
            char firstLetterLastWord = Character.toLowerCase(LastWord.charAt(0));*/
            if (!checkLettersInWords(list)) {
                Collections.shuffle(list);
                rearrangeWords(list);
            }
            if (checkLettersInWords(list)) {
                break;
            }
        }

        for (String item: list) {
            if (resultSB.length() > 0) resultSB.append(" ");
            resultSB.append(item);
        }
        return resultSB;
    }

    public static void rearrangeWords(List<String> list){
        for (int i = 0; i < list.size()-1; i++) {
            String firstWord = list.get(i);
            String secondWord = list.get(i + 1);
            char lastLetterFirstWord = Character.toLowerCase(firstWord.charAt(firstWord.length() - 1));
            char firstLetterSecondWord = Character.toLowerCase(secondWord.charAt(0));
            //System.out.println(lastLetterFirstWord);
            //System.out.println(firstLetterSecondWord);
            for (int j = i + 1; j < list.size()-1; j++){
                //while (!(lastLetterFirstWord == firstLetterSecondWord)) {
                if (lastLetterFirstWord == firstLetterSecondWord){
                    break;
                }
                //System.out.println(firstWord.substring(firstWord.length() - 1).equals(secondWord.substring(0, 1).toLowerCase()));
                list.remove(i + 1);
                list.add(secondWord);
                secondWord = list.get(i + 1);
                firstLetterSecondWord = Character.toLowerCase(secondWord.charAt(0));
                //System.out.println(list);
            }
        }
    }

    public static boolean checkLettersInWords(List<String> list){
        Boolean result = true;
        for (int i = 0; i < list.size()-1; i++) {
            String firstWord = list.get(i);
            String secondWord = list.get(i + 1);
            char lastLetterFirstWord = Character.toLowerCase(firstWord.charAt(firstWord.length() - 1));
            //System.out.println(lastLetterFirstWord);
            char firstLetterSecondWord = Character.toLowerCase(secondWord.charAt(0));
            //System.out.println(firstLetterSecondWord);
            if (lastLetterFirstWord != firstLetterSecondWord) {
                result = false;
                break;
            }
        }
        return result;
    }
}
