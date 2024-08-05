package bank.management.system;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String cardNo,pin;
    NumberRestrictedTextField textRupees;
    JButton deposit, cancel;
    Deposit(String cardNo,String pin){

        super("Automated teller machine");
        Color controller;//background controller
        controller=new Color(140, 140, 140);
        int r=controller.getRed();
        int g=controller.getGreen();
        int b=controller.getBlue();

        this.pin = pin;
        this.cardNo = cardNo;

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image image2 = image1.getImage().getScaledInstance(900,692,Image.SCALE_DEFAULT);
        ImageIcon imageAtm = new ImageIcon(image2);
        JLabel atmImage = new JLabel(imageAtm);
        atmImage.setBounds(150,0,1000,700);
        add(atmImage);

        JLabel amountDeposit = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        amountDeposit.setForeground(Color.WHITE);
        amountDeposit.setFont(new Font("System", Font.BOLD, 16));
        amountDeposit.setBounds(370,240,400,35);
        atmImage.add(amountDeposit);

        JLabel labelRupees = new JLabel("₹");
        labelRupees.setForeground(Color.WHITE);
        labelRupees.setFont(new Font("Raleway", Font.BOLD, 18));
        labelRupees.setBounds(370,268,10,30);
        atmImage.add(labelRupees);

        textRupees = new NumberRestrictedTextField();
        textRupees.setBackground(new Color(29, 54, 200));
        textRupees.setForeground(Color.WHITE);
        textRupees.setBounds(390,270,150,30);
        textRupees.setFont(new Font("Arial", Font.BOLD,20));
        atmImage.add(textRupees);


        deposit = new JButton("DEPOSIT");
        deposit.setBounds(558,404,150,25);
        deposit.setBackground(new Color(50, 194, 10));
        deposit.setForeground(new Color(37, 11, 11));
        deposit.setFont(new Font("AOE", Font.BOLD,16));
        deposit.addActionListener(this);
        atmImage.add(deposit);

        cancel = new JButton("CANCEL");
        cancel.setBounds(558,432,150,24);
        cancel.setBackground(new Color(218, 7, 9));
        cancel.setForeground(new Color(32, 31, 31));
        cancel.setFont(new Font("AOE", Font.BOLD,16));
        cancel.addActionListener(this);
        atmImage.add(cancel);


        setSize(1300,730);
        setLocation(-10,-5);
        getContentPane().setBackground(new Color(r,g,b));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String amount = textRupees.getText();
            Date date = new Date();
            if (e.getSource()== deposit){
                if (amount.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter the Amount you want to Deposit");
                } else if (Long.parseLong(textRupees.getText()) <= 200) {
                    JOptionPane.showMessageDialog(null, "The value must be greater than 200.", "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                    textRupees.setText("");  // Clear the field if the value is invalid
                } else {
                    Connect connect = new Connect();
                    connect.statement.executeUpdate("insert into bank values('"+ cardNo +"', '"+date+"','Deposit', '"+amount+"', 'Cr')");
                    JOptionPane.showMessageDialog(null,"Rs. "+amount+" Deposited Successfully");
                    setVisible(false);
                    new main_Class(cardNo,pin);
                }
            }else if (e.getSource()== cancel){
                setVisible(false);
                new main_Class(cardNo,pin);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Deposit("","");
    }
}


class NumberRestrictedTextField extends JTextField {

    public NumberRestrictedTextField() {
        super();
        ((AbstractDocument) this.getDocument()).setDocumentFilter(new NumberFilter());
    }

    class NumberFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
            if (string.matches("\\d*")) {  // Allow only digits
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
            if (text.matches("\\d*")) {  // Allow only digits
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
}