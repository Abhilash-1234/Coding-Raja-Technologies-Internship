
package banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class signupTwo  extends JFrame implements ActionListener{
    JTextField pantf,addhtf;
    JButton next;
    JRadioButton eyes,eno,ayes,ano;
    JComboBox valrel,categ,incomebo,occup,eduquali;
    String formno;
    signupTwo(String formno){
        this.formno=formno;
        setLayout(null);
       
        setSize(850,800);
        setLocation(300,10);
        setVisible(true);
        
        setTitle("Application Form Two-Page 2");
        JLabel addnaldet= new JLabel("pageno2:Additional Details");
        addnaldet.setBounds(250,80,450,50);
        addnaldet.setFont(new Font("Arial",Font.BOLD,28));
        add(addnaldet);
        
        JLabel rel= new JLabel("Religion:");
        rel.setBounds(100,140,100,40);
        rel.setFont(new Font("Arial",Font.BOLD,20));
        add(rel);
        String relg[]={"Hidu","sikh","christian","Muslim","other"};
        valrel=new JComboBox(relg);
        valrel.setBounds(250,150,350,30);
        valrel.setBackground(Color.WHITE);
        add(valrel);
        
        JLabel scat= new JLabel("Category:");
        scat.setBounds(100,190,400,50);
        scat.setFont(new Font("Arial",Font.BOLD,20));
        add(scat);
        String cat[]={"sc/st","OBC","General","other"};
        categ=new JComboBox(cat);
        categ.setFont(new Font("Arial",Font.BOLD,22));
        categ.setBounds(250,200,350,30);
        add(categ);
        
        JLabel sincom= new JLabel("Income:");
        sincom.setBounds(100,240,400,30);
        sincom.setFont(new Font("Arial",Font.BOLD,20));
        add(sincom);
        String fat[]={"Null","<1,00,000","<5,00,000","up to 10,00,000"};
        incomebo=new JComboBox(fat);
        incomebo.setFont(new Font("Arial",Font.BOLD,22));
        incomebo.setBounds(250,240,350, 30);
        incomebo.setBackground(Color.WHITE);
        add(incomebo);
        
        JLabel sencit= new JLabel("Senior citiz:");
        sencit.setBounds(100,290,400,50);
        sencit.setFont(new Font("Arial",Font.BOLD,20));
        add(sencit);
        eyes=new JRadioButton("YES");
        eyes.setBounds(250,290,150,40);
        eyes.setFont(new Font("Arial",Font.BOLD,20));
        eyes.setBackground(Color.WHITE);
        add(eyes);
        eno=new JRadioButton("NO");
        eno.setBounds(400,290,150,40);
        eno.setFont(new Font("Arial",Font.BOLD,20));
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup gen =new ButtonGroup();
        gen.add(eyes);
        gen.add(eno);
        
        
        JLabel occupa= new JLabel("occupation");
        occupa.setBounds(100,340,400,50);
        occupa.setFont(new Font("Arial",Font.BOLD,20));
        add(occupa);
        String occu[]={"student","salaried","self-employed","bussiness man","other"};
         occup=new JComboBox(occu);
        occup.setFont(new Font("Arial",Font.BOLD,22));
        occup.setBounds(250,350,350, 30);
        occup.setBackground(Color.WHITE);
        add(occup);
        
        JLabel exac= new JLabel("Existing acc:");
        exac.setBounds(100,390,400,50);
        exac.setFont(new Font("Arial",Font.BOLD,20));
        add(exac);
        ayes=new JRadioButton("YES");
        ayes.setBounds(250,390,150,40);
        ayes.setFont(new Font("Arial",Font.BOLD,20));
        ayes.setBackground(Color.WHITE);
        add(ayes);
        ano=new JRadioButton("NO");
        ano.setBounds(400,390,150,40);
        ano.setFont(new Font("Arial",Font.BOLD,20));
        ano.setBackground(Color.WHITE);
        add(ano);
        
        ButtonGroup mart=new ButtonGroup();
        mart.add(ayes);
        mart.add(ano);
        
        JLabel panno= new JLabel("Pan number:");
        panno.setBounds(100,440,400,50);
        panno.setFont(new Font("Arial",Font.BOLD,20));
        add(panno);
        pantf=new JTextField();
        pantf.setFont(new Font("Arial",Font.BOLD,22));
        pantf.setBounds(250,450,350,30);
        add(pantf);
        
        JLabel addh= new JLabel("Adhaar Num:");
        addh.setBounds(100,490,400,50);
        addh.setFont(new Font("Arial",Font.BOLD,20));
        add(addh);
        addhtf=new JTextField();
        addhtf.setFont(new Font("Arial",Font.BOLD,22));
        addhtf.setBounds(250,500,350,30);
        add(addhtf);
        
        
        
        JLabel eduq= new JLabel("Edu Quali:");
        eduq.setBounds(100,540,400,50);
        eduq.setFont(new Font("Arial",Font.BOLD,20));
        add(eduq);
        String equali[]={"up to 10th class","intermediate","under-grad","post grad","doctorate","other"};
         eduquali=new JComboBox(equali);
        eduquali.setFont(new Font("Arial",Font.BOLD,22));
        eduquali.setBounds(250,550,350,30);
        eduquali.setBackground(Color.WHITE);
        add(eduquali);
      
        
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
        String srel=(String)valrel.getSelectedItem();
        String eduq=(String)eduquali.getSelectedItem();
        String  occu=(String)occup.getSelectedItem();
        String  catage=(String)categ.getSelectedItem();
        String  sinco=(String)incomebo.getSelectedItem();
        String sencit=null;
        if(eyes.isSelected()){
            sencit="Yes";
        }
        else if(eno.isSelected()){
            sencit="No";
        }
        
        String ex_ac=null;
        if(ayes.isSelected()){
            ex_ac="Yes";
        }else if(ano.isSelected()){
            ex_ac="No";
        }
        String  pan=pantf.getText();
        String adharno=addhtf.getText();
       
        try{
                Corn c=new Corn();
                String query = "insert into signuptwo values('"+formno+"','"+srel+"','"+eduq+"','"+occu+"','"+catage+"','"+sencit+"','"+sinco+ "','"+ex_ac+"','"+pan+"','"+adharno+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new signupThree(formno).setVisible(true);
            
        }catch(Exception e){
            System.out.println(e);
        }
     
    }
    public static void main(String args[]){
        new signupTwo("");
    }
}
