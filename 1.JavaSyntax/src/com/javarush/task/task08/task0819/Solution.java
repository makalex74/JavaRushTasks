package com.javarush.task.task08.task0819;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 
Set из котов
*/

public class Solution {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. step 3 - пункт 3
        Iterator iterr = cats.iterator();
        int cnt = 1;
        while (iterr.hasNext()){
            iterr.next();
            if ( cnt == 1){
                iterr.remove();
            }
            cnt++;
        }
        printCats(cats);
    }

    public static Set<Cat> createCats() {
        //напишите тут ваш код. step 2 - пункт 2
        Set<Cat> setCat = new HashSet<Cat>();
        Cat barsik = new Cat();
        setCat.add(barsik);
        Cat murzik = new Cat();
        setCat.add(murzik);
        Cat kisa = new Cat();
        setCat.add(kisa);
        return setCat;
    }

    public static void printCats(Set<Cat> cats) {
        // step 4 - пункт 4
        Iterator iterr = cats.iterator();
        while (iterr.hasNext()){
            System.out.println(iterr.next());
/*            if ( iterr.next().hashCode() > 10)
                iterr.remove();*/
        }
    }


    // step 1 - пункт 1
    public static class Cat{
 /*       private String name;
        public Cat(String name){
            this.name = name;
        }
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
*/
    }
}
