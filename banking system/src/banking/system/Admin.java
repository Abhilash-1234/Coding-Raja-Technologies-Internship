package banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Admin  extends JFrame implements ActionListener{
    private JTable table;
    private DefaultTableModel tableModel;
    JButton back,clear,transfer,show,admin;
    JTextField  formtf,amounttf,acctf_req,pintf,acc_numbtf_adm;
    Admin(){
        
        setSize(800,600);
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3); 
        label.setBounds(50,7,100,100);
        add(label);
        
        JLabel text=new JLabel("ADMIN");
        text.setFont(new Font("oswald",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel formno=new JLabel("Enter form number:");
        formno.setFont(new Font("Raleway",Font.BOLD,15));
        formno.setBounds(120,150,200,30);
        add(formno);
        
        formtf=new JTextField();
        formtf.setBounds(330,150,200,30);
        formtf.setFont(new Font("Arial",Font.BOLD,18));
        add(formtf);
        
        
        
        JLabel accn=new JLabel("Enter account number:");
        accn.setFont(new Font("Raleway",Font.BOLD,15));
        accn.setBounds(120,200,200,15);
        add(accn);
        JLabel sm_s=new JLabel("(requiste)");
        sm_s.setFont(new Font("Raleway",Font.BOLD,15));
        sm_s.setBounds(120,210,200,40);
        add(sm_s);
        
        acctf_req=new JTextField();
        acctf_req.setBounds(330,200,200,30);
        acctf_req.setFont(new Font("Arial",Font.BOLD,15));
        add(acctf_req);
        
        JLabel acc_numb=new JLabel("Enter account number:");
        acc_numb.setFont(new Font("Raleway",Font.BOLD,15));
        acc_numb.setBounds(120,250,200,40);
        add(acc_numb);
        JLabel sm_sh=new JLabel("(admin)");
        sm_sh.setFont(new Font("Raleway",Font.BOLD,15));
        sm_sh.setBounds(120,265,200,40);
        add(sm_sh);
        
        acc_numbtf_adm=new JTextField();
        acc_numbtf_adm.setBounds(330,250,200,30);
        acc_numbtf_adm.setFont(new Font("Arial",Font.BOLD,18));
        add(acc_numbtf_adm);
        
        JLabel pin=new JLabel("Enter pin:");
        pin.setFont(new Font("Raleway",Font.BOLD,15));
        pin.setBounds(120,300,200,40);
        add(pin);
        
        pintf=new JTextField();
        pintf.setBounds(330,300,200,30);
        pintf.setFont(new Font("Arial",Font.BOLD,18));
        add(pintf);
        
        JLabel amount=new JLabel("Enter amount:");
        amount.setFont(new Font("Raleway",Font.BOLD,15));
        amount.setBounds(120,350,200,40);
        add(amount);
        
        amounttf=new JTextField();
        amounttf.setBounds(330,350,200,30);
        amounttf.setFont(new Font("Arial",Font.BOLD,18));
        add(amounttf);
        
        back=new JButton("BACK");
        back.setBounds(150,400,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        clear=new JButton("CLEAR");
        clear.setBounds(550,150,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        transfer=new JButton("TRANSFER");
        transfer.setBounds(450,400,100,30);
        transfer.setBackground(Color.BLACK);
        transfer.setForeground(Color.WHITE);
        transfer.addActionListener(this);
        add(transfer); 
        
        show=new JButton("Show applications");
        show.setBounds(120,100,200,30);
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.addActionListener(new  ActionListener(){
         public void actionPerformed(ActionEvent e){
             displayDataFromDatabase();
             }
        });
        add(show); 
        
        admin=new JButton("Show transactions");
        admin.setBounds(370,100,200,30);
        admin.setBackground(Color.BLACK);
        admin.setForeground(Color.WHITE);
        admin.addActionListener(new  ActionListener(){
         public void actionPerformed(ActionEvent e){
             displayDataFromDatabases();
             }
        });
        add(admin); 
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setTitle("Automatic Teller Machine");
        setLocation(100,100);
    }
          private void displayDataFromDatabase() {
        // Connect to the database and retrieve data
        try {
            
            Corn conn=new Corn();
            ResultSet resultSet = conn.s.executeQuery("SELECT * FROM loan_application");

            // Create a new JFrame to display the data
            JFrame dataFrame = new JFrame("Data Display");
            dataFrame.setSize(600, 400);

            // Assuming you have a method to create a JTable from ResultSet
            JTable dataTable = createTableFromResultSet(resultSet);

            JScrollPane scrollPane = new JScrollPane(dataTable);
            dataFrame.add(scrollPane);

            dataFrame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private JTable createTableFromResultSet(ResultSet resultSet) {
        try {
            // Get ResultSet metadata to determine column count and names
            java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Create a DefaultTableModel with column names
             tableModel = new DefaultTableModel();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            // Populate the table model with data
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }

            // Create a JTable with the DefaultTableModel
            return new JTable(tableModel);
        } catch (Exception e) {
            e.printStackTrace();
            return new JTable(); // Return an empty table in case of an exception
        }
    }
    private void displayDataFromDatabases() {
        // Connect to the database and retrieve data
        try {
            
            Corn conn=new Corn();
            ResultSet resultSet = conn.s.executeQuery("SELECT * FROM admin");

            // Create a new JFrame to display the data
            JFrame dataFrame = new JFrame("Data Display");
            dataFrame.setSize(600, 400);

            // Assuming you have a method to create a JTable from ResultSet
            JTable dataTable = createTableFromResultSets(resultSet);

            JScrollPane scrollPane = new JScrollPane(dataTable);
            dataFrame.add(scrollPane);

            dataFrame.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private JTable createTableFromResultSets(ResultSet resultSet) {
        try {
            // Get ResultSet metadata to determine column count and names
            java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Create a DefaultTableModel with column names
             tableModel = new DefaultTableModel();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            // Populate the table model with data
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getObject(i);
                }
                tableModel.addRow(rowData);
            }

            // Create a JTable with the DefaultTableModel
            return new JTable(tableModel);
        } catch (Exception e) {
            e.printStackTrace();
            return new JTable(); // Return an empty table in case of an exception
        }
    }
        public void  actionPerformed(ActionEvent ae){
            String formno=""+formtf.getText();
            int  amount=Integer.parseInt(amounttf.getText());
            String  acc_no_req=""+acctf_req.getText();
            String  acc_no_adm=""+acc_numbtf_adm.getText();
            String  pin_number_adm=""+pintf.getText();
            if(ae.getSource()==clear){
                formtf.setText("");
                amounttf.setText("");
                acctf_req.setText("");
                acc_numbtf_adm.setText("");
                pintf.setText("");
                
            }
            else if(ae.getSource()==back){
                setVisible(false);
                new Login().setVisible(true);
            }else if(ae.getSource()==transfer){
              Corn con=new Corn();
                try {
                String query1="insert into admin values('"+formno+"','"+acc_no_adm+"','"+amount+"','success')";
                con.s.executeUpdate(query1);
                ResultSet rw = con.s.executeQuery("SELECT * FROM bank WHERE pin='" + pin_number_adm + "'");
                int balance = 0;
                while (rw.next()) {
                    if (rw.getString("ttype").equals("Deposit")||rw.getString("ttype").equals("credit")) {
                    balance += Integer.parseInt(rw.getString("amount"));
                } else if(rw.getString("ttype").equals("withdraw")||rw.getString("ttype").equals("debit")) {
                    balance -= Integer.parseInt(rw.getString("amount"));
                }
                }

                balance -= amount; 

                java.util.Date date = new java.util.Date();

                if ( balance < 0) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
            
                } else {
                String query = "INSERT INTO bank VALUES('" + pin_number_adm + "','" + date + "','debit','" + amount + "')";
                con.s.executeUpdate(query);

                ResultSet rt = con.s.executeQuery("SELECT * FROM login WHERE cardnumber='" + acc_no_req + "'");
                if (rt.next()) { 
                int pin = rt.getInt("pinnumber");
                String q2 = "INSERT INTO bank VALUES('" + pin + "','" + date + "','credit','" + amount + "')";
                con.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, amount+" credited to "+acc_no_req);
                }
           
                }

                }catch(Exception e){
                    System.out.println(e);
                }
            }
            else if(ae.getSource()==back){
                setVisible(false);
                new Login().setVisible(true);
            }
        }
        
   
    public static void main(String args[]){
        new Admin();
    
    }
}

