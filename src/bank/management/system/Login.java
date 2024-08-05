package bank.management.system;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JLabel labelATM, labelCardNo, labelPin;
    JTextField textField2;
    JPasswordField passwordField3;
    JButton buttonSignIN, buttonClear, buttonSignUP;
    Login(){
        super("Bank Management System");
        setLayout(null);

        ImageIcon back1=new ImageIcon(ClassLoader.getSystemResource("icon/background.png"));
        Image back2=back1.getImage().getScaledInstance(850,480,Image.SCALE_DEFAULT);
        ImageIcon back3=new ImageIcon(back2);
        JLabel background=new JLabel(back3);
        background.setBounds(0,0,850,480);
        add(background);


        ImageIcon bank1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bank2=bank1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon bank3=new ImageIcon(bank2);
        JLabel bankImage=new JLabel(bank3);
        bankImage.setBounds(350,10,100,100);
        background.add(bankImage);


        ImageIcon card1=new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image card2=card1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon card3=new ImageIcon(card2);
        JLabel cardImage=new JLabel(card3);
        cardImage.setBounds(650,350,100,100);
        background.add(cardImage);


        labelATM = new JLabel("WELCOME TO ATM");
        labelATM.setForeground(Color.WHITE);
        labelATM.setFont(new Font("Helvetica",Font.BOLD,38));
        labelATM.setBounds(225,125,450,40);
        background.add(labelATM);


        labelCardNo = new JLabel("Card No: ");
        labelCardNo.setForeground(new Color(255, 215, 0));
        labelCardNo.setFont(new Font("Arial",Font.BOLD,24));
        labelCardNo.setBounds(150,210,375,30);
        background.add(labelCardNo);

        textField2 = new JTextField(15);
        textField2.setBackground(Color.WHITE);
        textField2.setForeground(Color.BLACK);
        textField2.setBounds(300,210,230,30);
        textField2.setFont(new Font("Roboto",Font.BOLD,14));
        ((AbstractDocument) textField2.getDocument()).setDocumentFilter(new NumericDocumentFilter(16));
        background.add(textField2);
        background.add(textField2);


        labelPin = new JLabel("PIN: ");
        labelPin.setForeground(new Color(255, 215, 0));
        labelPin.setFont(new Font("Arial",Font.BOLD,24));
        labelPin.setBounds(150,270,375,24);
        background.add(labelPin);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBackground(Color.WHITE);
        passwordField3.setForeground(Color.BLACK);
        passwordField3.setBounds(300,270,230,30);
        passwordField3.setFont(new Font("Roboto",Font.BOLD,14));
        ((AbstractDocument) passwordField3.getDocument()).setDocumentFilter(new NumericDocumentFilter(4));
        background.add(passwordField3);

        buttonSignIN = new JButton("SIGN IN");
        buttonSignIN.setFont(new Font("Arial",Font.BOLD,14));
        buttonSignIN.setBackground(new Color(27, 214, 12, 255));
        buttonSignIN.setForeground(Color.BLACK);
        buttonSignIN.setBounds(250,320,100,30);
        buttonSignIN.addActionListener(this);
        background.add(buttonSignIN);

        buttonClear = new JButton("CLEAR");
        buttonClear.setFont(new Font("Arial",Font.BOLD,14));
        buttonClear.setBackground(new Color(235, 39, 32, 255));
        buttonClear.setForeground(Color.BLACK);
        buttonClear.setBounds(380,320,100,30);
        buttonClear.addActionListener(this);
        background.add(buttonClear);

        buttonSignUP = new JButton("SIGN UP");
        buttonSignUP.setFont(new Font("Arial",Font.BOLD,14));
        buttonSignUP.setBackground(new Color(255, 215, 0));
        buttonSignUP.setForeground(Color.BLACK);
        buttonSignUP.setBounds(250,370,230,30);
        buttonSignUP.addActionListener(this);
        background.add(buttonSignUP);

        //setLayout(null);
        setSize(850,480);
        setLocation(225,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == buttonSignIN) {
                Connect connect = new Connect();
                String cardNo = textField2.getText();
                String pin = passwordField3.getText();
                String query = "select * from login where card_number = '" + cardNo + "' and  pin = '" + pin + "'";
                ResultSet resultSet = connect.statement.executeQuery(query);
                if (resultSet.next()) {
                    setVisible(false);
                    new main_Class(cardNo,pin);
                }else {
                    JOptionPane.showMessageDialog(null, "Enter the correct credentials.", "Invalid Input",
                            JOptionPane.ERROR_MESSAGE);
                    textField2.setText("");
                    passwordField3.setText("");
                }
            } else if (e.getSource() == buttonClear) {
                    textField2.setText("");
                    passwordField3.setText("");
            } else if (e.getSource() == buttonSignUP) {
                    new Signup();
                    setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
class NumericDocumentFilter extends DocumentFilter {
    private final int maxDigits;

    public NumericDocumentFilter(int maxDigits) {
        this.maxDigits = maxDigits;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string != null && string.matches("\\d*")) {
            int newLength = fb.getDocument().getLength() + string.length();
            if (newLength <= maxDigits) {
                super.insertString(fb, offset, string, attr);
            }
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text != null && text.matches("\\d*")) {
            int newLength = fb.getDocument().getLength() - length + text.length();
            if (newLength <= maxDigits) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length);
    }
}