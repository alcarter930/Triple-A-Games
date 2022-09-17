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


public class Rock{

    private String player1;
    private String player2;
    private int player1Score;
    private int player2Score;

    public Rock(String name1, String name2){
        this.player1 = name1;
        this.player2 = name2;
    }

    JRadioButton rockButton = new JRadioButton("Rock");
    JRadioButton scissorsButton = new JRadioButton("Scissors");
    JRadioButton paperButton = new JRadioButton("Paper");

    ButtonGroup group = new ButtonGroup();
    group.add(rockButton);
    group.add(scissorsButton);
    group.add(paperButton);

    JButton submit =new JButton("Submit");
    JButton submit2 = new JButton("Submit");

    private String playerChoice = "";
    private String playerChoice2 = "";

    JRadioButton rockButton2 = new JRadioButton("Rock");
    JRadioButton scissorsButton2 = new JRadioButton("Scissors");
    JRadioButton paperButton2 = new JRadioButton("Paper");
    ButtonGroup group2 = new ButtonGroup();
    group2.add(rockButton2);
    group2.add(scissorsButton2);
    group2.add(paperButton2);

    //ends game, announces winner
    submit2.addActionListener(new ActionListener() {
        public String getWinner () {
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
            return winner;
        }
    });

    //player 2 choosing
    public void turn2(){
        JFrame frame1 = new JFrame("Rock-Paper-Scissors");
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Please Make Your Selection: ");
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10,10,10,10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(label);
        c.gridy++;
        panel.add(rockButton2);
        c.gridy++;
        panel.add(scissorsButton2);
        c.gridy++;
        panel.add(paperButton2);
        c.gridy+=4;
        panel.add(submit2);
        frame1.add(panel);
        if(rockButton2.isSelected()){
            playerChoice2 = "rock";
            getWinner();
        }
        else if(scissorsButton2.isSelected()){
            playerChoice2 = "scissors";
            getWinner();
        }
        else if(paperButton2.isSelected()){
            playerChoice2 = "paper";
            getWinner();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select an option!");
        }
    }

    //player 1 choosing
    submit.addActionListener(new ActionListener(){
        JFrame frame2 = new JFrame("Rock-Paper-Scissors");
        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel("Please Make Your Selection: ");
        panel2.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        c1.insets = new Insets(10,10,10,10);
        c1.fill = GridBagConstraints.HORIZONTAL;
        c1.gridx = 0;
        c1.gridy = 0;
        panel2.add(label2);
        c1.gridy++;
        panel2.add(rockButton);
        c1.gridy++;
        panel2.add(scissorsButton);
        c1.gridy++;
        panel2.add(paperButton);
        c1.gridy+=4;
        panel2.add(submit);
        frame2.add(panel2);
        if(rockButton.isSelected()){
            playerChoice = "rock";
            turn2();
        }
        else if(scissorsButton.isSelected()){
            playerChoice = "scissors";
            turn2();
        }
        else if(paperButton.isSelected()){
            playerChoice = "paper";
            turn2();
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select an option!");
        }

    });




}
