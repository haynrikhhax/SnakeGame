package SnakeGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Game {
    private static ArrayList<Food> foodList;
    private Board board;

    public Game() {
        board = new Board();
        this.resetFood();
        MyFrame myFrame = new MyFrame(board);
        int numberOfMovement = 1;

        myFrame.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) { }

            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if((keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) && !board.getSnake().getMove().equals("down")) {
                    board.getSnake().SetUp();
                }
                if((keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S ) && !board.getSnake().getMove().equals("up")) {
                    board.getSnake().SetDown();
                }
                if((keyCode == KeyEvent.VK_LEFT  || keyCode == KeyEvent.VK_A) && !board.getSnake().getMove().equals("right")){
                    board.getSnake().SetLeft();
                }
                if((keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) && !board.getSnake().getMove().equals("left")){
                    board.getSnake().SetRight();
                }
            }
            public void keyReleased(KeyEvent e) { }
        });

        //Game starts here
        while (true){
            //Updates frame
            SwingUtilities.updateComponentTreeUI(myFrame);
            /*if snake touches itself, get too small or exceed
            the speed limit the game will be over*/
            if (touchItself() || board.getSnake().snakeBody.size() < 3 || board.getSnake().getSpeed() < 30){
                new GameOverPage();
                myFrame.dispose();
                break;
            }
            //freezes loop for some time, by this we control speed
            try {
                Thread.sleep(board.getSnake().getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //moves snake
            board.getSnake().move();
            //moves from border
            checkBorder();
            //check if food eaten
            for (int i = 0;i<foodList.size();i++){
                if (checkFoodEaten(foodList.get(i))) {
                    foodList.get(i).functionality(board.getSnake());
                    newFoodGenerator(foodList.get(i));
                }
            }
            //increase speed by 1 millisecond after 20 moves
            if (numberOfMovement % 20 == 0 && board.getSnake().getSpeed() > 40)
                board.getSnake().setSpeed(board.getSnake().getSpeed()-1);
            //adds more harmful foods
            if (numberOfMovement % 100 == 0)
                foodList.add(new HarmFood(board.getSnake()));
            numberOfMovement++;
        }
    }
    public void resetFood(){
        foodList = new ArrayList<>(Arrays.asList(new GrowFood(board.getSnake()),new GrowFood(board.getSnake()),new GrowFood(board.getSnake()),new HarmFood(board.getSnake()),
                new FastFood(board.getSnake()),new FastFood(board.getSnake()),new SlowFood(board.getSnake()),new SlowFood(board.getSnake())));
    }

    private void checkBorder(){
        for (Rectangle element : board.getSnake().getSnakeBody()){
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
        for(int i = 0; i < board.getSnake().getSnakeBody().size()-1; i++) {
            for (int j = i+1; j < board.getSnake().snakeBody.size(); j++){
                if(board.getSnake().getSnakeBody().get(i).x == board.getSnake().getSnakeBody().get(j).x &&
                        board.getSnake().getSnakeBody().get(i).y == board.getSnake().getSnakeBody().get(j).y) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkFoodEaten(Food fd){
        return board.getSnake().snakeBody.get(0).x == fd.getX() && board.getSnake().snakeBody.get(0).y == fd.getY();
    }

    private void newFoodGenerator(Food food){
        boolean bool;

           do{
               food.foodLocation(board.getSnake());
                bool = false;
                for (int i = 0;i<foodList.size();i++) {
                    if (i == foodList.indexOf(food))
                        continue;
                    if (foodList.get(i).getX() == food.getX() && foodList.get(i).getY() == food.getY()){
                        bool = true;
                        food.setX(food.getX()+Board.size);
                    }
                }
            } while(bool);
    }
    //Accessor
    public static ArrayList<Food> getFoodList() {
        return foodList;
    }

    //Mutator
    public void setFoodList(ArrayList<Food> newList) {
        foodList = newList;
    }
}