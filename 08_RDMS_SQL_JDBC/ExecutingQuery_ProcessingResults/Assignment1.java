import java.sql.*;

public class Assignment1
{
	public static void main(String args[])
	{
		int port = 1521;
		String	address = "localhost",
				sid = "ORCL",
				username = "scott",
				password = "tiger";
		String url = "jdbc:oracle:thin:@" + address + ":" + port + ":" + sid;
		String	column1 = "EMPNO",
				column2 = "ENAME",
				tableName = "EMP";
		String query = "SELECT " +column1+ ", " +column2+ " FROM " + tableName;
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established successfully");
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			System.out.println("Running the SQL query \"" + query + "\"");
			System.out.println(column1 +"\t"+ column2);
			System.out.println("----------------");
			while (resultSet.next())
				System.out.println(resultSet.getInt(1) +"\t"+ resultSet.getString(column2));
		}
		catch (SQLException ex)
		{
			System.out.println("Connection could not be established!");
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