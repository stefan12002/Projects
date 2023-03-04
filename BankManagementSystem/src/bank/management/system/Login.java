package bank.management.system;

import javax.swing.*;//JFrame
import java.awt.*;//Imagine
import java.awt.event.*;


public class Login extends JFrame implements ActionListener {
    JButton login,signup,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){

        setTitle("AUTOMATED TELLER MACHINE") ;

        setLayout(null);

        ImageIcon imagine1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image imagine2=imagine1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon imagine3=new ImageIcon(imagine2);
        JLabel label=new JLabel(imagine3);
        label.setBounds(10,10,100,100);

        add(label);

        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(150,40,400,40);
        add(text);

        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,22));
        cardno.setBounds(120,120,150,40);
        add(cardno);

        cardTextField=new JTextField();
        cardTextField.setBounds(220,125,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(120,200,400,40);
        add(pin);

        pinTextField=new  JPasswordField();
        pinTextField.setBounds(170,210,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login=new JButton("SIGN IN");
        login.setBounds(180,280,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear=new JButton("CLEAR");
        clear.setBounds(320,280,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);


        signup=new JButton("SIGN UP");
        signup.setBounds(200,320,200,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);




        getContentPane().setBackground(Color.WHITE);

        setSize(600,400);
        setVisible(true);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if(ae.getSource() == login) {

        } else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
