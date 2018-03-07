package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class SQLiteJDBCDriverConnection {
    
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:sqlite1.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from employee");
            while (rs.next())
            {
            System.out.print (rs.getString(1)+" ");
            System.out.print (rs.getString(2)+" ");
            System.out.print (rs.getString(3)+" ");
            System.out.print (rs.getString(4)+" ");
            System.out.print (rs.getString(5)+" ");
            System.out.println(rs.getString(6));
            }
            //conn.close();
            //st.close();
            //rs.close();

            
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        connect();
        
      
    }
}
