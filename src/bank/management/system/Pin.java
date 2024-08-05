
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class Pin extends JFrame implements ActionListener {
        JButton b1,b2;
        JPasswordField p1,p2;
        String pin,cardNo;
        Pin(String pin,String cardNo){
            super("Automated teller machine");
            this.pin =pin;
            this.cardNo =cardNo;

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
            Image i2 = i1.getImage().getScaledInstance(900,692,Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel l3 = new JLabel(i3);
            l3.setBounds(150,0,1000,700);
            add(l3);

            JLabel label1 = new JLabel("CHANGE YOUR PIN");
            label1.setForeground(Color.WHITE);
            label1.setFont(new Font("System", Font.BOLD, 16));
            label1.setBounds(240,260,400,35);//430,180,400,35
            l3.add(label1);


            JLabel label2 = new JLabel("New PIN: ");
            label2.setForeground(Color.WHITE);
            label2.setFont(new Font("System", Font.BOLD, 16));
            label2.setBounds(240,300,150,35);
            l3.add(label2);

            p1 = new JPasswordField();
            p1.setBackground(new Color(29, 54, 200));
            p1.setForeground(Color.WHITE);
            p1.setBounds(410,302,80,25);
            p1.setFont(new Font("Raleway", Font.BOLD,22));
            l3.add(p1);

            JLabel label3 = new JLabel("Re-Enter New PIN: ");
            label3.setForeground(Color.WHITE);
            label3.setFont(new Font("System", Font.BOLD, 16));
            label3.setBounds(240,340,400,35);
            l3.add(label3);

            p2 = new JPasswordField();
            p2.setBackground(new Color(29, 54, 200));
            p2.setForeground(Color.WHITE);
            p2.setBounds(410,342,80,25);
            p2.setFont(new Font("Raleway", Font.BOLD,22));
            l3.add(p2);



            b1 = new JButton("CHANGE");
            b1.setBounds(417,408,150,25);
            b1.setForeground(new Color(228, 228, 228));
            b1.setFont(new Font("AOE", Font.BOLD,14));
            b1.setBackground(new Color(27, 214, 12));
            b1.addActionListener(this);
            l3.add(b1);

            b2 = new JButton("BACK");
            b2.setBounds(417,436,150,24);
            b2.setForeground(new Color(32, 31, 31));
            b2.setFont(new Font("AOE", Font.BOLD,14));
            b2.setBackground(new Color(219, 31, 33));
            b2.addActionListener(this);
            l3.add(b2);



            setLayout(null);
            setSize(1300,730);
            getContentPane().setBackground(new Color(140, 140, 140));
            setLocation(-10,-5);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            try{
                String pin1 = p1.getText();
                String pin2 = p2.getText();



                if (e.getSource()==b1){

                    if (p1.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Enter New PIN");
                        return;
                    }
                    if (p2.getText().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Re-Enter New PIN");
                        return;
                    }

                    if (!pin1.equals(pin2)){
                        JOptionPane.showMessageDialog(null,"Entered PIN does not match","Invalid Input",JOptionPane.ERROR_MESSAGE);
                        p1.setText("");
                        p2.setText("");
                        return;
                    } else if (pin1.length()!=4) {
                        JOptionPane.showMessageDialog(null,"Enter a 4-digit PIN","Invalid Input",
                                JOptionPane.ERROR_MESSAGE);
                        p1.setText("");
                        p2.setText("");
                        return;
                    }

                    Connect connect = new Connect();
                    //String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"'";
                    String query1 = "update login set pin = '"+pin1+"' where pin = '"+pin+"'";
                    String query2 = "update signupthree set pin = '"+pin1+"' where pin = '"+pin+"'";

                    //connect.statement.executeUpdate(q1);
                    connect.statement.executeUpdate(query1);
                    connect.statement.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"PIN changed successfully");
                    setVisible(false);
                    new main_Class(cardNo,pin);

                } else if (e.getSource()==b2) {
                    new main_Class(cardNo,pin);
                    setVisible(false);
                }


            }catch (Exception E){
                E.printStackTrace();
            }

        }

        public static void main(String[] args) {
            new Pin("","");
        }
    }
