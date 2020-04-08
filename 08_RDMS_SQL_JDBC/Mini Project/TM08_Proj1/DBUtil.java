package com.wipro.sales.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBUtil
{
	private static Connection connection = null;
	public static Connection getDBConnection(String url, String username, String password)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, username, password);
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println("Class not found!");
			System.out.println(ex.getMessage());
		}
		catch (SQLException ex)
		{
			System.out.println("SQL Exception occurred!");
			System.out.println(ex.getMessage());
		}
		catch (Exception ex)
		{
			System.out.println("Unknown Exception occurred!");
			ex.printStackTrace();
		}
		finally
		{
			return connection;
		}
	}
}