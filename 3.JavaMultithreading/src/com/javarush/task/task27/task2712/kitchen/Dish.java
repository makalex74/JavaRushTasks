package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;

    Dish(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public static String allDishesToString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Dish.values().length; i++) {
            if (i != 0) result.append(", ");
            result.append(Dish.values()[i]);
        }
        return result.toString();
    }
}
