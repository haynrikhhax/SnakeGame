package SnakeGame;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Container;

public class MyFrame extends JFrame{
    MyFrame(){
        Container c = new SnakeGame.Board();
        this.setContentPane(c);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("SnakeGame\\snake.png");
        this.setIconImage(image.getImage());
        this.setTitle("Snake");
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
    }
}