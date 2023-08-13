import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NumGuess extends JFrame{
    private JLabel inLbl, outLbl;
    private JTextField inTf;
    private JButton subBtn, exitBtn;
    private Random rand;
    private int num,attempts;

    public NumGuess(){
        setTitle("Number Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rand = new Random();
        num = rand.nextInt(100) + 1;
        attempts=0;

        inLbl = new JLabel("Enter a number between 1 and 100 :");
        outLbl = new JLabel("");
        inTf = new JTextField("");
        subBtn = new JButton("Guess!!!");
        exitBtn = new JButton("Quit");
        subBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                int val=Integer.parseInt(inTf.getText());
                attempts++;
                if(val == num){
                    outLbl.setText("Congratulations!!! You Guessed The Correct Number in "+attempts+" Guesses.");
                    subBtn.setEnabled(false);
                }else if(val > num){
                    outLbl.setText("Your guess is too high.");
                }else{
                    outLbl.setText("Your guess is too low.");
                }
            }
        });
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                dispose();
            }
        });

        inLbl.setBounds(25,25,300,25);
        inTf.setBounds(25,75,450,25);
        outLbl.setBounds(25,125,450,25);
        subBtn.setBounds(25,175,100,40);
        exitBtn.setBounds(350,175,100,40);
        
        add(inLbl);
        add(inTf);
        add(outLbl);
        add(subBtn);
        add(exitBtn);

        setSize(500, 275);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args){
        new NumGuess();
    }
}

