class Student extends Person
{
	private String studentID;
	Student(String studentName, String studentDOB, String student_ID)
	{
		super(studentName, studentDOB);
		this.setStudentID(student_ID);
	}

	public void setStudentID(String student_ID)
	{	this.studentID = student_ID;	}
	public String getStudentID()
	{	return this.studentID;			}
}