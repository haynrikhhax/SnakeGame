package SnakeGame;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverPage extends JFrame implements ActionListener {
    JLabel scoreText = new JLabel("Your final score is: "  + Game.getSnake().snakeBody.size());
    JButton buttonRestart = new JButton("Restart");
    JButton button = new JButton("Back to main menu");
    JButton buttonExit = new JButton("Exit");
    private ActionEvent e;

    GameOverPage() {

        this.setTitle("Snake");
        scoreText.setBounds(175, 100, 300, 40);
        scoreText.setForeground(new Color(2, 100, 100));
        scoreText.setSize(300, 50);
        scoreText.setFont(new Font("MV Boil", Font.BOLD, 25));
        this.add(scoreText);

        buttonRestart.setBounds(200, 200, 200, 40);
        buttonRestart.setFocusable(false);
        buttonRestart.addActionListener(this);
        buttonExit.setBounds(200, 300, 200, 40);
        buttonExit.setFocusable(false);
        buttonExit.addActionListener(e1 -> System.exit(0));
        button.setBounds(200, 250, 200, 40);
        button.setFocusable(false);
        button.addActionListener(this);

        ImageIcon image = new ImageIcon("SnakeGame\\snake.png");

        this.setIconImage(image.getImage());
        ImageIcon reset = new ImageIcon("SnakeGame\\restart.png");
        Image newReset = reset.getImage();
        Image modifiedReset = newReset.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        reset = new ImageIcon(modifiedReset);
        buttonRestart.setHorizontalTextPosition(JButton.LEFT);
        buttonRestart.setIcon(reset);

        ImageIcon exitGame = new ImageIcon("SnakeGame\\exit.png");
        Image newExit = exitGame.getImage();
        Image modifiedExit = newExit.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        exitGame = new ImageIcon(modifiedExit);
        buttonExit.setHorizontalTextPosition(JButton.LEFT);
        buttonExit.setIcon(exitGame);

        ImageIcon menuGame = new ImageIcon("SnakeGame\\menu.png");
        Image newMenu = menuGame.getImage();
        Image modifiedMenu = newMenu.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        menuGame = new ImageIcon(modifiedMenu);
        button.setHorizontalTextPosition(JButton.LEFT);
        button.setIcon(menuGame);


        this.add(button);
        this.add(buttonExit);
        this.add(buttonRestart);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(615, 640);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonRestart){
            dispose();
            new Thread(){
                @Override
                public void run(){
                    Game.resetFood();
                    new Game();
                }
            }.start(); this.dispose();
        }
        if (e.getSource() == button){
            LunchPage lunchPage = new LunchPage();
            this.dispose();
        }
    }
}