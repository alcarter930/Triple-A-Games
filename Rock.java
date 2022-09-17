import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.File;


public class Rock implements Game{

    public String getName(){
        return "Rock, Paper, Scissors";
    }
    private String player1;
    private String playerChoice = "";
    private String playerChoice2 = "";
    private String player2;
    private int player1Score;
    private int player2Score;
    private JRadioButton rockButton = new JRadioButton("Rock");
    private JRadioButton scissorsButton = new JRadioButton("Scissors");
    private JRadioButton paperButton = new JRadioButton("Paper");
    private JRadioButton rockButton2 = new JRadioButton("Rock");
    private JRadioButton scissorsButton2 = new JRadioButton("Scissors");
    private JRadioButton paperButton2 = new JRadioButton("Paper");
    private JButton submit = new JButton("Submit");
    private JButton submit2 = new JButton("Submit");


    public Rock(String name1, String name2){
        this.player1 = name1;
        this.player2 = name2;
    }
    public void play() {

        rockButton = new JRadioButton("Rock");
        scissorsButton = new JRadioButton("Scissors");
        paperButton = new JRadioButton("Paper");
        rockButton2 = new JRadioButton("Rock");
        scissorsButton2 = new JRadioButton("Scissors");
        paperButton2 = new JRadioButton("Paper");
        submit = new JButton("Submit");
        submit2 = new JButton("Submit");


        ButtonGroup group = new ButtonGroup();
        group.add(rockButton);
        group.add(scissorsButton);
        group.add(paperButton);







        ButtonGroup group2 = new ButtonGroup();
        group2.add(rockButton2);
        group2.add(scissorsButton2);
        group2.add(paperButton2);

        //ends game, announces winner

        JFrame frame2 = new JFrame("Rock-Paper-Scissors");

        //player 1 choosing
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rockButton.isSelected()) {
                    playerChoice = "rock";
                    frame2.dispose();
                    turn2();
                } else if (scissorsButton.isSelected()) {
                    playerChoice = "scissors";
                    frame2.dispose();
                    turn2();
                } else if (paperButton.isSelected()) {
                    playerChoice = "paper";
                    frame2.dispose();
                    turn2();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an option!");
                }

            }
        });

        JPanel panel2 = new JPanel();
        JLabel playerL = new JLabel("Player 1:");
        JLabel label2 = new JLabel("Please Make Your Selection: ");
        panel2.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        c1.insets = new Insets(10, 10, 10, 10);
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.gridx = 0;
        c1.gridy = 0;
        panel2.add(playerL, c1);
        c1.gridy++;
        panel2.add(label2, c1);
        c1.gridy++;
        panel2.add(rockButton, c1);
        c1.gridy++;
        panel2.add(scissorsButton, c1);
        c1.gridy++;
        panel2.add(paperButton, c1);
        c1.gridy += 4;
        panel2.add(submit, c1);
        frame2.add(panel2);
        frame2.setSize(500, 500);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
}
    public void turn2() {

        JFrame frame1 = new JFrame("Rock-Paper-Scissors");
        JPanel panel = new JPanel();
        JLabel p2Label = new JLabel("Player 2:");
        JLabel label = new JLabel("Please Make Your Selection: ");
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(p2Label, c);
        c.gridy++;
        panel.add(label,c);
        c.gridy++;
        panel.add(rockButton2, c);
        c.gridy++;
        panel.add(scissorsButton2, c);
        c.gridy++;
        panel.add(paperButton2, c);
        c.gridy += 4;
        panel.add(submit2, c);
        submit2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rockButton2.isSelected()) {
                    playerChoice2 = "rock";
                    frame1.dispose();
                    getWinner();
                } else if (scissorsButton2.isSelected()) {
                    playerChoice2 = "scissors";
                    frame1.dispose();
                    getWinner();
                } else if (paperButton2.isSelected()) {
                    playerChoice2 = "paper";
                    frame1.dispose();
                    getWinner();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an option!");
                }
            }
        });
        frame1.add(panel);
        frame1.setSize(500, 500);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);

    }
    public void getWinner(){
        String winner = "";
        if (playerChoice.equalsIgnoreCase("rock") && playerChoice2.equalsIgnoreCase("rock")) {
            winner = "tie";
        } else if (playerChoice.equalsIgnoreCase("scissors") && playerChoice2.equalsIgnoreCase("scissors")) {
            winner = "tie";
        } else if (playerChoice.equalsIgnoreCase("paper") && playerChoice2.equalsIgnoreCase("paper")) {
            winner = "tie";
        } else if (playerChoice.equalsIgnoreCase("rock") && playerChoice2.equalsIgnoreCase("scissors")) {
            winner = player1;
        } else if (playerChoice.equalsIgnoreCase("rock") && playerChoice2.equalsIgnoreCase("paper")) {
            winner = player2;
        } else if (playerChoice.equalsIgnoreCase("scissors") && playerChoice2.equalsIgnoreCase("rock")) {
            winner = player2;
        } else if (playerChoice.equalsIgnoreCase("scissors") && playerChoice2.equalsIgnoreCase("paper")) {
            winner = player1;
        } else if (playerChoice.equalsIgnoreCase("paper") && playerChoice2.equalsIgnoreCase("rock")) {
            winner = player1;
        } else if (playerChoice.equalsIgnoreCase("paper") && playerChoice2.equalsIgnoreCase("scissors")) {
            winner = player2;
        }
        win(winner);
    }

    public void win(String winner){

        if(winner.equals(player1)){
            GameSelector.playMore(1);
            String s = winner + " won.";
            System.out.println(s);
            JOptionPane.showMessageDialog(null, s);
        }else if(winner.equals(player2)){
            GameSelector.playMore(2);

            String s = winner + " won.";
            System.out.println(s);
            JOptionPane.showMessageDialog(null, s);
        }else{
            String s = "Tie.";
            JOptionPane.showMessageDialog(null, s);
            playerChoice = "";
            playerChoice2 = "";
            play();
        }
    }
}
