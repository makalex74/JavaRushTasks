package com.javarush.task.task21.task2105;

import java.util.HashSet;
import java.util.Set;

/* 
Исправить ошибку. Сравнение объектов
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Solution)) return false;
        if (this == o)  return true;
        Solution n = (Solution) o;
        //Если поля обоих объектов равны null, эти поля считаются равными, просто у них метод equals вызвать нельзя.
        if ((this.first == null && n.first != null) || (this.first != null && n.first == null))  return false;
        if ((this.last == null && n.last != null) || (this.last != null && n.last == null))  return false;

        boolean firstBool = (this.first == null && n.first == null)
                || (this.first.equals(n.first));

        boolean lastBool =  (this.last == null && n.last == null)
                || (this.last.equals(n.last));

        return  firstBool && lastBool;

        //return n.first.equals(first) && n.last.equals(last);
    }

    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (last != null ? last.hashCode() : 0);
        return result;
        //return 31* first.hashCode() + last.hashCode();

    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
