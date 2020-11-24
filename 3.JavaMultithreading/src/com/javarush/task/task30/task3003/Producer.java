package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        try {
            for (int i = 1; i <= 9; i++) {
                System.out.format("Элемент 'ShareItem-%d' добавлен\n", i);
                queue.offer(new ShareItem("ShareItem-" + i, i));
                Thread.sleep(100);
                if (queue.hasWaitingConsumer()) {
                    System.out.format("Consumer в ожидании!\n");
                }
            }
        } catch (InterruptedException e) {
        }
    }


}

/*
4. Реализация метода run для Producer:
4.1. Используя метод offer добавь в очередь 9 ShareItem-ов с такими параметрами: ("ShareItem-N", N), где N - номер элемента от 1 до 9.
4.2. Перед каждым добавлением выведи фразу "Элемент 'ShareItem-N' добавлен". Используй System.out.format.
4.3. Усыпи трэд на 0.1 секунды.
4.4. Если у очереди есть Consumer, не занятый работой, то выведи фразу "Consumer в ожидании!".
Просмотри методы интерфейса TransferQueue, там есть нужный метод.

5. Реализация метода run для Consumer:
5.1. Усыпи трэд на 0.45 секунды.
5.2. В бесконечном цикле забери элемент из очереди методом take и выведи в консоль "Processing item.toString()".

6. Сверь вывод с файлом output.txt.
7. Стек-трейс не выводи в консоль.
8. Для вывода любой информации на экран используй System.out.format.


 */