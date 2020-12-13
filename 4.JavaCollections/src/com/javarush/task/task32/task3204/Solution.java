package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;

/* 
Генератор паролей
Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.

Пример правильного пароля:
wMh7smNu


Требования:
1. Класс Solution должен содержать метод getPassword(), который возвращает ByteArrayOutputStream со сгенерированным паролем.
2. Длина пароля должна составлять 8 символов.
3. Пароль должен содержать хотя бы одну цифру.
4. Пароль должен содержать хотя бы одну латинскую букву нижнего регистра.
5. Пароль должен содержать хотя бы одну латинскую букву верхнего регистра.
6. Пароль не должен содержать других символов, кроме цифр и латинских букв разного регистра.
7. Сгенерированные пароли должны быть уникальными.
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String password = "";
        for (int i = 0; i < 6 ; i++) {
            password += randomCharacter("abcdefghijklmnopqrstuvwxyz");
        }
        if (password.equals(password.toLowerCase())){
            password = password.substring(0,1).toUpperCase()+password.substring(1);
        }
        if (password.equals(password.toUpperCase())){
            password = password.substring(0,1).toLowerCase()+password.substring(1);
        }
        for (int i = 0; i < 2 ; i++) {
            String randomDigit = randomCharacter("0123456789");
            password = insertAtRandom(password, randomDigit);
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] array = password.getBytes();
        outputStream.write(array,0,array.length);
        return outputStream;
    }

    public static String randomCharacter(String characters){
        int r = (int) (Math.random() * characters.length());
        int oneOrZero = (int) (Math.random() * 2);
        //System.out.println(oneOrZero);
        if (oneOrZero == 1) {
            return characters.substring(r, r + 1).toUpperCase();
        } else {
            return characters.substring(r, r + 1).toLowerCase();
        }
    }

    public static String insertAtRandom(String password, String randomDigit){
        int r = (int) (Math.random() * password.length());
        return password.substring(0,r) + randomDigit + password.substring(r);
    }
}
