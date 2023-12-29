package banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Balanceenquiry extends JFrame implements ActionListener {
    JButton back,submit;
    JPasswordField pin_num;
    public Balanceenquiry(){
 
    setLayout(null);
    setSize(900,900);
    setLocation(300,0);
    setVisible(true);
    
     
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2); 
    JLabel im1=new JLabel(i3);
    im1.setBounds(0,0,900,900);
    add(im1);
    
    JLabel head=new JLabel("ENTER YOUR PIN TO CHECK BALANCE");
    head.setForeground(Color.WHITE);
    head.setFont(new Font("System",Font.BOLD,18));
    head.setBounds(160,280,600,35);
    im1.add(head);
    
    pin_num=new JPasswordField();
    pin_num.setForeground(Color.BLACK);
    pin_num.setFont(new Font("System",Font.BOLD,18));
    pin_num.setBounds(250,350,100,35);
    im1.add(pin_num);
    
    
    back=new JButton("Back");
    back.setBounds(330,450,150,40);
    back.setForeground(Color.BLACK);
    back.setFont(new Font("Raleway",Font.BOLD,15));
    back.addActionListener(this);
    im1.add(back);
    
    submit=new JButton("submit");
    submit.setBounds(330,400,150,40);
    submit.setForeground(Color.BLACK);
    submit.setFont(new Font("Raleway",Font.BOLD,15));
    submit.addActionListener(this);
    im1.add(submit);
    }
    public void actionPerformed(ActionEvent ae){
        String pinnumber=pin_num.getText();
        if(ae.getSource()==back){
            setVisible(true);
            new Transactions(pinnumber).setVisible(true);
        }
        else{
            if(ae.getSource()==submit){
                Corn as=new Corn();
                     try{
                         int balance=0;
                        ResultSet rs=as.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                        while(rs.next()){
                            if(rs.getString("ttype").equals("Deposit") || rs.getString("ttype").equals("credit")){
                             balance+=Integer.parseInt(rs.getString("amount"));
                            }
                            else if(rs.getString("ttype").equals("withdraw") || rs.getString("ttype").equals("debit")){
                             balance-=Integer.parseInt(rs.getString("amount"));
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Your balance for the pin you entered is "+balance);
                    }catch(Exception e){
                             System.out.println(e);
                    }
            }
                
        }
    }
    public static void main(String args[]){
        new Balanceenquiry();
    }
    
}
