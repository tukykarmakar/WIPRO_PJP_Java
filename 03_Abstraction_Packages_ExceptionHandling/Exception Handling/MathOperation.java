class FiveIntegersNotGiven extends Exception
{
	FiveIntegersNotGiven()
	{ super("Five integers were not entered."); }
}
class MathOperation
{
	public static void main(String args[]) throws FiveIntegersNotGiven
	{
		int i, sum = 0; double average;
		try
		{
			if (args.length != 5)
				throw new FiveIntegersNotGiven();

			for (i = 0; i < args.length; i++)
				sum = sum + Integer.parseInt(args[i]);
			average = 1.0 * sum / args.length;

			System.out.println("The sum of entered numbers is " + sum);
			System.out.println("The average of entered numbers is " + average);
		}
		catch(Exception e)
		{
			System.out.println(e.getClass().getName());
		}
	}
}