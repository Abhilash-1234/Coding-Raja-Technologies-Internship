
package banking.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class signupOne  extends JFrame implements ActionListener{
    
    long rd;
    JTextField nametf,fnametf,emailtf,pinctf,statetf,addrtf,citytf;
    JButton next;
    JRadioButton married,unmarried,male,female;
    JDateChooser jdc;
    
    signupOne(){
        
        setLayout(null);
       
        setSize(850,800);
        setLocation(300,10);
        setVisible(true);
        
        Random rand= new Random();
        rd=Math.abs((rand.nextLong()%9000L)+4000L);
        
        JLabel lab= new JLabel("APPLILICATION NO:"+rd);
        lab.setBounds(200,30,500,50);
        lab.setFont(new Font("Arial",Font.BOLD,38));
        add(lab);
        
        JLabel persodet= new JLabel("pageno1:Personal Details");
        persodet.setBounds(250,80,450,50);
        persodet.setFont(new Font("Arial",Font.BOLD,28));
        add(persodet);
        
        JLabel name= new JLabel("Name:");
        name.setBounds(100,140,100,40);
        name.setFont(new Font("Arial",Font.BOLD,20));
        add(name);
        nametf=new JTextField();
        nametf.setFont(new Font("Arial",Font.BOLD,22));
        nametf.setBounds(250,150,350,30);
        add(nametf);
        
        JLabel fname= new JLabel("Fathers Name:");
        fname.setBounds(100,190,400,50);
        fname.setFont(new Font("Arial",Font.BOLD,20));
        add(fname);
        fnametf=new JTextField();
        fnametf.setFont(new Font("Arial",Font.BOLD,22));
        fnametf.setBounds(250,200,350,30);
        add(fnametf);
        
        JLabel dob= new JLabel("Date Of Birth:");
        dob.setBounds(100,240,400,30);
        dob.setFont(new Font("Arial",Font.BOLD,20));
        add(dob);
        
        jdc=new JDateChooser();
        jdc.setBounds(250,240,350, 30);
        jdc.setForeground(new Color(105,105,105));
        add(jdc);


        
        JLabel martial= new JLabel("Martial Status:");
        martial.setBounds(100,290,400,50);
        martial.setFont(new Font("Arial",Font.BOLD,20));
        add(martial);
        married=new JRadioButton("married");
        married.setBounds(250,290,150,40);
        married.setFont(new Font("Arial",Font.BOLD,20));
        married.setBackground(Color.WHITE);
        add(married);
        unmarried=new JRadioButton("unmarried");
        unmarried.setBounds(400,290,150,40);
        unmarried.setFont(new Font("Arial",Font.BOLD,20));
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        ButtonGroup gen =new ButtonGroup();
        gen.add(married);
        gen.add(unmarried);
        
        
        JLabel email= new JLabel("Email:");
        email.setBounds(100,340,400,50);
        email.setFont(new Font("Arial",Font.BOLD,20));
        add(email);
        emailtf=new JTextField();
        emailtf.setFont(new Font("Arial",Font.BOLD,22));
        emailtf.setBounds(250,350,350,30);
        add(emailtf);
        
        JLabel gender= new JLabel("Gender:");
        gender.setBounds(100,390,400,50);
        gender.setFont(new Font("Arial",Font.BOLD,20));
        add(gender);
        male=new JRadioButton("Male");
        male.setBounds(250,390,150,40);
        male.setFont(new Font("Arial",Font.BOLD,20));
        male.setBackground(Color.WHITE);
        add(male);
        female=new JRadioButton("Female");
        female.setBounds(400,390,150,40);
        female.setFont(new Font("Arial",Font.BOLD,20));
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup mart=new ButtonGroup();
        mart.add(male);
        mart.add(female);
        
        JLabel addr= new JLabel("Address:");
        addr.setBounds(100,440,400,50);
        addr.setFont(new Font("Arial",Font.BOLD,20));
        add(addr);
        addrtf=new JTextField();
        addrtf.setFont(new Font("Arial",Font.BOLD,22));
        addrtf.setBounds(250,450,350,30);
        add(addrtf);
        
        JLabel city= new JLabel("City:");
        city.setBounds(100,490,400,50);
        city.setFont(new Font("Arial",Font.BOLD,20));
        add(city);
        citytf=new JTextField();
        citytf.setFont(new Font("Arial",Font.BOLD,22));
        citytf.setBounds(250,500,350,30);
        add(citytf);
        
        JLabel state= new JLabel("State:");
        state.setBounds(100,540,400,50);
        state.setFont(new Font("Arial",Font.BOLD,20));
        add(state);
        statetf=new JTextField();
        statetf.setFont(new Font("Arial",Font.BOLD,22));
        statetf.setBounds(250,550,350,30);
        add(statetf);
        
        JLabel pinc= new JLabel("Pin Code:");
        pinc.setBounds(100,590,400,50);
        pinc.setFont(new Font("Arial",Font.BOLD,20));
        add(pinc);
        pinctf=new JTextField();
        pinctf.setFont(new Font("Arial",Font.BOLD,22));
        pinctf.setBounds(250,600,350,30);
        add(pinctf);
        
        next=new JButton("NEXT");
        next.setForeground(Color.WHITE);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Arial",Font.BOLD,14));
        next.setBounds(500,650,100,50);
        next.addActionListener(this);
        add(next);
        getContentPane().setBackground(Color.WHITE);
    }
    public void actionPerformed(ActionEvent ae){
        String formno=""+rd;
        String name=nametf.getText();
        String fname=fnametf.getText();
        String dob=((JTextField)jdc.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="Female";
        }
        String email=emailtf.getText();
        String martial=null;
        if(married.isSelected()){
            martial="Married";
        }else if(unmarried.isSelected()){
            martial="UnMarried";
        }
        String  addtf=addrtf.getText();
        String city=citytf.getText();
        String state=statetf.getText();
        String pin=pinctf.getText();
        try{
            if(name.equals("") && fname.equals("") && dob.equals("")  && email.equals("") && addtf.equals("") && city.equals("") && state.equals("") && pin.equals("") ){
                JOptionPane.showMessageDialog(null,"please fill the required details");
            }else{
                Corn c=new Corn();
                String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + martial + "','" + addtf + "','" + city + "','" + state + "','" + pin + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signupTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        

    
    }
    public static void main(String args[]){
        new signupOne();
    }
}
