package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup_2 extends JFrame implements ActionListener {
    String formNo;
    int yOffset=10;
    JComboBox comboBox, comboBox2, comboBox3, comboBox4, comboBox5;
    JTextField textPan, textAadhaar;
    JRadioButton yes, no, yes2, no2;
    JButton next,back;


    Signup_2(String formNo){
        super("APPLICATION FORM");
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setPreferredSize(new Dimension(850, 800));

        Color controller;//background controller
        controller=new Color(33, 243, 243);
        int r=controller.getRed();
        int g=controller.getGreen();
        int b=controller.getBlue();

        int r2,g2,b2,r3,g3,b3;
        Color controller2,controller3;//columns controller
        controller2=new Color(0, 0, 128);
        controller3=new Color(255,255,255);
        r2=controller2.getRed();
        g2=controller2.getGreen();
        b2=controller2.getBlue();
        r3=controller3.getRed();
        g3=controller3.getGreen();
        b3=controller3.getBlue();

        JLabel labelPage,labelAdditionalDtls,labelReligion,labelCategory,labelIncome,labelEdu,labelOccupation,labelPan,labelAadhaar,labelSenior,labelExisting,labelFormNo,labelRandNo;

        this.formNo = formNo;

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

        labelPage = new JLabel("Page 2");
        labelPage.setFont(new Font("Roboto", Font.BOLD,25));
        labelPage.setBounds(400,30,600,40);
        contentPanel.add(labelPage);

        labelAdditionalDtls = new JLabel("Additional Details");
        labelAdditionalDtls.setFont(new Font("Arial", Font.BOLD,25));
        labelAdditionalDtls.setBounds(335,70,600,40);
        contentPanel.add(labelAdditionalDtls);

        labelReligion = new JLabel("Religion :");
        labelReligion.setFont(new Font("Arial", Font.BOLD,18));
        labelReligion.setBounds(100,140+yOffset,100,20);
        contentPanel.add(labelReligion);

        String[] religion = {"Hindu","Muslim","Sikh", "Christian", "Other"};
        comboBox = new JComboBox(religion);
        comboBox.setBackground(new Color(r2,g2,b2));
        comboBox.setForeground(new Color(r3,g3,b3));
        //comboBox.setBorder(BorderFactory.createLineBorder(new Color(228, 37, 30)));
        comboBox.setFont(new Font("Arial",Font.BOLD,14));
        comboBox.setBounds(335,140+yOffset,320,30);
        contentPanel.add(comboBox);

        labelCategory = new JLabel("Category : ");
        labelCategory.setFont(new Font("Arial", Font.BOLD,18));
        labelCategory.setBounds(100,190+yOffset,100,30);
        add(labelCategory);


        String[] Category = {"General","OBC","SC", "ST", "Other"};
        comboBox2 = new JComboBox(Category);
        comboBox2.setBackground(new Color(r2,g2,b2));
        comboBox2.setForeground(new Color(r3,g3,b3));
        comboBox2.setFont(new Font("Arial",Font.BOLD,14));
        comboBox2.setBounds(335,190+yOffset,320,30);
        contentPanel.add(comboBox2);

        labelIncome = new JLabel("Income : ");
        labelIncome.setFont(new Font("Arial", Font.BOLD,18));
        labelIncome.setBounds(100,240+yOffset,100,30);
        contentPanel.add(labelIncome);

        String[] income = {"Nil","<1,50,000","<2,50,000", "5,00,000", "Up-to 10,00,000","Above 10,00,000"};
        comboBox3 = new JComboBox(income);
        comboBox3.setBackground(new Color(r2,g2,b2));
        comboBox3.setForeground(new Color(r3,g3,b3));
        comboBox3.setFont(new Font("Arial",Font.BOLD,14));
        comboBox3.setBounds(335,240+yOffset,320,30);
        contentPanel.add(comboBox3);

        labelEdu=new JLabel("Educational : ");
        labelEdu.setFont(new Font("Arial", Font.BOLD,18));
        labelEdu.setBounds(100,290+yOffset,150,30);
        contentPanel.add(labelEdu);

        String[] educational = {"Non-Graduate","Graduate","Post-Graduate", "Doctorate", "Others"};
        comboBox4 = new JComboBox(educational);
        comboBox4.setBackground(new Color(r2,g2,b2));
        comboBox4.setForeground(new Color(r3,g3,b3));
        comboBox4.setFont(new Font("Arial",Font.BOLD,14));
        comboBox4.setBounds(335,290+yOffset,320,30);
        contentPanel.add(comboBox4);


        labelOccupation = new JLabel("Occupation : ");
        labelOccupation.setFont(new Font("Arial", Font.BOLD,18));
        labelOccupation.setBounds(100,340+yOffset,150,30);
        contentPanel.add(labelOccupation);

        String[] Occupation = {"Salaried","Self-Employed","Business", "Student", "Retired", "Other"};
        comboBox5 = new JComboBox(Occupation);
        comboBox5.setBackground(new Color(r2,g2,b2));
        comboBox5.setForeground(new Color(r3,g3,b3));
        comboBox5.setFont(new Font("Arial",Font.BOLD,14));
        comboBox5.setBounds(335,340+yOffset,320,30);
        contentPanel.add(comboBox5);

        labelPan = new JLabel("PAN Number : ");
        labelPan.setFont(new Font("Arial", Font.BOLD,18));
        labelPan.setBounds(100,390+yOffset,150,30);
        contentPanel.add(labelPan);

        textPan = new JTextField();
        textPan.setFont(new Font("Arial", Font.BOLD,18));
        textPan.setBounds(335,390+yOffset,320,30);
        contentPanel.add(textPan);

        labelAadhaar = new JLabel("Aadhaar Number : ");
        labelAadhaar.setFont(new Font("Arial", Font.BOLD,18));
        labelAadhaar.setBounds(100,440+yOffset,180,30);
        contentPanel.add(labelAadhaar);

        textAadhaar = new JTextField();
        textAadhaar.setFont(new Font("Arial", Font.BOLD,18));
        textAadhaar.setBounds(335,440+yOffset,320,30);
        contentPanel.add(textAadhaar);


        labelSenior = new JLabel("Senior Citizen : ");
        labelSenior.setFont(new Font("Arial", Font.BOLD,18));
        labelSenior.setBounds(100,490+yOffset,180,30);
        contentPanel.add(labelSenior);

        yes = new JRadioButton("Yes");
        yes.setFont(new Font("Arial", Font.BOLD,14));
        yes.setBackground(new Color(r,g,b));
        yes.setBounds(335,490+yOffset,100,30);
        contentPanel.add(yes);
        no = new JRadioButton("No");
        no.setFont(new Font("Arial", Font.BOLD,14));
        no.setBackground(new Color(r,g,b));
        no.setBounds(460,490+yOffset,100,30);
        contentPanel.add(no);

        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(yes);
        buttonGroup1.add(no);

        labelExisting = new JLabel("Existing Account : ");
        labelExisting.setFont(new Font("Arial", Font.BOLD,18));
        labelExisting.setBounds(100,540+yOffset,180,30);
        contentPanel.add(labelExisting);

        yes2 = new JRadioButton("Yes");
        yes2.setFont(new Font("Arial", Font.BOLD,14));
        yes2.setBackground(new Color(r,g,b));
        yes2.setBounds(335,540+yOffset,100,30);
        contentPanel.add(yes2);

        no2 = new JRadioButton("No");
        no2.setFont(new Font("Arial", Font.BOLD,14));
        no2.setBackground(new Color(r,g,b));
        no2.setBounds(460,540+yOffset,100,30);
        contentPanel.add(no2);

        ButtonGroup buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(yes2);
        buttonGroup2.add(no2);

        next = new JButton("Next");
        next.setFont(new Font("Arial",Font.BOLD,14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setBounds(500,640+yOffset,150,30);
        next.addActionListener(this);
        contentPanel.add(next);

        back = new JButton("Back");
        back.setFont(new Font("Arial",Font.BOLD, 14));
        back.setBackground(Color.red);
        back.setForeground(Color.white);
        back.setBounds(250,640+yOffset,150,30);
        back.addActionListener(this);
        contentPanel.add(back);

        JLabel labelBack=new JLabel("(DISCLAIMER:--- Page1 Will Be Reset)");
        labelBack.setFont(new Font("Raleway",Font.BOLD,12));
        labelBack.setBounds(205,670+yOffset,500,20);
        contentPanel.add(labelBack);

        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);

        setSize(850,700);
        setLocation(225,10);
        contentPanel.setBackground(new Color(r,g,b));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new Signup();
            setVisible(false);
        }
        else{
                String rel = (String) comboBox.getSelectedItem();
                String cate = (String) comboBox2.getSelectedItem();
                String inc = (String) comboBox3.getSelectedItem();
                String edu = (String) comboBox4.getSelectedItem();
                String occ = (String) comboBox5.getSelectedItem();

                String pan = textPan.getText();
                String aadhaar = textAadhaar.getText();

                String sCitizen = null;
                if ((yes.isSelected())) {
                    sCitizen = "Yes";
                } else if (no.isSelected()) {
                    sCitizen = "No";
                }
                String eAccount = null;
                if ((yes2.isSelected())) {
                    eAccount = "Yes";
                } else if (no2.isSelected()) {
                    eAccount = "No";
                }

                try {
                    if (textPan.getText().isEmpty() || textAadhaar.getText().isEmpty()
                            || sCitizen==null || eAccount == null) {
                        JOptionPane.showMessageDialog(null, "Fill all the fields");
                    } else {
                Connect c = new Connect();
                String query2 =
                        "insert into Signuptwo values('" + formNo + "', '" + rel + "', '" + cate + "','" + inc + "','" +
                                edu + "','" + occ + "','" + pan + "','" + aadhaar + "','" + sCitizen + "','" + eAccount +
                                "')";
                c.statement.executeUpdate(query2);
                new Signup_3(formNo);
                setVisible(false);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }


        public static void main(String[] args){
                new Signup_2("");
            }
}
