package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit,withdrawal,ministatement,pinchange,fastcash,balanceEnquiry,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setBounds(255,310,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Rs 100");
        deposit.setBounds(210,410,100,20);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawal=new JButton("Rs 500");
        withdrawal.setBounds(420,410,130,20);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash=new JButton("Rs 1000");
        fastcash.setBounds(210,435,100,20);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Rs 2000");
        ministatement.setBounds(420,435,130,20);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(210,460,100,20);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceEnquiry=new JButton("Rs 10000");
        balanceEnquiry.setBounds(420,460,130,20);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit=new JButton("Back");
        exit.setBounds(420,485,130,20);
        exit.addActionListener(this);
        image.add(exit);



        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
          setVisible(false);
          new Transactions(pinnumber).setVisible(true);
        }else{
            String amount=((JButton)ae.getSource()).getText().substring(3);//Rs=500
            Conn c=new Conn();
            try{
                ResultSet rs=c.s.executeQuery("select*from bank where pin= '"+pinnumber+"'");
                int balance=0;
                while (rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }

                if( ae.getSource()!=exit&&balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Successfully ");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
