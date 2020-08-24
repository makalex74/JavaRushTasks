package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
1. Дан двумерный массив N*N, который содержит несколько прямоугольников.
2. Различные прямоугольники не соприкасаются и не накладываются.
3. Внутри прямоугольник весь заполнен 1.
4. В массиве:
4.1) a[i, j] = 1, если элемент (i, j) принадлежит какому-либо прямоугольнику
4.2) a[i, j] = 0, в противном случае
5. getRectangleCount должен возвращать количество прямоугольников.
6. Метод main не участвует в тестировании


Требования:
1. В классе Solution должен существовать метод getRectangleCount с одним параметром типа byte[][].
2. Метод getRectangleCount должен быть публичным.
3. Метод getRectangleCount должен быть статическим.
4. Метод getRectangleCount должен возвращать количество прямоугольников (в соответствии с заданием) найденное в полученном массиве.
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };
        byte[][] a3 = new byte[][]{
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 1}
        };

        byte[][] a4 = new byte[][]{
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, },
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, },
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, },
                {0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, },
                {0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, },
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, },
                {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, }
        };

        byte[][] a5 = new byte[][]{
                {1, 0, 0, 0},
                {1, 0, 1, 0}
        };


        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        int count3 = getRectangleCount(a3);
        System.out.println("count = " + count3 + ". Должно быть 4");
        int count4 = getRectangleCount(a4);
        System.out.println("count = " + count4 + ". Должно быть 10");
        int count5 = getRectangleCount(a5);
        System.out.println("count = " + count5 + ". Должно быть 2");

    }

    public static int getRectangleCount(byte[][] a) {
        int cntRect = 0;
        int preX = 0;
        for (int i = 0; i < a.length ; i++) {
            for (int j = 0; j < a[i].length ; j++) {
                //Первая строка
                if (i==0) {
                    if ((a[i][j] == 1) && (preX == 0)) {
                        cntRect++;
                        preX = 1;
                    }
                    if (a[i][j] == 0) {
                        preX = 0;
                    }
                }
                //Вторая и последующие строки
                if (i>0){
                    if ((a[i][j] == 1) && (a[i-1][j] == 0) && (preX == 0)){
                        cntRect++;
                        preX = 1;
                    }
                    if ((a[i][j] == 0)){
                        preX = 0;
                    }
                 }
                System.out.print(a[i][j]);
            }
            preX = 0;
            System.out.println();
        }
        return cntRect;
    }
}
