package com.wipro.sales.bean;

public class SalesReport
{
	private double productUnitPrice, salesPricePerUnit, profitAmount;
	private String salesID, productID, productName;
	private java.util.Date salesDate;
	private int quantitySold;

	public double getProductUnitPrice()
	{ return productUnitPrice; }
	public double getSalesPricePerUnit()
	{ return salesPricePerUnit; }
	public double getProfitAmount()
	{ return profitAmount; }
	public String getSalesID()
	{ return salesID; }
	public String getProductID()
	{ return productID; }
	public String getProductName()
	{ return productName; }
	public java.util.Date getSalesDate()
	{ return salesDate; }
	public int getQuantitySold()
	{ return quantitySold; }

	public void setProductUnitPrice(double productUnitPrice)
	{ this.productUnitPrice = productUnitPrice; }
	public void setSalesPricePerUnit(double salesPricePerUnit)
	{ this.salesPricePerUnit = salesPricePerUnit; }
	public void setProfitAmount(double profitAmount)
	{ this.profitAmount = profitAmount; }
	public void setSalesID(String salesID)
	{ this.salesID = salesID; }
	public void setProductID(String productID)
	{ this.productID = productID; }
	public void setProductName(String productName)
	{ this.productName = productName; }
	public void setSalesDate(java.util.Date salesDate)
	{ this.salesDate = salesDate; }
	public void setQuantitySold(int quantitySold)
	{ this.quantitySold = quantitySold; }
}