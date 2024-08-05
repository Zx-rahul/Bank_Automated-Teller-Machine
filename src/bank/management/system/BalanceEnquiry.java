package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    String pin, cardNo;
    JLabel label2;
    JButton b1;
    BalanceEnquiry(String cardNo,String pin){
        this.pin =pin;
        this.cardNo =cardNo;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900,692,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(150,0,1000,700);
        add(l3);

        JLabel label1 = new JLabel("Your Current Balance is Rs ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System", Font.BOLD, 18));
        label1.setBounds(240,260,400,35);
        l3.add(label1);

        JLabel labelRupees = new JLabel("₹");
        labelRupees.setForeground(Color.WHITE);
        labelRupees.setFont(new Font("Raleway", Font.BOLD, 18));
        labelRupees.setBounds(240,292,10,30);
        l3.add(labelRupees);

        label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 18));
        label2.setBounds(253,290,400,35);
        l3.add(label2);

        b1 = new JButton("BACK");
        b1.setBounds(447,436,120,24);
        b1.setBackground(new Color(218, 7, 9));
        b1.setForeground(new Color(32, 31, 31));
        b1.setFont(new Font("AOE", Font.BOLD,16));
        b1.addActionListener(this);
        l3.add(b1);

        int balance =0;
        try{
            Connect connect = new Connect();
            ResultSet resultSet = connect.statement.executeQuery("Select * from bank where card_number = '"+this.cardNo+
                    "'");
            while (resultSet.next()){
                if (resultSet.getString("deposit_withdrawal").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        label2.setText(""+balance);

        setLayout(null);
        setSize(1300,730);
        getContentPane().setBackground(new Color(140, 140, 140));
        setLocation(-10,-5);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new main_Class(cardNo,pin);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("","");
    }
}