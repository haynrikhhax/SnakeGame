package SnakeGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Game {
    private static Snake snake;

    static ArrayList<Food> foodList;

    public Game() {
        snake = new Snake();
        MyFrame myFrame = new MyFrame();

        int numberOfMovement = 1;

        myFrame.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) { }

            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if((keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) && !snake.getMove().equals("down")) {
                    snake.SetUp();
                }
                if((keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S ) && !snake.getMove().equals("up")) {
                    snake.SetDown();
                }
                if((keyCode == KeyEvent.VK_LEFT  || keyCode == KeyEvent.VK_A) && !snake.getMove().equals("right")){
                    snake.SetLeft();
                }
                if((keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) && !snake.getMove().equals("left")){
                    snake.SetRight();
                }
            }
            public void keyReleased(KeyEvent e) { }
        });

        while (true){
            SwingUtilities.updateComponentTreeUI(myFrame);
            if (touchItself() || snake.snakeBody.size() < 3 || snake.getSpeed() < 30){
                new GameOverPage();
                myFrame.dispose();
                break;
            }
            try {
                Thread.sleep(snake.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            snake.move();
            checkBorder();
            for (int i = 0;i<foodList.size();i++){
                if (checkFoodEaten(foodList.get(i))) {
                    foodList.get(i).functionality(snake);
                    newFoodGenerator(foodList.get(i));
                }
            }


            if (numberOfMovement % 20 == 0 && snake.getSpeed() > 40)
                snake.setSpeed(snake.getSpeed()-1);
            if (numberOfMovement % 100 == 0)
                foodList.add(new HarmFood());
            numberOfMovement++;
        }

    }
    public static void resetFood(){
        foodList = new ArrayList<>(Arrays.asList(new GrowFood(),new GrowFood(),new GrowFood(),new HarmFood(),
                new FastFood(),new FastFood(),new SlowFood(),new SlowFood()));
    }
    private boolean checkFoodEaten(Food fd){
        return snake.snakeBody.get(0).x == fd.getX() && snake.snakeBody.get(0).y == fd.getY();
    }

    private void checkBorder(){
        for (Rectangle element : snake.getSnakeBody()){
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

    private boolean touchItself() {
        for(int i = 0; i < snake.getSnakeBody().size()-1; i++) {
            for (int j = i+1; j < snake.snakeBody.size(); j++){
                if(snake.getSnakeBody().get(i).x == snake.getSnakeBody().get(j).x &&
                        snake.getSnakeBody().get(i).y == snake.getSnakeBody().get(j).y) {
                    return true;
                }
            }
        }
        return false;
    }
    private void newFoodGenerator(Food food){
        boolean bool;
       do{
            bool = false;
            food.foodLocation();
            for (int i = 0;i<foodList.size();i++) {
                if (i == foodList.indexOf(food))
                    continue;
                if (foodList.get(i).getX() == food.getX() && foodList.get(i).getY() == food.getY()){
                    bool = true;
                }
            }
        } while(bool);
    }


    public static Snake getSnake() {
        return snake;
    }
    public static void setSnake(Snake sn) {
        snake = sn;
    }
    public static ArrayList<Food> getFoodList() {
        return foodList;
    }
    public void setFoodList(ArrayList<Food> newList) {
        foodList = newList;
    }
}