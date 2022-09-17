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


                //TEMPORARY TEMPORARY TEMPORARY
                playMore(1);
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
        //update score
        boolean playing = false;
        scores[pWinner - 1]++;
        //ask to play more or not
        JFrame frame = new JFrame("Play Again?");
        //big panel
        JPanel bigP = new JPanel();
        bigP.setLayout(new GridBagLayout());
        GridBagConstraints bigC = new GridBagConstraints();

        bigC.insets = new Insets(10,0, 10, 0);
        bigC.gridx = 0;
        bigC.gridy = 0;
        //game over! image :)
        try {
            BufferedImage myPicture = ImageIO.read(new File("C:\\Users\\alcar\\OneDrive\\Desktop\\CS180\\TripleAGames\\gameover.png"));
            Image scaledImage = myPicture.getScaledInstance(200,200,Image.SCALE_SMOOTH);
            JLabel gameOver = new JLabel(new ImageIcon(scaledImage));
            bigP.add(gameOver, bigC);
            bigC.gridy++;
        }catch (Exception e){
            System.out.println(e);
            JLabel gameOver = new JLabel("Game Over");
            gameOver.setFont(new Font("Futura", Font.PLAIN, 20));
            bigP.add(gameOver, bigC);
            bigC.gridy++;

        }
        //text below
        JLabel funLabel = new JLabel("Wow! That was fun!");
        funLabel.setFont(new Font("Serif", Font.PLAIN, 15));
        bigP.add(funLabel, bigC);
        bigC.gridy++;

        //new scores
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridBagLayout());
        GridBagConstraints scoreC = new GridBagConstraints();
        scoreC.fill = GridBagConstraints.BOTH;
        scoreC.insets = new Insets(10, 10, 10, 10);
        //if multiplayer
        if(pNames.size() > 1){
            scoreC.gridx = 0;
            scoreC.gridy = 0;
            scorePanel.add(new JLabel("Scores: "), scoreC);
            scoreC.gridx++;
            for(int i = 0; i<pNames.size(); i++){
                scorePanel.add(new JLabel(pNames.get(i) + ": " + scores[i]), scoreC);
                scoreC.gridx++;
            }
        }else {
            scorePanel.add(new JLabel("Score: " + scores[0]), scoreC);
        }
        //adding to big panel
        bigP.add(scorePanel, bigC);
        bigC.gridy++;

        //ask to play again
        JPanel playAgain = new JPanel();
        playAgain.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        //constraints
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10, 10, 10, 10);
        //question
        c.fill = GridBagConstraints.CENTER;
        JLabel playQuest = new JLabel("Play Another Game?");
        playQuest.setFont(new Font("Serif", Font.PLAIN, 15));
        playQuest.setHorizontalAlignment(SwingConstants.CENTER);
        playAgain.add(playQuest, c);
        c.gridy++;
        c.gridwidth = 1;
        c.insets = new Insets(10, 20, 10, 10);
        //buttons
        JButton yesButton = new JButton("Yes!");
        JButton noButton = new JButton("No :(");
        c.fill = GridBagConstraints.WEST;
        playAgain.add(yesButton, c);
        c.gridx++;
        c.fill = GridBagConstraints.EAST;
        playAgain.add(noButton, c);

        bigP.add(playAgain, bigC);

        noButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frame.dispose();

                //find max score
                displayWinner();
            }
        });
        yesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //play again!
                frame.dispose();
                selectGame();
            }
        });



        frame.add(bigP);
        frame.pack();
        frame.setSize(1000, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    private void displayWinner(){

        if(pNames.size() == 1){
            JOptionPane.showMessageDialog(null, "Good Game! Your Score was: " + scores[0]);
        }else{
            //find max score
            int maxScore = scores[0];
            int ties = -1;
            int maxIndex = 0;
            ArrayList<Integer> tiedPeople = new ArrayList<Integer>();
            for(int i= 0; i<scores.length;i++){
                if(scores[i] > maxScore){
                    maxScore = scores[i];
                    maxIndex = i;
                    ties = 0;
                    tiedPeople.clear();
                    tiedPeople.add(i);
                }else if(scores[i] == maxScore){
                    ties++;
                    tiedPeople.add(i);
                }
            }
            if(tiedPeople.size() > 1){
                String s = "Good Game! There was a tie between:\n";
                for(int i: tiedPeople){
                    s+= pNames.get(i) + "\n";
                }
                JOptionPane.showMessageDialog(null, s);

            }else{
                String s = "Good Game! " + pNames.get(maxIndex) + " won with a score of " + maxScore;
                JOptionPane.showMessageDialog(null, s);
            }
        }

    }

