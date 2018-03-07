package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Zapytannia1 {

	public static void main(String[] args) {
		try(Connection c = DriverManager.getConnection(
				"jdbc:sqlite:sqlite1.db")) {
		
		String sql = "SELECT * FROM employee WHERE head_of_department = 'true'";
				//+ " GROUP BY job_id, job_title"
				//+ " ORDER BY job_id";
		
		try(Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql)) { 
		
			while(rs.next()) {
				// Mozna kolumny wynikowe odczytywac wg numeru, numeracja od 1
				String department = rs.getString(5);
				String name = rs.getString(2);
				//int ilu = rs.getInt(3);
				//double srednia = rs.getDouble(4);
				System.out.println(department + " " + name);
				//System.out.printf("%-10s %-32s %3d %10.2f\n",
				//		department, name);
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

	}


