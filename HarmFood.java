package SnakeGame;

import java.awt.Color;

public class HarmFood extends Food{
    public HarmFood() {
        super();
    }
    public void functionality(Snake sn) {
            sn.snakeBody.remove(Game.getSnake().snakeBody.size() - 1);
    }
    public Color getColor(){
        return Color.red;
    }
}