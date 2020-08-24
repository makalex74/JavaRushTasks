package com.javarush.task.task08.task0823;

import org.omg.CORBA.WStringSeqHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        if (string.length() > 0) {
            Set<Integer> posFirstLetters = new HashSet<Integer>();
            posFirstLetters.add(0);
            char[] chArr = string.toCharArray();
            for (int i = 0; i < chArr.length; i++) {
                if ((Character.isWhitespace(chArr[i]) && (i != chArr.length -1))) {
                    posFirstLetters.add(i+1);
                }
            }
                for (int i = 0; i < chArr.length; i++) {
                    if (posFirstLetters.contains(i))
                      System.out.print(Character.toUpperCase(chArr[i]));
                    else
                      System.out.print(chArr[i]);
                }
            System.out.println();
        }
    }
}
