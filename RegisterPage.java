import javax.swing.*;
import java.awt.event.*;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.PrintWriter;

class RegisterPage extends JFrame implements ActionListener {
    private final JLabel rUserLabel;
    private final JLabel rPassLabel;
    private final JTextField desiredUser;
    private final JTextField desiredPass;
    private final JButton rRegister;

    LoginPage lPage = new LoginPage();

    public RegisterPage() {
        setLayout(null);
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rUserLabel = new JLabel("Enter your desired username: ");
        rUserLabel.setBounds(10, 10, 180, 30);

        rPassLabel = new JLabel("Enter your desired password: ");
        rPassLabel.setBounds(10, 70, 180, 30);

        rRegister = new JButton("Register");
        rRegister.setBounds(10, 150, 100, 30);
        rRegister.addActionListener(this);

        desiredUser = new JTextField();
        desiredUser.setBounds(10, 40, 90, 30);

        desiredPass = new JTextField();
        desiredPass.setBounds(10, 100, 90, 30);

        add(rUserLabel);
        add(rPassLabel);
        add(rRegister);
        add(desiredUser);
        add(desiredPass);
    }

    public void actionPerformed(ActionEvent e){

        try {
            String DU = desiredUser.getText();
            String DP = desiredPass.getText();            

            FileOutputStream fos = new FileOutputStream("userinfo.txt", true);
            PrintWriter pw = new PrintWriter(fos);

            pw.print(DU + " , " + DP + "\n");
            pw.close();
        } catch (FileNotFoundException e1) {

            e1.printStackTrace();
        }
        setVisible(false);
        dispose();
        lPage.setVisible(true);
    }

}