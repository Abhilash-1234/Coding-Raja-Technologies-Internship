package banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AdminLogin  extends JFrame implements ActionListener{
    JButton logi,clear,back;
    JTextField  cardtf;
    JPasswordField pintf;
    String user,pin;
     
    AdminLogin(){
        
        setSize(800,600);
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3); 
        label.setBounds(50,7,100,100);
        add(label);
        
        JLabel text=new JLabel("ADMIN LOGIN");
        text.setFont(new Font("oswald",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno=new JLabel("User name:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,200,40);
        add(cardno);
        
        cardtf=new JTextField();
        cardtf.setBounds(300,150,200,40);
        cardtf.setFont(new Font("Arial",Font.BOLD,18));
        add(cardtf);
        
        logi=new JButton("LOGIN");
        logi.setBounds(300,350,100,30);
        logi.setBackground(Color.BLACK);
        logi.setForeground(Color.WHITE);
        logi.addActionListener(this);
        add(logi);
        
        clear=new JButton("CLEAR");
        clear.setBounds(450,350,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        back=new JButton("BACK");
        back.setBounds(350,450,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back); 
        
        JLabel pin=new JLabel("password");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,250,200,40);
        add(pin);
        
        pintf=new JPasswordField();
        pintf.setBounds(300,250,200,40);
        pintf.setFont(new Font("Arial",Font.BOLD,18));
        add(pintf);
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setTitle("Automatic Teller Machine");
        setLocation(100,100);
    }
        public void  actionPerformed(ActionEvent ae){
           
             user=cardtf.getText();
             pin=pintf.getText();
            if(ae.getSource()==clear){
                cardtf.setText("");
                pintf.setText("");
            }
            else if(ae.getSource()==logi){
                if (user.equals("ADMIN")&&pin.equals("admin@123")){
                    setVisible(false);
                    new Admin().setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "invalid credentials");
                }
            }
            else if(ae.getSource()==back){
                setVisible(false);
                new Login().setVisible(true);
            }
        }
        
   
    public static void main(String args[]){
        new AdminLogin();
    
    }
}

