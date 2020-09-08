package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

/*
Надо:
а) Добавить в класс Snake поле sections типа List<SnakeSection>.
б) Добавить поле isAlive типа boolean.
в) Добавить поле direction типа SnakeDirection.
г) Для всех полей добавить getter'ы, а для direction еще и setter.
 */

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        SnakeSection headSnake = new SnakeSection(x, y);
        sections = new ArrayList<>();
        sections.add(headSnake);
        isAlive = true;
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public int getX(){
        return sections.get(0).getX();
    }

    public int getY(){
        return sections.get(0).getY();
    }

    public void move(){

    }


}
