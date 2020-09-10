package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Snake {
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";

    private List<GameObject> snakeParts;
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    public Snake(int x, int y) {
        this.snakeParts = new ArrayList<>();
        GameObject part1 = new GameObject(x, y);
        GameObject part2 = new GameObject(x + 1, y);
        GameObject part3 = new GameObject(x + 2, y);
        snakeParts.add(part1);
        snakeParts.add(part2);
        snakeParts.add(part3);
    }

    public void setDirection(Direction direction) {
        if ((this.direction == Direction.RIGHT && direction != Direction.LEFT) ||
           (this.direction == Direction.LEFT && direction != Direction.RIGHT) ||
           (this.direction == Direction.UP && direction != Direction.DOWN) ||
           (this.direction == Direction.DOWN && direction != Direction.UP)){
            this.direction = direction;
        }
    }

    public void draw(Game game){
        Color snakeColor = Color.GREEN;
        if (isAlive) {
            snakeColor = Color.GREEN;
        }
        else {
            snakeColor = Color.RED;
        }
        for (int i = 0; i < snakeParts.size() ; i++) {
            if (i == 0) {
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, HEAD_SIGN, snakeColor, 75);
            }
            else {
                game.setCellValueEx(snakeParts.get(i).x, snakeParts.get(i).y, Color.NONE, BODY_SIGN, snakeColor, 75);
            }
        }

    }

    public void move(Apple apple){
        GameObject newHead = createNewHead();
        if (newHead.x < 0 || newHead.y < 0 || newHead.x >= SnakeGame.WIDTH || newHead.y >= SnakeGame.HEIGHT){
            isAlive = false;
            return;
        }
        snakeParts.add(0, newHead);
        if ((newHead.x == apple.x) && (newHead.y == apple.y)){
            apple.isAlive = false;
        }
        else{
            removeTail();
        }
    }

    public GameObject createNewHead(){
        GameObject head = snakeParts.get(0);
        GameObject newHead = null;
        if (direction == Direction.LEFT) {
            newHead = new GameObject(head.x - 1, head.y);
        }
        if (direction == Direction.DOWN) {
            newHead = new GameObject(head.x, head.y + 1);
        }
        if (direction == Direction.UP) {
            newHead = new GameObject(head.x, head.y - 1);
        }
        if (direction == Direction.RIGHT) {
            newHead = new GameObject(head.x + 1, head.y);
        }
        return newHead;
    }
    public void removeTail(){
        snakeParts.remove(snakeParts.size()-1);
    }

}
