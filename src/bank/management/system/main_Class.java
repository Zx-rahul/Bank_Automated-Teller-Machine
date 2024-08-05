package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Class extends JFrame implements ActionListener {
    JButton deposit, cashOut, fastCash, miniState, pinChange, balanceEnquiry, exit;
    String cardNo,pin;
    main_Class(String cardNo,String pin){
        super("Automated teller machine");


        Color controller;//background controller
        controller=new Color(140, 140, 140);
        int r=controller.getRed();
        int g=controller.getGreen();
        int b=controller.getBlue();

        this.pin=pin;
        this.cardNo = cardNo;

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image image2 = image1.getImage().getScaledInstance(900,692,Image.SCALE_DEFAULT);
        ImageIcon imageAtm = new ImageIcon(image2);
        JLabel atmImage = new JLabel(imageAtm);
        atmImage.setBounds(150,0,1000,700);
        add(atmImage);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(230,250,500,25);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,20));
        atmImage.add(label);

        cashOut = new JButton("CASH WITHDRAWAL");
        cashOut.setForeground(new Color(32, 31, 31));
        cashOut.setFont(new Font("AOE", Font.BOLD,11));
        cashOut.setBackground(Color.cyan);
        cashOut.setBounds(206,350,150,25);
        cashOut.addActionListener(this);
        atmImage.add(cashOut);

        fastCash = new JButton("FAST CASH");
        fastCash.setForeground(new Color(32, 31, 31));
        fastCash.setFont(new Font("AOE", Font.BOLD,12));
        fastCash.setBackground(Color.cyan);
        fastCash.setBounds(418,350,150,25);
        fastCash.addActionListener(this);
        atmImage.add(fastCash);

        deposit = new JButton("DEPOSIT");
        deposit.setForeground(new Color(255,255,255));
        deposit.setFont(new Font("AOE", Font.BOLD,12));
        deposit.setBackground(Color.magenta);
        deposit.setBounds(418,379,150,25);
        deposit.addActionListener(this);
        atmImage.add(deposit);

        miniState = new JButton("MINI STATEMENT");
        miniState.setForeground(new Color(255,255,255));
        miniState.setFont(new Font("AOE", Font.BOLD,12));
        miniState.setBackground(Color.magenta);
        miniState.setBounds(206,379,150,25);
        miniState.addActionListener(this);
        atmImage.add(miniState);

        pinChange = new JButton("PIN CHANGE");
        pinChange.setForeground(new Color(32, 31, 31));
        pinChange.setFont(new Font("AOE", Font.BOLD,12));
        pinChange.setBackground(Color.orange);
        pinChange.setBounds(418,408,150,25);
        pinChange.addActionListener(this);
        atmImage.add(pinChange);

        balanceEnquiry = new JButton("BALANCE ENQUIRY");
        balanceEnquiry.setForeground(new Color(32, 31, 31));
        balanceEnquiry.setFont(new Font("AOE", Font.BOLD,11));
        balanceEnquiry.setBackground(Color.orange);
        balanceEnquiry.setBounds(206,408,150,25);
        balanceEnquiry.addActionListener(this);
        atmImage.add(balanceEnquiry);

        exit = new JButton("EXIT");
        exit.setForeground(new Color(255,255,255));
        exit.setFont(new Font("AOE", Font.BOLD,12));
        exit.setBackground(new Color(219, 31, 33));
        exit.setBounds(418,437,150,24);
        exit.addActionListener(this);
        atmImage.add(exit);

        setLayout(null);
        setSize(1300,730);
        getContentPane().setBackground(new Color(r,g,b));
        setLocation(-10,-5);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== deposit){
            new Deposit(cardNo,pin);
            setVisible(false);
        }else if (e.getSource()== exit){
            System.exit(0);
        } else if (e.getSource()== cashOut) {
            new Withdrawal(cardNo,pin);
            setVisible(false);
        } else if (e.getSource()== balanceEnquiry) {
            new BalanceEnquiry(cardNo,pin);
            setVisible(false);
        } else if (e.getSource()== fastCash) {
            new FastCash(cardNo,pin);
            setVisible(false);
        } else if (e.getSource()== pinChange) {
            new Pin(pin,cardNo);
            setVisible(false);
        } else if (e.getSource()== miniState) {
            new Mini(cardNo,pin);
        }
    }

    public static void main(String[] args) {
        new main_Class("","");
    }
}
