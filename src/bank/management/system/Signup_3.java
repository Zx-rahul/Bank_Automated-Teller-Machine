package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static java.awt.AWTEventMulticaster.add;

public class Signup_3 extends JFrame implements ActionListener {

    String formNo;
    JRadioButton savingAcc, fixedDepoAcc, currentAcc, recurrDepoAcc;
    JCheckBox atmCard, confirmation, internetBanking, mobileBanking, eMailAlerts, checkBook, eStatement;
    JButton submit, cancel;

    int yOffset=0;

    //4-digit card number
    int first4 = (int)(Math.random() * 9000) + 1000;
    String first4String = Integer.toString(first4);

    Signup_3(String formNo) {
        super("");
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setPreferredSize(new Dimension(850, 800));

        JLabel labelPage,labelAccountDtls,labelFormNo,labelRandNo;

        Color controller;//background controller
        controller=new Color(215,252,252);
        int r=controller.getRed();
        int g=controller.getGreen();
        int b=controller.getBlue();

        this.formNo=formNo;

        ImageIcon bank1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bank2=bank1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon bank3=new ImageIcon(bank2);
        JLabel bankImage=new JLabel(bank3);
        bankImage.setBounds(130,10,100,100);
        contentPanel.add(bankImage);

        labelFormNo = new JLabel("Form No : ");
        labelFormNo.setFont(new Font("Arial", Font.BOLD,14));
        labelFormNo.setBounds(695,10,100,30);
        contentPanel.add(labelFormNo);

        labelRandNo = new JLabel(this.formNo);
        labelRandNo.setFont(new Font("Arial", Font.BOLD,14));
        labelRandNo.setBounds(770,10,60,30);
        contentPanel.add(labelRandNo);

        labelPage = new JLabel("Page 3");
        labelPage.setFont(new Font("Roboto", Font.BOLD,25));
        labelPage.setBounds(400,30,600,40);
        contentPanel.add(labelPage);

        labelAccountDtls = new JLabel("Account Details");
        labelAccountDtls.setFont(new Font("Arial", Font.BOLD,25));
        labelAccountDtls.setBounds(345,70,600,40);
        contentPanel.add(labelAccountDtls);

        JLabel labelAccType = new JLabel("Account Type:");
        labelAccType.setFont(new Font("Arial",Font.BOLD,18));
        labelAccType.setBounds(100,150+yOffset,200,30);
        contentPanel.add(labelAccType);

        savingAcc = new JRadioButton("Saving Account");
        savingAcc.setFont(new Font("Arial",Font.BOLD,16));
        savingAcc.setBackground(new Color(r,g,b));
        savingAcc.setBounds(100,200+yOffset,150,30);
        contentPanel.add(savingAcc);

        fixedDepoAcc = new JRadioButton("Fixed Deposit Account");
        fixedDepoAcc.setFont(new Font("Arial",Font.BOLD,16));
        fixedDepoAcc.setBackground(new Color(r,g,b));
        fixedDepoAcc.setBounds(380,200+yOffset,300,30);
        contentPanel.add(fixedDepoAcc);

        currentAcc = new JRadioButton("Current Account");
        currentAcc.setFont(new Font("Arial",Font.BOLD,16));
        currentAcc.setBackground(new Color(r,g,b));
        currentAcc.setBounds(100,240+yOffset,250,30);
        contentPanel.add(currentAcc);

        recurrDepoAcc = new JRadioButton("Recurring Deposit Account");
        recurrDepoAcc.setFont(new Font("Arial",Font.BOLD,16));
        recurrDepoAcc.setBackground(new Color(r,g,b));
        recurrDepoAcc.setBounds(380,240+yOffset,250,30);
        contentPanel.add(recurrDepoAcc);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(savingAcc);
        buttonGroup.add(fixedDepoAcc);
        buttonGroup.add(currentAcc);
        buttonGroup.add(recurrDepoAcc);

        JLabel labelCardNo = new JLabel("Card Number:");
        labelCardNo.setFont(new Font("Arial",Font.BOLD,18));
        labelCardNo.setBounds(100,300,200,30);
        contentPanel.add(labelCardNo);

        JLabel labelCardNo2 = new JLabel("(Your 16-digit Card Number)");
        labelCardNo2.setFont(new Font("Arial",Font.BOLD,12));
        labelCardNo2.setBounds(100,330,200,20);
        contentPanel.add(labelCardNo2);

        JLabel labelDisplayCardNo = new JLabel("XXXX-XXXX-XXXX-"+first4String);
        labelDisplayCardNo.setFont(new Font("Arial",Font.BOLD,18));
        labelDisplayCardNo.setBounds(345,300,250,30);
        contentPanel.add(labelDisplayCardNo);

        JLabel l7 = new JLabel("(It would appear on atm card/cheque Book and Statements)");
        l7.setFont(new Font("Raleway",Font.BOLD,12));
        l7.setBounds(345,330,500,20);
        contentPanel.add(l7);

        JLabel l8 = new JLabel("PIN:");
        l8.setFont(new Font("Raleway",Font.BOLD,18));
        l8.setBounds(100,370,200,30);
        contentPanel.add(l8);

        JLabel l9 = new JLabel("XXXX");
        l9.setFont(new Font("Raleway",Font.BOLD,18));
        l9.setBounds(345,370,200,30);
        contentPanel.add(l9);

        JLabel l10 = new JLabel("(4-digit Password)");
        l10.setFont(new Font("Raleway",Font.BOLD,12));
        l10.setBounds(100,400,200,20);
        contentPanel.add(l10);

        JLabel l11 = new JLabel("Services Required:");
        l11.setFont(new Font("Raleway",Font.BOLD,18));
        l11.setBounds(100,450,200,30);
        contentPanel.add(l11);

        atmCard = new JCheckBox("ATM Card");
        atmCard.setBackground(new Color(r,g,b));
        atmCard.setFont(new Font("Arial",Font.BOLD,16));
        atmCard.setBounds(100,500,200,30);
        contentPanel.add(atmCard);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(new Color(r,g,b));
        internetBanking.setFont(new Font("Arial",Font.BOLD,16));
        internetBanking.setBounds(390,500,200,30);
        contentPanel.add(internetBanking);

        mobileBanking = new JCheckBox("Mobile Banking (UPI)");
        mobileBanking.setBackground(new Color(r,g,b));
        mobileBanking.setFont(new Font("Arial",Font.BOLD,16));
        mobileBanking.setBounds(100,550,200,30);
        contentPanel.add(mobileBanking);

        eMailAlerts = new JCheckBox("E-Mail Alerts");
        eMailAlerts.setBackground(new Color(r,g,b));
        eMailAlerts.setFont(new Font("Arial",Font.BOLD,16));
        eMailAlerts.setBounds(390,550,200,30);
        contentPanel.add(eMailAlerts);

        checkBook = new JCheckBox("Cheque Book");
        checkBook.setBackground(new Color(r,g,b));
        checkBook.setFont(new Font("Arial",Font.BOLD,16));
        checkBook.setBounds(100,600,200,30);
        contentPanel.add(checkBook);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setBackground(new Color(r,g,b));
        eStatement.setFont(new Font("Arial",Font.BOLD,16));
        eStatement.setBounds(390,600,200,30);
        contentPanel.add(eStatement);

        confirmation = new JCheckBox("I here by declare that the above entered details correct to the best of my knlowledge.",true);
        confirmation.setBackground(new Color(r,g,b));
        confirmation.setFont(new Font("Arial",Font.BOLD,12));
        confirmation.setBounds(100,680,600,20);
        contentPanel.add(confirmation);


        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.BOLD,14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        contentPanel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.BOLD,14));
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        contentPanel.add(cancel);

        JLabel labelCancel=new JLabel("(DISCLAIMER:--- You Will Exit)");
        labelCancel.setFont(new Font("Raleway",Font.BOLD,12));
        labelCancel.setBounds(380,750+yOffset,500,20);
        contentPanel.add(labelCancel);


        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

        setSize(850,700);
        setLocation(225,10);
        contentPanel.setBackground(new Color(r,g,b));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String confirm="ok";
        if (!confirmation.isSelected()){
            confirm=null;
        }
        String accType = null;
        if (savingAcc.isSelected()){
            accType = "Saving Account";
        } else if (fixedDepoAcc.isSelected()) {
            accType ="Fixed Deposit Account";
        }else if (currentAcc.isSelected()){
            accType ="Current Account";
        }else if (recurrDepoAcc.isSelected()){
            accType ="Recurring Deposit Account";
        }

        Random ran = new Random();
        //5 digits random
        long remaining5Digits = (ran.nextLong() % 90000L) + 10000L;
        String remaining5String = Long.toString(Math.abs(remaining5Digits));

        // Combine the bank code to form the card number
        String cardNo = "1409963" + remaining5String + first4String;


        // Generate a 4-digit PIN
        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        StringBuilder facility = new StringBuilder();
        if(atmCard.isSelected()){
            facility.append("ATM Card");
        }
        if (internetBanking.isSelected()) {
            if (!facility.isEmpty()) {
                facility.append(" ");
            }
            facility.append("Internet Banking");
        }
        if (mobileBanking.isSelected()) {
            if (!facility.isEmpty()) {
                facility.append(" ");
            }
            facility.append("Mobile Banking");
        }
        if (eMailAlerts.isSelected()) {
            if (!facility.isEmpty()) {
                facility.append(" ");
            }
            facility.append("E-mail Alerts");
        }
        if (checkBook.isSelected()) {
            if (!facility.isEmpty()) {
                facility.append(" ");
            }
            facility.append("Cheque Book");
        }
        if (eStatement.isSelected()) {
            if (!facility.isEmpty()) {
                facility.append(" ");
            }
            facility.append("E-Statement");
        }


        try {
            if (e.getSource()== submit){
                if (accType == null || facility.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Fill all the fields");
                } else if (confirm==null) {
                    JOptionPane.showMessageDialog(null,"Check on the Declaration checkbox");
                } else {
                    Connect connect = new Connect();
                    String q1 = "insert into signupthree values('"+formNo+"', '"+accType+"','"+cardNo+"','"+pin+"','"+facility+"')";
                    String q2 = "insert into login values('"+formNo+"','"+cardNo+"','"+pin+"')";
                    connect.statement.executeUpdate(q1);
                    connect.statement.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null,"Card Number : "+cardNo+"\n Pin : "+pin );
                    new Deposit(cardNo,pin);
                    setVisible(false);
                }
            } else if (e.getSource()== cancel) {
                System.exit(0);
            }

        }catch (Exception E){
            E.printStackTrace();
        }

    }



public static void main(String[] args) {
        new Signup_3("3287");
    }
}
