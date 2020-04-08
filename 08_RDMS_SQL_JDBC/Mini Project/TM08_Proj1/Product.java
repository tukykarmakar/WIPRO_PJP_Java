package com.wipro.sales.bean;

public class Product
{
	private String productID, productName;
	private int quantityOnHand, reorderLevel;
	private double productUnitPrice;

	public String getProductID()
	{ return this.productID; }
	public String getProductName()
	{ return this.productName; }
	public int getQuantityOnHand()
	{ return this.quantityOnHand; }
	public int getReorderLevel()
	{ return this.reorderLevel; }
	public double getProductUnitPrice()
	{ return this.productUnitPrice; }

	public void setProductID(String product_ID)
	{ this.productID = product_ID; }
	public void setProductName(String product_name)
	{ this.productName = product_name; }
	public void setQuantityOnHand(int quantity_on_hand)
	{ this.quantityOnHand = quantity_on_hand; }
	public void setReorderLevel(int recorder_level)
	{ this.reorderLevel = recorder_level; }
	public void setProductUnitPrice(double product_unit_price)
	{ this.productUnitPrice = product_unit_price; }
}