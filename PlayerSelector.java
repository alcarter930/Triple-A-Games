import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;

public class PlayerSelector {
   protected int myPlayerNum; //number of players playing
    protected ArrayList<String> myNames; //names of all of the players
    protected JFrame myFrame; //frame for the game
    protected JPanel myPanel; //one panel
    protected JLabel welcomeLabel, selectPlayers;
    protected JButton oneP,twoP,threeP; //buttons to indicate # of players

    public PlayerSelector() {
        //initializing frame
        myFrame = new JFrame("Player Selector");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //initializing panel
        myPanel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        myPanel.setLayout(layout);
        GridBagConstraints c = new GridBagConstraints();
        myPanel.setBorder(new EmptyBorder(10, 20, 10, 20));


        //initializing label and font
        welcomeLabel = new JLabel("Welcome!");
        welcomeLabel.setFont(new Font("Serif", Font.PLAIN, 20));

        //making another label! yay!
        selectPlayers = new JLabel("How many Players do you have?");
        selectPlayers.setFont(new Font("Serif", Font.PLAIN, 14));

        //initalizing buttons
        oneP = new JButton("One Player");
        twoP = new JButton("Two Players");


        c.weightx = 1.0;
        c.weighty = 1.0;
        //adding labels
        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = GridBagConstraints.REMAINDER;
        myPanel.add(welcomeLabel, c);
        myPanel.add(selectPlayers, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,10,10);
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.gridx = 0;
        c.gridy = 2;
        myPanel.add(oneP, c);
        c.gridx = 1;
        myPanel.add(twoP, c);



        myFrame.add(myPanel);

    }
    
    public void testFrame() {
        myFrame.setSize(300,300);
        myFrame.pack();
        myFrame.setVisible(true);
    }
 
  
  
  
}
