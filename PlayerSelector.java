import javax.swing.*;
import java.util.awt;
import java.util.ArrayList;

public class PlayerSelector {
   protected int myPlayerNum; //number of players playing
    protected ArrayList<String> myNames; //names of all of the players
    protected JFrame myFrame; //frame for the game
    protected JPanel myPanel; //one panel
    protected JLabel welcomeLabel;

    public PlayerSelector() {
        myFrame = new JFrame("Player Selector");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myPanel = new JPanel();
        welcomeLabel = new JLabel("Welcome!");
        myPanel.add(welcomeLabel);
        
        myFrame.add(myPanel);
    }
    
    public void testFrame() {
        myFrame.setVisible(true);
    }
 
  
  
  
}
