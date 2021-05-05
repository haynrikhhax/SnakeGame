package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LunchPage extends JFrame implements ActionListener {
    JLabel label = new JLabel("Welcome to Snake");
    JButton button = new JButton("Start the game");
    JButton instructions = new JButton("Instructions");
    JButton buttonExit = new JButton("Exit");
    LunchPage(){

        label.setBounds(190, 50, 200, 40);
        label.setForeground(new Color(115, 0, 180));
        label.setSize(300, 50);
        label.setFont(new Font("MV Boil", Font.BOLD, 25));
        this.add(label);

        ImageIcon startGame = new ImageIcon("SnakeGame\\start.png");
        Image newStart = startGame.getImage();
        Image modifiedStart = newStart.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        startGame = new ImageIcon(modifiedStart);
        button.setHorizontalTextPosition(JButton.LEFT);
        button.setIcon(startGame);
        button.setBounds(200, 110, 200, 40);
        button.setFocusable(false);
        button.addActionListener(this);
        this.add(button);

        ImageIcon instructionsGame = new ImageIcon("SnakeGame\\instructions.png");
        Image newInstructions = instructionsGame.getImage();
        Image modifiedInstructions = newInstructions.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        instructionsGame = new ImageIcon(modifiedInstructions);
        instructions.setHorizontalTextPosition(JButton.LEFT);
        instructions.setIcon(instructionsGame);
        instructions.setBounds(200, 170, 200, 40);
        instructions.setFocusable(false);
        instructions.addActionListener(this);
        this.add(instructions);



        ImageIcon exitGame = new ImageIcon("SnakeGame\\exit.png");
        Image newExit = exitGame.getImage();
        Image modifiedExit = newExit.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        exitGame = new ImageIcon(modifiedExit);
        buttonExit.setHorizontalTextPosition(JButton.LEFT);
        buttonExit.setIcon(exitGame);

        buttonExit.setBounds(200, 230, 200, 40);
        buttonExit.setFocusable(false);
        buttonExit.addActionListener(e1 -> System.exit(0));
        this.add(buttonExit);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600,600);
        this.setResizable(false);
        ImageIcon image = new ImageIcon("SnakeGame\\snake.png");
        this.setIconImage(image.getImage());
        this.setTitle("Snake");
        this.setLayout(null);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            dispose();
            new Thread(){
                @Override
                public void run(){
                    Game.resetFood();
                    new Game();
                }
            }.start(); this.dispose();
        }
        if (e.getSource() == instructions){
            InstructionsPage instructionsPage = new InstructionsPage();
            this.dispose();
        }


    }

}
