class CollegeStudent extends Student
{
	private String collegeName, currentYear;
	CollegeStudent(String collegeStudentName, String colledgeStudentDOB, String collegeStudentID, String college_name, String current_year)
	{
		super(collegeStudentName, colledgeStudentDOB, collegeStudentID);
		this.setCollegeName(college_name);
		this.setCurrentYear(current_year);
	}

	public void setCollegeName(String college_name)
	{	this.collegeName = college_name;	}
	public void setCurrentYear(String current_year)
	{	this.currentYear = current_year;	}

	public String getCollegeName()
	{	return this.collegeName;	}
	public String getCurrentYear()
	{	return this.currentYear;	}
}