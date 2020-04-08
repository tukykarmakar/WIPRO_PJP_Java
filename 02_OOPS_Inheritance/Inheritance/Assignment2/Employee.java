class Employee extends Person
{
	private String national_insurance_number;
	private double annual_salary;
	private int joining_year;

	Employee(String empName, String empNIN, double empAnnualSalary, int empJoiningYear)
	{
		super(empName);
		this.setNIN(empNIN);
		this.setAnnualSalary(empAnnualSalary);
		this.setJoiningYear(empJoiningYear);
	}

	public void setNIN(String empNIN)
	{	this.national_insurance_number = empNIN;	}
	public void setAnnualSalary(double empAnnualSalary)
	{	this.annual_salary = empAnnualSalary;		}
	public void setJoiningYear(int empJoiningYear)
	{	this.joining_year = empJoiningYear;			}

	public String getNIN()
	{	return this.national_insurance_number;	}
	public double getAnnualSalary()
	{	return this.annual_salary;				}
	public int getJoiningYear()
	{	return this.joining_year;				}
}