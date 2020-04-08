package com.wipro.sales.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.wipro.sales.bean.Sales;
import com.wipro.sales.util.DBUtil;
import com.wipro.sales.bean.SalesReport;

public class SalesDao
{
	public int insertSales(Sales sales)
	{
		int		port = 1521;
		String	username = "scott",
				password = "tiger",
				address = "localhost",
				sid = "ORCL",
				url = "jdbc:oracle:thin:@" + address + ":" + port + ":" + sid;
				
		Connection connection = null;
		PreparedStatement prepStmt = null;

		java.sql.Date salesDate = new java.sql.Date(sales.getSalesDate().getTime());
		String	tableName = "TBL_SALES";
		int		salesIDIndex = 1,
				salesDateIndex = 2,
				productIDIndex = 3,
				quantitySoldIndex = 4,
				salesPricePerUnitIndex = 5;
		String query = "INSERT INTO " +tableName+ " VALUES (?, ?, ?, ?, ?)";

		try
		{
			connection = DBUtil.getDBConnection(url, username, password);
			prepStmt = connection.prepareStatement(query);

			prepStmt.setString(salesIDIndex, sales.getSalesID());
			prepStmt.setDate(salesDateIndex, salesDate);
			prepStmt.setString(productIDIndex, sales.getProductID());
			prepStmt.setInt(quantitySoldIndex, sales.getQuanititySold());
			prepStmt.setDouble(salesPricePerUnitIndex, sales.getSalesPricePerUnit());

			connection.close(); prepStmt.close();
			return prepStmt.executeUpdate();
		}
		catch (SQLException ex)
		{
			System.out.println("SQL Exception occurred when Inserting Sales!");
			ex.printStackTrace(); return 0;
		}
		catch (Exception ex)
		{
			System.out.println("Unknown exception occurred when Generating Sales ID!");
			ex.printStackTrace(); return 0;
		}
	}
	public String generateSalesID(java.util.Date salesDate)
	{
		int		port = 1521;
		String	username = "scott",
				password = "tiger",
				address = "localhost",
				sid = "ORCL",
				url = "jdbc:oracle:thin:@" + address + ":" + port + ":" + sid;
				
		Connection connection = null;
		PreparedStatement prepStmt = null;

		int salesID;
		String	sequenceTableName = "DUAL",
				sequenceName = "SEQ_SALES_ID";
		String query = "SELECT " +sequenceName+ ".NEXTVAL FROM " +sequenceTableName;

		String output = salesDate.toString().substring(salesDate.toString().length()-2, salesDate.toString().length());

		try
		{
			connection = DBUtil.getDBConnection(url, username, password);
			prepStmt = connection.prepareStatement(query);
			ResultSet resultSet = prepStmt.executeQuery();

			resultSet.next();
			salesID = resultSet.getInt(1);

			connection.close(); prepStmt.close();
			return (output + salesID);
		}
		catch (SQLException ex)
		{
			System.out.println("SQL Exception occurred when Generating Sales ID!");
			ex.printStackTrace(); return null;
		}
		catch (Exception ex)
		{
			System.out.println("Unknown exception occurred when Generating Sales ID!");
			ex.printStackTrace(); return null;
		}
	}
	public ArrayList<SalesReport> getSalesReport()
	{
		int		port = 1521;
		String	username = "scott",
				password = "tiger",
				address = "localhost",
				sid = "ORCL",
				url = "jdbc:oracle:thin:@" + address + ":" + port + ":" + sid;
				
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String	tableName = "V_SALES_REPORT",
				salesIDColumn = "Sales_ID",
				salesDateColumn = "Sales_Date",
				productIDColumn = "Product_ID",
				productNameColumn = "Product_Name",
				quantitySoldColumn = "Quantity_Sold",
				productUnitPriceColumn = "Product_Unit_Price",
				salesPricePerUnitColumn = "Sales_Price_Per_Unit",
				profitAmountColumn = "Profit_Amount";
		String query = "SELECT * FROM " +tableName;

		ArrayList<SalesReport> salesReportList = new ArrayList<SalesReport>();
		SalesReport salesReport = null;

		try
		{
			connection = DBUtil.getDBConnection(url, username, password);
			prepStmt = connection.prepareStatement(query);
			ResultSet resultSet = prepStmt.executeQuery();

			while (resultSet.next())
			{
				salesReport = new SalesReport();
				salesReport.setSalesID(resultSet.getString(salesIDColumn));
				salesReport.setSalesDate(resultSet.getDate(salesDateColumn));
				salesReport.setProductID(resultSet.getString(productIDColumn));
				salesReport.setProductName(resultSet.getString(productNameColumn));
				salesReport.setQuantitySold(resultSet.getInt(quantitySoldColumn));
				salesReport.setProductUnitPrice(resultSet.getDouble(productUnitPriceColumn));
				salesReport.setSalesPricePerUnit(resultSet.getDouble(salesPricePerUnitColumn));
				salesReport.setProfitAmount(resultSet.getDouble(profitAmountColumn));
				salesReportList.add(salesReport);
			}

			connection.close(); prepStmt.close();
			return salesReportList;
		}
		catch (SQLException ex)
		{
			System.out.println("SQL Exception occurred when Getting Sales Report!");
			ex.printStackTrace(); return null;
		}
		catch (Exception ex)
		{
			System.out.println("Unknown Exception occurred when Getting Sales Report!");
			ex.printStackTrace(); return null;
		}
	}
}