package MainCode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    //theses are the objects on the form
    private JPanel App;
    private JTextField txtMain;
    private JButton BtnMax;
    private JLabel lblAnwser;


    //this is the button
    public App() {
        BtnMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //this reads what the users has typed and set it to a varuble called "s"
                String s = txtMain.getText();

                //this calls the function
                int LocalMax = findMax(s);

                //this displays the function
                lblAnwser.setText(String.valueOf(LocalMax));
            }
        });
    }

    public static int findMax(String s){

        //local varubles
        int maxString = 1;
        int currentCount = 1;

        //error checking if the user enters nothing
        if(s.length() == 0){
            return 0;
        }

        //where the loop should begin
        char Current = s.charAt(0);

        //this loop has an loop run's to entill there is no more charecters
        for (int i = 1; i<s.length();i++){

            //checking to see if the chracter is the same as the last if yes incremnt the current count
            if (s.charAt(i) == Current){
                currentCount++;
            }
            //if no check to see if the number of chracters in a row is bigger than the last time and reset it
            else {
                if (currentCount > maxString){
                    maxString = currentCount;
                }
                currentCount = 1;
                Current = s.charAt(i);
            }
        }

        //error checking 
        if (currentCount > maxString){
            maxString = currentCount;
        }

        //returns the number
        return maxString;
    }

    //this displays the form and makes it so the user can intrecat with the objects
    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().App);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
