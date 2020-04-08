import java.io.*;
import java.util.Date;

class Employee implements Serializable
{
	private String name, department, designation;
	private double salary; Date dateOfBirth;

	Employee(String empName, String empDepartment, String empDesignation, double empSalary, Date empDOB)
	{
		this.setName(empName);
		this.setDepartment(empDepartment);
		this.setDesignation(empDesignation);
		this.setSalary(empSalary);
		this.setSalary(empSalary);
		this.setDOB(empDOB);
	}

	public void setName(String empName)
	{ this.name = empName; }
	public void setDepartment(String empDepartment)
	{ this.department = empDepartment; }
	public void setDesignation(String empDesignation)
	{ this.designation = empDesignation; }
	public void setSalary(double empSalary)
	{ this.salary = empSalary; }
	public void setDOB(Date empDOB)
	{ this.dateOfBirth = empDOB; }

	public String getName()
	{ return this.name; }
	public String getDepartment()
	{ return this.department; }
	public String getDesignation()
	{ return this.designation; }
	public double getSalary()
	{ return this.salary; }
	public Date getDOB()
	{ return this.dateOfBirth; }
}
class Assignment1
{
	static void serializeObject(Employee employee)
	{
		try
		{
			FileOutputStream fileOut = new FileOutputStream("Employee.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(employee); objectOut.close();
			fileOut.close();
		}
		catch (IOException e)
		{ System.out.println(e.getMessage()); }
	}
	static Employee deserializeObject()
	{
		Employee employee = null;
		try
		{
			FileInputStream fileIn = new FileInputStream("Employee.ser");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			employee = (Employee)objectIn.readObject();
			objectIn.close(); fileIn.close();
			return employee;
		}
		catch (IOException e)
		{ System.out.println(e.getMessage()); return employee; }
		catch (ClassNotFoundException e)
		{ System.out.println(e.getMessage()); return employee; }
	}
	public static void main(String args[])
	{
		Employee employee1 = new Employee("Bob Doe", "Senior Accountant", "Finance", 40000, new Date(90, 03, 15));
		serializeObject(employee1);
		Employee employee2 = deserializeObject();

		System.out.println("\nSerialized Object:-");
		System.out.println("Name:\t\t" + employee1.getName());
		System.out.println("Date of Birth:\t" + employee1.getDOB().toString());
		System.out.println("Designation:\t" + employee1.getDesignation());
		System.out.println("Department:\t" + employee1.getDepartment());
		System.out.println("Salary:\t\t" + employee1.getSalary());
		
		System.out.println("\nDeserialized Object:-");
		System.out.println("Name:\t\t" + employee2.getName());
		System.out.println("Date of Birth:\t" + employee2.getDOB().toString());
		System.out.println("Designation:\t" + employee2.getDesignation());
		System.out.println("Department:\t" + employee2.getDepartment());
		System.out.println("Salary:\t\t" + employee2.getSalary());
	}
}