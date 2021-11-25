package com.javarush.task.task36.task3613;

import java.util.concurrent.SynchronousQueue;

/* 
Найти класс по описанию Ӏ Java Collections: 6 уровень, 10 лекция
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
/*
ArrayBlockingQueue
DelayQueue
LinkedBlockingQueue
LinkedBlockingDeque
LinkedTransferQueue
PriorityBlockingQueue
SynchronousQueue
 */
        return SynchronousQueue.class;
    }
}
