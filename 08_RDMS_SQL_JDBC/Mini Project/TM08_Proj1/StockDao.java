package com.wipro.sales.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.wipro.sales.util.DBUtil;
import com.wipro.sales.bean.Product;

public class StockDao
{
	public int insertStock(Product product)
	{
		int		port = 1521;
		String	username = "scott",
				password = "tiger",
				address = "localhost",
				sid = "ORCL",
				url = "jdbc:oracle:thin:@" + address + ":" + port + ":" + sid;
				
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String	tableName = "TBL_STOCK";
		int		productIDIndex = 1,
				productNameIndex = 2,
				quantityOnHandIndex = 3,
				productUnitPriceIndex = 4,
				reorderLevelIndex = 5;
		String query = "INSERT INTO " +tableName+ " VALUES (?, ?, ?, ?, ?)";

		try
		{
			connection = DBUtil.getDBConnection(url, username, password);
			prepStmt = connection.prepareStatement(query);

			prepStmt.setString(productIDIndex, product.getProductID());
			prepStmt.setString(productNameIndex, product.getProductName());
			prepStmt.setInt(quantityOnHandIndex, product.getQuantityOnHand());
			prepStmt.setDouble(productUnitPriceIndex, product.getProductUnitPrice());
			prepStmt.setInt(reorderLevelIndex, product.getReorderLevel());

			connection.close(); prepStmt.close();
			return prepStmt.executeUpdate();
		}
		catch (SQLException ex)
		{
			System.out.println("SQL Exception occurred when Inserting Stock!");
			ex.printStackTrace(); return 0;
		}
		catch (Exception ex)
		{
			System.out.println("Unknown exception occurred!");
			ex.printStackTrace(); return 0;
		}
	}
	public String generateProductID(String productName)
	{
		int		port = 1521;
		String	username = "scott",
				password = "tiger",
				address = "localhost",
				sid = "ORCL",
				url = "jdbc:oracle:thin:@" + address + ":" + port + ":" + sid;
				
		Connection connection = null;
		PreparedStatement prepStmt = null;

		int productID;
		String	sequenceTableName = "DUAL",
				sequenceName = "SEQ_PRODUCT_ID";
		String query = "SELECT " +sequenceName+ ".NEXTVAL FROM " +sequenceTableName;

		try
		{
			connection = DBUtil.getDBConnection(url, username, password);
			prepStmt = connection.prepareStatement(query);
			ResultSet resultSet = prepStmt.executeQuery();

			resultSet.next();
			productID = resultSet.getInt(1);

			connection.close(); prepStmt.close();
			return (productName.substring(0, 2)+ productID);
		}
		catch (SQLException ex)
		{
			System.out.println("SQL Exception occurred when Generating Product ID!");
			ex.printStackTrace(); return null;
		}
		catch (Exception ex)
		{
			System.out.println("Unknown exception occurred when Generating Product ID!");
			ex.printStackTrace(); return null;
		}
	}
	public int updateStock(String productID, int soldQty)
	{
		int		port = 1521;
		String	username = "scott",
				password = "tiger",
				address = "localhost",
				sid = "ORCL",
				url = "jdbc:oracle:thin:@" + address + ":" + port + ":" + sid;
				
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String	tableName = "TBL_STOCK";
		String	productIDColumn = "Product_ID",
				quantityOnHandColumn = "Quantity_On_Hand";
		int		productIDIndex = 1,
				quantityOnHandIDIndex = 2;
		String query = "UPDATE TBL_STOCK SET " +quantityOnHandColumn+ " = " +quantityOnHandColumn+ " - ? " + "WHERE " +productIDColumn+ " = ?";

		try
		{
			connection = DBUtil.getDBConnection(url, username, password);
			prepStmt = connection.prepareStatement(query);

			prepStmt.setInt(quantityOnHandIDIndex, soldQty);
			prepStmt.setString(productIDIndex, productID);

			connection.close(); prepStmt.close();
			return prepStmt.executeUpdate();
		}
		catch (SQLException ex)
		{
			System.out.println("SQL Exception occurred when Updating Stock!");
			ex.printStackTrace(); return 0;
		}
		catch (Exception ex)
		{
			System.out.println("Unknown exception occurred when Updating Stock!");
			ex.printStackTrace(); return 0;
		}
	}
	public Product getStock(String productID)
	{
		int		port = 1521;
		String	username = "scott",
				password = "tiger",
				address = "localhost",
				sid = "ORCL",
				url = "jdbc:oracle:thin:@" + address + ":" + port + ":" + sid;
				
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String	tableName = "TBL_STOCK",
				productIDColumn = "Product_ID",
				productNameColumn = "Product_Name",
				quantityOnHandColumn = "Quantity_On_Hand",
				productUnitPriceColumn = "Product_Unit_Price",
				reorderLevelColumn = "Recorder_Level";
		String query = "SELECT * FROM " +tableName+ " WHERE " +productIDColumn+ " = ?";

		Product returnProduct = null;

		try
		{
			connection = DBUtil.getDBConnection(url, username, password);
			prepStmt = connection.prepareStatement(query);
			ResultSet resultSet = prepStmt.executeQuery();

			while (resultSet.next())
			{
				returnProduct = new Product();
				returnProduct.setProductID(resultSet.getString(productIDColumn));
				returnProduct.setProductName(resultSet.getString(productNameColumn));
				returnProduct.setQuantityOnHand(resultSet.getInt(quantityOnHandColumn));
				returnProduct.setProductUnitPrice(resultSet.getDouble(productUnitPriceColumn));
				returnProduct.setReorderLevel(resultSet.getInt(reorderLevelColumn));
			}

			connection.close(); prepStmt.close();
			return returnProduct;
		}
		catch (SQLException ex)
		{
			System.out.println("SQL Exception occurred when Getting Stock!");
			ex.printStackTrace(); return null;
		}
		catch (Exception ex)
		{
			System.out.println("Unknown Exception occurred when Getting Stock!");
			ex.printStackTrace(); return null;
		}
	}
	public int deleteStock(String productID)
	{
		int		port = 1521;
		String	username = "scott",
				password = "tiger",
				address = "localhost",
				sid = "ORCL",
				url = "jdbc:oracle:thin:@" + address + ":" + port + ":" + sid;
				
		Connection connection = null;
		PreparedStatement prepStmt = null;

		String	tableName = "TBL_STOCK",
				productIDColumn = "Product_ID";
		String query = "DELETE * FROM " +tableName+ " WHERE " +productIDColumn+ " = ?";

		try
		{
			connection = DBUtil.getDBConnection(url, username, password);
			prepStmt = connection.prepareStatement(query);

			prepStmt.setString(1, productID);
			connection.close(); prepStmt.close();
			return prepStmt.executeUpdate();
		}
		catch (SQLException ex)
		{
			System.out.println("SQL Exception occurred when Deleting Stock!");
			ex.printStackTrace(); return 0;
		}
		catch (Exception ex)
		{
			System.out.println("Unknown exception occurred when Deleting Stock!");
			ex.printStackTrace(); return 0;
		}
	}
}