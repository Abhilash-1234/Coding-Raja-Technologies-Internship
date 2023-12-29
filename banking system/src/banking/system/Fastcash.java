package banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Fastcash extends JFrame implements ActionListener {
    JButton j1,j2,j3,j4,j5,j6,j7;
    String pinnumber;
    Fastcash(String pinnumber){
    this.pinnumber= pinnumber;
    setLayout(null);
    setSize(900,900);
    setLocation(300,0);
    setUndecorated(true);
    setVisible(true);
    
     
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2); 
    JLabel im1=new JLabel(i3);
    im1.setBounds(0,0,900,900);
    add(im1);
    
    JLabel head=new JLabel("PLEASE ENTER YOUR OPTION");
    head.setForeground(Color.WHITE);
    head.setFont(new Font("System",Font.BOLD,18));
    head.setBounds(200,280,400,35);
    im1.add(head);
    
    j1=new JButton("Rs 50");
    j1.setBounds(160,330,150,40);
    j1.setFont(new Font("Raleway",Font.BOLD,15));
    j1.addActionListener(this);
    im1.add(j1);
    
    j2=new JButton("Rs 100");
    j2.setBounds(330,330,150,40);
    j2.setFont(new Font("Raleway",Font.BOLD,15));
    j2.addActionListener(this);
    im1.add(j2);
    
    j3=new JButton("Rs 500");
    j3.setBounds(160,380,150,40);
    j3.setFont(new Font("Raleway",Font.BOLD,15));
    j3.addActionListener(this);
    im1.add(j3);
    
    j4=new JButton("Rs 1000");
    j4.setBounds(330,380,150,40);
    j4.setFont(new Font("Raleway",Font.BOLD,15));
    j4.addActionListener(this);
    im1.add(j4);
    
    j5=new JButton("Rs 5000");
    j5.setBounds(160,430,150,40);
    j5.setFont(new Font("Raleway",Font.BOLD,15));
    j5.addActionListener(this);
    im1.add(j5);
    
    j6=new JButton("Rs 10000");
    j6.setBounds(330,430,150,40);
    j6.setFont(new Font("Raleway",Font.BOLD,15));
    j6.addActionListener(this);
    im1.add(j6);
    
    j7=new JButton("Back");
    j7.setBounds(330,500,150,40);
    j7.setFont(new Font("Raleway",Font.BOLD,15));
    j7.addActionListener(this);
    im1.add(j7);
    
    
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==j7){
            setVisible(true);
            new Transactions(pinnumber).setVisible(true);
        }else {
            setVisible(false);
            new Deposits("").setVisible(true);
            Corn cn=new Corn();
            String amount=((JButton)ae.getSource()).getText().substring(3);
            try{
                ResultSet rs=cn.s.executeQuery("select * from bank where pin='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("ttype").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                     balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=j7 && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String query="insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+amount+"')";
                cn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited sucessfully");
                setVisible(true);
                new Transactions(pinnumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new Fastcash("");
    }
    
}
