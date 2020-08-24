package com.javarush.task.task20.task2022;

import java.io.*;

/*
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName = "sol.txt" ;

    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        //out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName,true);
        //in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution sol = new Solution("sol.txt");
        sol.writeObject("Строка");
        FileOutputStream fos = new FileOutputStream("sol.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(sol);
        fos.close();
        oos.close();
        sol.close();
        FileInputStream fis = new FileInputStream("sol.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution loadSol = (Solution) ois.readObject();
        fis.close();
        ois.close();
        loadSol.writeObject("Строка2");
        loadSol.close();
    }
}
