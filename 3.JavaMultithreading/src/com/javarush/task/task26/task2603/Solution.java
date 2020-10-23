package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 
Убежденному убеждать других не трудно
В таблице есть колонки, по которым можно сортировать.
Пользователь имеет возможность настроить под себя список колонок, которые будут сортироваться.
Напиши public static компаратор CustomizedComparator, который будет:
1. В конструкторе принимать массив компараторов.
2. Сортировать данные в порядке, соответствующем последовательности компараторов.
Все переданные компараторы сортируют дженерик тип Т.
В конструктор передается как минимум один компаратор.


Требования:
1. Класс Solution должен содержать public static компаратор CustomizedComparator.
2. Класс CustomizedComparator должен содержать приватное поле comparators типа Comparator<T>[].
3. Класс CustomizedComparator должен содержать конструктор с параметром vararg компараторов.
4. Метод compare() класса CustomizedComparator должен сравнивать объекты в порядке, соответствующем последовательности компараторов comparators.
*/
public class Solution {

    public static class CustomizedComparator<T> implements Comparator<T> {
        private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>... comparators) {
            this.comparators = comparators;
        }

        @Override
        public int compare(T o1, T o2) {
            int res = 0;
            for (Comparator<T> comparator : comparators) {
                res = comparator.compare(o1, o2);
                if (res != 0) {
                    return res;
                }
            }
            return 0;
        }
    }

    public static class Woman {

        public int age;
        public int childrenCount;
        public int weight;
        public int height;
        public String name;

        public Woman(int age, int childrenCount, int weight, int height, String name) {

            this.age = age;
            this.childrenCount = childrenCount;
            this.weight = weight;
            this.height = height;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public int getChildrenCount() {
            return childrenCount;
        }

        public int getWeight() {
            return weight;
        }

        public int getHeight() {
            return height;
        }
    }


    public static void main(String[] args) {

        Comparator<Woman> compareByHeight = new Comparator<Woman>() {

            public int compare(Woman o1, Woman o2) {
                return o1.height - o2.height;
            }
        };

        Comparator<Woman> compareByWeight = new Comparator<Woman>() {

            public int compare(Woman o1, Woman o2) {

                return o1.weight - o2.weight;
            }
        };

        Comparator<Woman> compareByAge = new Comparator<Woman>() {

            public int compare(Woman o1, Woman o2) {

                return o1.age - o2.age;
            }
        };

        CustomizedComparator<Woman> customizedComparator = new CustomizedComparator<>(compareByHeight, compareByAge, compareByWeight);//
        List<Woman> womens = new ArrayList<Woman>();
        womens.add(new Woman(18, 0, 45, 170, "Ann"));
        womens.add(new Woman(21, 1, 57, 168, "Iren"));
        womens.add(new Woman(5, 0, 20, 110, "Angelina"));
        womens.add(new Woman(35, 0, 50, 168, "Lena"));
        Collections.sort(womens,customizedComparator);

        for (Woman woman: womens) {
            System.out.println(woman.getName() + " " + woman.getAge() + " " + woman.getHeight()  + " " + woman.getWeight());
        }

    }
}
