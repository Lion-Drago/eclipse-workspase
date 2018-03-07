package sqlite;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;   


public class Connectdatabase {

        Connection con = null;

        public static Connection ConnecrDb(){

            try{
                //String dir = System.getProperty("user.dir");
                Class.forName("org.sqlite.JDBC");
                Connection con = DriverManager.getConnection("jdbc:sqlite:sqlite.db");
                return con;
            }
            catch(ClassNotFoundException | SQLException e){
                JOptionPane.showMessageDialog(null,"Problem with connection of database");
                return null;
            }
        }

    }

