package com.javarush.task.task20.task2003;


//import javax.crypto.spec.PSource;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();
    public static String separatorGlobal = ":";

    public static void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        for (Map.Entry<String, String> item: runtimeStorage.entrySet()) {
            prop.setProperty(item.getKey(),item.getValue());
        }
        prop.store(outputStream, null);
    }

/*
    public static void save(OutputStream outputStream) throws Exception {
        OutputStreamWriter outputStreamWriter =  new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        for (Map.Entry<String, String> item: runtimeStorage.entrySet()) {
            bufferedWriter.write(item.getKey()+separatorGlobal+item.getValue()+System.lineSeparator());
        }
        bufferedWriter.close();
        outputStreamWriter.close();
    }
*/

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties prop = new Properties();
        prop.load(inputStream);
        for (Map.Entry item: prop.entrySet()) {
            System.out.println(item.getKey().toString() +" "+ item.getValue().toString());
            runtimeStorage.put(item.getKey().toString(),item.getValue().toString());
        }
    }

/*    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = "";
        String separator = ":";
        boolean firstString = true;
        while ((str = bufferedReader.readLine()) != null) {
            if (firstString){
                separator = getSeparator(str);
                separatorGlobal = separator;
                //System.out.println(separator);
                firstString = false;
            }
            String keyStr = str.substring(0, str.indexOf(separator));
            String valueStr = str.substring(str.indexOf(separator)+1);
            runtimeStorage.put(keyStr,valueStr);
            //System.out.println(str.indexOf(separator));
            //System.out.println("keyStr="+keyStr);
            //System.out.println("valueStr="+valueStr);
            //System.out.println(keyStr+separator+valueStr);
            //System.out.println(str);
        }
        bufferedReader.close();
        inputStreamReader.close();
    }*/

    public static String getSeparator(String str){
        //Оба символа присутствуют в строке
        String separator = "";
        if (str.contains("=") && str.contains(":"))  {
            if (str.indexOf("=") < str.indexOf(":"))
                separator = "=";
            else
                separator = ":";
        }
        //Один из символов присутствует в строке
        else {
            if (str.contains(":")) {
                separator = ":";
            }
            else
            if (str.contains("=")) {
                separator = "=";
            }
        }
        return separator;
    }

    public static void main(String[] args) {
        String greetings = "properties.txt\n";
        byte[] bytes = greetings.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("properties.txt");
            save(fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
