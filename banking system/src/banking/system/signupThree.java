
package banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class signupThree extends JFrame implements ActionListener{
    JRadioButton p1,p2,p3,p4;
    ButtonGroup t1;
    JCheckBox l1,l2,l3,l4,l5,l6,l7;
    JButton submit,cancel;
    String formno;
    signupThree(String formno){
        this.formno=formno;
        setLayout(null);
        setSize(850,820);
        setBackground(Color.WHITE);
        setVisible(true);
        setLocation(350,0);
        
        JLabel labe=new JLabel("APPLICATION FORM-PAGE 3");
        labe.setFont(new Font("Realeway",Font.BOLD,24));
        labe.setBounds(250,10,400,25);
        labe.setBackground(Color.WHITE);
        add(labe);
        
        JLabel rat=new JLabel("ACCOUNT TYPE:");
        rat.setFont(new Font("Realeway",Font.BOLD,22));
        rat.setBounds(100,80,300,25);
        rat.setBackground(Color.WHITE);
        add(rat);
        
        p1=new JRadioButton("Saving account");
        p1.setFont(new Font("Raleway",Font.BOLD,16));
        p1.setBounds(100,120,300,30);
        p1.setBackground(Color.WHITE);
        add(p1);
        
        p2=new JRadioButton("Fixed deposit accouunt");
        p2.setFont(new Font("Raleway",Font.BOLD,16));
        p2.setBounds(400,120,300,30);
        p2.setBackground(Color.WHITE);
        add(p2);
        
        p3=new JRadioButton("Current acount");
        p3.setFont(new Font("Raleway",Font.BOLD,16));
        p3.setBounds(100,200,300,30);
        p3.setBackground(Color.WHITE);
        add(p3);
        
        p4=new JRadioButton("recurring  account");
        p4.setFont(new Font("Raleway",Font.BOLD,16));
        p4.setBounds(400,200,300,30);
        p4.setBackground(Color.WHITE);
        add(p4);
        
        t1=new ButtonGroup();
        t1.add(p1);
        t1.add(p2);
        t1.add(p3);
        t1.add(p4);
        JLabel card=new JLabel("CARD NUMBER:");
        card.setFont(new Font("Realeway",Font.BOLD,20));
        card.setBounds(100,260,400,25);
        card.setBackground(Color.WHITE);
        add(card);
        
        JLabel carddigits=new JLabel("XXXX-XXXX-XXXX-2345");
        carddigits.setFont(new Font("Realeway",Font.BOLD,20));
        carddigits.setBounds(300,260,400,25);
        carddigits.setBackground(Color.WHITE);
        add(carddigits);
        
        JLabel carddetail=new JLabel("this is you card number");
        carddetail.setFont(new Font("Realeway",Font.BOLD,14));
        carddetail.setBounds(100,280,400,25);
        carddetail.setBackground(Color.WHITE);
        add(carddetail);
        
        JLabel PIN=new JLabel("PIN NUMBER:");
        PIN.setFont(new Font("Realeway",Font.BOLD,20));
        PIN.setBounds(100,330,400,25);
        PIN.setBackground(Color.WHITE);
        add(PIN);
        
        JLabel pinnumb=new JLabel("XXXX");
        pinnumb.setFont(new Font("Realeway",Font.BOLD,20));
        pinnumb.setBounds(300,330,400,25);
        pinnumb.setBackground(Color.WHITE);
        add(pinnumb);
        
        JLabel pindetail=new JLabel("this is your pin number");
        pindetail.setFont(new Font("Realeway",Font.BOLD,14));
        pindetail.setBounds(100,350,400,25);
        pindetail.setBackground(Color.WHITE);
        add(pindetail);
        
        JLabel service=new JLabel("Sercice Required:");
        service.setFont(new Font("Realeway",Font.BOLD,22));
        service.setBounds(100,400,400,25);
        service.setBackground(Color.WHITE);
        add(service);
        
        l1=new JCheckBox("ATM CARD");
        l1.setFont(new Font("Realeway",Font.BOLD,17));
        l1.setBounds(100,430,200,25);
        l1.setBackground(Color.WHITE);
        add(l1);
        
        l2=new JCheckBox("Internet Banking");
        l2.setFont(new Font("Realeway",Font.BOLD,17));
        l2.setBounds(300,430,200,25);
        l2.setBackground(Color.WHITE);
        add(l2);
        
        l3=new JCheckBox("Mobile Banking");
        l3.setFont(new Font("Realeway",Font.BOLD,17));
        l3.setBounds(100,480,200,25);
        l3.setBackground(Color.WHITE);
        add(l3);
        
        l4=new JCheckBox("Email &SMS alerts");
        l4.setFont(new Font("Realeway",Font.BOLD,17));
        l4.setBounds(300,480,200,25);
        l4.setBackground(Color.WHITE);
        add(l4);
        
        l5=new JCheckBox("Cheque book");
        l5.setFont(new Font("Realeway",Font.BOLD,17));
        l5.setBounds(100,530,200,25);
        l5.setBackground(Color.WHITE);
        add(l5);
        
        l6=new JCheckBox("E-statemnet");
        l6.setFont(new Font("Realeway",Font.BOLD,17));
        l6.setBounds(300,530,200,25);
        l6.setBackground(Color.WHITE);
        add(l6);
        
        l7=new JCheckBox("I hereby declare the information provided above");
        l7.setFont(new Font("Realeway",Font.BOLD,17));
        l7.setBounds(100,580,500,25);
        l7.setBackground(Color.WHITE);
        add(l7);
        
        submit=new JButton("SUBMIT");
        submit.setFont(new Font("Realeway",Font.BOLD,17));
        submit.setBounds(250,700,200,40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("CANCEL");
        cancel.setFont(new Font("Realeway",Font.BOLD,17));
        cancel.setBounds(500,700,200,40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        getContentPane().setBackground(Color.WHITE);
        }
        public void actionPerformed(ActionEvent ae){
            Random rand=new Random();
                String cardnumber=""+Math.abs((rand.nextLong()%9000000L)+5040936000000000L);
                String pinnumber=""+Math.abs((rand.nextLong()%9000L)+1000L);
            if(ae.getSource()==submit){
                String account_type="";
                if(l1.isSelected()){
                    account_type="Saving Account";
                }else if(l2.isSelected()){
                    account_type="Fixed deposit Account";
                }else if(l3.isSelected()){
                    account_type="Current Account";
                }else if(l4.isSelected()){
                    account_type="recurring Account";
                }
                
                
                String facility=null;
                if(l1.isSelected()){
                    facility="ATM CARD,";
                }
                if(l2.isSelected()){
                    facility=facility+" Internet Banking,";
                }
                if(l3.isSelected()){
                    facility=facility+" Mobile Banking,";
                }
                if(l4.isSelected()){
                    facility=facility+" Email &SMS Alerts,";
                }
                if(l5.isSelected()){
                    facility=facility+" Cheque Book,";
                }
                if(l6.isSelected()){
                    facility=facility+" E-Statement,";
                }
                try{
                    if(account_type.equals("")){
                        JOptionPane.showMessageDialog(rootPane,"Account type cannot be empty");
                    }else {
                        Corn con=new Corn();
                        String query1 = "insert into signupthree values('"+formno+"','"+account_type+"','"+ cardnumber+"','"+pinnumber+"','"+facility+"')";
                        String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                        con.s.executeUpdate(query1);
                        con.s.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null,"Card number: "+cardnumber+"\npin number:"+pinnumber);
                        setVisible(false);
                        new Login().setVisible(true);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }else if(ae.getSource()==cancel){
                setVisible(false);
                new signupThree(formno).setVisible(true);
            }
   
        }
    public static void main(String args[]){
        new signupThree("");
    }
    
}
