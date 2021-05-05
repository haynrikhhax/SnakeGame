package SnakeGame;

import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

public class Board extends JPanel{
    public static final int width = 600;
    public static final int height = 600;
    public static final int size = 20;

    public Board() {
        this.setPreferredSize(new Dimension(width, height));
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

        g2D.setColor(Color.white);
        for (Rectangle element : Game.getSnake().getSnakeBody()){
            g2D.fill(element);
        }
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
}