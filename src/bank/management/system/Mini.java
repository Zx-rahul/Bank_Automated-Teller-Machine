package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini extends JFrame implements ActionListener {
    String pin;
    JButton button;
    Mini(String pin){
        super("Automated teller machine");
        this.pin = pin;
        getContentPane().setBackground(new Color(235, 87, 41));//255,204,204
        setSize(400,600);
        setLocation(-5,0);
        setLayout(null);

        JLabel label1 = new JLabel();
        label1.setBounds(20,140,400,200);
        add(label1);

        JLabel label2 = new JLabel("YCYCY BANK");
        label2.setFont(new Font("System", Font.BOLD,20));
        label2.setBounds(125,20,200,20);
        add(label2);

        JLabel label3 = new JLabel();
        label3.setBounds(20,80,300,20);
        add(label3);

        JLabel label4 = new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);

        try{
            Connect connect = new Connect();
            ResultSet resultSet = connect.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while (resultSet.next()){
                label3.setText("Card Number:  "+ resultSet.getString("card_number").substring(0,4) + "XXXXXXXX"+ resultSet.getString("card_number").substring(12));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }

        try{
            int balance =0;
            Connect connect2 = new Connect();
            ResultSet resultSet = connect2.statement.executeQuery("select * from bank where pin = '"+pin+"'");
            StringBuilder transactionHistory = new StringBuilder("<html>");  // Use StringBuilder for efficiency

            while (resultSet.next()) {
                String date = resultSet.getString("date");
                String type = resultSet.getString("deposit_withdrawal");
                String amount = resultSet.getString("amount");

                transactionHistory.append(date)
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(type)
                        .append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(amount)
                        .append("<br><br>");

                if (type.equals("Deposit")) {
                    balance += Integer.parseInt(amount);
                } else if (type.equals("Withdrawal")) {
                    balance -= Integer.parseInt(amount);
                } else
                    balance -= Integer.parseInt(amount);
                }

            transactionHistory.append("</html>");
            label1.setText(label1.getText() + transactionHistory.toString());
            /*if (resultSet.next()) {  // Move to the first row
                label1.setText(label1.getText() + "<html>" + resultSet.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("deposit_withdrawal") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount") + "<br><br><html>");

            }

            while (resultSet.next()) {
                if (resultSet.getString("deposit_withdrawal").equals("Deposit")) {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                }
            }*/
            label4.setText("Your Total Balance is Rs "+balance);
        }catch (Exception e){
            e.printStackTrace();
        }

        button = new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new Mini("");
    }
}
