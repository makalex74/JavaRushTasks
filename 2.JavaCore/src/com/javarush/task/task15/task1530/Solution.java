package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

public class Solution {
    public static void main(String[] args) {
        DrinkMaker teaMaker = new TeaMaker();
        teaMaker.makeDrink();
        DrinkMaker latteMaker = new LatteMaker();
        latteMaker.makeDrink();
    }
}
