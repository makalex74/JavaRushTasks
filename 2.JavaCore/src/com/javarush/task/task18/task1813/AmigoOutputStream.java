package com.javarush.task.task18.task1813;

import java.io.*;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream {
    public static String fileName = "result.txt";
    private FileOutputStream original;

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.original = fileOutputStream;
    }

    @Override
    public void write(int b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        original.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        original.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        original.flush();
    }

    @Override
    public void close() throws IOException {
        /*2 При вызове метода close() должны выполняться следующая последовательность действий:
        2.1 Вызвать метод flush().
        2.2 Дописать следующий текст "JavaRush © All rights reserved.", используй метод getBytes().
        2.3 Закрыть поток методом close().*/
        flush();
        byte[] data = "JavaRush © All rights reserved.".getBytes();
        write(data);
        original.close();
    }
}
