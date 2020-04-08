package com.mile1.service;
import com.mile1.bean.*;
import com.mile1.exception.*;

public class StudentReport
{
	public String findGrade(Student studentObject)
	{
		int studentObjectMarks[] = studentObject.getMarks();
		int i, passMarks = 35, sum = 0;
		int rangeOfD[] = {passMarks, 150};
		int rangeOfC[] = {151, 200};
		int rangeOfB[] = {201, 250};
		int rangeOfA[] = {251, 300};

		for (i = 0; i < studentObjectMarks.length; i++)
		{
			if (studentObjectMarks[i] < passMarks)
				return "F";

			sum = sum + studentObjectMarks[i];
		}

		if (sum >= rangeOfD[0] && sum <= rangeOfD[1])
			return "D";
		else if (sum >= rangeOfC[0] && sum <= rangeOfC[1])
			return "C";
		else if (sum >= rangeOfB[0] && sum <= rangeOfB[1])
			return "B";
		else if (sum >= rangeOfA[0] && sum <= rangeOfA[1])
			return "A";

		return "Marks out of range";
	}

	public String validate(Student studentObject)
	throws NullStudentException, NullNameException, NullMarksArrayException
	{
		if (studentObject == null)
			throw new NullStudentException();

		if (studentObject.getName() == null)
			throw new NullNameException();

		if (studentObject.getMarks() == null)
			throw new NullMarksArrayException();

		return this.findGrade(studentObject);
	}
}