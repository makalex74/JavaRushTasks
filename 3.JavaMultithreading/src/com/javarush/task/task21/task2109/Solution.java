package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            A cloneA = new A(this.getI(), this.getJ());
            return cloneA;
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

       @Override
       protected Object clone() throws CloneNotSupportedException {
              throw new CloneNotSupportedException();
       }
    }

    public static class C extends B implements Cloneable {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            C cloneC = new C(this.getI(),this.getJ(),this.getName());
            return cloneC;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(1,2);
        A cloneA = (A) a.clone();
        System.out.println(a);
        System.out.println(cloneA);
        C c = new C(1,2,"Numbers");
        C cloneC = (C) c.clone();
        System.out.println(c);
        System.out.println(cloneC);
        B b = new B(1,2,"Numbers");
        B cloneB = (B) b.clone();
        System.out.println(b);
        System.out.println(cloneB);
    }
}
