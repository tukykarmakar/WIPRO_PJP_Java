class Employee implements Cloneable
{
	String name, id; int age;
	Employee(String empName, String empID, int empAge)
	{
		this.name = empName;
		this.id = empID;
		this.age = empAge;
	}
	public void setEmployeeProperties(String empName, String empID, int empAge)
	{
		this.name = empName;
		this.id = empID;
		this.age = empAge;
	}
	public void showProperties()
	{
		System.out.println("Name: " + this.name);
		System.out.println("ID: " + this.id);
		System.out.println("Age: " + this.age);
	}
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
}

class Assignment4
{
	public static void main(String args[])
	{
		Employee employee1 = new Employee("Alice Doe", "1234", 28);
		System.out.println("Original object"); employee1.showProperties();
		try
		{
			Employee employee2 = (Employee)employee1.clone();
			System.out.println("\nCloned object"); employee2.showProperties();

			employee1.setEmployeeProperties("Bob Doe", "5678", 38);
			System.out.println("\nOriginal object's properties changed");

			System.out.println("\nOriginal object"); employee1.showProperties();
			System.out.println("\nCloned object"); employee2.showProperties();
		}
		catch(Exception e)
		{ System.out.println(e.getMessage()); }
	}
}