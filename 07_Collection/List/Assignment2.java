import java.util.ArrayList;

class Employee
{
	private String empName, empEmail, empGender;
	private int empID;
	private double empSalary;

	Employee(String name, String email, String gender, int id, double salary)
	{
		this.setName(name); this.setEmail(email); this.setGender(gender);
		this.setID(id); this.setSalary(salary);
	}

	public void getEmployeeDetails()
	{
		System.out.println("Employee ID:\t\t" + this.empID);
		System.out.println("Employee Name:\t\t" + this.empName);
		System.out.println("Employee Gender:\t" + this.empGender);
		System.out.println("Employee Email:\t\t" + this.empEmail);
		System.out.println("Employee Salary:\t" + this.empSalary);
	}

	public void setName(String name)
	{ this.empName = name; }
	public void setEmail(String email)
	{ this.empEmail = email; }
	public void setGender(String gender)
	{ this.empGender = gender; }
	public void setID(int id)
	{ this.empID = id; }
	public void setSalary(double salary)
	{ this.empSalary = salary; }

	public String getName()
	{ return this.empName; }
	public String getEmail()
	{ return this.empEmail; }
	public String getGender()
	{ return this.empGender; }
	public int getID()
	{ return this.empID; }
	public double getSalary()
	{ return this.empSalary; }
}
class EmployeeDB
{
	ArrayList<Employee> list = new ArrayList<Employee>();

	public boolean addEmployee(Employee e)
	{
		for (Employee employee : list)
			if (employee.getID() == e.getID())
				return false;

		list.add(e); return true;
	}
	public boolean deleteEmployee(int empID)
	{
		for (Employee employee : list)
			if (employee.getID() == empID)
			{
				list.remove(employee);
				return true;
			}
		return false;
	}
	public String showPaySlip(int empID)
	{
		for (Employee employee : list)
			if (employee.getID() == empID)
				return ("Employee ID:\t" +employee.getID()+ "\nEmployee Name:\t" +employee.getName()+ "\nAmount Paid:\t" +employee.getSalary());
				
		return ("No employee found with ID: " + empID);
	}
}
class Assignment2
{
	public static void main(String args[])
	{
		Employee employee1 = new Employee("Alice Doe", "alice_doe@gmail.com", "Female", 123, 30000);
		Employee employee2 = new Employee("Bob Doe", "bobdoe@gmail.com", "Male", 456, 40000);
		Employee employee3 = new Employee("Charles Doe", "DoeCharles@gmail.com", "Male", 789, 50000);
		EmployeeDB database = new EmployeeDB();

		if (!database.addEmployee(employee1))
			System.out.println("\nEmployee with ID " + employee1.getID() + " already exists!");
		else
		{
			System.out.println("\nEmployee added with following details");
			employee1.getEmployeeDetails();
		}

		if (!database.addEmployee(employee2))
			System.out.println("\nEmployee with ID " + employee2.getID() + " already exists!");
		else
		{
			System.out.println("\nEmployee added with following details");
			employee2.getEmployeeDetails();
		}

		if (!database.addEmployee(employee3))
			System.out.println("\nEmployee with ID " + employee3.getID() + " already exists!");
		else
		{
			System.out.println("\nEmployee added with following details");
			employee3.getEmployeeDetails();
		}

		if (!database.addEmployee(employee1))
			System.out.println("\nEmployee with ID " + employee1.getID() + " already exists!");
		else
		{
			System.out.println("\nEmployee added with following details");
			employee1.getEmployeeDetails();
		}

		int id1 = 123, id2 = 101;
		if (!database.deleteEmployee(id1))
			System.out.println("\nNo employee found with ID: " + id1);
		else
			System.out.println("\nEmployee with ID " + id1 + " removed.");

		if (!database.deleteEmployee(id2))
			System.out.println("\nNo employee found with ID: " + id2);
		else
			System.out.println("\nEmployee with ID " + id2 + " removed.");

		id1 = 456;
		System.out.println("\nPay Slip");
		System.out.println(database.showPaySlip(id1));
		System.out.println(database.showPaySlip(id2));
	}
}