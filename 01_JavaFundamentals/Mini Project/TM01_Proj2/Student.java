package com.mile1.bean;

public class Student
{
	private String name;
	private int marks[];

	public Student()
	{}

	public Student(String studentName, int studentMarks[])
	{
		this.setName(studentName);
		this.setMarks(studentMarks);
	}

	public void setName(String studentName)
	{	this.name = studentName;	}
	public void setMarks(int studentMarks[])
	{	this.marks = studentMarks;	}

	public String getName()
	{	return this.name;	}
	public int[] getMarks()
	{	return this.marks;	}
}