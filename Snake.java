package SnakeGame;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
    ArrayList<Rectangle> snakeBody = new ArrayList<>();
    private final int cubeSize = Board.size;



    private int speed = 150;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public String move = "down";

    public Snake() {
        Rectangle temp = new Rectangle(3*cubeSize, cubeSize, cubeSize, cubeSize);
        snakeBody.add(temp);

        temp = new Rectangle(2*cubeSize, cubeSize, cubeSize, cubeSize);
        snakeBody.add(temp);

        temp = new Rectangle(cubeSize, cubeSize, cubeSize, cubeSize);
        snakeBody.add(temp);

        temp = new Rectangle(0, cubeSize,cubeSize,cubeSize);
        snakeBody.add(temp);
        }

    public void move() {
            growing();
            snakeBody.remove(snakeBody.size()-1);
        }
    public void growing() {
        Rectangle temp = new Rectangle(cubeSize, cubeSize);
        Rectangle head = snakeBody.get(0);

        if (this.move.equals("right")){
            temp.setLocation(head.x + cubeSize,head.y);
        }else if (this.move.equals("left")){
            temp.setLocation(head.x - cubeSize,head.y);
        }else if (this.move.equals("up")){
            temp.setLocation(head.x,head.y - cubeSize);
        }else{
            temp.setLocation(head.x,head.y + cubeSize);
        }
        snakeBody.add(0,temp);
        }
    //Accessor
    public ArrayList<Rectangle> getSnakeBody() {
        return snakeBody;
    }
    public String getMove() {
        return move;
    }
    public int getX() {
        return snakeBody.get(0).x;
    }
    public int getY() {
        return snakeBody.get(0).y ;
    }

    //Mutator
    public void setSnakeBody(ArrayList<Rectangle> snakeBody) {
        this.snakeBody = snakeBody;
    }
    public void setMove(String move) {
        this.move = move;
    }

    public void SetUp() {
        move = "up";
    }
    public void SetDown() {
        move = "down";
    }
    public void SetLeft() {
        move = "left";
    }
    public void SetRight() {
        move = "right";
    }

}