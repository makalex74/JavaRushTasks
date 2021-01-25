package com.javarush.task.task06.task0601;

/* 
Метод finalize класса Cat
*/

public class Cat {
    //напишите тут ваш код
    public static void main(String[] args) {
        System.out.println("Begin program");
        Cat catTom = new Cat();
        System.out.println("After  Cat catTom = new Cat();");
//        catTom = null;
//        System.out.println("After  catTom = null;");
        System.out.println("End program");
    }
    protected void finalize() throws Throwable{

        System.out.println("Run finalize for class Cat");
    }
}
