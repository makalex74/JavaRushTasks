package com.javarush.task.task07.task0716;

import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        //strings.add("роза");
        //strings.add("лоза");
        //strings.add("лира");
        strings.add("роза");
        strings.add("мера");
        strings.add("лоза");
        strings.add("лира");
        strings.add("вода");
        strings.add("упор");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        ArrayList<String> strings_res = new ArrayList<String>();

        for (int i = 0; i < strings.size();) {
            int numCharR = strings.get(i).indexOf("р");
            //System.out.println("numCharR = "+numCharR);
            int numCharL = strings.get(i).indexOf("л");
            //System.out.println("numCharL = "+numCharL);
            if ((numCharR != -1) && (numCharL == -1))
                strings.remove(i);
            else
                 i++;
        }
        for (int i = 0; i < strings.size(); i++) {
            int numCharR = strings.get(i).indexOf("р");
            //System.out.println("numCharR = "+numCharR);
            int numCharL = strings.get(i).indexOf("л");
            //System.out.println("numCharL = "+numCharL);
            if ((numCharR == -1) && (numCharL != -1)) {
                strings_res.add(strings.get(i));
                strings_res.add(strings.get(i));
            } else
              if ((numCharR != -1) && (numCharL != -1))
                  strings_res.add(strings.get(i));
              else
                  strings_res.add(strings.get(i));
        }
        return strings_res;
    }

}