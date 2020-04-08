class Teacher extends Person
{
	private String subject;
	private double salary;

	Teacher(String teacherName, String teacherDOB, double teacherSalary, String teacherSubject)
	{
		super(teacherName, teacherDOB);
		this.setSalary(teacherSalary);
		this.setSubject(teacherSubject);
	}

	public void setSalary(double teacherSalary)
	{	this.salary = teacherSalary;	}
	public void setSubject(String teacherSubject)
	{	this.subject = teacherSubject;	}

	public double getSalary()
	{	return this.salary;				}
	public String getSubject()
	{	return this.subject;			}
}