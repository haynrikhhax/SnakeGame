package SnakeGame;
import java.awt.*;

public class Food {
    private int x;
    private int y;

    public Food(Snake player) {
        this.foodLocation(player);
    }

    public void foodLocation(Snake player) {
        do{
            x = (int)(Math.random() * Board.width/Board.size - 1) * Board.size;
            y = (int)(Math.random() * Board.width/Board.size - 1) * Board.size;
            for(Rectangle r : player.getSnakeBody()){
                if(r.x != x && r.y != y && (x !=0 || y != 0)) {
                    return;
                }
            }
        }while (true);
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
