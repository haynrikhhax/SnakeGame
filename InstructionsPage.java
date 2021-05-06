package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionsPage extends JFrame implements ActionListener {
    JLabel move = new JLabel();
    JLabel up = new JLabel();
    JLabel down = new JLabel();
    JLabel left = new JLabel();
    JLabel right = new JLabel();
    JLabel foodTypes = new JLabel();
    JLabel green = new JLabel();
    JLabel red = new JLabel();
    JLabel yellow = new JLabel();
    JLabel blue = new JLabel();
    JLabel size = new JLabel();
    JLabel speed = new JLabel();
    JLabel speedCont = new JLabel();
    JButton button = new JButton("Back to main menu");
    JButton startButton = new JButton("Start the game");

    InstructionsPage(){
        String[] stringArr = {"To move the snake use the arrow keys","When you press up arrow or W the snake goes up",
                "When you press down arrow or S the snake goes down", "When you press left arrow or A the snake goes left",
                "When you press right arrow or D the snake goes right", "In this game there are 4 types of food",
                "When You see a green dot on the board try to eat it. It makes you grow bigger",
                "When You see a red dot on the board try to avoid eating it. It is poisonous and will remove one of snake's body parts",
                "When You see a yellow dot on the board you can either eat it or leave it as is. It makes your snake go faster. Déjà vu",
                "When You see a blue dot on the board you can either eat it or leave it as is. It makes your snake go slower",
                "If the snake size reaches 2 you loose. Remember overtime the board will be filled with red dots",
                "If the snake becomes very fast be cautious because if the snake reaches max speed and you eat one more",
                "yellow fruit you will loose"};
        JLabel[] arr = {move, up, down, left, right, foodTypes, green, red, yellow, blue, size, speed, speedCont};

        for (int i = 0; i < arr.length; i++) {

            arr[i].setBounds(25, 25*(i+1), 850, 25);
            arr[i].setText(stringArr[i]);
            arr[i].setForeground(Color.BLACK);
            arr[i].setSize(850, 25);
            arr[i].setFont(new Font("MV Boil", Font.BOLD, 15));
            this.add(arr[i]);
        }

        move.setFont(new Font("MV Boil", Font.BOLD, 20));
        foodTypes.setFont(new Font("MV Boil", Font.BOLD, 20));


        green.setForeground(Color.GREEN);
        red.setForeground(Color.RED);
        yellow.setForeground(Color.YELLOW);
        blue.setForeground(Color.BLUE);


        ImageIcon buttonGame = new ImageIcon("SnakeGame\\menu.png");
        Image newButton = buttonGame.getImage();
        Image modifiedButton = newButton.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        buttonGame = new ImageIcon(modifiedButton);
        button.setHorizontalTextPosition(JButton.LEFT);
        button.setIcon(buttonGame);
        button.setBounds(250, 460, 200, 40);
        button.setFocusable(false);
        button.addActionListener(this);
        this.add(button);

        ImageIcon startGame = new ImageIcon("SnakeGame\\start.png");
        Image newStart = startGame.getImage();
        Image modifiedStart = newStart.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        startGame = new ImageIcon(modifiedStart);
        startButton.setHorizontalTextPosition(JButton.LEFT);
        startButton.setIcon(startGame);
        startButton.setBounds(470, 460, 200, 40);
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        this.add(startButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,600);
        ImageIcon image = new ImageIcon("SnakeGame\\snake.png");
        this.setIconImage(image.getImage());
        this.setTitle("Snake");
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == startButton){
            dispose();
            ColorPicker cp = new ColorPicker();
        }

        if (e.getSource() == button){
            LunchPage lunchPage = new LunchPage();
        } this.dispose();
    }

}
