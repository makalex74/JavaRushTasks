package com.javarush.task.task15.task1529;

/* 
Осваивание статического блока
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String flyString = reader.readLine();
            if (flyString.equals("helicopter")) {
                result = new Helicopter();
            }
            if (flyString.equals("plane")) {
                int cntPassngr = Integer.parseInt(reader.readLine());
                result = new Plane(cntPassngr);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
            //result.fly();
    }

}
