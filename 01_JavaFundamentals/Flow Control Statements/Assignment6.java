class Assignment6
{
	public static void main(String args[])
	{
		if (args.length > 0)
		{
			String gender = args[0];
			int age = Integer.parseInt(args[1]);
			double interest = 0;

			if (gender.equalsIgnoreCase("female"))
			{
				if (age >= 1 && age <= 58)
					interest = 8.2;
				else if (age >= 59 && age <= 100)
					interest = 9.2;
			}
			else if (gender.equalsIgnoreCase("male"))
			{
				if (age >= 1 && age <= 58)
					interest = 8.4;
				else if (age >= 59 && age <= 100)
					interest = 10.5;
			}

			System.out.println("The interest is " + interest + "%");
		}
		else
			System.out.println("No value entered.");
	}
}