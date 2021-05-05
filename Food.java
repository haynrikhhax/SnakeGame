package SnakeGame;

import java.awt.*;

public abstract class Food {
    private int x;
    private int y;

    public Food(Snake snake) {
        this.foodLocation(snake);
    }
    public void foodLocation(Snake snake) {
        boolean bool;
        do{
            bool = false;
            x = (int)(Math.random() * Board.width/Board.size - 1) * Board.size;
            y = (int)(Math.random() * Board.width/Board.size - 1) * Board.size;
            for(Rectangle element : snake.getSnakeBody()){
                if (element.x == x && element.y == y) {
                    bool = true;
                }
            }
        }while(bool);
    }
    public void functionality(Snake sn){ }

    public Color getColor(){
        return Color.black;
    }

    //accessors
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    //mutators
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}