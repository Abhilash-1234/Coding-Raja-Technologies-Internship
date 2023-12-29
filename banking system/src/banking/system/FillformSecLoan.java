
package banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FillformSecLoan extends JFrame implements ActionListener {
    long  rd;
    JTextField loan,contxt,purpose, incometxt, loanamtxt, time, amopaytxt, monthpaytxt, edatetxt, sdatetxt, acc_no;
    JButton calculate,sub,back;
    String pinnumber, referenceid;
    double total_amount,intrest,month_pay;
    FillformSecLoan(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        setSize(800,800);
        setLocation(300,0);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        Random rand= new Random();
        rd=Math.abs((rand.nextLong()%9000L)+4000L);
 
        JLabel apno=new JLabel("APPLICATION FORM NO: "+rd);
        apno.setBounds(70,50,400,20);
        apno.setFont(new Font("raleway",Font.BOLD,20));
        add(apno);
        
        JLabel purpose1=new JLabel("write purpose of loan");
        purpose1.setBounds(70,90,400,30);
        purpose1.setFont(new Font("raleway",Font.BOLD,20));
        add(purpose1);
        
        purpose=new JTextField();
        purpose.setBounds(70,130,600,30);
        add(purpose);
        
        
        JLabel income=new JLabel(" OVRALL INCOME:");
        income.setBounds(70,200,200,30);
        income.setFont(new Font("raleway",Font.BOLD,20));
        add(income);
        
        incometxt=new JTextField();
        incometxt.setBounds(400,200,200,30);
        add(incometxt);
        
        JLabel loanam=new JLabel("enter loan  amount required:");
        loanam.setBounds(70,250,300,30);
        loanam.setFont(new Font("raleway",Font.BOLD,20));
        add(loanam); 
        
        loanamtxt=new JTextField();
        loanamtxt.setBounds(400,250,200,30);
        add(loanamtxt);
        
        JLabel timereq=new JLabel("Time Period in months:");
        timereq.setBounds(70,300,300,30);
        timereq.setFont(new Font("raleway",Font.BOLD,20));
        add(timereq); 
        
        time=new JTextField();
        time.setBounds(400,300,200,30);
        add(time);
        
        JLabel fine=new JLabel("Account number :");
        fine.setBounds(70,350,300,30);
        fine.setFont(new Font("raleway",Font.BOLD,20));
        add(fine);
        
        acc_no=new JTextField();
        acc_no.setBounds(400,350,200,30);
        add(acc_no);  
        
        JLabel contact=new JLabel("contact number :");
        contact.setBounds(70,400,200,30);
        contact.setFont(new Font("raleway",Font.BOLD,20));
        add(contact);
        
        contxt=new JTextField();
        contxt.setBounds(250,400,150,30);
        add(contxt);
        
        JLabel txt=new JLabel("Press Calculate to know the following");
        txt.setFont(new Font("raleway",Font.PLAIN,10));
        txt.setBounds(70,450,700,30);
        txt.setFont(new Font("raleway",Font.BOLD,20));
        add(txt);
        
        calculate=new JButton("Calculate");
        calculate.setBounds(650,450,100,30);
        calculate.setBackground(Color.BLACK);
        calculate.setForeground(Color.WHITE);
        calculate.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e){
           
                double time_per=Double.parseDouble(time.getText())/12;
                double loan_amo=Double.parseDouble(loanamtxt.getText());
                try{
                    intrest=loan_amo*time_per*0.12;
                    total_amount=loan_amo+intrest;
                    amopaytxt.setText(String.valueOf(total_amount));  
                    month_pay=total_amount/(time_per*12);
                    monthpaytxt.setText(String.valueOf(month_pay)); 
                     LocalDate currentDate = LocalDate.now();
                     LocalDate dateTwoDaysLater = currentDate.plusDays(2);
                     
                     LocalDate dateTwoMonthsLater = currentDate.plusMonths(2);
                    
                     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                     String form_datem=formatter.format(dateTwoMonthsLater);
                     String form_dated=formatter.format(dateTwoDaysLater);
                     sdatetxt.setText(form_dated);
                     edatetxt.setText(form_datem);
             
                     referenceid="5040935997737604";
                     loan.setText(referenceid);
                
                }catch(Exception ae){
                    System.out.println(ae);
                }
               
            }
        });
        
        add(calculate);
        JLabel amopay=new JLabel("Total Amount:");
        amopay.setBounds(70,500,200,30);
        amopay.setFont(new Font("raleway",Font.BOLD,20));
        add(amopay);
        
        amopaytxt=new JTextField();
        amopaytxt.setBounds(230,500,200,30);
        amopaytxt.setEditable(false);
        add(amopaytxt);
        
        JLabel loan_ref=new JLabel("loan id:");
        loan_ref.setBounds(460,500,80,30);
        loan_ref.setFont(new Font("raleway",Font.BOLD,20));
        add(loan_ref);
        
        loan=new JTextField();
        loan.setBounds(560,500,150,30);
        loan.setEditable(false);
        add(loan);
        
        JLabel monthpay=new JLabel("Monthly Payment:");
        monthpay.setBounds(70,550,300,30);
        monthpay.setFont(new Font("raleway",Font.BOLD,20));
        add(monthpay);
        
        monthpaytxt=new JTextField();
        monthpaytxt.setBounds(400,550,200,30);
        monthpaytxt.setEditable(false);
        add(monthpaytxt);
        
        sub=new JButton("SUMBIT");
        sub.setBounds(650,700,100,30);
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.addActionListener(this);
        add(sub);
        
        back=new JButton("BACK");
        back.setBounds(70,700,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        JLabel sdate=new JLabel("Start date:");
        sdate.setBounds(70,600,300,30);
        sdate.setFont(new Font("raleway",Font.BOLD,20));
        add(sdate);
        
        sdatetxt=new JTextField();
        sdatetxt.setBounds(400,600,200,30);
        sdatetxt.setEditable(false);
        add(sdatetxt);
        
        JLabel edate=new JLabel("End date:");
        edate.setBounds(70,650,300,30);
        edate.setFont(new Font("raleway",Font.BOLD,20));
        add(edate);
        
        edatetxt=new JTextField();
        edatetxt.setBounds(400,650,200,30);
        edatetxt.setEditable(false);
        add(edatetxt);
        
        
        setLayout(null);
 
        
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        String formno=""+rd;
        String purpo=purpose.getText();
        String income=""+incometxt.getText();
        String loan_amo=""+loanamtxt.getText();
        String time_per=""+time.getText();
        String account_no=""+acc_no.getText();
        String contact_no=""+contxt.getText();
         
        String total_amoun=""+loanamtxt.getText();
        String monthly_pay=""+monthpaytxt.getText();
        String startdate=sdatetxt.getText();
        String enddate=edatetxt.getText();
        String loanid=loan.getText();
        if(ae.getSource()==sub){ 
            try{
                Corn c=new Corn();
                String query1 = "insert into loan_application values('" + formno + "','" + purpo + "','" + income + "','" + loan_amo + "','" + time_per + "','" + account_no + "','" + contact_no + "')";
                c.s.executeUpdate(query1);
                String query2 = "insert into loan_cal values('" + formno + "','" + loanid + "','" + total_amoun + "','" + monthly_pay + "','" + startdate + "','" + enddate + "')";
                c.s.executeUpdate(query2);
            }catch(Exception e){
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(null,"your application is submitted wait for two days for approval");
            new ApplyLoan(pinnumber).setVisible(true);
            
        }else if(ae.getSource()==back){
            setVisible(false);
            new ApplyLoan(pinnumber).setVisible(true);
        }
         
    }
    public static void  main(String args[]){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FillformSecLoan("");
            }
        });
    }
    
}
