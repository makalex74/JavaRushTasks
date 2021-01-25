package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
/*        allPeople.add(Person.createFemale("Филаретова Евгения", new Date()));  //сегодня родился    id=2
        allPeople.add(Person.createFemale("Форточкина Люся", new Date()));  //сегодня родился    id=3
        allPeople.add(Person.createMale("Бармалейкин Василий", new Date()));  //сегодня родился    id=4*/
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

        //args = "-c Миронов м 15/04/1990 Пупкин м 20/01/1970 Пушкевич ж 20/03/2001 Сахаров м 15/04/1990 Цукерман ж 15/04/1990".split(" ");
        //args = "-u 0 Миронов м 15/04/1990 1 Пупкин м 20/01/1970".split(" ");
        //args = "-d 0 2".split(" ");
        //args = "-i 0 2".split(" ");

        DateFormat dateFormatOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        DateFormat dateFormatInput = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

/*        if (args[0].equals("-i")){
            //System.out.println("-i параметр"); //-i id //Миронов м 15-Apr-1990
            int indx = Integer.parseInt(args[1]);
            String sex = allPeople.get(indx).getSex().toString().equals("MALE") ? "м" : "ж";
            System.out.println(allPeople.get(indx).getName() + " " +
                    sex + " " +
                    dateFormatOutput.format(allPeople.get(indx).getBirthDate()));
        }*/

        //start here - начни тут
        switch (args[0]) {
            case  ("-i"):
                //System.out.println("-i параметр"); //-i id1 id2 id3 id4 ...
                synchronized (allPeople) {
                    for (int i = 1; i < args.length ; i++) {
                        int indx = Integer.parseInt(args[i]);
                        String sex = allPeople.get(indx).getSex().toString().equals("MALE") ? "м" : "ж";
                        System.out.println(allPeople.get(indx).getName() + " " +
                                sex + " " +
                                dateFormatOutput.format(allPeople.get(indx).getBirthDate()));
                    }
                }
                break;
            case ("-d"):
                //System.out.println("-d параметр"); //-d id1 id2 id3 id4 ...
                synchronized (allPeople) {
                    for (int i = 1; i < args.length ; i++) {
                        int indx = Integer.parseInt(args[i]);
                        allPeople.get(indx).setName(null);
                        allPeople.get(indx).setSex(null);
                        allPeople.get(indx).setBirthDate(null);
                    }
                }
                //ShowAllPeople();
                break;
            case ("-u"):
                //System.out.println("-u параметр"); //-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
                synchronized (allPeople) {
                    for (int i = 1; i < args.length ; i=i+4) {
                        int indx = Integer.parseInt(args[i]);
                        String name = args[i+1];
                        String sex = args[i+2];
                        Date bdate = dateFormatInput.parse(args[i+3]);
                        allPeople.get(indx).setName(name);
                        allPeople.get(indx).setBirthDate(bdate);
                        if (sex.equals("м"))
                            allPeople.get(indx).setSex(Sex.MALE);
                        else
                            allPeople.get(indx).setSex(Sex.FEMALE);

                    }
                }
                //ShowAllPeople();
                break;
            case ("-c"):                           // 0   1    2    3   4     5    6   7     8    9   10    11   12
                //System.out.println("-c параметр"); //-c name1 sex1 bd1 name2 sex2 bd2 name3 sex3 bd3 name4 sex4 bd4...
                synchronized (allPeople) {
                    for (int i = 1; i < args.length ; i=i+3) {
                            String name = args[i];
                            String sex = args[i + 1];
                            Date bdate = dateFormatInput.parse(args[i + 2]);
                            if (sex.equals("м"))
                                allPeople.add(Person.createMale(name, bdate));
                            else
                                allPeople.add(Person.createFemale(name, bdate));
                            int indx = allPeople.size() - 1;
                            System.out.println(indx);
                    }
                }
                //ShowAllPeople();
                break;
            default:
                System.out.println("0-й параметр должен быть один из параметров: -c -u -d или -i !");
                break;
        }
    }
}
