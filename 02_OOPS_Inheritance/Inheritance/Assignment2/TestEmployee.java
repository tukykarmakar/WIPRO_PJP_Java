class TestEmployee
{
	public static void main(String args[])
	{
		Person person = new Person("Jane Doe");
		Employee employee = new Employee("John Doe", "1AB23C567D", 600000, 2020);

		System.out.println("Person Name:\t\t" + person.getName());
		System.out.println();
		System.out.println("Employee Name:\t\t" + employee.getName());
		System.out.println("Employee National\nInsurance Number:\t" + employee.getNIN());
		System.out.println("Employee Annual Salary:\t" + employee.getAnnualSalary());
		System.out.println("Employee Joining Year:\t" + employee.getJoiningYear());
	}
}