package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String sourceString = outputStream.toString();

        //Возвращаем все как было
        System.setOut(consoleStream);

        //System.out.println(sourceString);
        String spamText = "JavaRush - курсы Java онлайн";
        String[] arrStr =  sourceString.split(System.lineSeparator());
/*        for (int i = 0; i < arrStr.length ; i++) {
            System.out.println(arrStr[i]);
        }*/
        int cnt = 0;
        for (String item: arrStr) {
            System.out.println(item);
            cnt++;
            if (cnt%2 == 0) System.out.println(spamText);

        }



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
