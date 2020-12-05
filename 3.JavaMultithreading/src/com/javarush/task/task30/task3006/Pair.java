package com.javarush.task.task30.task3006;

public class Pair {
    private int x;
    private int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("x=%d, y=%d", x, y);
    }

    public void swap() {
        //System.out.println("Before");
        //System.out.println(" x = " + Integer.toString(x,2));
        //System.out.println(" y = " + Integer.toString(y,2));
        x = x ^ y;
        //System.out.println(" x = x ^ y = " + Integer.toString(x,2));
        y = y ^ x;
        //System.out.println(" y = y ^ x = " + Integer.toString(y,2));
        x = x ^ y;
        //System.out.println(" x = x ^ y = " + Integer.toString(x,2));
        //System.out.println("After");
        //System.out.println(" x = " + Integer.toString(x,2));
        //System.out.println(" x = " + Integer.toString(y,2));
    }
}

