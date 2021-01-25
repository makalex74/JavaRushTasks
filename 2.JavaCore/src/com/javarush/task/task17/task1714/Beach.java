package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        Beach beach1 = new Beach("Sochi",88.1f, 4);
        Beach beach2 = new Beach("Anapa",99.1f, 3);
        System.out.println(beach1.compareTo(beach2));
    }

    @Override
    public synchronized int compareTo(Beach o) {
/*
Реализовать метод compareTo так, чтобы он при сравнении двух пляжей выдавал число, которое показывает что первый пляж лучше (положительное число)
или второй пляж лучше (отрицательное число), и насколько он лучше
 */
        float distanceDiff =  o.distance - this.distance;
        int qualityDiff = this.quality - o.quality;
        return (int) distanceDiff + qualityDiff ;
    }
}
