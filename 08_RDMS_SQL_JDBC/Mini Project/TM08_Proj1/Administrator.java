package com.wipro.sales.service;

import java.util.ArrayList;
import java.util.Date;

import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.dao.SalesDao;
import com.wipro.sales.dao.StockDao;

public class Administrator
{
	private static SalesDao salesDao = new SalesDao();
	private static StockDao stockDao = new StockDao();

	public String insertStock(Product productObj)
	{
		String failMessage = "Data not Valid for inseriton!";
		if (productObj != null && productObj.getProductName().length() >= 2)
		{
			String productID = stockDao.generateProductID(productObj.getProductName());
			productObj.setProductID(productID);
			return (stockDao.insertStock(productObj) == 1)? productID : failMessage;
		}
		else
			return failMessage;
	}
	public String deleteStock(String productID)
	{
		return (stockDao.deleteStock(productID) == 1)? "Deleted" : "Record cannot be deleted!";
	}
	public String insertSales(Sales salesObj)
	{
		if (salesObj == null)
			return "Object not valid for inseriton!";
		if (stockDao.getStock(salesObj.getProductID()) == null)
			return "Unknown product for sale";
		if (stockDao.getStock(salesObj.getProductID()).getQuantityOnHand() < salesObj.getQuanititySold())
			return "Not enough stock on hand for sales!";
		if (salesObj.getSalesDate().before(new Date()))
			return "Invalid Date!";

		return
			(salesDao.insertSales(salesObj) == 1 && stockDao.updateStock(salesObj.getProductID(), salesObj.getQuanititySold()) == 1)?
				"Sales record iserted successfully" : "Error!";
	}
	public ArrayList<SalesReport> getSalesReport()
	{
		return salesDao.getSalesReport();
	}
}