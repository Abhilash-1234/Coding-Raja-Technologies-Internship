
package banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login  extends JFrame implements ActionListener{
    JButton sin,clear,siup,admin;
    JTextField  cardtf;
    JPasswordField pintf;
    
    Login(){
        
        setSize(800,600);
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3); 
        label.setBounds(50,7,100,100);
        add(label);
        
        JLabel text=new JLabel("WELCOME TO ATM");
        text.setFont(new Font("oswald",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno=new JLabel("CARD NO:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,200,40);
        add(cardno);
        
        cardtf=new JTextField();
        cardtf.setBounds(300,150,200,40);
        cardtf.setFont(new Font("Arial",Font.BOLD,18));
        add(cardtf);
        
        sin=new JButton("SIGN IN");
        sin.setBounds(300,350,100,30);
        sin.setBackground(Color.BLACK);
        sin.setForeground(Color.WHITE);
        sin.addActionListener(this);
        add(sin);
        
        clear=new JButton("CLEAR");
        clear.setBounds(450,350,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        siup=new JButton("SIGN UP");
        siup.setBounds(350,450,100,30);
        siup.setBackground(Color.BLACK);
        siup.setForeground(Color.WHITE);
        siup.addActionListener(this);
        add(siup); 
        
        JLabel pin=new JLabel("PIN NO:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,250,200,40);
        add(pin);
        
        pintf=new JPasswordField();
        pintf.setBounds(300,250,200,40);
        pintf.setFont(new Font("Arial",Font.BOLD,18));
        add(pintf);
        
        admin=new JButton("Admin");
        admin.setBounds(150,350,100,30);
        admin.setBackground(Color.BLACK);
        admin.setForeground(Color.WHITE);
        admin.setFont(new Font("Raleway",Font.BOLD,15));
        admin.addActionListener(this);
        add(admin);
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setTitle("Automatic Teller Machine");
        setLocation(100,100);
    }
        public void  actionPerformed(ActionEvent ae){
            if(ae.getSource()==clear){
                cardtf.setText("");
                pintf.setText("");
            }
            else if(ae.getSource()==sin){
                Corn con=new Corn();
                String cardnumber=cardtf.getText();
                String pinnumber=pintf.getText();
                String query="select * from login where cardnumber='"+cardnumber+"' and pinnumber='"+pinnumber+"'" ;
                try{
                    ResultSet rs=con.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(null,"pinnumber or cardnumber is incorrect");
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(ae.getSource()==siup){
                setVisible(false);
                new signupOne().setVisible(true);
            }else if(ae.getSource()==admin){
            setVisible(false);
            new  AdminLogin().setVisible(true);
        }
        }
        
   
    public static void main(String args[]){
        new Login();
    
    }
}
