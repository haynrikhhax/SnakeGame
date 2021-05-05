package SnakeGame;

import java.awt.Color;

public class SlowFood extends Food{
    public SlowFood(Snake snake) {
        super(snake);
    }
    public void functionality(Snake sn) {
        sn.setSpeed(sn.getSpeed()+10);
    }
    public Color getColor(){
        return Color.blue;
    }
}