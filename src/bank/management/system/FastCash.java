package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;
    int size;
    FastCash(String pin){
        super("Automated teller machine");
        this.pin =pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900,692,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(150,0,1000,700);
        add(l3);

        JLabel label = new JLabel("SELECT WITHDRAWAL AMOUNT");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 18));
        label.setBounds(240,260,400,35);
        l3.add(label);

        b1 = new JButton("₹ 100");
        b1.setForeground(new Color(255,255,255));
        b1.setFont(new Font("AOE", Font.BOLD,15));
        b1.setBackground(new Color(0, 0, 128));
        b1.setBounds(417,352,150,25);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("₹ 500");
        b2.setForeground(new Color(255,255,255));
        b2.setFont(new Font("AOE", Font.BOLD,15));
        b2.setBackground(new Color(0, 0, 128));
        b2.setBounds(206,352,150,25);
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("₹ 1000");
        b3.setForeground(new Color(32, 31, 31));
        b3.setFont(new Font("AOE", Font.BOLD,15));
        b3.setBackground(new Color(255, 215, 0));
        b3.setBounds(417,380,150,25);
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("₹ 2000");
        b4.setForeground(new Color(32, 31, 31));
        b4.setFont(new Font("AOE", Font.BOLD,15));
        b4.setBackground(new Color(255, 215, 0));
        b4.setBounds(206,380,150,25);
        b4.addActionListener(this);
        l3.add(b4);

        b5 = new JButton("₹ 5000");
        b5.setForeground(Color.WHITE);
        b5.setFont(new Font("AOE", Font.BOLD,15));
        b5.setBackground(new Color(27, 214, 12, 255));
        b5.setBounds(417,408,150,25);
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("₹ 10000");
        b6.setForeground(Color.WHITE);
        b6.setFont(new Font("AOE", Font.BOLD,15));
        b6.setBackground(new Color(27, 214, 12, 255));
        b6.setBounds(206,408,150,25);
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("BACK");
        b7.setForeground(new Color(32, 31, 31));
        b7.setFont(new Font("AOE", Font.BOLD,14));
        b7.setBackground(new Color(219, 31, 33));
        b7.setBounds(417,436,150,24);
        b7.addActionListener(this);
        l3.add(b7);

        setLayout(null);
        setSize(1300,730);
        getContentPane().setBackground(new Color(140, 140, 140));
        setLocation(-10,-5);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b7) {
            setVisible(false);
            new main_Class(pin);
        }else {
            size=((JButton)e.getSource()).getText().length();
            String amount = ((JButton)e.getSource()).getText().substring(2,size);
            Connect connect = new Connect();
            Date date = new Date();
            try{
                ResultSet resultSet = connect.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance =0;
                while (resultSet.next()){
                    if (resultSet.getString("deposit_withdrawal").equals("Withdrawal")){
                        balance -= Integer.parseInt(resultSet.getString("amount"));
                    }else {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }
                }

                if (e.getSource() != b7 && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                connect.statement.executeUpdate("insert into bank values('"+pin+"', '"+date+"','Withdrawal', '"+amount+
                        "', 'Dr')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
            }catch (Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new main_Class(pin);
        }


    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
