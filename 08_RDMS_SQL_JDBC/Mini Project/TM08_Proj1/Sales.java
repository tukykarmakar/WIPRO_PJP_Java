package com.wipro.sales.bean;

public class Sales
{
	private java.util.Date salesDate;
	private String salesID, productID;
	private double salesPricePerUnit;
	private int quanititySold;
	
	public java.util.Date getSalesDate()
	{ return salesDate; }
	public String getSalesID()
	{ return salesID; }
	public String getProductID()
	{ return productID; }
	public double getSalesPricePerUnit()
	{ return salesPricePerUnit; }
	public int getQuanititySold()
	{ return quanititySold; }

	public void setSalesDate(java.util.Date salesDate)
	{ this.salesDate = salesDate; }
	public void setSalesID(String salesID)
	{ this.salesID = salesID; }
	public void setProductID(String productID)
	{ this.productID = productID; }
	public void setSalesPricePerUnit(double salesPricePerUnit)
	{ this.salesPricePerUnit = salesPricePerUnit; }
	public void setQuanititySold(int quanititySold)
	{ this.quanititySold = quanititySold; }
}