package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Zapytannia2 {

	public static void main(String[] args) {
		try(Connection c = DriverManager.getConnection(
				"jdbc:sqlite:sqlite1.db")) {
		
		String sql = "SELECT department, degree, COUNT(*) FROM employee GROUP BY department, degree";
		
		try(Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) { 
		
			while(rs.next()) {
				
				String department = rs.getString(1);
				String degree = rs.getString(2);
				int count = rs.getInt(3);
				System.out.printf("%-7s %-20s %2d\n",
						 department, degree, count);
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

	}
