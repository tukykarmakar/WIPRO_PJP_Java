class Assignment3
{
	public static void main(String args[])
	{
		if (args.length > 0)
		{
			String message = ""; int i;

			for (i = 0; i < args.length; i++)
			{
				message = message + args[i];
				if (i < args.length - 1)
					message = message + ", ";
			}

			System.out.println(message);
		}
		else
			System.out.println("No values");
	}
}