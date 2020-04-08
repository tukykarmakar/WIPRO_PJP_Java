class Assignment3
{
	public static void main(String args[])
	{
		Person person = new Person("Alice Smith", "01/01/1981");
		Teacher teacher = new Teacher("Bob Smith", "01/02/1981", 250000, "Java");
		Student student = new Student("Carol Shelby", "11/01/1993", "FMGT1969");
		CollegeStudent collegeStudent = new CollegeStudent("Benjamin Dover", "20/04/1969", "FML42FU2020", "ABC College", "Fourth");

		System.out.println("Person Name:\t" + person.getName());
		System.out.println("Person D.O.B:\t" + person.getDOB());
		System.out.println();
		System.out.println("Teacher Name:\t\t" + teacher.getName());
		System.out.println("Teacher D.O.B:\t\t" + teacher.getDOB());
		System.out.println("Teacher Salary:\t\t" + teacher.getSalary());
		System.out.println("Teacher Subject:\t" + teacher.getSubject());
		System.out.println();
		System.out.println("Student Name:\t" + student.getName());
		System.out.println("Student D.O.B:\t" + student.getDOB());
		System.out.println("Student ID:\t" + student.getStudentID());
		System.out.println();
		System.out.println("College Student Name:\t\t" + collegeStudent.getName());
		System.out.println("College Student D.O.B:\t\t" + collegeStudent.getDOB());
		System.out.println("College Student ID:\t\t" + collegeStudent.getStudentID());
		System.out.println("College Student College Name:\t" + collegeStudent.getCollegeName());
		System.out.println("College Student Current Year:\t" + collegeStudent.getCurrentYear());
	}
}