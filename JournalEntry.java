import javax.swing.*;
import java.awt.event.*;

import java.io.File;  
import java.io.IOException;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.PrintWriter;

public class JournalEntry extends JFrame implements ActionListener {
    
    private final JLabel dateQ;
    private final JTextField dateA;
    private final JLabel nameQ;
    private final JTextField nameA;
    private final JLabel journalInfo;
    private final JTextField journalTitle;
    private final JTextField journal;
    private final JButton submit;

    public JournalEntry(){
        setLayout(null);
        setSize(1650, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        dateQ = new JLabel("What is today's date? (mm-dd-yy)");
        dateQ.setBounds(80, 30, 300, 30);

        dateA = new JTextField();
        dateA.setBounds(80, 120, 90, 30);

        nameQ = new JLabel("What is your first name?");
        nameQ.setBounds(80, 210, 300, 30);

        nameA = new JTextField();
        nameA.setBounds(80, 300, 90, 30);

        journalInfo = new JLabel("Start journaling: ");
        journalInfo.setBounds(80, 390, 300, 30);

        journalTitle = new JTextField();
        journalTitle.setBounds(80, 480, 700, 30);

        journal = new JTextField();
        journal.setBounds(80, 570, 700, 30);

        submit = new JButton("Submit");
        submit.setBounds(80, 680, 90, 30);
        submit.addActionListener(this);
        add(dateQ);
        add(dateA);
        add(nameQ);
        add(nameA);
        add(journalInfo);
        add(journalTitle);
        add(journal);
        add(submit);
    }
    public void actionPerformed(ActionEvent e) {
        String name = nameA.getText();
        String date = dateA.getText();
        String journalString = journal.getText();
        String journalTitleString = journalTitle.getText();

       File newFile = new File(name + " " + date + ".txt");
       try {
        if (newFile.createNewFile()) {
            System.out.println("File created: " + newFile.getName());
          } else {
            System.out.println("File already exists.");
          }
    } catch (IOException e1) {
        e1.printStackTrace();
    }

    try {
        FileOutputStream fos = new FileOutputStream(name + " " + date + ".txt", true);
        PrintWriter pw = new PrintWriter(fos);

        pw.print(name + " " + date + "\n" + journalTitleString + "\n" + journalString);
        pw.close();
    } catch (FileNotFoundException e1) {

        e1.printStackTrace();
    }
    setVisible(false);
    dispose();
 
}
} 
    

