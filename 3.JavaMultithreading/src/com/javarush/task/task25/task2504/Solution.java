package com.javarush.task.task25.task2504;

/* 
Switch для нитей
Обработай список нитей в зависимости от состояния:
1. Если нить еще не запущена, то запусти ее.
2. Если нить в ожидании, то прерви ее.
3. Если нить работает, то проверь маркер isInterrupted.
4. Если нить прекратила работу, то выведи в консоль ее приоритет.
Используй switch.


Требования:
1. Метод processThreads принимает аргументом массив нитей.
2. Если переданная нить не запущена, нужно ее запустить.
3. Если переданная нить находится в ожидании, нужно ее прервать.
4. Если переданная нить работает, то нужно проверить маркер isInterrupted.
5. Если переданная нить завершила работу, нужно вывести в консоль ее приоритет.
6. Метод processThreads должен использовать оператор switch.
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread thread: threads) {
            Thread.State currentState = thread.getState();
            String prefix = thread.getId()+" "+thread.getName()+" "+thread.getState();
            switch (currentState) {
            case NEW:
                //System.out.println(prefix + " -  thread.start();" );
                thread.start();
                break;
            case RUNNABLE:
                //System.out.println(prefix + " -  thread.isInterrupted()" );
                thread.isInterrupted();
                break;
            case BLOCKED:
                //System.out.println(prefix + " -  thread.interrupt();" );
                thread.interrupt();
                break;
            case WAITING:
                //System.out.println(prefix + " -  thread.interrupt();" );
                thread.interrupt();
                break;
            case TIMED_WAITING:
                //System.out.println(prefix + " -  thread.interrupt();" );
                thread.interrupt();
                break;
            case TERMINATED:
                //System.out.println(prefix + " -  thread.getPriority();" );
                System.out.println(thread.getPriority());
                break;
/*            default:
                 System.out.println("Noname state");
                break;*/
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[3];
        threads[0] = new Thread();
        threads[1] = new Thread();
        threads[2] = new Thread();
        threads[0].start();
        processThreads(threads);
        Thread.sleep(100);
        processThreads(threads);
    }
}
