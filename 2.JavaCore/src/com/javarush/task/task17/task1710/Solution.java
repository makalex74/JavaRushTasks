package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void ShowAllPeople(){
        DateFormat dateFormatOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        System.out.println("--");
        for (Person item : allPeople) {
            if ((item.getName() != null) && (item.getSex() != null) && (item.getBirthDate() != null) )
            System.out.println(item.getName() + " " + item.getSex() + " " +
                    dateFormatOutput.format(item.getBirthDate()));
        }
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        args = "-c Миронов м 15/04/1990".split(" ");

        DateFormat dateFormatOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        DateFormat dateFormatInput = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        if (args[0].equals("-i")){
            //System.out.println("-i параметр"); //-i id //Миронов м 15-Apr-1990
            int indx = Integer.parseInt(args[1]);
            String sex = allPeople.get(indx).getSex().toString().equals("MALE") ? "м" : "ж";
            System.out.println(allPeople.get(indx).getName() + " " +
                               sex + " " +
                               dateFormatOutput.format(allPeople.get(indx).getBirthDate()));
        }
        else
            if (args[0].equals("-d")) {
//              System.out.println("-d параметр"); //-d id
              int indx = Integer.parseInt(args[1]);
              allPeople.get(indx).setName(null);
              allPeople.get(indx).setSex(null);
              allPeople.get(indx).setBirthDate(null);
            }
            else
                if (args[0].equals("-u")) {
                  //System.out.println("-u параметр"); //-u id name sex bd
                  int indx = Integer.parseInt(args[1]);
                  String name = args[2];
                  String sex = args[3];
                  Date bdate = dateFormatInput.parse(args[4]);
                  allPeople.get(indx).setName(name);
                  allPeople.get(indx).setBirthDate(bdate);
                  if (sex.equals("м"))
                      allPeople.get(indx).setSex(Sex.MALE);
                  else
                      allPeople.get(indx).setSex(Sex.FEMALE);
                }
                else
                if (args[0].equals("-c")) {
                    //System.out.println("-c параметр"); //-c Миронов м 15/04/1990
                    String name = args[1];
                    String sex = args[2];
                    Date bdate = dateFormatInput.parse(args[3]);
                    if (sex.equals("м"))
                       allPeople.add(Person.createMale(name, bdate));
                    else
                       allPeople.add(Person.createFemale(name, bdate));
                    int indx = allPeople.size()-1;
                    System.out.println(indx);
                }
        //ShowAllPeople();
    }
}
