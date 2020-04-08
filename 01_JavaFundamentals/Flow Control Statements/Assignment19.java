class Assignment19
{
	public static void main(String args[])
	{
		int i = 6, count = 0;
		
		while (count < 5)
		{
			if (i % 2 == 0 && i % 3 == 0 && i % 5 == 0)
			{
				System.out.println(i);
				count++;
			}
			i++;
		}
	}
}