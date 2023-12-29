
package banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FundsTran extends JFrame implements ActionListener{
    String pinnumber;
    JButton back,trans;
    JTextField amount,acc_num;
    
    public FundsTran(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")); 
        Image im2=im1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon im3=new ImageIcon(im2);
        
        JLabel im=new  JLabel(im3);
        im.setBounds(0,0,900,900);
        add(im);
        
        JLabel tst=new JLabel("enter Receiver's ACCOUNT NUMBER");
        tst.setBounds(160,300,400,30);
        tst.setForeground(Color.WHITE);
        tst.setFont(new Font("raleway",Font.BOLD,15));
        im.add(tst);
        acc_num=new JTextField();
        acc_num.setBounds(160,350,200,30);
        acc_num.setForeground(Color.BLACK);
        acc_num.setFont(new Font("raleway",Font.BOLD,15));
        im.add(acc_num);
        im.add(acc_num);
        
        JLabel tst1=new JLabel("enter amount");
        tst1.setBounds(160,400,200,30);
        tst1.setForeground(Color.WHITE);
        tst1.setFont(new Font("raleway",Font.BOLD,15));
        im.add(tst1);
        
        amount=new JTextField();
        amount.setBounds(270,400,200,30);
        amount.setForeground(Color.BLACK);
        amount.setFont(new Font("raleway",Font.BOLD,15));
        im.add(amount);
        
        trans=new JButton("TRANSFER");
        trans.setBounds(200,450,100,30);
        trans.setBackground(Color.WHITE);
        trans.setForeground(Color.BLACK);
        trans.addActionListener(this);
        im.add(trans);
        
        back=new JButton("BACK");
        back.setBounds(350,450,100,30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        im.add(back);
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);      
        }else if(ae.getSource()==trans){
            Corn con=new Corn();
            String accountnum=acc_num.getText();
            int money=Integer.parseInt(amount.getText());
           try {
                ResultSet rw = con.s.executeQuery("SELECT * FROM bank WHERE pin='" + pinnumber + "'");
                int balance = 0;

                while (rw.next()) {
                    if (rw.getString("ttype").equals("Deposit")) {
                    balance += Integer.parseInt(rw.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rw.getString("amount"));
                }
            }

            balance -= money; 

            Date date = new Date();

            if ( balance < 0) {
            JOptionPane.showMessageDialog(null, "Insufficient Balance");
            } else {
            String query = "INSERT INTO bank VALUES('" + pinnumber + "','" + date + "','debit','" + money + "')";
            con.s.executeUpdate(query);

            ResultSet rt = con.s.executeQuery("SELECT * FROM login WHERE cardnumber='" + accountnum + "'");
            if (rt.next()) { 
            int pin = rt.getInt("pinnumber");
            String q2 = "INSERT INTO bank VALUES('" + pin + "','" + date + "','credit','" + money + "')";
            con.s.executeUpdate(q2);
            JOptionPane.showMessageDialog(null, money+" credited to "+accountnum);
            }
        }

        }  catch (Exception e) {
                e.printStackTrace(); 
        }

        }
        
    }
    public static void main(String args[]){
        new  FundsTran("");
    }
}
