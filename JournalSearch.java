import javax.swing.*;
import java.awt.event.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JournalSearch extends JFrame implements ActionListener {
    
    private final JLabel findNameQ;
    private final JTextField findNameA;
    private final JLabel findDateQ;
    private final JTextField findDateA;
    private final JButton search;

    public JournalSearch(){
        setLayout(null);
        setSize(1650, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        findNameQ = new JLabel("What is your first name?");
        findNameQ.setBounds(80, 30, 300, 20);

        findNameA = new JTextField();
        findNameA.setBounds(80, 120, 90, 20);

        findDateQ = new JLabel("When did you write this journal? (mm-dd-yy)");
        findDateQ.setBounds(80, 210, 300, 20);

        findDateA = new JTextField();
        findDateA.setBounds(80, 300, 90, 20);

        search = new JButton("Search");
        search.setBounds(80, 390, 90, 20);

        add(findNameQ);
        add(findNameA);
        add(findDateQ);
        add(findDateA);
        add(search);
    }
    public void actionPerformed(ActionEvent e) {
        
        String name = findNameA.getText();
        String date = findDateA.getText(); 
        

        try {
            Scanner scan = new Scanner(new File(name + " " + date + ".txt"));
            while(scan.hasNext()){
                String line = scan.nextLine();
                if(line.contains(name + " " + date)){
                    setVisible(false);
                    dispose();
                    System.out.println("smd");
                    
                }
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
     }
        
    }
    

