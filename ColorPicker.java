package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ColorPicker extends JFrame implements ActionListener {
    JLabel scoreText = new JLabel();
    Random rn = new Random();
    JButton white = new JButton("White");
    JButton green = new JButton("Green");
    JButton red = new JButton("Red");
    JButton yellow = new JButton("Yellow");
    JButton blue = new JButton("Blue");
    JButton pink = new JButton("Pink");
    JButton cyan = new JButton("Cyan");
    JButton random = new JButton("Random");
    JButton button = new JButton("Back to main menu");
    private Snake snake;
    private ActionEvent e;
    ColorPicker() {

        this.snake = new Snake();
        this.setTitle("Snake");
        scoreText.setText("Choose the color of your snake");
        scoreText.setBounds(150, 25, 300, 40);
        scoreText.setForeground(new Color(0, 0, 0));
        scoreText.setSize(300, 50);
        scoreText.setFont(new Font("MV Boil", Font.BOLD, 20));
        this.add(scoreText);

        JButton[] arr = {white, red, blue, cyan};
        JButton[] arr2 = {green, yellow, pink, random};
        Color[] arr3 = {Color.WHITE, Color.RED, Color.BLUE, Color.CYAN};
        Color[] arr4 = {Color.GREEN, Color.YELLOW, new Color(217,25,255), new Color(rn.nextInt(255), rn.nextInt(255), rn.nextInt(255))};
        for (int i = 0; i < arr.length; i++) {
            arr[i].setBackground(arr3[i]);
            arr[i].setBounds(125, 75*(i+1), 150, 40);
            arr[i].setFocusable(false);
            arr[i].addActionListener(this);
            this.add(arr[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            arr2[i].setBackground(arr4[i]);
            arr2[i].setBounds(325, 75*(i+1), 150, 40);
            arr2[i].setFocusable(false);
            arr2[i].addActionListener(this);
            this.add(arr2[i]);
        }



        ImageIcon buttonGame = new ImageIcon("SnakeGame\\menu.png");
        Image newButton = buttonGame.getImage();
        Image modifiedButton = newButton.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        buttonGame = new ImageIcon(modifiedButton);
        button.setHorizontalTextPosition(JButton.LEFT);
        button.setIcon(buttonGame);
        button.setBounds(200, 500, 200, 40);
        button.setFocusable(false);
        button.addActionListener(this);
        this.add(button);



        ImageIcon image = new ImageIcon("SnakeGame\\snake.png");
        this.setIconImage(image.getImage());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(615, 640);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }

        @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() != button) {
            if (e.getSource() == white) {
                Board.setSnakeColor(Color.WHITE);
            }
            if (e.getSource() == green) {
                Board.setSnakeColor(Color.GREEN);
            }
            if (e.getSource() == red) {
                Board.setSnakeColor(Color.RED);
            }
            if (e.getSource() == yellow) {
                Board.setSnakeColor(Color.YELLOW);
            }
            if (e.getSource() == blue) {
                Board.setSnakeColor(Color.BLUE);
            }
            if (e.getSource() == pink) {
                Board.setSnakeColor(Color.PINK);
            }
            if (e.getSource() == cyan) {
                Board.setSnakeColor(Color.CYAN);
            }
            if (e.getSource() == random) {
                Board.setSnakeColor(new Color(rn.nextInt(255), rn.nextInt(255), rn.nextInt(255)));
            }
            dispose();
                new Thread(){
                    @Override
                    public void run(){
                        new Game();
                    }
                }.start(); this.dispose();
        }
            if (e.getSource() == button) {
                LunchPage lunchPage = new LunchPage();
            }
            this.dispose();
        }
}



