package com.javarush.task.task34.task3402;

/* 
Факториал с помощью рекурсии
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.factorial(9));     //362880
        System.out.println(solution.factorial(0));     //1
        System.out.println(solution.factorial(1));     //1
        System.out.println(solution.factorial(2));
        System.out.println(solution.factorial(3));
        System.out.println(solution.factorial(4));
        System.out.println(solution.factorial(5));
        System.out.println(solution.factorial(6));
        System.out.println(solution.factorial(7));
        System.out.println(solution.factorial(8));
        System.out.println(solution.factorial(9));
    }

    public int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return factorial(n-1) * n;
        }
    }
}
