import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;

public class PlayerSelector {
    protected int myPlayerNum; //number of players playing
    protected ArrayList<String> myNames; //names of all of the players
    protected ArrayList<JTextField> names; //list of the text fields for names
    protected JFrame myFrame, nameFrame; //frame for the game
    protected JPanel myPanel; //one panel
    protected JLabel welcomeLabel, selectPlayers;
    protected JButton oneP,twoP,threeP; //buttons to indicate # of players

    public PlayerSelector() {
        //initializing arrayList
        names = new ArrayList<JTextField>();
        myNames = new ArrayList<String>();
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


        oneP.addActionListener(new OnePListener());
        twoP.addActionListener(new TwoPListener());

    }

    public void testFrame() {
        myFrame.setSize(300,300);
        myFrame.pack();
        myFrame.setVisible(true);
    }

    //creating an action listener for the one player button
    public class OnePListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            myPlayerNum = 1;
            getNames();
        }

    }

    public class TwoPListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            myPlayerNum = 2;
            getNames();
        }
    }

    public void getNames(){
        JLabel label;
        JTextField nameField;
        //closing current window
        myFrame.dispose();

        //creating new window!
        nameFrame = new JFrame("Name Time!");
        //new panel! with layout :)
        final JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);
        if(myPlayerNum>1){
            for(int i = 0; i < myPlayerNum; i++){
                c.gridx = 0;
                c.gridy = i;
                label = new JLabel("Player " + (i+1) + ", What's your name?");
                panel.add(label, c);
                nameField = new JTextField();
                c.gridx = 1;
                panel.add(nameField, c);
                names.add(nameField);

            }
        } else{
            c.gridx = 0;
            c.gridy = 0;
            label = new JLabel("What's your name?");
            panel.add(label,c);
            nameField = new JTextField();
            c.gridx = 1;
            panel.add(nameField, c);
            names.add(nameField);
        }
        //adding submit button! yay!
        JButton button = new JButton("Submit");
        c.gridy = myPlayerNum;
        panel.add(button, c);

        button.addActionListener(new SubmitListener());



        nameFrame.add(panel);
        nameFrame.pack();
        nameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nameFrame.setSize(300, 300);
        nameFrame.setVisible(true);

    }

    public class SubmitListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            for(JTextField j: names){
                myNames.add(j.getText());
            }
            nameFrame.dispose();

            //Game Loop. Begins the cycle.
            GameSelector gaming = new GameSelector(myNames);
            gaming.play();
        }
    }

    public ArrayList<String> getMyNames(){
        return myNames;
    }
    public int getPlayerNum(){
        return myPlayerNum;
    }
}
