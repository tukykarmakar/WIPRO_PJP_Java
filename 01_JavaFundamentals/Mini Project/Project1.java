class Project1
{
	static int empIDList[] = {1001, 1002, 1003, 1004, 1005, 1006, 1007};
	static String empNameList[] = {"Ashish", "Shushma", "Rahul", "Chahat", "Ranjan", "Suman", "Tanmay"};
	static String empJoiningDate[] = {"01/04/2009", "23/08/2012", "12/11/2008", "29/01/2013", "16/07/2005", "01/01/2000", "12/06/2006"};
	static char empDesignationCodeList[] = {'e', 'c', 'k', 'r', 'm', 'e', 'c'};
	static String empDepartmentList[] = {"R&D", "PM", "Acct", "Front Desk", "Engg", "Manufacturing", "PM"};
	static int empBasicList[] = {20000, 30000, 10000, 12000, 50000, 23000, 29000};
	static int empHRAList[] = {8000, 12000, 8000, 6000, 20000, 9000, 12000};
	static int empITList[] = {3000, 9000, 1000, 2000, 20000, 4400, 10000};

	static char designationCode[] = {'e', 'c', 'k', 'r', 'm'};
	static String designation[] = {"Engineering", "Consultant", "Clerk", "Recepionist", "Manger"};
	static int da[] = {20000, 32000, 12000, 15000, 40000};

	static int getIndexOf(String array[], String value)
	{
		for (int i = 0; i < array.length; i++)
			if (array[i].equals(value))
				return i;

		return -1;
	}
	static int getIndexOf(char array[], char value)
	{
		for (int i = 0; i < array.length; i++)
			if (array[i] == value)
				return i;

		return -1;
	}
	static int getIndexOf(int array[], int value)
	{
		for (int i = 0; i < array.length; i++)
			if (array[i] == value)
				return i;

		return -1;
	}

	static String getDesignation(char code)
	{
		int index = getIndexOf(designationCode, code);
		return designation[index];
	}

	static int calculateSalary(int employeeIndex)
	{
		int daValueIndex = getIndexOf(designationCode, empDesignationCodeList[employeeIndex]);
		int daValue = da[daValueIndex];
		int basicValue = empBasicList[employeeIndex];
		int HRAValue = empHRAList[employeeIndex];
		int ITValue = empITList[employeeIndex];

		return (basicValue + HRAValue + daValue - ITValue);
	}

	static void showEmployeeInformation(int empID)
	{
		int employeeIndex = getIndexOf(empIDList, empID);

		if (employeeIndex < 0)
			System.out.println("There is no employee with empid : " + empID);
		else
		{
			String dataFieldName[] = {"Emp No.", "Emp Name", "Department", "Designation", "Salary"};
			String dataFieldValue[] = new String[dataFieldName.length];

			for (int i = 0; i < dataFieldName.length; i++)
			{
				switch(i)
				{
					case 0: dataFieldValue[i] = "" + empIDList[employeeIndex];
					break;

					case 1: dataFieldValue[i] = "" + empNameList[employeeIndex];
					break;

					case 2: dataFieldValue[i] = "" + empDepartmentList[employeeIndex];
					break;

					case 3: dataFieldValue[i] = "" + getDesignation(empDesignationCodeList[employeeIndex]);
					break;

					case 4: dataFieldValue[i] = "" + calculateSalary(employeeIndex);
					break;
				}

				System.out.print(dataFieldName[i] + "\t");
			}

			System.out.println();
			for (int i = 0; i < dataFieldValue.length; i++)
				System.out.print(dataFieldValue[i] + "\t");
		}
	}
	public static void main(String args[])
	{
		try
		{
			if (args.length == 1)
			{
				int empID = Integer.parseInt(args[0]);
				showEmployeeInformation(empID);
			}
			else
				throw new Exception();
		}
		catch (Exception e)
		{
			System.out.println("Please enter Employee Number");
		}
	}
}