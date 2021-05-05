package SnakeGame;

import java.awt.Color;

public class HarmFood extends Food{
    public HarmFood(Snake snake) {
        super(snake);
    }
    public void functionality(Snake sn) {
            sn.snakeBody.remove(sn.snakeBody.size() - 1);
    }
    public Color getColor(){
        return Color.red;
    }
}