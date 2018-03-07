package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Zapytannya3 {

	public static void main(String[] args) {
		try(Connection c = DriverManager.getConnection(
				"jdbc:sqlite:sqlite1.db")) {
		
		String sql = "SELECT department, AVG(salary) FROM employee GROUP  BY department";
		
		try(Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) { 
		
			while(rs.next()) {
				
				String department = rs.getString(1);				
				int count = rs.getInt(2);
				System.out.printf("The average salary of %-7s %2d\n",
						 department, count);
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

}
