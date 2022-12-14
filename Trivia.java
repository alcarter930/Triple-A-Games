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

public class Trivia {



    private static JButton moviesButton;
    private static String playerChoice;
    private static JButton gamesButton;

    private static int movieScore;
    private static int movieScore2;
    private static int gameScore;
    private static int gameScore2;

    private static int turnNum;

    public Trivia(){
        moviesButton = new JButton("Movies");
        gamesButton = new JButton("Games");
    }
    static String[] movieQuestions = {
            "Which of these films is Christopher Nolan’s highest-grossing film?",
            "Who is Draco Malfoy’s actor in the Harry Potter film series?",
            "Who directed the film 'Harry Potter and the Prisoner of Azkaban'?",
            "Who is the first film actor to portray James Bond?",
            "When was “The Fast and the Furious: Tokyo Drift” film released?",
            "Which of these production companies were not involved with the film 'Spider-Man: Into " +
                    "the Spider-Verse?'",
            "What was Quentin Tarantino’s first film as a writer and director?",
            "As of 2022, what is the highest-rated film on the IMDb Top 250 list?",
            "What is the protagonist's name in the Christopher Nolan film 'Tenet'?",
            "As of 2022, what is the highest-grossing film of all time?",
            "Which Disney princess dresses up as a man?",
            "Which country does Forrest Gump travel to as part of the All-American Ping-Pong Team?",
            "Which is not the name of a child selected to tour the Wonka factory in Willy Wonka and " +
                    "the Chocolate Factory?",
            "What was the top-grossing movie of 2014?",
            "If you watch the Marvel movies in chronological order, which movie would you watch first?",
            "Some of the velociraptor noises in Jurassic Park are actually which animals mating?",
            "Which was the first movie to show a toilet flushing?",
            "Who is the youngest person to win an Oscar?",
            "Which is the first movie in the Bourne franchise?",
            "When was the first Mission: Impossible movie released?",
            "Which phrase completes this famous quote from The Princess Bride: 'Hello, my name is " +
                    "Inigo Montoya. You killed my father. ______.'",
            "Which of these films is considered to be one of the worst of all time?",
            "Which of these actors has won the Oscar for Best Actor award the most times?",
            "Who is the oldest winner of the Oscar for Best Actor award?",
            "Who is the youngest winner of the Oscar for Best Actor award?"
    };

    static String[][] movieChoices = {
            {"The Dark Knight", "Memento", "Interstellar", "The Dark Knight Rises"},
            {"Warwick Davis", "Brendan Gleeson", "Tom Felton", "Jason Isaacs"},
            {"David Yates", "Francis Ford Coppola", "Chris Columbus", "Alfonso Cuarón"},
            {"Sean Connery", "Daniel Craig", "Ian Fleming", "Pierce Brosnan"},
            {"2001", "2003", "2006", "2007"},
            {"Illumination", "Sony Pictures Animation", "Columbia Pictures", "Marvel Entertainment"},
            {"Pulp Fiction", "Reservoir Dogs", "Jackie Brown", "From Dusk Til Dawn"},
            {"The Godfather", "Schindler's List", "Forrest Gump", "The Shawshank Redemption"},
            {"Protagonist", "Character", "Persona", "Neil"},
            {"Avengers: Endgame", "Avatar", "Star Wars: The Force Awakens", "Titanic"},
            {"Ariel", "Merida", "Cinderella", "Mulan"},
            {"Vietnam", "China", "Sweden", "France"},
            {"Billy Warp", "Veruca Salt", "Mike Teavee", "Charlie Bucket"},
            {"The Hunger Games: Mockingjay Part 1", "The Lego Movie", "Captain America: The Winter Soldier",
                    "Guardians of the Galaxy"},
            {"Iron Man", "Captain America: The First Avenger", "Doctor Strange", "Captain Marvel"},
            {"Tortoises", "Frogs", "Lizards", "Crocodiles"},
            {"Psycho", "Citizen Kane", "The Graduate", "Vertigo"},
            {"Jennifer Lawrence", "Mickey Rooney", "Haley Joel Osment", "Tatum O'Neal"},
            {"The Bourne Legacy", "The Bourne Supremacy", "Jason Bourne", "The Bourne Identity"},
            {"1993", "1996", "1997", "1999"},
            {"'And now, you will pay.'", "'Face me, coward.'", "'Prepare to die.'", "'Tell me, why?'"},
            {"Twilight (Robert Pattinson)", "The Room (Tommy Wiseau)", "Bruce Almighty (Jim Carrey)", "The Lorax " +
                    "(Danny DeVito)"},
            {"Will Smith", "Daniel Day-Lewis", "Joaquin Phoenix", "Gary Oldman"},
            {"Anthony Hopkins", "Morgan Freeman", "Denzel Washington", "Robert De Niro"},
            {"Eddie Redmayne", "Adam Driver", "Adrien Brody", "Jamie Foxx"}
    };

    static char[] movieAnswers = {
            'D',
            'C',
            'D',
            'B',
            'C',
            'A',
            'B',
            'D',
            'A',
            'B',
            'D',
            'B',
            'A',
            'D',
            'B',
            'A',
            'A',
            'D',
            'D',
            'B',
            'C',
            'B',
            'B',
            'A',
            'C'
    };

    static String[] gamesQuestions = {
            "When was the first 'Super Mario Bros.' game released?",
            "Which of these Pac-Man ghosts is the color red?",
            "What is the least successful home Nintendo console?",
            "Which home console has sold the most units?",
            "What is the name of the final course in each of the Mario Kart games?",
            "What is the highest-rated video game on Metacritic?",
            "What is the highest-rated Mario game on Metacritic?",
            "Which of these games does not fall under the “sandbox” genre?",
            "What is the first video game console ever released?",
            "What handheld video game system has sold the highest number of units?",
            "Who created the character Mario?",
            "What is the highest-rated Sonic game on Metacritic?",
            "Who published the games in the Yakuza series?",
            "Which of these game franchises was not created by Square Enix?",
            "Who created the character Kirby?",
            "When was the NES released in America?",
            "When was the SNES released in America?",
            "When was the Game Boy released in America?",
            "When was the Game Boy Color released in America?",
            "When was the Game Boy Advance released in America?",
            "When was the PlayStation Portable released in America?",
            "When was the PlayStation Vita released in America?",
            "When was the Sega Genesis released in America?",
            "When was the Sega Saturn released in America?",
            "When was the Sega Dreamcast released in America?"
    };

    static String[][] gamesChoices = {
            {"1980", "1982", "1985", "1988"},
            {"Inky", "Blinky", "Pinky", "Clyde"},
            {"Nintendo 64", "Wii", "GameCube", "Wii U"},
            {"Xbox 360", "PlayStation 2", "Nintendo Switch", "SNES"},
            {"Rainbow Run", "Rainbow Road", "Rainbow Ride", "Rainbow Rush"},
            {"Super Mario 64", "Grand Theft Auto V", "Red Dead Redemption 2", "The Legend of Zelda: Ocarina of Time"},
            {"Super Mario Odyssey", "Super Mario 3D World", "Super Mario Galaxy", "Super Mario Galaxy 2"},
            {"Minecraft", "No Man's Sky", "Cyberpunk 2077", "Terraria"},
            {"Magnavox Odyssey", "Intellivision", "Atari 2600", "Nintendo Entertainment System"},
            {"Nintendo Game Boy", "Nintendo DS", "PlayStation Portable", "PlayStation Vita"},
            {"Hirohiko Araki", "Jun Maeda", "Shigeru Miyamoto", "Eiichiro Oda"},
            {"Sonic CD", "Sonic Mania", "Sonic Adventure 2", "Sonic the Hedgehog 2"},
            {"Nintendo", "Square Enix", "Kadokawa", "Sega"},
            {"Final Fantasy", "Pokemon", "Dragon Quest", "Kingdom Hearts"},
            {"Masahiro Sakurai", "Shigeru Miyamoto", "Satoru Iwata", "Fusajiro Yamauchi"},
            {"1983", "1984", "1985", "1986"},
            {"1988", "1989", "1990", "1991"},
            {"1988", "1989", "1990", "1991"},
            {"1998", "1999", "2000", "2001"},
            {"2000", "2001", "2002", "2003"},
            {"2004", "2005", "2006", "2007"},
            {"2010", "2011", "2012", "2013"},
            {"1986", "1987", "1988", "1989"},
            {"1994", "1995", "1996", "1997"},
            {"1999", "2000", "2001", "2002"},
    };

    static char[] gamesAnswers = {
            'C',
            'B',
            'D',
            'B',
            'B',
            'D',
            'C',
            'C',
            'A',
            'B',
            'C',
            'A',
            'D',
            'B',
            'A',
            'C',
            'D',
            'B',
            'A',
            'B',
            'B',
            'C',
            'D',
            'B',
            'A'
    };
    private static JRadioButton choiceA, choiceC, choiceD;
    private static JRadioButton choiceB;


    public void play() {
        turnNum = 0;
        movieScore = 0;
        movieScore2 = 0;
        gameScore = 0;
        gameScore2 = 0;



        boolean playingMovies = false;
        boolean playingGames = false;

       playerChoice = "";

        JFrame f = new JFrame("Trivia");
        JLabel l = new JLabel("Please choose a Trivia category: ");
        ButtonGroup group = new ButtonGroup();
        group.add(moviesButton);
        group.add(gamesButton);
        l.setBounds(1050, 300, 400, 100);
        JPanel p = new JPanel();
        p.setSize(2100, 2100);
        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        moviesButton.setBounds(700, 1050, 500, 100);
        gamesButton.setBounds(1400, 1050, 500, 100);

        p.add(l);
        c.gridy++;
        p.add(moviesButton);
        c.gridx++;
        p.add(gamesButton);
        f.add(p);
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        gamesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Scores: Player 1: " + gameScore + " Player 2: " + gameScore2);
                playerChoice = "games";
                f.dispose();
                JLabel l;
                System.out.println(turnNum);
                if((turnNum%2) == 0){
                    l = new JLabel("Player 1:");
                }else{
                    l = new JLabel("Player 2:");
                }
                //new button
                JButton submit = new JButton("Final Answer");
                    int qNum = (int)(Math.random()*(24+1));
                    JFrame f2 = new JFrame("Game Trivia");
                    JLabel li = new JLabel(gamesQuestions[qNum]);
                    choiceA = new JRadioButton(gamesChoices[qNum][0]);
                    choiceB = new JRadioButton(gamesChoices[qNum][1]);
                    choiceC = new JRadioButton(gamesChoices[qNum][2]);
                    choiceD = new JRadioButton(gamesChoices[qNum][3]);
                    ButtonGroup group = new ButtonGroup();
                    group.add(choiceA);
                    group.add(choiceB);
                    group.add(choiceC);
                    group.add(choiceD);
                    li.setBounds(1050, 300, 400, 100);
                    JPanel pi = new JPanel();
                    pi.setSize(3400, 3400);
                    pi.setLayout(new GridBagLayout());
                    GridBagConstraints c2 = new GridBagConstraints();

                    //actionListener for button
                submit.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String s;
                        if(gameAnswers[qNum] == 'A'){
                            if(choiceA.isSelected()){
                                s = "Nice Job! Correct Answer!";
                                if(turnNum%2 == 0){
                                    gameScore++;

                                }else{
                                    gameScore2++;
                                }
                            }else{
                                s = "Sorry, not quite right. Maybe next time!";
                            }
                        }else if (gameAnswers[qNum] == 'B'){
                            if(choiceB.isSelected()){
                                s = "Nice Job! Correct Answer!";
                                if(turnNum%2 == 0){
                                    gameScore++;
                                }else{
                                    gameScore2++;
                                }
                            }else{
                                s = "Sorry, not quite right. Maybe next time!";
                            }
                        }else if (gameAnswers[qNum] == 'C'){
                            if(choiceC.isSelected()){
                                s = "Nice Job! Correct Answer!";
                                if(turnNum%2 == 0){
                                    gameScore++;
                                }else{
                                    gameScore2++;
                                }
                            }else{
                                s = "Sorry, not quite right. Maybe next time!";
                            }
                        }else{
                            if(choiceD.isSelected()){
                                s = "Nice Job! Correct Answer!";
                                if(turnNum%2 == 0){

                                    gameScore++;
                                }else{
                                    gameScore2++;
                                }
                            }else{
                                s = "Sorry, not quite right. Maybe next time!";
                            }
                        }
                        turnNum++;
                        if(turnNum == 10){
                            f2.dispose();
                            GameSelector.winMany(gameScore, gameScore2);
                        }else{
                        JOptionPane.showMessageDialog(null, s);
                        f2.dispose();
                        gamesButton.doClick();
                    }}
                });

                    pi.add(l);
                    c2.gridy++;
                    pi.add(li);
                    c2.gridy += 10;
                    pi.add(choiceA, c2);
                    c2.gridy++;
                    pi.add(choiceB, c2);
                    c2.gridy++;
                    pi.add(choiceC, c2);
                    c2.gridy++;
                    pi.add(choiceD, c2);
                    c2.gridy++;
                    pi.add(submit, c2);
                    f2.add(pi);
                    f2.setSize(800, 800);
                    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f2.setVisible(true);
                if(GameSelector.pNames.get(1).equals("Computer") && turnNum%2 == 1){
                    int ran = (int)( Math.random() * (4-1+1));
                    if(ran == 0){
                        choiceA.setSelected(true);

                    }else if (ran == 1){
                        choiceB.setSelected(true);
                    }else if (ran == 2){
                        choiceC.setSelected(true);
                    }else{
                        choiceD.setSelected(true);
                    }
                    submit.doClick();
                }


            }
        });
        moviesButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Scores: Player 1: " + movieScore + " Player 2: " + movieScore2);
            playerChoice = "movies";
            f.dispose();
            JLabel l;
            if((turnNum%2) == 0){
                l = new JLabel("Player 1:");
            }else{
                l = new JLabel("Player 2:");
            }
            //new button
            JButton submit = new JButton("Final Answer");
            int qNum = (int)(Math.random()*(24+1));
            JFrame f2 = new JFrame("Movie Trivia");
            JLabel li = new JLabel(movieQuestions[qNum]);
            choiceA = new JRadioButton(movieChoices[qNum][0]);
            choiceB = new JRadioButton(movieChoices[qNum][1]);
            choiceC = new JRadioButton(movieChoices[qNum][2]);
            choiceD = new JRadioButton(movieChoices[qNum][3]);
            ButtonGroup group = new ButtonGroup();
            group.add(choiceA);
            group.add(choiceB);
            group.add(choiceC);
            group.add(choiceD);
            li.setBounds(1050, 300, 400, 100);
            JPanel pi = new JPanel();
            pi.setSize(3400, 3400);
            pi.setLayout(new GridBagLayout());
            GridBagConstraints c2 = new GridBagConstraints();

            //actionListener for button
            submit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String s;
                    if(movieAnswers[qNum] == 'A'){
                        if(choiceA.isSelected()){
                            s = "Nice Job! Correct Answer!";
                            if(turnNum%2 == 0){
                                movieScore++;

                            }else{
                                movieScore2++;
                            }
                        }else{
                            s = "Sorry, not quite right. Maybe next time!";
                        }
                    }else if (movieAnswers[qNum] == 'B'){
                        if(choiceB.isSelected()){
                            s = "Nice Job! Correct Answer!";
                            if(turnNum%2 == 0){
                                movieScore++;
                            }else{
                                movieScore2++;
                            }
                        }else{
                            s = "Sorry, not quite right. Maybe next time!";
                        }
                    }else if (movieAnswers[qNum] == 'C'){
                        if(choiceC.isSelected()){
                            s = "Nice Job! Correct Answer!";
                            if(turnNum%2 == 0){
                                movieScore++;
                            }else{
                                movieScore2++;
                            }
                        }else{
                            s = "Sorry, not quite right. Maybe next time!";
                        }
                    }else{
                        if(choiceD.isSelected()){
                            s = "Nice Job! Correct Answer!";
                            if(turnNum%2 == 0){

                                movieScore++;
                            }else{
                                movieScore2++;
                            }
                        }else{
                            s = "Sorry, not quite right. Maybe next time!";
                        }
                    }

                    turnNum++;
                    if(turnNum == 10){
                        f2.dispose();
                        GameSelector.winMany(movieScore, movieScore2);
                    }else{
                    JOptionPane.showMessageDialog(null, s);
                    f2.dispose();
                    moviesButton.doClick();
                }}
            });


            pi.add(l);
            c2.gridy++;
            pi.add(li);
            c2.gridy += 10;
            pi.add(choiceA, c2);
            c2.gridy++;
            pi.add(choiceB, c2);
            c2.gridy++;
            pi.add(choiceC, c2);
            c2.gridy++;
            pi.add(choiceD, c2);
            c2.gridy++;
            pi.add(submit, c2);
            f2.add(pi);
            f2.setSize(800, 800);
            f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f2.setVisible(true);
            if(GameSelector.pNames.get(1).equals("Computer") && turnNum%2 == 1){
                int ran = (int)( Math.random() * (4-1+1));

                if(ran == 0){
                    choiceA.setSelected(true);

                }else if (ran == 1){
                    choiceB.setSelected(true);
                }else if (ran == 2){
                    choiceC.setSelected(true);
                }else{
                    choiceD.setSelected(true);
                }
                submit.doClick();
            }



        }
    });

    }






}
