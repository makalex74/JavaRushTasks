package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        //args = "file1.txt".split(" ");
        FileReader fileReader = null;
        fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String str = null;
        while (true){
            str = bufferedReader.readLine();
            if (str == null) break;
            String[] arrStr = str.split(" ");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.M.y");
            String day = arrStr[arrStr.length - 3];
            String month = arrStr[arrStr.length - 2];
            String year = arrStr[arrStr.length - 1];
            Date birthday =  simpleDateFormat.parse(day +"."+ month + "." + year);
            String name = "";
            for (int i = 0; i < arrStr.length - 3; i++) {
                name += arrStr[i] + " ";
            }
            name = name.trim();
            //System.out.println(name + " " + birthday);
            Person person = new Person(name, birthday);
            PEOPLE.add(person);
        }
        bufferedReader.close();
        fileReader.close();
    }
}
