
package banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class MakePayments  extends JFrame implements ActionListener{
    private JTable table;
    private DefaultTableModel tableModel;
    JButton back,clear,transfer,show,show_paym;
    JTextField  formtf,amount_tf,loan_id;
    String pinnumber;
    MakePayments(String pinnumber){
        this.pinnumber=pinnumber;
        setSize(800,600);
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3); 
        label.setBounds(50,7,100,100);
        add(label);
        
        JLabel text=new JLabel("Make Payments");
        text.setFont(new Font("oswald",Font.BOLD,38));
        text.setBounds(200,40,400,48);
        add(text);
        
        JLabel formno=new JLabel("Enter form number:");
        formno.setFont(new Font("Raleway",Font.BOLD,15));
        formno.setBounds(120,150,200,30);
        add(formno);
        
        formtf=new JTextField();
        formtf.setBounds(330,150,200,30);
        formtf.setFont(new Font("Arial",Font.BOLD,18));
        add(formtf);
       
        JLabel accn=new JLabel("Enter loan id:");
        accn.setFont(new Font("Raleway",Font.BOLD,15));
        accn.setBounds(120,200,200,15);
        add(accn);
        
        
        loan_id=new JTextField();
        loan_id.setBounds(330,200,200,30);
        loan_id.setFont(new Font("Arial",Font.BOLD,15));
        add(loan_id);
        
        JLabel acc_numb=new JLabel("Enter amount:");
        acc_numb.setFont(new Font("Raleway",Font.BOLD,15));
        acc_numb.setBounds(120,250,200,40);
        add(acc_numb);
     
        
        amount_tf=new JTextField();
        amount_tf.setBounds(330,250,200,30);
        amount_tf.setFont(new Font("Arial",Font.BOLD,18));
        add(amount_tf);
        
       
        
        
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
        
        show=new JButton("Show my loans");
        show.setBounds(120,100,200,30);
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.addActionListener(new  ActionListener(){
         public void actionPerformed(ActionEvent e){
             displayDataFromDatabase();
             }
        });
        add(show); 
        
        show_paym=new JButton("Show my payments");
        show_paym.setBounds(120,350,200,30);
        show_paym.setBackground(Color.BLACK);
        show_paym.setForeground(Color.WHITE);
        show_paym.addActionListener(new  ActionListener(){
         public void actionPerformed(ActionEvent e){
             displayDataFromDatabases();
             }
        });
        add(show_paym); 
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setTitle("Automatic Teller Machine");
        setLocation(100,100);
    }
          private void displayDataFromDatabase() {
        // Connect to the database and retrieve data
        try {
            String formno=formtf.getText();
            
            Corn conn=new Corn();
            ResultSet resultSet = conn.s.executeQuery("SELECT * FROM loan_cal where formno='"+formno+"'");

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
            String formno=formtf.getText();
            
            Corn conn=new Corn();
            ResultSet resultSet = conn.s.executeQuery("SELECT * FROM payments where formno='"+formno+"'");

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
            String  loanid=""+loan_id.getText();

             int amount = Integer.parseInt(amount_tf.getText());
            if(ae.getSource()==clear){
                formtf.setText("");
                amount_tf.setText("");
                loan_id.setText("");   
            }
            else if(ae.getSource()==back){
                setVisible(false);
                new Login().setVisible(true);
            }else if(ae.getSource()==transfer){
              Corn con=new Corn();
                try {
                ResultSet rw = con.s.executeQuery("SELECT * FROM bank WHERE pin='" + pinnumber + "'");
                    int balance = 0;
                     
                    while (rw.next()) {
                    String ttype = rw.getString("ttype");
                    int amoun = Integer.parseInt(rw.getString("amount")); 
                    if (ttype.equals("Deposit") || ttype.equals("credit")) {
                    balance += amoun;
                    } else if (ttype.equals("withdraw") || ttype.equals("debit")) {
                         balance -= amoun;
                        }
                    }

            java.util.Date date = new java.util.Date();

            if (balance < amount) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
              } else {
                 String query1="insert into payments values('"+formno+"','"+loanid+"','" + amount + "','succcess','"+date+"')";
                con.s.executeUpdate(query1);

                String query = "INSERT INTO bank VALUES('" + pinnumber + "','" + date + "','debit','" + amount + "')";
                con.s.executeUpdate(query);

                ResultSet rt = con.s.executeQuery("SELECT * FROM login WHERE cardnumber='" + loanid + "'");
                if (rt.next()) {
                String  pin = rt.getString("pinnumber");
                String q2 = "INSERT INTO bank VALUES('" + pin + "','" + date + "','credit','" + amount + "')";
                con.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, amount + " credited to " + loanid);
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
        new MakePayments("");
    
    }
}

