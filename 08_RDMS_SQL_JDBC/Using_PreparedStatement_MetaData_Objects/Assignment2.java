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
	public boolean insert(int rollnum, String name, String standard, String dob, int fee)
	{
		if (dataValid(rollnum, name, standard, dob, fee))
		{
			String query = "INSERT INTO " +tableName+ " VALUES(?, ?, ?, ?, ?)";
			try
			{
				this.prepStmt = this.connection.prepareStatement(query);

				this.prepStmt.setInt(1, rollnum);
				this.prepStmt.setString(2, name);
				this.prepStmt.setString(3, standard);
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
		return false;
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
	private boolean dataValid(int rollnum, String name, String standard, String dob, int fee)
	{
		boolean validity = true;
		String validStandards[] = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

		if (rollnum < 1000 || rollnum > 9999)
		{
			System.out.println("Roll Number must be of four digits.");
			validity = false;
		}
		if (name.length() > 20)
		{
			System.out.println("Name must be maximum 20 characters long.");
			validity = false;
		}
		for (int i = 0; i < validStandards.length; i++)
		{
			if (validStandards[i].equalsIgnoreCase(standard))
			{
				validity = true;
				break;
			}
			else
				validity = false;
		}

		return validity;
	}
}
public class Assignment2
{
	public static void main(String args[])
	{
		StudentDatabase studentDatabase = new StudentDatabase();
		try
		{
			if (studentDatabase.insert(Integer.parseInt(args[0]), args[1], args[2], args[3], Integer.parseInt(args[4])))
				System.out.println("Student with roll number " + args[0] + " removed from the database.");
			else
				System.out.println("Student could not be reomved!");
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