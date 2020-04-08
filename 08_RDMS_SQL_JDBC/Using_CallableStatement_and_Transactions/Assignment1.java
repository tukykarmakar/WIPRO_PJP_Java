import java.sql.*;

public class Assignment1
{
	public static void main(String args[])
	{
		Connection connection = null;
		Statement statement = null;
		CallableStatement callableStatement = null;

		int		port = 1521;
		String	username = "scott",
				password = "tiger",
				address = "localhost",
				sid = "ORCL",
				url = "jdbc:oracle:thin:@" + address + ":" + port + ":" + sid;

		String	tableName = "EMP",
				empnoColumn = "EMPNO",
				enameColumn = "ENAME",
				salaryColumn = "SAL";

		String	selectQuery = "SELECT * FROM " + tableName,
				salaryQuery = "{ call calculate_salary(?, ?) }";
		int empNo; String empName; double netSalary;

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, username, password);
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println("Class not found!");
			System.out.println(ex.getMessage() + "\n");
		}
		catch (SQLException ex)
		{
			System.out.println("Exception occured in SQL");
			System.out.println(ex.getMessage() + "\n");
		}

		try
		{
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectQuery);

			while (resultSet.next())
			{
				empNo = resultSet.getInt(empnoColumn);
				empName = resultSet.getString(enameColumn);
				netSalary = 0;

				callableStatement = connection.prepareCall(salaryQuery);
				callableStatement.setInt(1, empNo);
				callableStatement.registerOutParameter(2, Types.DOUBLE);

				callableStatement.executeQuery();
				netSalary = callableStatement.getByte(2);

				System.out.println(empnoColumn +":\t"+ empNo +"\n"+ enameColumn +":\t"+ empName +"\n"+ "NET SALARY:\t" + netSalary);
				System.out.println("----------------------------------------------------------------");
			}
		}
		catch (SQLException ex)
		{
			System.out.println("SQL Exception occured!");
			ex.printStackTrace();
		}
		finally
		{ connection.close(); statement.close(); callableStatement.close(); }
	}
}