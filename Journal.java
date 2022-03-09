import javax.swing.*;
import java.awt.event.*;


public class Journal extends JFrame implements ActionListener {

    private final JLabel welcoming;
    private final JButton journaling;
    private final JButton search;
    
    JournalEntry jEntry = new JournalEntry();
    JournalSearch jSearch = new JournalSearch();
    
    public Journal(){
    setLayout(null);
    setSize(1650, 1080);
    setExtendedState(JFrame.MAXIMIZED_BOTH); 
    setUndecorated(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    welcoming = new JLabel("Welcome back.");
    welcoming.setBounds(900, 20, 450, 300);

    journaling = new JButton("Start journaling");
    journaling.setBounds(450, 500, 220, 25);
    journaling.addActionListener(this);

    search = new JButton("Search for previous journal");
    search.setBounds(1300, 500, 220, 25);
    search.addActionListener(this);

    add(welcoming);
    add(journaling);
    add(search);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == journaling){
            jEntry.setVisible(true);
            setVisible(false);
            dispose();
        }
        else{
            jSearch.setVisible(true);
            setVisible(false);
            dispose();
        }
    }
}
