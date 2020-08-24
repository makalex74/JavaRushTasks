package com.javarush.task.task22.task2203;

/*
Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.


Требования:
1. Класс TooShortStringException должен быть потомком класса Exception.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String resString = "";
        if (string == null) {
            throw new TooShortStringException();
        }
        int cntTab = 0;
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == '\t') cntTab++;
        }
        if (cntTab < 2) {
                throw new TooShortStringException();
        }
        else {
            int firstTabIndex = string.indexOf("\t");
            int secondTabIndex = string.indexOf("\t",firstTabIndex+1);
            resString = string.substring(firstTabIndex + 1, secondTabIndex);
        }
        return resString;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        //System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        //System.out.println(getPartOfString("JavaRush - лучший сервис "));
        System.out.println(getPartOfString(null));
    }
}
