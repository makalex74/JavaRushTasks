package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
Разложить целое число n > 1 на простые множители.
Вывести в консоль через пробел все множители в порядке возрастания.
Написать рекурсивный метод для вычисления простых множителей.
Не создавай в классе Solution дополнительные поля.

Пример:
132

Вывод на консоль:
2 2 3 11

Требования:
1. В классе Solution не должны быть созданы дополнительные поля.
2. Метод recurse должен выводить на экран все простые множители числа полученного в качестве параметра (пример в условии).
3. Метод recurse не должен быть статическим.
4. Метод recurse должен быть рекурсивным.
*/

public class Solution {
    public void recurse(int n) {
        if (n < 2) return;
        for (int i = 2; i <= n ; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                recurse(n / i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.recurse(132);
        //solution.recurse(20);
        //solution.recurse(35);
    }
}
