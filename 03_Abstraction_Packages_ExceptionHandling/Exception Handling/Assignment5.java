import java.util.Scanner;
class DivideByZeroException extends Exception
{
	DivideByZeroException()
	{ super("Trying to divie by Zero"); }
}
class Assignment5
{
	static double divide(int a, int b) throws DivideByZeroException
	{
		if (b == 0)
			throw new DivideByZeroException();
		return (1.0*a/b);
	}
	public static void main(String args[]) throws DivideByZeroException
	{
		Scanner scanner = new Scanner(System.in);
		try
		{
			System.out.print("Enter an Integer: ");
			int x = scanner.nextInt();

			System.out.print("Enter another Integer: ");
			int y = scanner.nextInt();

			System.out.println(x + " divided by " + y + " is " + divide(x, y));
			scanner.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getClass().getName());
		}
	}
}