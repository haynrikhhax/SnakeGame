package SnakeGame;

import java.awt.Color;

public class GrowFood extends Food{
    public GrowFood(Snake snake) {
        super(snake);
    }
    public void functionality(Snake sn){
        sn.growing();
    }
    public Color getColor(){
        return Color.green;
    }
}