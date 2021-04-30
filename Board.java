package SnakeGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.*;


public class Board extends JPanel{
    public static final int width = 600;
    public static final int height = 600;
    public static final int size = 20;

    public Board() {
        this.setPreferredSize(new Dimension(width, height));
    }

    private int x;
    @Override
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    private int y;
    @Override
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void paintComponent(Graphics g){
        setX(0);
        setY(0);

        super.paintComponent(g);
        this.setBackground(Color.WHITE);

        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.LIGHT_GRAY);
        for(int i = x; i < width; i+=40) {
            for (int j = y; j < height; j += 40) {
                g2D.fillRect(i, j, 20, 20);
            }
        }
        for(int i = (x+20); i < width; i+=40){
            for(int j = (y+20); j < height; j+=40){
                g2D.fillRect(i,j,20,20);
            }
        }
        g2D.setColor(Color.green);
        g2D.fillRect(Game.food.getX(),Game.food.getY(),size,size);

        g2D.setColor(Color.black);
        for (Rectangle element : Game.sn.getSnakeBody()){
            g2D.fill(element);
        }
    }
}
