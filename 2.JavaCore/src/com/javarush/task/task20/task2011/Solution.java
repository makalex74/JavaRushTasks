package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String) in.readObject();
            year = in.readInt();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Apartment apartmentOut = new Apartment("В деревню", 5);
        System.out.println(apartmentOut);

        FileOutputStream fileOutputStream = new FileOutputStream("apartment.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        apartmentOut.writeExternal(objectOutputStream);
        objectOutputStream.close();
        fileOutputStream.close();


        FileInputStream fileInputStream = new FileInputStream("apartment.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Apartment apartmentIn = new Apartment("В село", 7);
        apartmentIn.readExternal(objectInputStream);
        objectInputStream.close();
        fileInputStream.close();

        System.out.println(apartmentIn);

    }
}
