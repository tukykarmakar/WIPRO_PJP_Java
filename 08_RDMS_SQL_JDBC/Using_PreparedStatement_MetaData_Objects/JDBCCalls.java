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

class DAOClass
{
	private Connection connection = null;
	PreparedStatement prepStmt = null;

	public DAOClass()
	{
		this.connection = Database.createConnection("scott", "tiger", "localhost", 1521, "ORCL");
		this.createDatabaseTable();
	}
	public void closeConnection()
	{
		if (this.connection != null)
			try
			{ this.connection.close(); }
			catch (SQLException ex) {}
	}
	public boolean insert(int rollnum, String name, String grade, String dob, int fee)
	{
		String query = "INSERT INTO STDNT VALUES(?, ?, ?, ?, ?)";
		try
		{
			this.prepStmt = this.connection.prepareStatement(query);

			this.prepStmt.setInt(1, rollnum);
			this.prepStmt.setString(2, name);
			this.prepStmt.setString(3, grade);
			this.prepStmt.setString(4, dob);
			this.prepStmt.setInt(5, fee);

			this.prepStmt.executeUpdate();
			return true;
		}
		catch (SQLException ex)
		{
			System.out.println("Exception occured when inserting values in table!");
			System.out.println(ex.getMessage() + "\n");
			return false;
		}
		catch (Exception ex)
		{
			System.out.println("Exception occured when inserting values in table!");
			System.out.println(ex.getMessage() + "\n");
			return false;
		}
	}
	public boolean delete(int rollnum)
	{
		String query = "DELETE STDNT WHERE ROLLNUM = ?";
		try
		{
			this.prepStmt = connection.prepareStatement(query);
			this.prepStmt.setInt(1, rollnum);
			this.prepStmt.executeUpdate();
			return true;
		}
		catch (SQLException ex)
		{
			System.out.println("Exception occured when deleting values from table!");
			System.out.println(ex.getMessage() + "\n");
			return false;
		}
		catch (Exception ex)
		{
			System.out.println("Exception occured when deleting values from table!");
			System.out.println(ex.getMessage() + "\n");
			return false;
		}
	}
	public boolean update(int rollnum, int fee)
	{
		String query = "UPDATE STDNT SET FEE = ? WHERE ROLLNUM = ?";
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
	public boolean display(int rollnum)
	{
		String query = "SELECT * FROM STDNT WHERE ROLLNUM = ?";
		String heading = "", row = "";
		try
		{
			this.prepStmt = connection.prepareStatement(query);
			this.prepStmt.setInt(1, rollnum);
			ResultSet resultSet = this.prepStmt.executeQuery();
			ResultSetMetaData metaData = resultSet.getMetaData();

			for (int i = 1; i <= metaData.getColumnCount(); i++)
				heading = heading + metaData.getColumnName(i) + "\t";
			System.out.println(heading);
			System.out.println("------------------------------------------------------------------------------------");

			while (resultSet.next())
			{
				row = "";
				for (int i = 1; i <= metaData.getColumnCount(); i++)
					row = row + resultSet.getObject(i) + "\t";
				System.out.println(row);
			}

			return true;
		}
		catch (SQLException ex)
		{
			System.out.println("Exception occured when displaying table!");
			System.out.println(ex.getMessage() + "\n");
			return false;
		}
		catch (Exception ex)
		{
			System.out.println("Exception occured when displaying table!");
			System.out.println(ex.getMessage() + "\n");
			return false;
		}
	}
	public boolean displayAll()
	{
		String query = "SELECT * FROM STDNT";
		String heading = "", row = "";
		try
		{
			this.prepStmt = connection.prepareStatement(query);
			ResultSet resultSet = this.prepStmt.executeQuery();
			ResultSetMetaData metaData = resultSet.getMetaData();

			for (int i = 1; i <= metaData.getColumnCount(); i++)
				heading = heading + metaData.getColumnName(i) + "\t";
			System.out.println(heading);
			System.out.println("------------------------------------------------------------------------------------");

			while (resultSet.next())
			{
				row = "";
				for (int i = 1; i <= metaData.getColumnCount(); i++)
					row = row + resultSet.getObject(i) + "\t";
				System.out.println(row);
			}

			return true;
		}
		catch (SQLException ex)
		{
			System.out.println("Exception occured when displaying table!");
			System.out.println(ex.getMessage() + "\n");
			return false;
		}
		catch (Exception ex)
		{
			System.out.println("Exception occured when displaying table!");
			System.out.println(ex.getMessage() + "\n");
			return false;
		}
	}
	private void createDatabaseTable()
	{
		String query = "CREATE TABLE STDNT(ROLLNUM NUMBER(4) PRIMARY KEY, NAME VARCHAR2(30), GRADE VARCHAR2(4), DOB DATE, FEE NUMBER(6))";
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
	}
}

public class JDBCCalls
{
	public static void main(String args[])
	{
		DAOClass studentDatabase = new DAOClass();
		try
		{
			int choice = Integer.parseInt(args[0]);
			switch (choice)
			{
				case 1:
					if (args.length != 6)
						System.out.println("Invalid amount of Data!");
					else if (studentDatabase.insert(Integer.parseInt(args[1]), args[2], args[3], args[4], Integer.parseInt(args[5])))
						System.out.println("Data inserted into table successfully.");
					else
						System.out.println("Data insertion failed!");
					break;

				case 2:
					if (args.length != 2)
						System.out.println("Invalid amount of Data!");
					else if (studentDatabase.delete(Integer.parseInt(args[1])))
						System.out.println("Data deleted from table successfully.");
					else
						System.out.println("Data deletion failed!");
					break;

				case 3:
					if (args.length != 3)
						System.out.println("Invalid amount of Data!");
					else if (studentDatabase.update(Integer.parseInt(args[1]), Integer.parseInt(args[2])))
						System.out.println("Data updated in table successfully.");
					else
						System.out.println("Data update failed!");
					break;

				case 4:
					try
					{ studentDatabase.display(Integer.parseInt(args[1])); }
					catch (Exception ex)
					{ studentDatabase.displayAll(); }
					break;

				default:
					System.out.println("Invalid option! Options are from 1 to 4.");
					break;
			}
		}
		catch (NumberFormatException ex)
		{
			System.out.println("Exception occured");
			System.out.println(ex.getMessage() + ", as it is not a number as specified!");
		}
		catch (StringIndexOutOfBoundsException ex)
		{
			System.out.println("Exception occured! Empty data values not allowed");
		}
		catch (ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("Exception occured! No arguments entered");
		}
		catch (Exception ex)
		{
			System.out.println("Unknown exception occured!");
			System.out.println(ex + "\n");
		}
		finally
		{ studentDatabase.closeConnection(); }
	}
}