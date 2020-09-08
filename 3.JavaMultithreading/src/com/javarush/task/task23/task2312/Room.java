package com.javarush.task.task23.task2312;

public class Room {
    public static Room game;
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void sleep(){

    }

    public void run(){

    }
    public void print(){

    }

    public void createMouse(){
        mouse = new Mouse((int) (Math.random() * width),(int) (Math.random() * height));
    }

    public void eatMouse(){
        createMouse();
    }

    public static void main(String[] args) {
        Snake snake = new Snake(50,50);
        Room room = new Room(400,200,snake);
        Room.game = room;
        snake.setDirection(SnakeDirection.DOWN);
        Room.game.createMouse();
        Room.game.run();
    }
}
