package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            //Human ivanov = new Human("Ivanov", null);
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(somePerson.equals(ivanov));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            OutputStreamWriter outputStreamWriter =  new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(name + System.lineSeparator());
            for (Asset item: assets) {
                bufferedWriter.write(item.getName() + System.lineSeparator());
                bufferedWriter.write(item.getPrice() + System.lineSeparator());
            }
            bufferedWriter.close();
            outputStreamWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = "";
            int cnt = 0;
            String aName = "";
            String aPrice = "";
            while ((str = bufferedReader.readLine()) != null){
                if (cnt == 0){
                    //System.out.println(cnt);
                    name = str;
                    cnt++;
                }
                else
                    if (cnt%2 != 0){
                        //System.out.println(cnt);
                        aName = str;
                        cnt++;
                    }
                    else {
                        //System.out.println(cnt);
                        aPrice = str;
                        if (!aName.equals("") && !aPrice.equals("")) {
                            assets.add(new Asset(aName, Double.parseDouble(aPrice)));
                        }
                        cnt++;
                    }
                //System.out.println(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
/*            for (Asset item: assets) {
                System.out.println(item.getName());
                System.out.println(item.getPrice());
            }*/
        }
    }
}
