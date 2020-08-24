package com.javarush.task.task22.task2202;

/* 
Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.

Пример:
"JavaRush - лучший сервис обучения Java."

Результат:
"- лучший сервис обучения"

Пример:
"Амиго и Диего лучшие друзья!"

Результат:
"и Диего лучшие друзья!"

На некорректные данные бросить исключение TooShortStringException (сделать исключением).

Требования:
1. Класс TooShortStringException должен быть потомком класса RuntimeException.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если в метод getPartOfString были переданы некорректные данные, должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова, которое следует после 4-го пробела.
*/
public class Solution {
    public static void main(String[] args) {
        //System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        //System.out.println(getPartOfString("JavaRush - лучший сервис обучения."));
        System.out.println(getPartOfString(""));
    }

    public static String getPartOfString(String string) {
            String resString = "";

            if ((string == null) || (string.split(" ").length < 5)) {
                throw new TooShortStringException();
            }
            else {
                String[] arrStr = string.split(" ");
                resString += arrStr[1] + " " + arrStr[2] + " " + arrStr[3] + " " + arrStr[4];
            }
            return resString;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
