import java.util.Scanner;
class MarksValueOutOfRange extends Exception
{
	MarksValueOutOfRange()
	{ super("Marks should be in range of 0-100."); }
}
class NegativeMarksValue extends Exception
{
	NegativeMarksValue()
	{ super("Marks cannot be negative."); }
}
class Student
{
	String name; int marks[];
	Student(String name, int[] marks)
	{
		this.name = name;
		this.marks = marks;
	}
	double calculateAverage() throws NegativeMarksValue, MarksValueOutOfRange
	{
		int i, sum = 0;
		for (i = 0; i < marks.length; i++)
		{
			if (marks[i] < 0)
				throw new NegativeMarksValue();
			if (marks[i] > 100)
				throw new MarksValueOutOfRange();
			sum = sum + marks[i];
		}
		return (1.0*sum/marks.length);
	}
}

public class Assignment6
{
	public static void main(String args[]) throws NegativeMarksValue, MarksValueOutOfRange
	{
		int i, j, numberOfStudents = 2, numberOfSubjects = 3;
		int studentMarks[] = new int[numberOfSubjects]; String studentName;
		Student student[] = new Student[numberOfStudents];
		Scanner scanner = new Scanner(System.in);

		for (i = 0; i < student.length; i++)
		{
			System.out.print("Enter student " + (i+1) + " name: ");
			studentName = scanner.nextLine();

			System.out.println("Enter " + studentName + "'s marks of " + numberOfSubjects + " subjects");
			for (j = 0; j < studentMarks.length; j++)
			{
				try
				{
					System.out.print("Marks of Subject " + (j+1) + ": ");
					studentMarks[j] = scanner.nextInt();

					if (studentMarks[j] < 0)
						throw new NegativeMarksValue();
					if (studentMarks[j] > 100)
						throw new MarksValueOutOfRange();
				}
				catch(Exception e)
				{ System.out.println(e.getMessage()); break; }
			}

			student[i] = new Student(studentName, studentMarks);
		}

		try
		{
			for (i = 0; i < student.length; i++)
				System.out.println("Average marks of " + student[i].name + " is " + student[i].calculateAverage());
		}
		catch(Exception e)
		{ System.out.println(e.getMessage()); }

		scanner.close();
	}
}