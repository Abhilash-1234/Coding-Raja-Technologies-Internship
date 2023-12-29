
package banking.system;
import java.sql.*;
public class Corn {
    Connection c;
    Statement s;
    public Corn(){
        try{
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","7981877371");
             s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}