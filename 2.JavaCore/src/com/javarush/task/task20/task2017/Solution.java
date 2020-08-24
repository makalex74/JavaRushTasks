package com.javarush.task.task20.task2017;

import java.io.*;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {

/*        Object object = null;
        try {
            object = objectStream.readObject();
            objectStream.close();
            A resA  = (A)object;
            if (resA.getClass().getSimpleName().equals("A"))
                return resA;
            else  return null;
        } catch (Exception e) {
            return null;
        }*/
        A resA;
        try {
            resA = (A) objectStream.readObject();
            if (resA.getClass().getSimpleName().equals("A"))
                return resA;
            else return null;
        } catch (Exception e) {
            resA = null;
        }
        return resA;        
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
/*       B  b = new B();

        //save b to file
        FileOutputStream fileOutput = new FileOutputStream("b.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(b);
        fileOutput.close();
        outputStream.close();

        //load b from file
        FileInputStream fiStream = new FileInputStream("b.dat");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        A a = getOriginalObject(objectStream);
        fiStream.close();
        System.out.println(a);*/
    }
}
