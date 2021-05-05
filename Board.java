package SnakeGame;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JPanel;

public class Board extends JPanel{
    public static final int width = 600;
    public static final int height = 600;
    public static final int size = 20;
    private Snake snake;
    Random rn = new Random();

    public Board() {
        this.setPreferredSize(new Dimension(width, height));
        this.snake = new Snake();
    }
    private int x;
    private int y;

    public void paintComponent(Graphics g){
        setX(0);
        setY(0);

        super.paintComponent(g);
        this.setBackground(Color.black);

        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(Color.green);
        for (Food element : Game.getFoodList()){
            g2D.setColor(element.getColor());
            g2D.fill(new Ellipse2D.Double(element.getX(),element.getY(),size,size));
        }

        for (Rectangle element :snake.getSnakeBody()){
            g2D.setColor(new Color(rn.nextInt(255), rn.nextInt(255), rn.nextInt(255)));
            g2D.fill(element);
        }
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public  Snake getSnake() {
        return this.snake;
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setSnake(Snake snake) {
        this.snake = snake;
    }
}