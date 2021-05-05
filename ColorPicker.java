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
    JButton special = new JButton("SPECIAL");
    JButton button = new JButton("Back to main menu");
    JButton startButton = new JButton("Start the game");
    private Snake snake;
    private Board board;
    private ActionEvent e;
    ColorPicker() {

        this.snake = new Snake();
        this.board = new Board();
        this.setTitle("Snake");
        scoreText.setText("Choose the color of your snake");
        scoreText.setBounds(150, 25, 300, 40);
        scoreText.setForeground(new Color(0, 0, 0));
        scoreText.setSize(300, 50);
        scoreText.setFont(new Font("MV Boil", Font.BOLD, 20));
        this.add(scoreText);

        white.setBounds(125, 75, 150, 40);
        white.setFocusable(false);
        white.addActionListener(this);
        white.setBackground(Color.WHITE);
        green.setBounds(325, 75, 150, 40);
        green.setFocusable(false);
        green.addActionListener(this);
        green.setBackground(Color.GREEN);
        red.setBounds(125, 150, 150, 40);
        red.setFocusable(false);
        red.addActionListener(this);
        red.setBackground(Color.RED);
        yellow.setBounds(325, 150, 150, 40);
        yellow.setFocusable(false);
        yellow.addActionListener(this);
        yellow.setBackground(Color.YELLOW);
        blue.setBounds(125, 225, 150, 40);
        blue.setFocusable(false);
        blue.addActionListener(this);
        blue.setBackground(Color.BLUE);
        pink.setBounds(325, 225, 150, 40);
        pink.setFocusable(false);
        pink.addActionListener(this);
        pink.setBackground(new Color(217,25,255));
        cyan.setBounds(125, 300, 150, 40);
        cyan.setFocusable(false);
        cyan.addActionListener(this);
        cyan.setBackground(Color.CYAN);
        random.setBounds(325, 300, 150, 40);
        random.setFocusable(false);
        random.addActionListener(this);
        random.setBackground(new Color(rn.nextInt(255), rn.nextInt(255), rn.nextInt(255)));
        special.setBounds(225, 375, 150, 40);
        special.setFocusable(false);
        special.addActionListener(this);
        special.setBackground(new Color(rn.nextInt(255), rn.nextInt(255), rn.nextInt(255)));

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
        this.add(white);
        this.add(green);
        this.add(red);
        this.add(blue);
        this.add(yellow);
        this.add(pink);
        this.add(cyan);
        this.add(random);
        this.add(special);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(615, 640);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == white){
                dispose();
                new Thread(){
                    @Override
                    public void run(){
                        Board.setSnakeColor(Color.WHITE);
                        new Game();
                    }
                }.start(); this.dispose();
            }
            if (e.getSource() == green){
                dispose();
                new Thread(){
                    @Override
                    public void run(){
                        Board.setSnakeColor(Color.GREEN);
                        new Game();
                    }
                }.start(); this.dispose();
            }
            if (e.getSource() == red){
                dispose();
                new Thread(){
                    @Override
                    public void run(){
                        Board.setSnakeColor(Color.RED);
                        new Game();
                    }
                }.start(); this.dispose();
            }
            if (e.getSource() == yellow){
                dispose();
                new Thread(){
                    @Override
                    public void run(){
                        Board.setSnakeColor(Color.YELLOW);
                        new Game();
                    }
                }.start(); this.dispose();
            }
            if (e.getSource() == blue){
                dispose();
                new Thread(){
                    @Override
                    public void run(){
                        Board.setSnakeColor(Color.BLUE);
                        new Game();
                    }
                }.start(); this.dispose();
            }
            if (e.getSource() == pink){
                dispose();
                new Thread(){
                    @Override
                    public void run(){
                        Board.setSnakeColor(Color.PINK);
                        new Game();
                    }
                }.start(); this.dispose();
            }
            if (e.getSource() == cyan){
                dispose();
                new Thread(){
                    @Override
                    public void run(){
                        Board.setSnakeColor(Color.CYAN);
                        new Game();
                    }
                }.start(); this.dispose();
            }
            if (e.getSource() == random){
                dispose();
                new Thread(){
                    @Override
                    public void run(){
                        Board.setSnakeColor(new Color(rn.nextInt(255), rn.nextInt(255), rn.nextInt(255)));
                        new Game();
                    }
                }.start(); this.dispose();
            }
//            NEED TO FIX
            if (e.getSource() == special){
                dispose();
                new Thread(){
                    @Override
                    public void run(){
                        if (true){
                            Board.setSnakeColor(new Color(rn.nextInt(255), rn.nextInt(255), rn.nextInt(255)));
                        }
                        new Game();
                    }
                }.start(); this.dispose();
            }
            if (e.getSource() == button){
                LunchPage lunchPage = new LunchPage();
            } this.dispose();
        }

    }

