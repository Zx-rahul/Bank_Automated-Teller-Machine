package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class Signup extends JFrame implements ActionListener {

    JRadioButton male, female, others, married,single , special;
    int first4 = (int)(Math.random() * 9000) + 1000; // Generates a random number between 1000 and 9999
    String first = Integer.toString(first4);
    JTextField textName , textFatherName, textEmail,textAdd, textCity,textState,textPin;
    JDateChooser calendar;
    JButton next, cancel;

    int yOffset=2;

    Signup(){
        super ("APPLICATION FORM");
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setPreferredSize(new Dimension(850, 800));


        Color controller;
        controller=new Color(109, 243, 212);
        int r=controller.getRed();
        int g=controller.getGreen();
        int b=controller.getBlue();

        JLabel labelForm,labelPage,labelPersonalDtls,labelMs,
                labelName,labelFatherName,labelDOB,labelGender,labelEmail;


        ImageIcon bank1=new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bank2=bank1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon bank3=new ImageIcon(bank2);
        JLabel bankImage=new JLabel(bank3);
        bankImage.setBounds(25,10,100,100);
        contentPanel.add(bankImage);

        labelForm=new JLabel("APPLICATION FORM NO. "+first);
        labelForm.setBounds(160,20,600,40);
        labelForm.setFont(new Font("Raleway",Font.BOLD,38));
        contentPanel.add(labelForm);

        labelPage=new JLabel("Page 1");
        labelPage.setBounds(350,80,600,30);
        labelPage.setFont(new Font("Roboto", Font.BOLD,25  ));
        contentPanel.add(labelPage);

        labelPersonalDtls=new JLabel("Personal Details");
        labelPersonalDtls.setBounds(295,120+yOffset,600,30);
        labelPersonalDtls.setFont(new Font("Arial",Font.BOLD,25  ));
        contentPanel.add(labelPersonalDtls);

        labelName=new JLabel("Name :");
        labelName.setBounds(100,190+yOffset,100,30);
        labelName.setFont(new Font("Arial",Font.BOLD,20  ));
        contentPanel.add(labelName);

        textName=new JTextField(15);
        textName.setBackground(Color.WHITE);
        textName.setForeground(Color.BLACK);
        textName.setBounds(300,190+yOffset,400,30);
        textName.setFont(new Font("Roboto",Font.BOLD,17)  );
        contentPanel.add(textName);

        labelFatherName=new JLabel("Father's Name :");
        labelFatherName.setBounds(100,240+yOffset,200,30);
        labelFatherName.setFont(new Font("Arial",Font.BOLD,20  ));
        contentPanel.add(labelFatherName);

        textFatherName =new JTextField(15);
        textFatherName.setBackground(Color.WHITE);
        textFatherName.setForeground(Color.BLACK);
        textFatherName.setBounds(300,240+yOffset,400,30);
        textFatherName.setFont(new Font("Roboto",Font.BOLD,17)  );
        contentPanel.add(textFatherName);

        labelGender=new JLabel("Gender :");
        labelGender.setBounds(100,290+yOffset,200,30);
        labelGender.setFont(new Font("Arial",Font.BOLD,20  ));
        contentPanel.add(labelGender);

        male =new JRadioButton("Male");
        male.setBounds(300,290+yOffset,60,30);
        male.setFont(new Font("Arial",Font.BOLD,14));
        male.setBackground(new Color(r, g, b));
        male.setForeground(Color.black);
        contentPanel.add(male);

        female =new JRadioButton("Female");
        female.setBounds(440,290+yOffset,90,30);
        female.setFont(new Font("Arial",Font.BOLD,14));
        female.setBackground(new Color(r, g, b));
        female.setForeground(Color.black);
        contentPanel.add(female);

        others =new JRadioButton("Others");
        others.setBounds(600,290+yOffset,90,30);
        others.setFont(new Font("Arial",Font.BOLD,14));
        others.setBackground(new Color(r, g, b));
        others.setForeground(Color.black);
        contentPanel.add(others);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(male);
        buttonGroup.add(female);
        buttonGroup.add(others);

        labelDOB=new JLabel("Date of Birth :");
        labelDOB.setBounds(100,340+yOffset,200,30);
        labelDOB.setFont(new Font("Arial",Font.BOLD,20  ));
        contentPanel.add(labelDOB);

        calendar =new JDateChooser();
        calendar.setBounds(300,340+yOffset,400,30);
        calendar.setForeground(new Color(192, 192, 192));
        calendar.setBackground(new Color(60, 63, 65));
        contentPanel.add(calendar);

        // Calculate the date 12 years ago from today
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -12);
        Date maxDate = cal.getTime();

        // Set the minimum selectable date
        calendar.setMaxSelectableDate(maxDate);

        labelEmail=new JLabel("Email Address :");
        labelEmail.setBounds(100,390+yOffset,200,30);
        labelEmail.setFont(new Font("Arial",Font.BOLD,20  ));
        contentPanel.add(labelEmail);

        textEmail =new JTextField(15);
        textEmail.setBackground(Color.WHITE);
        textEmail.setForeground(Color.BLACK);
        textEmail.setBounds(300,390+yOffset,400,30);
        textEmail.setFont(new Font("Roboto",Font.BOLD,17)  );
        contentPanel.add(textEmail);

        labelMs=new JLabel("Marital Status :");
        labelMs.setBounds(100,440+yOffset,200,30);
        labelMs.setFont(new Font("Arial",Font.BOLD,20  ));
        contentPanel.add(labelMs);

        married = new JRadioButton("Married");
        married.setBounds(300,440+yOffset,100,30);
        married.setBackground(new Color(r, g, b));
        married.setFont(new Font("Arial", Font.BOLD,14));
        contentPanel.add(married);

        single = new JRadioButton("Unmarried");
        single.setBackground(new Color(r, g, b));
        single.setBounds(440,440+yOffset,100,30);
        single.setFont(new Font("Arial", Font.BOLD,14));
        contentPanel.add(single);

        special = new JRadioButton("Others");
        special.setBackground(new Color(r, g, b));
        special.setBounds(600,440+yOffset,100,30);
        special.setFont(new Font("Arial", Font.BOLD,14));
        contentPanel.add(special);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(married);
        buttonGroup1.add(single);
        buttonGroup1.add(special);

        JLabel labelAdd = new JLabel("Address :");
        labelAdd.setFont(new Font("Arial", Font.BOLD, 20));
        labelAdd.setBounds(100,490+yOffset,200,30);
        contentPanel.add(labelAdd);

        textAdd =new JTextField(15);
        textAdd.setBackground(Color.WHITE);
        textAdd.setForeground(Color.BLACK);
        textAdd.setBounds(300,490+yOffset,400,30);
        textAdd.setFont(new Font("Roboto",Font.BOLD,17)  );
        contentPanel.add(textAdd);

        JLabel labelCity = new JLabel("City :");
        labelCity.setFont(new Font("Arial", Font.BOLD, 20));
        labelCity.setBounds(100,540+yOffset,200,30);
        contentPanel.add(labelCity);

        textCity =new JTextField(15);
        textCity.setBackground(Color.WHITE);
        textCity.setForeground(Color.BLACK);
        textCity.setBounds(300,540+yOffset,400,30);
        textCity.setFont(new Font("Roboto",Font.BOLD,17)  );
        contentPanel.add(textCity);

        JLabel labelPin = new JLabel("Pin Code :");
        labelPin.setFont(new Font("Arial", Font.BOLD, 20));
        labelPin.setBounds(100,590+yOffset,200,30);
        contentPanel.add(labelPin);

        textPin = new JTextField(15);
        textPin.setBackground(Color.WHITE);
        textPin.setForeground(Color.BLACK);
        textPin.setBounds(300,590+yOffset,400,30);
        textPin.setFont(new Font("Roboto",Font.BOLD, 17));
        contentPanel.add(textPin);

        JLabel labelState = new JLabel("State :");
        labelState.setFont(new Font("Arial", Font.BOLD, 20));
        labelState.setBounds(100,640+yOffset,200,30);
        contentPanel.add( labelState);

        textState = new JTextField();
        textState.setFont(new Font("Roboto",Font.BOLD, 17));
        textState.setBounds(300,640+yOffset,400,30);
        contentPanel.add(textState);

        next = new JButton("Next");
        next.setFont(new Font("Arial",Font.BOLD, 14));
        next.setBackground(new Color(16, 15, 15));
        next.setForeground(Color.white);
        next.setBounds(550,710+yOffset,150,30);
        next.addActionListener(this);
        contentPanel.add(next);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial",Font.BOLD, 14));
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.white);
        cancel.setBounds(300,710+yOffset,150,30);
        cancel.addActionListener(this);
        contentPanel.add(cancel);


        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);


        contentPanel.setBackground(new Color(r, g, b));
        setSize(850, 700);
        setLocation(225, 10);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource()== cancel) {
            new Login();
            setVisible(false);
        }else
        {
        String formNo = first;
        String name = textName.getText();
        String fName = textFatherName.getText();
        String dob = ((JTextField) calendar.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (others.isSelected()) {
            gender = "Others";
        }
        String email = textEmail.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "Married";
        } else if (single.isSelected()) {
            marital = "Unmarried";
        } else if (special.isSelected()) {
            marital = "Others";
        }
        String address = textAdd.getText();
        String city = textCity.getText();
        String pinCode = textPin.getText();
        String state = textState.getText();
        try {
            if (textName.getText().isEmpty()
                    || textFatherName.getText().isEmpty() ||
                    ((JTextField) calendar.getDateEditor().getUiComponent()).getText().isEmpty()
                    || textAdd.getText().isEmpty() || textCity.getText().isEmpty()
                    || textPin.getText().isEmpty() || textState.getText().isEmpty()
                    || gender == null || marital == null) {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            } else {
                Connect connect1 = new Connect();
                String query =
                        "insert into signup values('" + formNo + "', '" + name + "','" + fName + "','" + dob + "','" +
                                gender + "','" + email +
                                "','" + marital + "', '" + address + "', '" + city + "','" + pinCode + "','" + state +
                                "' )";
                connect1.statement.executeUpdate(query);
                new Signup_2(first);
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
