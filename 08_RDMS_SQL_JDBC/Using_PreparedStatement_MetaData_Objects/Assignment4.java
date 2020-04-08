import java.sql.*;

class Database
{
	public static Connection createConnection(String username, String password, String address, int port, String sid)
	{
		Connection connection = null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@" + address + ":" + port + ":" + sid;
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Database connection established\n");
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println("Database connection could not be made!");
			System.out.println("The class " + ex.getMessage() + " could not be found!\n");
		}
		catch (SQLException ex)
		{
			System.out.println("Database connection could not be made!");
			System.out.println(ex.getMessage() + "\n");
		}
		catch (Exception ex)
		{
			System.out.println("Database connection could not be made!");
			System.out.println(ex.getMessage() + "\n");
		}
		finally
		{
			return connection;
		}
	}
}

class StudentDatabase
{
	private Connection connection = null;
	private PreparedStatement prepStmt = null;

	private String	username = "scott",
					password = "tiger",
					address = "localhost",
					sid = "ORCL";
	private int		port = 1521;
	private String	tableName = "STUDENT",
					rollColumn = "RollNo",
					studentNameColumn = "StudentName",
					standardColumn = "Standard",
					dobColumn = "Date_Of_Birth",
					feesColumn = "Fees";

	public StudentDatabase()
	{
		this.connection = Database.createConnection(username, password, address, port, sid);
		this.createDatabaseTable();
	}
	public boolean update(int rollnum, int fee)
	{
		String query = "UPDATE " +tableName+ " SET " +feesColumn+ " = ? WHERE " +rollColumn+ " = ?";
		try
		{
			this.prepStmt = connection.prepareStatement(query);
			this.prepStmt.setInt(1, fee);
			this.prepStmt.setInt(2, rollnum);
			this.prepStmt.executeUpdate();
			return true;
		}
		catch (SQLException ex)
		{
			System.out.println("Exception occured when updating fee in table!");
			System.out.println(ex.getMessage() + "\n");
			return false;
		}
		catch (Exception ex)
		{
			System.out.println("Exception occured when updating fee in table!");
			System.out.println(ex.getMessage() + "\n");
			return false;
		}
	}
	public void closeConnection()
	{
		if (this.connection != null)
			try
			{ this.connection.close(); }
			catch (SQLException ex) {}
	}
	private void createDatabaseTable()
	{
		String query = "CREATE TABLE " +tableName+ "("
						+rollColumn+ " NUMBER(4) PRIMARY KEY, "
						+studentNameColumn+ " VARCHAR2(20), "
						+standardColumn+ " VARCHAR2(2), "
						+dobColumn+ " DATE, "
						+feesColumn+ " NUMBER(9,2))";
		try
		{
			Statement statement = this.connection.createStatement();
			statement.executeQuery(query);
		}
		catch (SQLException ex)
		{
			if (!ex.getMessage().equals("ORA-00955: name is already used by an existing object\n"))
			{
				System.out.println("Exception occured while creating table!");
				System.out.println(ex.getMessage() + "\n");
			}
		}
		catch (Exception ex)
		{
			System.out.println("Exception occured while creating table!");
			System.out.println(ex.getMessage() + "\n");
		}
		finally
		{ System.out.println(this.tableName + " Table is created."); }
	}
}

public class Assignment4
{
	public static void main(String args[])
	{
		StudentDatabase studentDatabase = new StudentDatabase();
		try
		{
			if (studentDatabase.update(Integer.parseInt(args[0]), Integer.parseInt(args[1])))
				System.out.println("Fees updated to " + args[1] + " for roll number " + args[0]);
			else
				System.out.println("Fees could not be updated!");
		}
		catch (NumberFormatException ex)
		{
			System.out.println("Invalid data entered! Expected an Integer");
			System.out.println(ex.getMessage() + "\n");
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("Insufficient amount of data entered!");
			System.out.println(ex.getMessage() + "\n");
		}
		catch (StringIndexOutOfBoundsException ex)
		{
			System.out.println("Empty data values not allowed!");
			System.out.println(ex.getMessage() + "\n");
		}
		finally
		{ studentDatabase.closeConnection(); }
	}
}