package SnakeGame;

import java.awt.Color;

public class GrowFood extends Food{
    public GrowFood() {
        super();
    }
    public void functionality(Snake sn){
        sn.growing();
    }
    public Color getColor(){
        return Color.green;
    }
}