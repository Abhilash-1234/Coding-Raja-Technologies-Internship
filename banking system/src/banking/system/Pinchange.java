
package banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class  Pinchange extends JFrame implements ActionListener{
    JButton bchange,back ;
    JPasswordField enter1pin,enter2pin;
    String pinnumber;
    Pinchange(String pinnumber){
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
        
        bchange=new JButton("CHANGE");
        bchange.setFont(new Font("Arial",Font.BOLD,17));
        bchange.setBounds(200,450,200,25);
        bchange.setForeground(Color.BLACK);
        bchange.addActionListener(this);
        j1.add(bchange);
        
        back=new JButton("BACK");
        back.setFont(new Font("Arial",Font.BOLD,17));
        back.setBounds(200,490,200,25);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        j1.add(back);
        
        JLabel fieldpin=new JLabel("CHANGE YOUR PIN HERE");
        fieldpin.setFont(new Font("Arial",Font.BOLD,15));
        fieldpin.setForeground(Color.WHITE);
        fieldpin.setBounds(230,290,300,25);
        fieldpin.setBackground(Color.WHITE);
        j1.add(fieldpin);
        
        JLabel jtextpin=new JLabel("PLEASE ENTER  NEW PIN");
        jtextpin.setFont(new Font("Arial",Font.BOLD,13));
        jtextpin.setForeground(Color.WHITE);
        jtextpin.setBounds(170,330,400,25);
        jtextpin.setBackground(Color.WHITE);
        j1.add(jtextpin);
        
        JLabel j2textpin=new JLabel("PLEASE RE-ENTER THE PIN");
        j2textpin.setFont(new Font("Arial",Font.BOLD,13));
        j2textpin.setForeground(Color.WHITE);
        j2textpin.setBounds(170,370,400,25);
        j2textpin.setBackground(Color.WHITE);
        j1.add(j2textpin);
        
        enter1pin=new JPasswordField();
        enter1pin.setBounds(350,330,100,25);
        enter1pin.setBackground(Color.WHITE);
        j1.add(enter1pin);
        
        enter2pin=new JPasswordField();
        enter2pin.setBounds(350,370,100,25);
        enter2pin.setBackground(Color.WHITE);
        j1.add(enter2pin);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else if(ae.getSource()==bchange){
            String newpin=enter1pin.getText();
            String repin=enter2pin.getText();
            if(!newpin.equals(repin)){
                JOptionPane.showMessageDialog(null,"re_entered pin does not match");
            }else{
                try{
                Corn cn=new Corn();
                String query1="update bank set pin='"+newpin+"' where pin='"+pinnumber+"'";
                String query2="update  login set pinnumber='"+newpin+"' where pinnumber='"+pinnumber+"'";
                String query3="update  signupthree set pinnumber='"+newpin+"' where pinnumber='"+pinnumber+"'";
                cn.s.executeUpdate(query1);
                cn.s.executeUpdate(query2);
                cn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "PIN is cahnged sucessfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
 
            }  
   
        }
    }
    
    public static void main(String args[]){
        new Pinchange("");
    }
}
