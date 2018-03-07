package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Zapytannya5 {

	public static void main(String[] args) {
		try (Connection c = DriverManager.getConnection("jdbc:sqlite:sqlite1.db")) {

			String sql = "SELECT name FROM employee";

			Scanner sc = new Scanner(System.in);

			System.out.print("Global search by ");
			String str = sc.nextLine();

			try (Statement stmt = c.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

				while (rs.next()) {

					String department = rs.getString(1);

					if (department.contains(str))
						System.out.printf(" %-7s \n", department);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
