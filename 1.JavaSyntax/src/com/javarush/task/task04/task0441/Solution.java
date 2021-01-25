package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int max3 = max(max(a,b),c);
        int min3 = min(min(a,b),c);
        if ((a == max3) && (b == min3))
            System.out.println(c);
         else
            if ((a == max3) && (c == min3))
                System.out.println(b);
               else
                 if ((b == max3) && (c == min3))
                     System.out.println(a);
                 else
                    if ((a == min3) && (b == max3))
                        System.out.println(c);
                    else
                        if ((a == min3) && (c == max3))
                            System.out.println(b);
                        else
                            if ((b == min3) && (c == max3))
                                System.out.println(a);
    }
    public static int min(int n1, int n2){
        if (n1 < n2)
            return n1;
        else
            return n2;
    }

    public static int max(int n1, int n2){
        if (n1 > n2)
            return n1;
        else
            return n2;
    }

}
