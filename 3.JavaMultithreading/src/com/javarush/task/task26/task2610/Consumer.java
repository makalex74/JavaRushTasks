package com.javarush.task.task26.task2610;

/*
Мир скучен для скучных людей
*/

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (true) {
                //Извлекает и удаляет голову этой очереди или возвращает null, если эта очередь пуста.
                //System.out.println(queue.poll());
                //Извлекает и удаляет голову этой очереди, ожидая при необходимости, пока элемент не станет доступным.
                System.out.println(queue.take());
                Thread.sleep(350);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
