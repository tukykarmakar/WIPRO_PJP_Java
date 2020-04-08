package com.mile1.service;
import com.mile1.bean.*;
import com.mile1.exception.*;

public class StudentService
{
	public int findNumberOfNullMarks(Student data[])
	{
		int i, nullMarksCount = 0;

		for (i = 0; i < data.length; i++)
		{
			try
			{
				if (data[i] == null)
					nullMarksCount++;
			}
			catch(NullPointerException e) {}
		}

		return nullMarksCount;
	}
	public int findNumberOfNullNames(Student data[])
	{
		int i, nullNameCount = 0;

		for (i = 0; i < data.length; i++)
		{
			try
			{
				if (data[i] == null)
					nullNameCount++;
			}
			catch(NullPointerException e) {}
		}

		return nullNameCount;
	}
	public int findNumberOfNullObjects(Student data[])
	{
		int i, nullObjectCount = 0;

		for (i = 0; i < data.length; i++)
		{
			try
			{
				if (data[i] == null)
					nullObjectCount++;
			}
			catch(NullPointerException e)
			{
				nullObjectCount++;
			}
		}

		return nullObjectCount;
	}
}