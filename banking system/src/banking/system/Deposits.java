
package banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposits extends JFrame implements ActionListener{
    JButton deposit,back;
    JTextField amoun;
    String pinnumber;
    Deposits(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel j1=new JLabel(i3);
        j1.setBounds(0,0,900,900);
        add(j1);
        
        JLabel displ=new JLabel("PLEASE ENTER YOUR AMOUNT");
        displ.setBounds(170,300,300,25);
        displ.setForeground(Color.WHITE);
        j1.add(displ);
        
        deposit=new JButton("Deposit");
        deposit.setFont(new Font("Arial",Font.BOLD,17));
        deposit.setBounds(200,450,200,25);
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        j1.add(deposit);
        
        back=new JButton("BACK");
        back.setFont(new Font("Arial",Font.BOLD,17));
        back.setBounds(200,490,200,25);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        j1.add(back);
        
        amoun=new JTextField();
        amoun.setBounds(170,330,300,25);
        amoun.setBackground(Color.WHITE);
        j1.add(amoun);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else if(ae.getSource()==deposit){
            String amount=amoun.getText();
            Date date=new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposit");
            }else{
                try{
                Corn cn=new Corn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+amount+"')";
                cn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "the amount is sucessfully deposited");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
 
            }  
   
        }
    }
    
    public static void main(String args[]){
        new Deposits("");
    }
}
