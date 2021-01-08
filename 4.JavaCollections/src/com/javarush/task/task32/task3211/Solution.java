package com.javarush.task.task32.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

/* 
Целостность информации
Представь ситуацию, ты выкачал архив с интернета, и в момент скачивания у тебя на несколько секунд пропало соединение.
Нужно убедиться, валидный ли архив ты скачал. Для этого сверим его MD5 хеш.
Прочитать о MD5 на wiki.
Прочитать о MessageDigest.

Реализуй логику метода compareMD5, который должен получать MD5 хеш из переданного ByteArrayOutputStream
и сравнивать с эталонным MD5 переданным вторым параметром.
Метод main не участвует в тестировании.


Требования:
1. Класс Solution должен содержать метод compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5).
2. Метод compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) должен использовать MessageDigest.
3. Метод compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) должен возвращать результат
сравнения вычисленного MD5 хеша для byteArrayOutputStream с переданным параметром md5.
4. Класс Solution должен содержать метод main.
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] hash = messageDigest.digest(byteArrayOutputStream.toByteArray());

        StringBuffer hexString = new StringBuffer();

        for (int i = 0; i < hash.length; i++) {
            String x = Integer.toHexString(0xFF & hash[i]);
            if (x.length() < 2) x = "0" + x;
            //System.out.println("x = " + x + "; hash["+i+"] = " + hash[i]);
            hexString.append(x);
        }

        String digestAsString = hexString.toString();
        //System.out.println(digestAsString);
        //System.out.println(md5);
        return digestAsString.equals(md5);
    }
}
