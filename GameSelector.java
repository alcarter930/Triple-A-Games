import java.util.ArrayList;
public class GameSelector{
  
  private String[] P1Games, P2Games;
  public final String[] P1GAMES = {"Trivia"};
  public final String[] P2GAMES = {"Rock, Paper, Scissors", "Trivia"};
  protected int[] scores;
  
  /*
  constructor
  takes arrayList of player names as parameter
  */
  public GameSelector(ArrayList<String> names){

    scores = new int[names.size()];
    Arrays.fill(scores, 0);
  }
  /*
  constructor
  takes arraylist of names as parameter and array of scores
  */
  public GameSelector(ArrayList<String> names, int[] orgScore){
    scores = orgScore;

  }
  
}
