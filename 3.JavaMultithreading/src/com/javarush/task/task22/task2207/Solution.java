package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }
    public static void main(String[] args) throws IOException {
/*        String greetings = "reverses.txt\n";
        byte[] bytes = greetings.getBytes();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        System.setIn(inputStream);*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //System.out.println(fileName);
        reader.close();
        System.setIn(System.in);

        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> listWords = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        String str;
        while (true){
            str = bufferedReader.readLine();
            if (str == null) break;
            System.out.println(str);
            for (String item:str.split(" ")) {
                listWords.add(item);
                if (map.containsKey(item)) {
                    int cnt = map.get(item);
                    map.put(item, ++cnt);
                }
                else {
                    map.put(item, 1);
                }
            }
        }
        bufferedReader.close();
        fileReader.close();
        System.out.println(listWords);
        System.out.println(map);

        Map<String,Integer> mapReverse = new HashMap<>();
        for (String item: listWords) {
            String stringReverse = new StringBuilder(item).reverse().toString();
            if (map.containsKey(stringReverse)){
                if (mapReverse.containsKey(stringReverse)) {
                    int cnt = mapReverse.get(stringReverse);
                    mapReverse.put(stringReverse, ++cnt);
                }
                else {
                    mapReverse.put(stringReverse, 1);
                }
            }
        }
        System.out.println(mapReverse);


        for(Iterator<String> iterator = mapReverse.keySet().iterator(); iterator.hasNext(); ) {
            String string = iterator.next();
            String stringReverse = new StringBuilder(string).reverse().toString();
            if(mapReverse.containsKey(stringReverse) && !string.equals(stringReverse)) {
                iterator.remove();
            }
        }
        System.out.println(mapReverse);


        for (Map.Entry<String,Integer> item: mapReverse.entrySet()) {
            String string = item.getKey();
            String stringReverse = new StringBuilder(string).reverse().toString();
            //Для строк-не палиндромов
            if (!string.equals(stringReverse))
                for (int i = 0; i < mapReverse.get(string); i++) {
                    Pair pair = new Pair(string, stringReverse);
                result.add(pair);
                }
            //Для строк-палиндромов
            else
                for (int i = 0; i < mapReverse.get(string)/2; i++) {
                    Pair pair = new Pair(string, stringReverse);
                    result.add(pair);
                }
        }

/*        //Для строк-палиндромов
        for (Map.Entry<String,Integer> item: map.entrySet()) {
            String string = item.getKey();
            String stringReverse = new StringBuilder(string).reverse().toString();
            //Если в мапе присутствует строка-реверс
            if (map.containsKey(stringReverse)){
                //Если строка-палиндром и присутствует в мапе больше 1 раза
                if (string.equals(stringReverse) && map.get(string) > 1){
                    for (int i = 0; i < map.get(string)/2; i++) {
                        Pair pair = new Pair(string, string);
                        result.add(pair);
                    }
                }
            }
        }*/

        //Пары повторно писаться должны столько раз, сколько они встречаются в данных.
        //по условию result может содержать повторы (т.е. не указано, что все пары должны быть уникальными)

        System.out.println(result);

    }

}
