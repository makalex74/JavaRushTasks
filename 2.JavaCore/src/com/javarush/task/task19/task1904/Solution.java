package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner.
Поле инициализировать в конструкторе с одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957

В файле хранится большое количество людей, данные одного человека находятся в одной строке.
Метод read() должен читать данные только одного человека.


Требования:
1. PersonScanner должен быть интерфейсом.
2. Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
3. Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
4. Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
5. Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
6. Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её,
и возвращать данные только одного человека, в виде объекта класса Person.
*/

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        File file = new File("person.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(scanner);
            Person person = personScannerAdapter.read();
            System.out.println(person);

        }
        scanner.close();
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            fileScanner.useDelimiter(System.getProperty("line.separator"));
            String[] arrStr = fileScanner.next().split(" ");
            //System.out.println(arrStr[0]+" "+arrStr[1]+" "+arrStr[2]+" "+arrStr[3]+" "+arrStr[4]+" "+arrStr[5]);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date bd = null;
            try {
                 bd = dateFormat.parse(arrStr[3]+"."+arrStr[4]+"."+arrStr[5]);
            } catch (ParseException e) {
                 e.printStackTrace();
            }
            Person person = new Person(arrStr[1], arrStr[2], arrStr[0], bd);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
