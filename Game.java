package SnakeGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.*;

public class Game {
    public static Snake sn;
    public static Food food;

    public Game() {
        SnakeGame.MyFrame myFrame = new SnakeGame.MyFrame();
        sn = new Snake();
        food = new Food(sn);

        myFrame.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) { }

            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if(keyCode == KeyEvent.VK_UP && sn.getMove() != "down") {
                    sn.SetUp();
                }
                if(keyCode == KeyEvent.VK_DOWN && sn.getMove() != "up") {
                    sn.SetDown();
                }
                if(keyCode == KeyEvent.VK_LEFT && sn.getMove() != "right") {
                    sn.SetLeft();
                }
                if(keyCode == KeyEvent.VK_RIGHT && sn.getMove() != "left") {
                    sn.SetRight();
                }
            }
            public void keyReleased(KeyEvent e) { }
        });

        while (true){
            checkBorder();
            if (touchItself()){
                break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (sn.snakeBody.get(0).x == food.getX() && sn.snakeBody.get(0).y == food.getY()){
                sn.growing();
                food.foodLocation(sn);
            }else {
                sn.move();
            }
            SwingUtilities.updateComponentTreeUI(myFrame);
        }
    }
    private static void checkBorder(){
        for (Rectangle element : sn.getSnakeBody()){
            if(element.x >= Board.width) {
                element.x -= Board.width;
            }else if(element.y >= Board.height) {
                element.y -= Board.height;
            }
            if(element.x < 0) {
                element.x += Board.width;
            }else if(element.y < 0) {
                element.y += Board.height;
            }
        }
    }

    private static boolean touchItself() {
        for(int i = 1; i < sn.getSnakeBody().size(); i++) {
            if(sn.getX() == sn.getSnakeBody().get(i).x && sn.getY() == sn.getSnakeBody().get(i).y) {
                return true;
            }
        }
        return false;
    }
}

