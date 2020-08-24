package com.javarush.task.task20.task2025;

import java.util.*;

import static java.lang.Math.pow;

/* 
Алгоритмы-числа
*/
public class Solution {

    private static long[][] powMatrix = new long[10][21];

    static {
        // Генерируем матрицу степеней
        generatePowMatrix();
    }

    public static long[] getNumbers(long N) {

        long[] result = null;
        if (N < 0) return result;
        ArrayList<Long> list = new ArrayList<>();
        long currentNumber = 1;
        while (currentNumber < N) {
            Long curArm = getArmNum(currentNumber);
            if (curArm != null) {
                list.add(curArm);
            }
            currentNumber = nextNumber(currentNumber);
        }

        result = new long[list.size()];
        for (int i = 0; i < list.size(); i++) {
              result[i] = list.get(i);
        }
        list.clear();

        return result;
    }

    /**
     * @return число армстронга  - если оно существует в наборе цифр переденного числа
     *         null - если число армстронга не существует
     */
    private static Long getArmNum(long sourceNum) {
        Long result = null;
        /* получаем список цифр исходного числа */
        List<Integer> sourceNumDigits = getNumDigits(sourceNum);
        /* считаем степенную сумму */
        long powSum = 0;
        for (Integer num : sourceNumDigits) {
            powSum += Math.pow(num, sourceNumDigits.size());
        }
        /* получаем список цифр степенной суммы */
        List<Integer> powSumDigits = getNumDigits(powSum);
        /* сортируем цифры исходного числа и степенной суммы по одному правилу */
        Collections.sort(sourceNumDigits);
        Collections.sort(powSumDigits);
        /* проверяем совпадают ли наборы цифр исходного числа и степенной суммы */
        if (sourceNumDigits.toString().equals(powSumDigits.toString())) {
            result = powSum;
        }
        return result;
    }

    /**
     * @return список цифт переденного цисла
     */
    private static List<Integer> getNumDigits(long number) {
        /* собираем цифры исходного числа */
        long ost = 0;
        long divideResult = number;
        List<Integer> nums = new ArrayList<>();
        /* достаем цифры пока число не кончилось */
        do {
            ost = divideResult % 10;
            nums.add((int) ost);
            divideResult = divideResult / 10;
        } while (divideResult != 0);
        return nums;
    }
    /**
     * @param curNumber - текущее число
     * @return возвращает следующее за текущим значение из ряда чисел, каждое из которых
     * соответсвует правилу: "любая цифра не меньше предыдущей и не больше последующей"
     * 1,2,3,4,5,6, ... ,48,49,50,55, ... ,890,899,900,990,999, ... ,89999999999999000,
     * 89999999999999900,89999999999999990,89999999999999999,90000000000000000
     */
    private static long nextNumber(long curNumber) {
        long ost;
        long divRes = curNumber;
        int por = 0; // число нулей в конце текущего числа
        /* подсчитываем число нулей в конце текущего числа */
        while (true) {
            ost = divRes % 10;
            if (ost != 0) {
                break;
            }
            por++;
            divRes = divRes / 10;
        }
        /* если в конце числа нет нулей выполняем простой декремент*/
        if (por == 0) {
            curNumber++;
        } else {
            long delta = ost * (long) Math.pow(10, por - 1);
            /* если вычисление нового значения ряда не вызовет переполнения, присваиваем новое значение */
            if (Long.MAX_VALUE - curNumber >= delta) {
                curNumber += delta;
            } else { /* иначе присваиваем значение, которое остановит перебор */
                curNumber = - 1;
            }
        }
        return curNumber;
    }

    /**
     * Возвращает степенную сумму числа
     *
     * @param n Любое long число
     * @return степенную сумму числа
     */
    private static long powerSum(long n) {
        if (n < 10) {
            return n;
        }

        int length = 1;
        long copyN = n;
        while (copyN >= 10) {
            copyN /= 10;
            length++;
        }

        long result = 0;
        while (true) {
            int num = (int) (n % 10);
            result += powMatrix[num][length];

            if (n < 10) break;

            n = n / 10;
        }
        return result;
    }

    /**
     * Генерируем матрицу степеней, работает вместе с pow()
     */
    private static void generatePowMatrix() {
        for (int i = 1; i < powMatrix.length; i++) {  //powMatrix.length = 10
            for (int j = 1; j < powMatrix[i].length; j++) { //powMatrix[i].length = 21
                powMatrix[i][j] = pow(i, j);
                //System.out.print(powMatrix[i][j]+ " ");
            }
            //System.out.println();
        }

    }

    static long pow(int a, int b) {
        long result = 1;
        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        for (int i = 1; i <= b; i++) {
            result = result * a;
        }
        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        //System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        //System.out.println(Arrays.toString(getNumbers(1000000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

/*        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(10000000)));
        //checkArmstrongNumbers(getNumbers(10000000));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);*/

/*        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);*/
    }

    /**
     * Ниже код для проверки
     */
/*    private static void checkArmstrongNumbers(long[] numbers) {
        long[] armstrongNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050, 24678051, 88593477, 146511208, 472335975, 534494836, 912985153, 4679307774L, 32164049650L, 32164049651L, 40028394225L, 42678290603L, 44708635679L, 49388550606L, 82693916578L, 94204591914L, 28116440335967L, 4338281769391370L, 4338281769391371L, 21897142587612075L, 35641594208964132L, 35875699062250035L, 1517841543307505039L, 3289582984443187032L, 4498128791164624869L, 4929273885928088826L};
        for (int i = 0; i < armstrongNumbers.length; i++) {
            if (numbers[i] != armstrongNumbers[i]) {
                System.out.println("Числа Армстронга не совпадают");
                System.out.println(numbers[i] + " != " + armstrongNumbers[i]);
                break;
            }
        }
    }*/
}
