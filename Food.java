package SnakeGame;

import java.awt.Rectangle;
import java.awt.Color;

public abstract class Food {
    private int x;
    private int y;

    public Food() {
        this.foodLocation();
    }
    public void foodLocation() {
            x = (int)(Math.random() * Board.width/Board.size - 1) * Board.size;
            y = (int)(Math.random() * Board.width/Board.size - 1) * Board.size;
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