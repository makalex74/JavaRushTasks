package com.javarush.task.task27.task2707;

public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        System.out.println("1someMethod "+ Thread.currentThread().getName() + ": "+ Thread.currentThread().getState());
        synchronized (obj1) {
            System.out.println("2someMethod "+ Thread.currentThread().getName() + ": "+ Thread.currentThread().getState());
            synchronized (obj2) {
                System.out.println("3someMethod "+ Thread.currentThread().getName() + ": "+ Thread.currentThread().getState());
                System.out.println(obj1 + " " + obj2);
            }
            System.out.println("4someMethod "+ Thread.currentThread().getName() + ": "+ Thread.currentThread().getState());
        }
        System.out.println("5someMethod "+ Thread.currentThread().getName() + ": "+ Thread.currentThread().getState());
    }

    private static volatile boolean flag = false;
    private static volatile boolean isInnerThreadBlocked = false;

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        synchronized (o1) {
            Thread outerThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    Thread innerThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            solution.someMethodWithSynchronizedBlocks(o1, o2);
                        }
                    });
                    innerThread.start();
                                                     System.out.println("    1 "+ innerThread.getName() + ": innerThread: "+ innerThread.getState());

                    while (innerThread.getState() != Thread.State.BLOCKED) ;
                                                    System.out.println("    2 "+ innerThread.getName() + ": innerThread: "+ innerThread.getState());
                    isInnerThreadBlocked = true;
                    synchronized (o2) {
                        flag = true;
                                                     System.out.println("    3 "+ innerThread.getName() + ": innerThread: "+ innerThread.getState());
                    }
                }
            });
            outerThread.setDaemon(true);
            outerThread.start();
                                                    System.out.println(" 1 "+ outerThread.getName() + ": outerThread: "+ outerThread.getState());

            while (!isInnerThreadBlocked) {
                Thread.sleep(1);
                                                    System.out.println(" 2 "+ outerThread.getName() + ": outerThread: "+ outerThread.getState());
            }
            while (outerThread.getState() != Thread.State.BLOCKED && outerThread.isAlive()) {
                Thread.sleep(1);
                                                    System.out.println(" 3 "+ outerThread.getName() + ": outerThread: "+ outerThread.getState());
            }
                                                    System.out.println(" 3 "+ outerThread.getName() + ": outerThread: "+ outerThread.getState());
        }

        return flag;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("#1 "+ Thread.currentThread().getName() + ": main: "+ Thread.currentThread().getState());
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();
        System.out.println("#2 "+ Thread.currentThread().getName() + ": main: "+ Thread.currentThread().getState());
        System.out.println(isLockOrderNormal(solution, o1, o2));
        System.out.println("#3 "+ Thread.currentThread().getName() + ": main: "+ Thread.currentThread().getState());
    }
}
