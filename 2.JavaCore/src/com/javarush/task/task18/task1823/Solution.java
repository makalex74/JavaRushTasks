package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        String greetings = "file1.txt\nfile2.txt\nfile3.txt\nexit\n";
        byte[] bytes = greetings.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        ArrayList<String> fileList = new ArrayList<>();
        while (true) {
            str = reader.readLine();
            if (str.equals("exit")) break;
            fileList.add(str);
        }
        reader.close();
        //System.out.println(fileList);
        for (String item: fileList) {
            ReadThread readThread = new ReadThread(item);
            readThread.start();
            //readThread.join();
        }
        Thread.sleep(2000);
        for (HashMap.Entry item: resultMap.entrySet()) {
            System.out.println(item.getKey()+ " " + item.getValue());
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;
        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            List<Integer> list = new ArrayList<>();
            int i = -2;
            while (i != -1){
                try {
                    i=bufferedInputStream.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (i > 0) list.add(i);
            }
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

/*            for (Integer item: list) {
              System.out.println(fileName+" "+item);
            }*/

            HashMap<Integer,Integer> map = new HashMap<>();
            for (Integer item: list) {
                if (!map.containsKey(item)){
                    map.put(item,1);
                }
                else {
                    Integer cnt = map.get(item);
                    map.put(item,++cnt);
                }
            }
            int maxCnt = -1;
            for (HashMap.Entry item: map.entrySet()) {
                //System.out.println((char)(int)item.getKey()+" "+ item.getKey()+ " " + item.getValue());
                maxCnt = maxCnt > (int)item.getValue() ? maxCnt : (int)item.getValue();
            }
            //System.out.println("maxCnt =" + maxCnt);

            for (HashMap.Entry item: map.entrySet()) {
                list.add((int)item.getKey());
                if ((int)item.getValue() == maxCnt) {
                    synchronized (resultMap) {
                        resultMap.put(fileName, (int) item.getKey());
                    }
                    //System.out.println("result " + fileName + " "+item.getKey());
                }
            }
        }


    }
}
