
package banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ApplyLoan extends JFrame implements ActionListener {
    JButton per_loan,auto_loan,secu_loan;
    JButton back;
    String pinnumber;
    ApplyLoan(String pinnumber){
    this.pinnumber= pinnumber;
    setLayout(null);
    setSize(800,600);
    setLocation(300,0);
    getContentPane().setBackground(Color.WHITE);
    setVisible(true);
    
    JLabel  txt=new JLabel("LOAN APPLICATION");
    txt.setBounds(100,80,450,50);
    txt.setFont(new Font("raleway",Font.BOLD,30));
    add(txt);
    
    JLabel  txt1=new JLabel("APPLY FOR");
    txt1.setBounds(100,150,450,30);
    txt1.setFont(new Font("raleway",Font.BOLD,20));
    add(txt1);
    
    JLabel inte1=new JLabel("interest rate is 12% p.a");
    inte1.setBounds(400,200,400,30);
    inte1.setFont(new Font("raleway",Font.BOLD,20));
    add(inte1);
    
    per_loan=new JButton("Personal Loan ");
    per_loan.setBounds(100,200,150,40);
    per_loan.setBackground(Color.WHITE);
    per_loan.setFont(new Font("Raleway",Font.BOLD,15));
    per_loan.addActionListener(this);
    add(per_loan);
    
    JLabel intel2=new JLabel("interest rate is 12% p.a");
    intel2.setBounds(400,270,300,30);
    intel2.setFont(new Font("raleway",Font.BOLD,20));
    add(intel2);
        
    
    
    secu_loan=new JButton("Secured Loan");
    secu_loan.setBounds(100,270,150,40);
    secu_loan.setBackground(Color.WHITE);
    secu_loan.setFont(new Font("Raleway",Font.BOLD,15));
    secu_loan.addActionListener(this);
    add(secu_loan);

    back=new JButton("BACK");
    back.setBounds(150,500,200,40);
    back.setFont(new Font("Raleway",Font.BOLD,15));
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.addActionListener(this);
    add(back);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==secu_loan){
            setVisible(false);
            new FillformSecLoan(pinnumber).setVisible(true);
        }else if(ae.getSource()==per_loan ){
            setVisible(false);
            new FillformSecLoan(pinnumber).setVisible(true);
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new ApplyLoan("");
    }
    
}

