package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            //File yourFile = new File("your_file_name.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.M.yyyy");

            User pupkin = new User();
            pupkin.setFirstName("Василий");
            pupkin.setLastName("Пупкин");
            pupkin.setBirthDate(simpleDateFormat.parse("01.01.1999"));
            pupkin.setMale(true);
            pupkin.setCountry(User.Country.RUSSIA);
            javaRush.users.add(pupkin);

            User molodtsov = new User();
            molodtsov.setFirstName("Петр");
            molodtsov.setLastName("Молодцов");
            molodtsov.setBirthDate(simpleDateFormat.parse("11.09.1980"));
            molodtsov.setMale(true);
            molodtsov.setCountry(User.Country.UKRAINE);
            javaRush.users.add(molodtsov);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            OutputStreamWriter outputStreamWriter =  new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            for (User item: users) {
                String strUser = item.getFirstName();
                strUser += " " + item.getLastName();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.M.yyyy.HH:mm:ss:S");
                strUser += " " + simpleDateFormat.format(item.getBirthDate());
                strUser += " " + item.isMale();
                strUser += " " + item.getCountry();
                bufferedWriter.write(strUser + System.lineSeparator());
            }
            bufferedWriter.close();
            outputStreamWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = "";
            while ((str = bufferedReader.readLine()) != null){
                //System.out.println(str);
                String[] arrStr = str.split(" ");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.M.yyyy.HH:mm:ss:S");
                User user = new User();
                user.setFirstName(arrStr[0]);
                user.setLastName(arrStr[1]);
                user.setBirthDate(simpleDateFormat.parse(arrStr[2]));
                user.setMale(Boolean.parseBoolean(arrStr[3]));
                user.setCountry(User.Country.valueOf(arrStr[4]));
                users.add(user);
            }
            bufferedReader.close();
            inputStreamReader.close();

/*            for (User item: users) {
                String strUser = item.getFirstName();
                strUser += " " + item.getLastName();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.M.yyyy.HH:mm:ss:S");
                strUser += " " + simpleDateFormat.format(item.getBirthDate());
                strUser += " " + item.isMale();
                strUser += " " + item.getCountry();
                System.out.println(strUser);
            }*/
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
