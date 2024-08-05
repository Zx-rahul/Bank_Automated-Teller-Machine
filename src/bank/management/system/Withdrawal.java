package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    String pin,cardNo;
    TextField textField;

    JButton b1, b2;
    Withdrawal(String cardNo,String pin){

        super("Automated teller machine");
        Color controller;//background controller
        controller=new Color(140, 140, 140);
        int r=controller.getRed();
        int g=controller.getGreen();
        int b=controller.getBlue();

        this.cardNo=cardNo;
        this.pin=pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900,692,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(150,0,1000,700);
        add(l3);

        JLabel label1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        label1.setForeground(Color.red);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setBounds(240,240,400,35);
        l3.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(240,265,400,35);
        l3.add(label2);

        JLabel labelRupees = new JLabel("₹");
        labelRupees.setForeground(Color.WHITE);
        labelRupees.setFont(new Font("Raleway", Font.BOLD, 18));
        labelRupees.setBounds(240,293,10,30);
        l3.add(labelRupees);

        textField = new TextField();
        textField.setBackground(new Color(29, 54, 200));
        textField.setForeground(Color.WHITE);
        textField.setBounds(260,295,150,30);
        textField.setFont(new Font("Raleway", Font.BOLD,20));
        l3.add(textField);

        b1 = new JButton("WITHDRAW");
        b1.setBounds(417,407,150,25);
        b1.setBackground(new Color(27, 214, 12, 255));
        b1.setForeground(Color.BLACK);
        b1.setFont(new Font("AOE", Font.BOLD,14));
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("CANCEL");
        b2.setBounds(417,436,150,24);
        b2.setBackground(new Color(246, 22, 10));
        b2.setForeground(Color.BLACK);
        b2.setFont(new Font("AOE", Font.BOLD,14));
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1300,730);
        getContentPane().setBackground(new Color(r,g,b));
        setLocation(-10,-5);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1) {
            try {
                String amount = textField.getText();
                Date date = new Date();
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount you want to withdraw","Invalid " +
                            "Input",JOptionPane.ERROR_MESSAGE);
                } else {
                    Connect connect = new Connect();
                    ResultSet resultSet =
                            connect.statement.executeQuery("select * from bank where card_number = '" + cardNo + "'");
                    int balance = 0;
                    while (resultSet.next()) {
                        if (resultSet.getString("deposit_withdrawal").equals("Deposit")) {
                            balance += Integer.parseInt(resultSet.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(resultSet.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    connect.statement.executeUpdate("insert into bank values('"+cardNo+"', '"+date+"','Withdrawal', '"+amount+
                            "', 'Dr')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                    setVisible(false);
                    new main_Class(cardNo,pin);

                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource()==b2) {
            setVisible(false);
            new main_Class(cardNo,pin);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("","");
    }
}