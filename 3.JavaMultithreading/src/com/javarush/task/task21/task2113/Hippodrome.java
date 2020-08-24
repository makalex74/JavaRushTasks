package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }
    
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
           move();
           print();
           Thread.sleep(200);
        }
    }

    public void move(){
        for (Horse item: horses) {
            item.move();
        }
    }

    public void print(){
        for (Horse item: horses) {
            item.print();
        }
        for (int i = 0; i < 10; i++){
            System.out.println();
        }
    }

    public Horse getWinner(){
        Horse winner = null;
        Double maxDistance = 0d;
        for (int i = 0; i < horses.size() ; i++) {
            if (i == 0) {
                maxDistance = horses.get(i).distance;
            }
            else {
                maxDistance = maxDistance > horses.get(i).distance ? maxDistance : horses.get(i).distance;
            }
        }
        for (Horse item: horses) {
            if (item.distance == maxDistance){
                winner = item;
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().name+"!");
    }


    public static void main(String[] args) throws InterruptedException {
        Horse veter = new Horse("Ветер",3,0);
        Horse meteor = new Horse("Метеор",3,0);
        Horse kometa = new Horse("Комета",3,0);
        List<Horse> listHorses = new ArrayList<>();
        listHorses.add(veter);
        listHorses.add(meteor);
        listHorses.add(kometa);
        Hippodrome hippodrome = new Hippodrome(listHorses);
        Hippodrome.game = hippodrome;
        Hippodrome.game.run();
        Hippodrome.game.printWinner();
    }

}
