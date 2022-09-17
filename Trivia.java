import java.util.Scanner;
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

public class Trivia implements ActionListener {

    String[] movieQuestions = {
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

    String[][] movieChoices = {
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

    char[] movieAnswers = {
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

    String[] gamesQuestions = {
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

    String[][] gamesChoices = {
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

    char[] gamesAnswers = {
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


    public void Trivia() {

        Scanner in = new Scanner(System.in);
        boolean playingMovies = false;
        boolean playingGames = false;

        JFrame f = new JFrame("Trivia");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JLabel l = new JLabel("Please choose a Trivia category: ");
        l.setBounds(1050, 300, 400, 100);
        JPanel p = new JPanel();
        p.setSize(2100, 2100);
        JButton moviesButton = new JButton("Movies");
        JButton gamesButton = new JButton("Games");
        moviesButton.setBounds(700, 1050, 500, 100);
        gamesButton.setBounds(1400, 1050, 500, 100);

        p.add(moviesButton);
        p.add(gamesButton);
        f.add(p);

    }

    public void nextQuestion() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
