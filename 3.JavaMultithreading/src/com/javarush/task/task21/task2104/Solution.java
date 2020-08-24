package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;

/* 
Equals and HashCode
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

//    public boolean equals(Solution n) {
      public boolean equals(Object o) {

       if (!(o instanceof Solution))  return false;

       if (this == o)  return true;

        Solution n = (Solution) o;

        if (n == null) return false;
        if (n.getClass() != this.getClass()) return false;

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
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));

        Solution a1 = new Solution(null, null);
        Solution b1 = null;
        System.out.println(a1.equals(b1));

        Solution a2 = new Solution(null, null);
        Solution b2 = a2;
        System.out.println(a2.equals(b2));

        Solution a3 = new Solution(null, null);
        Solution b3 = new Solution(null, null);
        System.out.println(a3.equals(b3));

        Solution a4 = new Solution("aaa", null);
        Solution b4 = new Solution(null, null);
        System.out.println(a4.equals(b4));

        Solution a5 = new Solution("aaa", "bbb");
        Solution b5 = new Solution(null, null);
        System.out.println(a5.equals(b5));

        Solution a6 = new Solution(null, null);
        Solution b6 = new Solution("aaa", null);
        System.out.println(a6.equals(b6));

        Solution a7 = new Solution(null, null);
        Solution b7 = new Solution("aaa", "bbb");
        System.out.println(a7.equals(b7));

    }
}
