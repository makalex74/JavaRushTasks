package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    private int value1;
    private String value2;
    private boolean value3;

    public static void main(String[] args) {

    }

    public Solution(int value1, String value2, boolean value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }

    Solution(int value1) {
        this.value1 = value1;
    }

    protected Solution(int value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    private Solution(String value2) {
        this.value2 = value2;
    }
}

