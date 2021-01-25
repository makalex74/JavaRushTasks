package com.javarush.task.task09.task0923;

/* 
Гласные и согласные
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};
    public static char[] consonants = new char[]{'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н',
                                                 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
                                                 '.', ',', ';', ':', '?', '!', '-', '"', '(', ')'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String vowelsStr = "";
        String consonantsStr = "";
        char[] chArr = str.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            if (isVowel(chArr[i]))
                vowelsStr = vowelsStr + chArr[i] + " ";
            if (isСonsonant(chArr[i]))
                consonantsStr = consonantsStr + chArr[i] + " ";
        }
        System.out.println(vowelsStr);
        System.out.println(consonantsStr);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }

    // метод проверяет, согласная ли буква
    public static boolean isСonsonant(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : consonants) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}