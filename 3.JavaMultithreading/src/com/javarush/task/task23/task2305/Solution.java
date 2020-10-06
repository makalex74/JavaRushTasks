package com.javarush.task.task23.task2305;

/*
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] result = new Solution[2];

        Solution solution1 = new Solution();
        InnerClass innerClass11 = solution1.new InnerClass();
        solution1.innerClasses[0] = innerClass11;
        InnerClass innerClass12 = solution1.new InnerClass();
        solution1.innerClasses[1] = innerClass12;
        result[0] = solution1;

        Solution solution2 = new Solution();
        InnerClass innerClass21 = solution2.new InnerClass();
        solution2.innerClasses[0] = innerClass21;
        InnerClass innerClass22 = solution2.new InnerClass();
        solution2.innerClasses[1] = innerClass22;

        result[1] = solution2;

        return result;
    }

    public static void main(String[] args) {

    }
}
