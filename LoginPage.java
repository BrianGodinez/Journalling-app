import javax.swing.*;
import java.awt.event.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class LoginPage extends JFrame implements ActionListener {

    private final JLabel userHeader;
    private final JLabel passHeader;
    private final JButton loginButton;
    public  JTextField userInput;
    private final JPasswordField passInput;
 

    public LoginPage(){
        setLayout(null);
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        userHeader = new JLabel("Enter your username: ");
        userHeader.setBounds(10, 10, 150, 30);

        passHeader = new JLabel("Enter your password: ");
        passHeader.setBounds(10, 70, 150, 30);

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 150, 80, 30);
        loginButton.addActionListener(this);

        userInput = new JTextField();
        userInput.setBounds(10, 40, 90, 30);

        passInput = new JPasswordField();
        passInput.setBounds(10, 100, 90, 30);

        add(userHeader);
        add(passHeader);
        add(loginButton);
        add(userInput);
        add(passInput);
    }

    public void actionPerformed(ActionEvent e) {
        String userUsername = userInput.getText();
        char[] userPassword2 =  passInput.getPassword();
        String userPassword = String.valueOf(userPassword2);
        Journal a = new Journal();

        try {
            Scanner scan = new Scanner(new File("userinfo.txt"));
            while(scan.hasNext()){
                String line = scan.nextLine();
                if(line.contains(userUsername + " , " + userPassword)){
                    setVisible(false);
                    dispose();
                    a.setVisible(true);
                }
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
     }
}

