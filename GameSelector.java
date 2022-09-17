import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GameSelector{

    private String[] P1Games, P2Games;
    protected ArrayList<Game> games;
    public final String[] P1GAMES = {"Trivia"};
    public final String[] P2GAMES = {"Rock, Paper, Scissors", "Trivia"};
    protected String[] gameNames;
    protected int[] scores;
    protected ArrayList<String> pNames;

    /*
    constructor
    takes arrayList of player names as parameter
    */
    public GameSelector(ArrayList<String> names){
        pNames = names;
        scores = new int[names.size()];
        Arrays.fill(scores, 0);
        initializeGames();
    }
    /*
    constructor
    takes arraylist of names as parameter and array of scores
    */
    public GameSelector(ArrayList<String> names, int[] orgScore){
        scores = orgScore;
        pNames = names;
        initializeGames();
    }
    //initializes the list of possible games
    private void initializeGames(){
        games = new ArrayList<Game>();
        if (pNames.size() == 1){
            games.add( new Trivia());
            gameNames = P1GAMES;
        }else if (pNames.size() == 2){
            games.add(new Trivia());
            games.add(new rockPaperScissors());
            gameNames = P2GAMES;
        }else{
            gameNames = new String[1];
        }
    }

    public void play(){
       selectGame();
    }
    private void selectGame(){
        //initialize frames and panels
        JFrame frame = new JFrame("Pick a Game");
        JPanel scorePanel = new JPanel();
        JPanel bigPanel = new JPanel();
        scorePanel.setLayout(new GridLayout());
        scorePanel.setBorder(new EmptyBorder(10, 20, 10, 20));
        JLabel scoreLabel;
        //format the bigpanel
        bigPanel.setLayout(new GridBagLayout());
        GridBagConstraints bigC = new GridBagConstraints();
        bigC.fill = GridBagConstraints.HORIZONTAL;
        bigC.gridx = 0;
        bigC.gridy = 0;
        if(pNames.size() > 1) {
            scoreLabel = new JLabel("Scores:");
            scoreLabel.setFont(new Font("Serif", Font.PLAIN, 20));
            bigPanel.add(scoreLabel, bigC);
            bigC.gridy++;

            //loops to add names to the score panel
            for(int i = 0; i<scores.length; i++){
                scoreLabel = new JLabel(pNames.get(i) + ": " + scores[i]);
                scoreLabel.setFont(new Font("Serif", Font.PLAIN, 20));
                scorePanel.add(scoreLabel);
            }
        } else {
            bigC.insets = new Insets(10, 10, 10, 10);
            scoreLabel = new JLabel("Score: " + scores[0]);
            scoreLabel.setFont(new Font("Serif", Font.PLAIN, 20));
            bigPanel.add(scoreLabel, bigC);
            bigC.gridy++;
        }
        //make the selection panel
        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new GridBagLayout());

        //gridbag constraints
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10,10,10,10);
        c.gridx = 0;
        c.gridy = 0;
        //label
        selectionPanel.add(new JLabel("Pick a Game:"), c);


        //drop-down list
        JComboBox gameList = new JComboBox(gameNames);
        c.gridx = 1;
        selectionPanel.add(gameList, c);

        //button to submit game choice
        JButton cont = new JButton("I choose... this one!");
        c.gridx = 2;
        selectionPanel.add(cont, c);
        cont.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               //find out which game was picked
                //play the game and update score
                frame.dispose();
            }
        });
        if(pNames.size() > 1){
            bigPanel.add(scorePanel, bigC);
            bigC.gridy++;
        }
        bigPanel.add(selectionPanel, bigC);
        frame.add(bigPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.pack();
        frame.setVisible(true);
    }

    private void playMore(int pWinner){
        //ask to play more or not
        boolean playing = false;
        
        scores[pWinner-1]++;

        if(playing){
            selectGame();
        }else{
            displayWinner();
        }
    }

    private void displayWinner(){

    }

}
