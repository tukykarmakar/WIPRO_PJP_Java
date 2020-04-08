package com.wipro.sales.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.service.Administrator;

public class SalesApplication
{
	private static Scanner scanner = new Scanner(System.in);
	private static int showOptions()
	{
		try
		{
			System.out.println("1. Insert Stock");
			System.out.println("2. Delete Stock");
			System.out.println("3. Insert Sales");
			System.out.println("4. View Sales Report");
			System.out.println("5. Exit");
			System.out.print("Enter your Choice: ");
			return scanner.nextInt();
		}
		catch (InputMismatchException ex)
		{
			System.out.println("Expected an Integer number");
			ex.printStackTrace(); return 0;
		}
	}
	public static void main(String args[])
	{
		Administrator admin = new Administrator();
		Product product = null;
		Sales sales = null;
		Date salesDate = null;
		
		String dateFormat = "dd-MM-yyyy";
		String removeProductID;
		int choice = 5;

		while (choice != 5)
		{
			choice = showOptions();
			switch (choice)
			{
				case 1:
					product = new Product();

					System.out.print("Enter product ID: ");
					product.setProductID(scanner.nextLine());

					System.out.print("Enter product name: ");
					product.setProductName(scanner.nextLine());
					
					System.out.print("Enter quantity on hand: ");
					product.setQuantityOnHand(scanner.nextInt());
					scanner.nextLine();
					
					System.out.print("Enter product unit price: ");
					product.setProductUnitPrice(scanner.nextDouble());
					
					System.out.print("Enter product reorder level: ");
					product.setReorderLevel(scanner.nextInt());
					scanner.nextLine();
					
					admin.insertStock(product);
					break;

				case 2:
					System.out.print("Enter product id to be deleted: ");
					removeProductID = scanner.nextLine();

					removeProductID = admin.deleteStock(removeProductID);

					if (removeProductID != null)
						System.out.println(removeProductID + " removed successfully");
					break;

				case 3:
					sales = new Sales();

					System.out.print("Enter sales id: ");
					sales.setSalesID(scanner.nextLine());
					
					System.out.print("Enter date (dd-mm-yyyy): ");
					try
					{ salesDate = new SimpleDateFormat(dateFormat).parse(scanner.nextLine()); }
					catch (Exception ex)
					{ System.out.println("Exception occurred when taking date input!"); }
					sales.setSalesDate(salesDate);

					System.out.print("Enter product id: ");
					sales.setProductID(scanner.nextLine());

					System.out.print("Enter quantity sold: ");
					sales.setQuanititySold(scanner.nextInt());
					scanner.nextLine();
					
					System.out.print("Enter sales price per unit: ");
					sales.setSalesPricePerUnit(scanner.nextDouble());
					
					admin.insertSales(sales);
					break;

				case 4:
					admin.getSalesReport();
					break;

				case 5:
					System.out.println("Exiting...");
					scanner.close();
					break;

				default:
					System.out.println("Please enter proper choice input");
					break;
			}
			System.gc();
		}
	}
}