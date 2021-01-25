package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;
    public double diameter;

    public Circle(){
        this.x=0;
        this.y=0;
        this.radius=0;
        this.diameter =0;
    }

    public Circle(double x){
        this.x=x;
        this.y=0;
        this.radius=0;
        this.diameter =0;
    }

    public Circle(double x, double y){
        this.x=x;
        this.y=y;
        this.radius=0;
        this.diameter =0;
    }

    public Circle(double x, double y, double radius){
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.diameter = 2*radius;
    }

    public Circle(double x, double y, double radius, double diameter){
        this.x=x;
        this.y=y;
        this.radius=radius;
        this.diameter = 2*radius;
    }


    //напишите тут ваш код

    public static void main(String[] args) {

    }
}