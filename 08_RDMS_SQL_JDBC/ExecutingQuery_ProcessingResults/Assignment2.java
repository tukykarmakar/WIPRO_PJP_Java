import java.sql.*;

public class Assignment2
{
	public static void main(String args[])
	{
		int port = 1521;
		String	address = "localhost",
				sid = "ORCL",
				username = "scott",
				password = "tiger";
		String url = "jdbc:oracle:thin:@" + address + ":" + port + ":" + sid;
		String	column1 = "ENAME",
				column2 = "JOB",
				column3 = "SAL",
				column4 = "COMM",
				tableName = "EMP",
				condition = " WHERE " + column3 + " > " + 1000 + " AND " + column3 + " < " + 2000;
		String query = "SELECT " +column1+ ", " +column2+ ", " +column3+ ", " +column4+ " FROM " + tableName + condition;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established successfully");
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			System.out.println("Running the SQL query \"" + query + "\"");
			System.out.println(column1 +"\t"+ column2 +"\t\t"+ column3 +"\t"+ column4);
			System.out.println("--------------------------------------");
			while (resultSet.next())
				System.out.println(resultSet.getString(column1) +"\t"+ resultSet.getString(column2) +"\t"+ resultSet.getString(column3) +"\t"+ resultSet.getString(column4));
		}
		catch (SQLException ex)
		{
			System.out.println("Error occurred with SQL Query!");
			System.out.println(ex.getMessage());
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println("Error: unable to load driver class!");
			System.out.println(ex.getMessage());
		}
		catch (Exception ex)
		{
			System.out.println("Connection could not be established!");
			System.out.println(ex.getMessage());
		}
	}
}