
package travel.management.system;
import java.sql.*;

public class Conn {
        //creating connection object which is present in sql package
       Connection c;
       Statement s;
    Conn(){
        //1.Register the driver
        try{
          Class.forName("com.mysql.cj.jdbc.Driver");
          
          //2.Creating Connection String
          
          
          c=DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem" , "root" , "tanveer29");
          
          //3.Creating Statement
          s = c.createStatement();
          
          
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    
}
