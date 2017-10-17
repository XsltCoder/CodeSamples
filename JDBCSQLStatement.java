package jdbcconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCSQLStatement {

	private static String URL = "jdbc:mysql://localhost:3306/hr";
	private static String DbUserName = "root";
	private static String DbPassword = "password";

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection(URL, DbUserName, DbPassword);
			System.out.println("Connected to MySql database...");

			statement = connection.createStatement();

			resultSet = statement.executeQuery("Select * from countries");
			
			while (resultSet.next()) {
				System.out
						.println(resultSet.getString("country_name") + "'s ID is " + resultSet.getString("country_id"));
			}
			System.out.println("#################QUERY 2 ON THE WAY ############");
			
			resultSet.previous();
			resultSet.previous();
			System.out
			.println(resultSet.getString("country_name") + "'s ID is " + resultSet.getString("country_id"));
			
			resultSet.close();
			
			resultSet=statement.executeQuery("SELECT last_name, department_name"
											+ " FROM employees e join departments d"
											+ " ON e.department_id=d.department_id");
			
			while(resultSet.next()){
				System.out.println(resultSet.getString("last_name") +" works in "+resultSet.getString("department_name")+
						  														" Department.");
			}
			
		} catch (SQLException e) {

			System.out.println("Something went wrong!");
			e.printStackTrace();

		} finally { // finally block always runs, and below conditions make sure
					// that we are not trying to close,
					// Not opened connections

			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}
}
