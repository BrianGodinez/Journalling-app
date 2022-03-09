import javax.swing.*;
import java.awt.event.*;


public class RegLog extends JFrame implements ActionListener {

    public JButton Login;
    public JButton Register; 
    public JLabel Head;

    LoginPage lPage = new LoginPage();
    RegisterPage rpage = new RegisterPage();

    public RegLog() {
        setLayout(null);
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Login = new JButton("Login");
        Login.setBounds(50, 100, 90, 30);
        Login.addActionListener(this);

        Register = new JButton("Register");
        Register.setBounds(170, 100, 90, 30);
        Register.addActionListener(this);

        Head = new JLabel("Would you like to login or register?");
        Head.setBounds(50, 20, 300, 30);

        add(Head);
        add(Login);
        add(Register);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Login){
            lPage.setVisible(true);
            setVisible(false);
            dispose();
        }
        else{
            rpage.setVisible(true);
            setVisible(false);
            dispose();
        }
    }
}