
package banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener {
    JButton saving_enq,exit,pin_ch,deposit,cash_withdr,fast_cash,min_stat,fund_tran,app_laon,make_paym,admin;
    String pinnumber;
    Transactions(String pinnumber){
    this.pinnumber= pinnumber;
    setLayout(null);
    setSize(1100,1100);
    setLocation(200,0);
    setUndecorated(true);
    setVisible(true);
    
     
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(1100,1100, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2); 
    JLabel im1=new JLabel(i3);
    im1.setBounds(0,0,1100,1000);
    add(im1);
    
    JLabel head=new JLabel("PLEASE ENTER YOUR OPTION");
    head.setForeground(Color.WHITE);
    head.setFont(new Font("System",Font.BOLD,18));
    head.setBounds(200,290,400,35);
    im1.add(head);
    
    deposit=new JButton("Deposit ");
    deposit.setBounds(190,330,150,40);
    deposit.setFont(new Font("Raleway",Font.BOLD,15));
    deposit.addActionListener(this);
    im1.add(deposit);
    
    cash_withdr=new JButton("Cash Withdrawl");
    cash_withdr.setBounds(400,330,150,40);
    cash_withdr.setFont(new Font("Raleway",Font.BOLD,15));
    cash_withdr.addActionListener(this);
    im1.add(cash_withdr);
    
    fast_cash=new JButton("Fast cash");
    fast_cash.setBounds(190,380,150,40);
    fast_cash.setFont(new Font("Raleway",Font.BOLD,15));
    fast_cash.addActionListener(this);
    im1.add(fast_cash);
    
    min_stat=new JButton("Mini statement");
    min_stat.setBounds(400,380,150,40);
    min_stat.setFont(new Font("Raleway",Font.BOLD,15));
    min_stat.addActionListener(this);
    im1.add(min_stat);
    
    pin_ch=new JButton("Pin Change");
    pin_ch.setBounds(190,430,150,40);
    pin_ch.setFont(new Font("Raleway",Font.BOLD,15));
    pin_ch.addActionListener(this);
    im1.add(pin_ch);
    
    saving_enq=new JButton("SEE BALANCE");
    saving_enq.setBounds(400,430,150,40);
    saving_enq.setFont(new Font("Raleway",Font.BOLD,15));
    saving_enq.addActionListener(this);
    im1.add(saving_enq);
    
    fund_tran=new JButton("SEND CASH");
    fund_tran.setBounds(190,480,150,40);
    fund_tran.setFont(new Font("Raleway",Font.BOLD,15));
    fund_tran.addActionListener(this);
    im1.add(fund_tran);
    
    app_laon=new JButton("APPLY LOAN");
    app_laon.setBounds(400,480,150,40);
    app_laon.setFont(new Font("Raleway",Font.BOLD,15));
    app_laon.addActionListener(this);
    im1.add(app_laon);
    
    
    
    make_paym=new JButton("Make payment");
    make_paym.setBounds(400,530,150,40);
    make_paym.setFont(new Font("Raleway",Font.BOLD,13));
    make_paym.addActionListener(this);
    im1.add(make_paym);
    
    exit=new JButton("EXIT");
    exit.setBounds(270,660,250,45);
    exit.setFont(new Font("Raleway",Font.BOLD,15));
    exit.addActionListener(this);
    im1.add(exit);
    
    
    
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposits(pinnumber).setVisible(true);
        }else if(ae.getSource()==cash_withdr){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fast_cash){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pin_ch){
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        }else if(ae.getSource()==saving_enq){
            setVisible(false);
            new  Balanceenquiry().setVisible(true);
        }else if(ae.getSource()==min_stat){
            setVisible(false);
            new  Ministatement(pinnumber).setVisible(true);
        }else if(ae.getSource()==fund_tran){
            setVisible(false);
            new FundsTran(pinnumber).setVisible(true);
        }else if(ae.getSource()==app_laon){
            setVisible(false);
            new ApplyLoan(pinnumber).setVisible(true);
        }else if(ae.getSource()==make_paym){
            setVisible(false);
            new MakePayments(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Transactions("");
    }
    
}
