package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Zapytannya4 {

	public static void main(String[] args) {
		try(Connection c = DriverManager.getConnection(
				"jdbc:sqlite:sqlite1.db")) {
		
		String sql = "SELECT department, COUNT(*) FROM employee GROUP  BY department";
		String dep_name = "informatics";
		
		try(Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) { 
		
			while(rs.next()) {
				
				String department = rs.getString(1);				
				int count = rs.getInt(2);
				if(dep_name.equals(department))
					System.out.printf("In the department of %-7s - %2d employees \n",
						 department, count);
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

}

