import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;

class Employee implements Comparable<Employee>
{
	private String firstName, lastName, email, address;
	private long mobileNumber;

	Employee(String first_name, String last_name, long mobile_number, String email_address, String resident_address)
	{
		super();
		this.setFirstName(first_name);
		this.setLastName(last_name);
		this.setMobileNumber(mobile_number);
		this.setEmail(email_address);
		this.setAddress(resident_address);
	}

	public void setFirstName(String first_name)
	{ this.firstName = first_name; }
	public void setLastName(String last_name)
	{ this.lastName = last_name; }
	public void setEmail(String email_address)
	{ this.email = email_address; }
	public void setAddress(String resident_address)
	{ this.address = resident_address; }
	public void setMobileNumber(long mobile_number)
	{ this.mobileNumber = mobile_number; }

	public String getFirstName()
	{ return this.firstName; }
	public String getLastName()
	{ return this.lastName; }
	public String getEmail()
	{ return this.email; }
	public String getAddress()
	{ return this.address; }
	public long getMobileNumber()
	{ return this.mobileNumber; }

	@Override
	public int compareTo(Employee employee)
	{ return this.firstName.compareTo(employee.getFirstName()); }
}

public class TM07_Proj1
{
	static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	static Scanner scanner = new Scanner(System.in);

	static void registerEmployees(int numberOfEmployees)
	{
		String first_name, last_name, email_address, resident_address;
		long mobile_number; int i; scanner.nextLine();

		for (i = 0; i < numberOfEmployees; i++)
		{
			System.out.println("\nEnter Employee " +(i+1)+ " details:-");
			
			System.out.print("Enter the Firstname: ");
			first_name = scanner.nextLine();

			System.out.print("Enter the Lastname: ");
			last_name = scanner.nextLine();

			System.out.print("Enter the Mobile Number: ");
			mobile_number = scanner.nextLong(); scanner.nextLine();

			System.out.print("Enter the Email: ");
			email_address = scanner.nextLine();

			System.out.print("Enter the Address: ");
			resident_address = scanner.nextLine();

			employeeList.add(new Employee(first_name, last_name, mobile_number, email_address, resident_address));
		}
	}

	static void displayEmployeeList()
	{
		Employee employee = null; Collections.sort(employeeList);
		System.out.format("\n%-15s %-15s %-15s %-30s %-15s\n", "Firstname", "Lastname", "Mobile", "Email", "Address");

		for (Iterator<Employee> iter = employeeList.iterator(); iter.hasNext(); )
		{
			employee = iter.next();
			System.out.format("%-15s %-15s %-15s %-30s %-15s\n",
			employee.getFirstName(), employee.getLastName(), employee.getMobileNumber(), employee.getEmail(), employee.getAddress());
		}
	}

	public static void main(String args[])
	{
		System.out.print("Enter the Number of Employees: ");
		registerEmployees(scanner.nextInt());

		displayEmployeeList();
		scanner.close();
	}
}