package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Живем своим умом
В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
1. прервать нить, которая бросила исключение.
2. вывести в консоль стек исключений, начиная с самого вложенного.

Пример исключения:
new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))

Пример вывода:
java.lang.IllegalAccessException: GHI
java.lang.RuntimeException: DEF
java.lang.Exception: ABC


Требования:
1. Класс Solution должен реализовывать интерфейс Thread.UncaughtExceptionHandler.
2. После вызова uncaughtException нужно прервать нить, которая бросила исключение.
3. Затем, вывести в консоль стек исключений, начиная с самого вложенного исключения.
4. Сообщения должны выводиться в формате "exception class: exception message".
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {

        t.interrupt();
        //System.out.println(e);                                  //  java.lang.Exception: ABC
        //System.out.println(e.getCause());                       //  java.lang.RuntimeException: DEF
        //System.out.println(e.getCause().getCause());            //  java.lang.IllegalAccessException: GHI
        //System.out.println(e.getCause().getCause().getCause()); //  null
        List<Throwable> list = new ArrayList<>();
        Throwable currThrow = e;
        list.add(currThrow);
        while (true){
            currThrow = currThrow.getCause();
            if (currThrow == null) break;
            list.add(currThrow);
        }
        Collections.reverse(list);
        for (Throwable item: list) {
            System.out.println(item);
        }

    }

    public static void main(String[] args) throws Exception {
        Thread.UncaughtExceptionHandler handler = new Solution();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                    Thread currentThread = Thread.currentThread();
                    handler.uncaughtException(currentThread, new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI"))));
            }
        });
        thread.setUncaughtExceptionHandler(handler);
        thread.start();
        //Thread.sleep(1000);
    }

}
