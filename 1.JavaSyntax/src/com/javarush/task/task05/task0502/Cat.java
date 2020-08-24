package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age; //возраст
    public int weight; //вес
    public int strength; //сила

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        int cnt1 = 0;
        int cnt2 = 0;
        if ((this.age == anotherCat.age) &&
                (this.strength == anotherCat.strength) &&
                (this.weight == anotherCat.weight))
             return false;
        //else {
            if (this.age > anotherCat.age) cnt1++;
            if (this.strength > anotherCat.strength) cnt1++;
            if (this.weight > anotherCat.weight) cnt1++;
            if (this.age < anotherCat.age) cnt2++;
            if (this.strength < anotherCat.strength) cnt2++;
            if (this.weight < anotherCat.weight) cnt2++;

        //}
        return cnt1 > cnt2;
    }

    public static void main(String[] args) {
        Cat vaska  = new Cat();
        vaska.age = 12;
        vaska.strength = 16;
        vaska.weight = 13;
        Cat murzik  = new Cat();
        murzik.age = 10;
        murzik.strength = 15;
        murzik.weight = 17;
        System.out.println(vaska.fight(murzik));
        System.out.println(murzik.fight(vaska));
        System.out.println(murzik.fight(murzik));
    }
}
