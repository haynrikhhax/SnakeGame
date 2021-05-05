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

        move.setText("To move the snake use the arrow keys");
        move.setBounds(25, 25, 400, 25);
        move.setForeground(Color.BLACK);
        move.setSize(400, 25);
        move.setFont(new Font("MV Boil", Font.BOLD, 20));
        this.add(move);

        up.setText("When you press up arrow the snake goes up");
        up.setBounds(25, 50, 350, 25);
        up.setForeground(Color.BLACK);
        up.setSize(350, 25);
        up.setFont(new Font("MV Boil", Font.BOLD, 15));
        this.add(up);

        down.setText("When you press down arrow the snake goes down");
        down.setBounds(25, 75, 370, 25);
        down.setForeground(Color.BLACK);
        down.setSize(370, 25);
        down.setFont(new Font("MV Boil", Font.BOLD, 15));
        this.add(down);

        left.setText("When you press left arrow the snake goes left");
        left.setBounds(25, 100, 350, 25);
        left.setForeground(Color.BLACK);
        left.setSize(350, 25);
        left.setFont(new Font("MV Boil", Font.BOLD, 15));
        this.add(left);

        right.setText("When you press right arrow the snake goes right");
        right.setBounds(25, 125, 350, 25);
        right.setForeground(Color.BLACK);
        right.setSize(350, 25);
        right.setFont(new Font("MV Boil", Font.BOLD, 15));
        this.add(right);

        foodTypes.setText("In this game there are 4 types of food");
        foodTypes.setBounds(25, 175, 400, 25);
        foodTypes.setForeground(Color.BLACK);
        foodTypes.setSize(400, 25);
        foodTypes.setFont(new Font("MV Boil", Font.BOLD, 20));
        this.add(foodTypes);

        green.setText("When You see a green dot on the board try to eat it. It makes you grow bigger");
        green.setBounds(25, 200, 700, 25);
        green.setForeground(Color.GREEN);
        green.setSize(700, 25);
        green.setFont(new Font("MV Boil", Font.BOLD, 15));
        this.add(green);

        red.setText("When You see a red dot on the board try to avoid eating it. It is poisonous and will remove one of snake's body parts");
        red.setBounds(25, 225, 850, 25);
        red.setForeground(Color.RED);
        red.setSize(850, 25);
        red.setFont(new Font("MV Boil", Font.BOLD, 15));
        this.add(red);

        yellow.setText("When You see a yellow dot on the board you can either eat it or leave it as is. It makes your snake go faster. Déjà vu");
        yellow.setBounds(25, 250, 850, 25);
        yellow.setForeground(Color.YELLOW);
        yellow.setSize(850, 25);
        yellow.setFont(new Font("MV Boil", Font.BOLD, 15));
        this.add(yellow);

        blue.setText("When You see a blue dot on the board you can either eat it or leave it as is. It makes your snake go slower");
        blue.setBounds(25, 275, 800, 25);
        blue.setForeground(Color.BLUE);
        blue.setSize(800, 25);
        blue.setFont(new Font("MV Boil", Font.BOLD, 15));
        this.add(blue);

        size.setText("If the snake size reaches 2 you loose. Remember overtime the board will be filled with red dots");
        size.setBounds(25, 300, 800, 25);
        size.setForeground(Color.BLACK);
        size.setSize(800, 25);
        size.setFont(new Font("MV Boil", Font.BOLD, 15));
        this.add(size);

        speed.setText("If the snake becomes very fast be cautious because if the snake reaches max speed and you eat one more");
        speed.setBounds(25, 325, 800, 25);
        speed.setForeground(Color.BLACK);
        speed.setSize(800, 25);
        speed.setFont(new Font("MV Boil", Font.BOLD, 15));
        this.add(speed);

        speedCont.setText("yellow fruit you will loose");
        speedCont.setBounds(25, 350, 400, 25);
        speedCont.setForeground(Color.BLACK);
        speedCont.setSize(400, 25);
        speedCont.setFont(new Font("MV Boil", Font.BOLD, 15));
        this.add(speedCont);



        ImageIcon buttonGame = new ImageIcon("SnakeGame\\menu.png");
        Image newButton = buttonGame.getImage();
        Image modifiedButton = newButton.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        buttonGame = new ImageIcon(modifiedButton);
        button.setHorizontalTextPosition(JButton.LEFT);
        button.setIcon(buttonGame);
        button.setBounds(250, 660, 200, 40);
        button.setFocusable(false);
        button.addActionListener(this);
        this.add(button);

        ImageIcon startGame = new ImageIcon("SnakeGame\\start.png");
        Image newStart = startGame.getImage();
        Image modifiedStart = newStart.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        startGame = new ImageIcon(modifiedStart);
        startButton.setHorizontalTextPosition(JButton.LEFT);
        startButton.setIcon(startGame);
        startButton.setBounds(470, 660, 200, 40);
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        this.add(startButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
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
