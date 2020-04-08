class Assignment16
{
	static void forFloyd(int rows)
	{
		int i, j;
		for (i = 1; i <= rows; i++)
		{
			for (j = 1; j <= i; j++)
				System.out.printf("* ");
			System.out.printf("\n");
		}
	}
	static void whileFloyd(int rows)
	{
		int i = 0, j = 0;
		while (i <= rows)
		{
			j = 0;
			while (j <= i)
			{
				System.out.printf("* ");
				j++;
			}
			System.out.printf("\n");
			i++;
		}
	}
	public static void main(String args[])
	{
		try
		{
			int rows = Integer.parseInt(args[0]);
			forFloyd(rows);
			whileFloyd(rows);
		}
		catch (Exception e)
		{
			System.out.println("Please enter an integer number");
		}
	}
}