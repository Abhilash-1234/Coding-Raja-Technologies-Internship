package banking.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class Ministatement extends JFrame {
    
    Ministatement(String pinnumber){
    setSize(600,600);
    setLocation(30,30);
    setTitle("MINI STATEMENT");
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    setVisible(true);

    JLabel ba=new JLabel("INDIAN BANK");
    ba.setFont(new Font("Arial",Font.BOLD,18));
    ba.setBounds(150,20,300,25);
    add(ba);
    
    JLabel label=new JLabel();
    label.setFont(new Font("Arial",Font.BOLD,18));
    label.setBounds(50,60,300,25);
    add(label);
    
     
    JLabel info=new JLabel();
    info.setFont(new Font("raleway",Font.BOLD,18));
    info.setBounds(50,200,500,400);
    add(info);
    
    Corn cs=new Corn();
    try{
        String query="select * from login where pinnumber='"+pinnumber+"'";
        ResultSet rs=cs.s.executeQuery(query);
            while(rs.next()){
                label.setText("cardnumber:"+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
    try{
        String query ="select * from bank where pin='"+pinnumber+"'";
        ResultSet rt=cs.s.executeQuery(query);
            while(rt.next()){
                   info.setText(info.getText()+"<html>"+rt.getString("ddate")+"&nbsp;&nbsp;&nbsp;"+rt.getString("ttype")+"&nbsp;&nbsp;&nbsp;"+rt.getString("amount")+"<br><br><html>");       
            }
        
    }catch(Exception e){
        System.out.println(e);
    }
   
    }
    public static void main(String args[]){
        new Ministatement("");
    }
}
    


