import java.util.Vector;
import java.util.Iterator;
import java.util.Enumeration;

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
		System.out.println();
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

class Assignment7
{
	public static void main(String args[])
	{
		Vector<Employee> employeeVector = new Vector<Employee>();
		
		employeeVector.add(new Employee("Alice Doe", "alice_doe@gmail.com", "Female", 123, 30000));
		employeeVector.add(new Employee("Bob Doe", "bobdoe@gmail.com", "Male", 456, 40000));
		employeeVector.add(new Employee("Charles Doe", "DoeCharles@gmail.com", "Male", 789, 50000));

		System.out.println("\n-------Using Iterator-------");
		for (Iterator<Employee> e = employeeVector.iterator(); e.hasNext();)
    		e.next().getEmployeeDetails();

		System.out.println("\n-----Using Enumerations-----");
		for (Enumeration<Employee> e = employeeVector.elements(); e.hasMoreElements();)
    		e.nextElement().getEmployeeDetails();
	}
}