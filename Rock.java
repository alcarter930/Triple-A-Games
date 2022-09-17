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

    private String playerChoice = "";
    private String playerChoice2 = "";

    JRadioButton rockButton2 = new JRadioButton("Rock");
    JRadioButton scissorsButton2 = new JRadioButton("Scissors");
    JRadioButton paperButton2 = new JRadioButton("Paper");
    ButtonGroup group2 = new ButtonGroup();
    group2.add(rockButton2);
    group2.add(scissorsButton2);
    group2.add(paperButton2);
    public String getWinner(){
        String winner = "";
        if(playerChoice.equalsIgnoreCase("rock") && playerChoice2.equalsIgnoreCase("rock")){
            winner = "tie";
        }
        else if(playerChoice.equalsIgnoreCase("scissors") && playerChoice2.equalsIgnoreCase("scissors")){
            winner = "tie";
        }
        else if(playerChoice.equalsIgnoreCase("paper") && playerChoice2.equalsIgnoreCase("paper")){
            winner = "tie";
        }
        else if(playerChoice.equalsIgnoreCase("rock") && playerChoice2.equalsIgnoreCase("scissors")){
            winner = player1;
        }
        else if(playerChoice.equalsIgnoreCase("rock") && playerChoice2.equalsIgnoreCase("paper")){
            winner = player2;
        }
        else if(playerChoice.equalsIgnoreCase("scissors") && playerChoice2.equalsIgnoreCase("rock")){
            winner = player2;
        }
        else if(playerChoice.equalsIgnoreCase("scissors") && playerChoice2.equalsIgnoreCase("paper")){
            winner = player1;
        }
        else if(playerChoice.equalsIgnoreCase("paper") && playerChoice2.equalsIgnoreCase("rock")){
            winner = player1;
        }
        else if(playerChoice.equalsIgnoreCase("paper") && playerChoice2.equalsIgnoreCase("scissors")){
            winner = player2;
        }
        return winner;
    }

    public void turn2(){
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
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select an option!");
        }
    }

    submit.addActionListener(new ActionListener(){
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
            turn2()
        }
        else{
            JOptionPane.showMessageDialog(null, "Please select an option!");
        }

    });




}
