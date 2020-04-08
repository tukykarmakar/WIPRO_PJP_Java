import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

class Employee implements Serializable
{
	private String id, name;
	private int age;
	private double salary;

	Employee(String empID, String empName, int empAge, double empSalary)
	{
		this.setID(empID); this.setName(empName);
		this.setAge(empAge); this.setSalary(empSalary);
	}

	public void printAllValues()
	{
		System.out.println(this.id + "\t" + this.name + "\t" + this.age + "\t" + this.salary);
	}

	public void setID(String empID)
	{ this.id = empID; }
	public void setName(String empName)
	{ this.name = empName; }
	public void setAge(int empAge)
	{ this.age = empAge; }
	public void setSalary(double empSalary)
	{ this.salary = empSalary; }

	public String getID()
	{ return this.id; }
	public String getName()
	{ return this.name; }
	public int getAge()
	{ return this.age; }
	public double getSalary()
	{ return this.salary; }
}

class TM06_Proj1
{
	static int showOptions(Scanner scanner)
	{
		System.out.println("Main Menu");
		System.out.println("1. Add an Employee");
		System.out.println("2. Display All");
		System.out.println("3. Exit");
		return (scanner.nextInt());
	}
	static void serilizeObject(Object object, String directory, String fileName, int index) throws IOException
	{
		try
		{
			directory = directory + "/"; new File(directory).mkdirs();
			FileOutputStream fileOut = new FileOutputStream(directory+fileName+index+".ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(object); objectOut.close(); fileOut.close();
		}
		catch (IOException e)
		{ System.out.println(e.getMessage()); }
	}
	static Object deserializeObject(String fileName) throws IOException, ClassNotFoundException
	{
		Object object = null;
		try
		{
			FileInputStream fileIn = new FileInputStream(fileName);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			object = (Object)objectIn.readObject();
			objectIn.close(); fileIn.close();
			return object;
		}
		catch (IOException e)
		{ System.out.println(e.getMessage()); return object; }
		catch (ClassNotFoundException e)
		{ System.out.println(e.getMessage()); return object; }
	}
	static void displayAll(String directory) throws IOException, ClassNotFoundException
	{
		Employee employee = null;
		for (File file : new File(directory).listFiles())
		{
			employee = (Employee)deserializeObject(directory+"/"+file.getName());
			employee.printAllValues(); employee = null;
		}
	}
	public static void main(String args[]) throws IOException
	{
		String storageDirectory = "Employees";
		int choice = 0, indexCounter = 1;
		Scanner scanner = new Scanner(System.in);
		Employee employee = null;

		try
		{
			String empName, empID; int empAge; double empSalary;

			while (choice != 3)
			{
				choice = showOptions(scanner);
				switch (choice)
				{
					case 1: System.out.print("Enter Employee ID: ");	empID = scanner.next();
						System.out.print("Enter Employee Name: ");	empName = scanner.next();
						System.out.print("Enter Employee Age: ");	empAge = scanner.nextInt();
						System.out.print("Enter Employee Salary: ");	empSalary = scanner.nextDouble();
						employee = new Employee(empID, empName, empAge, empSalary);
						serilizeObject(employee, storageDirectory, "EmployeeFile", indexCounter++);
						employee = null;
						break;

					case 2: System.out.println("-----Report-----");
						displayAll(storageDirectory);
						System.out.println("-----End of Report-----");
						break;

					case 3: System.out.println("Exiting the System...");
						break;

					default:System.out.println("Invalid choice! Please try again.");
						break;
				}
			}
		}
		catch (IOException e)
		{ System.out.println("Unavailable directory or file name."); }
		catch (InputMismatchException e)
		{ System.out.println("Please enter proper values as specified."); }
		catch (Exception e)
		{ System.out.println(e.getMessage()); }
		finally
		{ scanner.close(); }
	}
}
