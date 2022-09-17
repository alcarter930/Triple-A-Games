import java.util.ArrayList;
public class GameSelector{
  
  private String[] P1Games, P2Games;
    protected ArrayList<Game> games;
    public final String[] P1GAMES = {"Trivia"};
    public final String[] P2GAMES = {"Rock, Paper, Scissors", "Trivia"};
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
    pNames = names;
    scores = orgScore;
    initializeGames();

  }
  
  //initializes the list of possible games
    private void initializeGames(){
        if (pNames.size() == 1){
            games.add( new Trivia());
        }else if (pNames.size() == 2){
            games.add(new Trivia());
            games.add(new rockPaperScissors());
        }
    }
    //plays the games in a loop. the string returned in a win message to display who won
    public String play(){
        boolean stillPlaying = true;
        String whoWon;
        Game currentGame;
        //continually plays games until the user says they do not want to anymore
        while(stillPlaying){
            currentGame = selectGame();
          //updates the score after playing a game
            scores[currentGame.play()-1] += 1;
            stillPlaying = playMore();
        }

        /*to implement:
        - compare all the final scores
        - depending on who won, update the who won message
        
        */
        whoWon = " wins!";
        return whoWon;
    }
    //selects the game to play next
    private Game selectGame(){

    }
    //asks the players if they are planning on playing more games
    private boolean playMore(){
        
    }

  
}
