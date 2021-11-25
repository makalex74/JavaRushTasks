package com.javarush.task.task36.task3604;

/* 
Разбираемся в красно-черном дереве
*/

public class Solution {
    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.insert(15);
        redBlackTree.insert(35);
        redBlackTree.insert(12);
        redBlackTree.insert(14);
        redBlackTree.insert(21);
        redBlackTree.insert(48);
        redBlackTree.insert(17);
        redBlackTree.insert(13);
        redBlackTree.insert(7);
        redBlackTree.insert(5);
        redBlackTree.insert(3);
        redBlackTree.insert(2);
        System.out.println(redBlackTree);
    }
}
