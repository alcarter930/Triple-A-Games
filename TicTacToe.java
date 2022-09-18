import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static java.lang.Thread.sleep;

public class TicTacToe implements Game{

    protected ArrayList<String> pNames;
    protected ArrayList<JButton> spaces;
    protected int turnNum;
    public TicTacToe(ArrayList<String> names){
        pNames = names;
    }

    public void play(){
        turnNum = 0;
        spaces = new ArrayList<JButton>();
        JFrame frame = new JFrame("Tic-Tac-Toe");
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JPanel bigP = new JPanel();
        bigP.setLayout(new BorderLayout());


        JPanel title = new JPanel();
        title.setLayout(new GridBagLayout());
        GridBagConstraints titleC = new GridBagConstraints();
        titleC.gridx = 0;
        titleC.gridy = 0;
        JLabel tictac = new JLabel("Tic-Tac-Toe!");
        tictac.setFont(new Font("Marker Felt", Font.BOLD, 20));
        JLabel turn = new JLabel(pNames.get((turnNum%2))+"'s Turn");
        turn.setFont(new Font("Marker Felt", Font.BOLD, 20));
        title.add(tictac,titleC);
        titleC.gridy++;
        title.add(turn, titleC);



        c.gridx = 0;
        c.gridy = 0;
        JButton b;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                b = new JButton();
                b.setPreferredSize(new Dimension(100, 100));
                c.gridx = j;
                c.gridy = i;
                panel.add(b, c);
                JButton finalB = b;
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int choice;
                        if((turnNum%2) == 0){
                            finalB.setText("X");
                        }else{
                            finalB.setText("O");
                        }
                        finalB.setEnabled(false);
                        turnNum++;
                        int l;
                        boolean winner = false;
                        //check for a win
                        for(int k = 0; k<3; k++){
                            l = k*3;

                            if(spaces.get(l).getText().equals(spaces.get(l+1).getText()) && spaces.get(l).getText().equals(spaces.get(l+2).getText())){
                                if(spaces.get(l).getText().equals("")){
                                    continue;
                                }
                                win(spaces.get(l).getText());
                                winner = true;
                                frame.dispose();

                                break;
                            }

                            if(spaces.get(k).getText().equals(spaces.get(k+3).getText()) && spaces.get(k).getText().equals(spaces.get(k+6).getText())) {
                                if(spaces.get(k).getText().equals("")){
                                    continue;
                                }
                                win(spaces.get(k).getText());
                                frame.dispose();
                                winner = true;
                                break;
                            }
                        }
                        String test = spaces.get(4).getText();
                        if(!test.equals("") && test.equals(spaces.get(0).getText()) && test.equals(spaces.get(8).getText())){
                            System.out.println("Bruh");
                            winner = true;
                            win(spaces.get(0).getText());
                            frame.dispose();
                        } else if (!test.equals("") && test.equals(spaces.get(2).getText()) && test.equals(spaces.get(6).getText())) {
                            winner = true;
                            win(spaces.get(2).getText());
                            frame.dispose();
                        }
                        //check for tie
                        if (turnNum == 9 && !winner){
                            win("NA");
                            frame.dispose();
                        }


                        if(pNames.get(turnNum%2).equals("Computer") && !winner){
                            do{
                                choice = (int)(Math.random()*8+1);}
                            while(!spaces.get(choice).getText().equals(""));
                            spaces.get(choice).doClick();
                        }
                        if(!winner) {
                            turn.setText(pNames.get((turnNum % 2)) + "'s Turn");
                            turn.revalidate();
                        }
                        turn.revalidate();
                    }
                });
                spaces.add(b);
            }
        }
        bigP.add(title, BorderLayout.NORTH);
        bigP.add(panel, BorderLayout.CENTER);
        bigP.setBorder(new EmptyBorder(20, 20, 20, 20));
        frame.add(bigP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        frame.pack();



    }

    public String getName(){
        return "Tic-Tac-Toe";
    }

    public void win(String s){
        if(s.equals("X")){
            GameSelector.playMore(1);
            JOptionPane.showMessageDialog(null, "X Wins!");
        }else if(s.equals("O")){
            GameSelector.playMore(2);
            JOptionPane.showMessageDialog(null, "O Wins!");
        }else{
            System.out.println(s);
            JOptionPane.showMessageDialog(null, "Tie :/");
            turnNum = 0;
            play();
        }
    }

}
