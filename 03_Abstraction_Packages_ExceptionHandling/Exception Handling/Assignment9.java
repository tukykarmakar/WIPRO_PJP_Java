import java.util.Scanner;
class DivideByZeroException extends Exception
{
	DivideByZeroException()
	{ super("Trying to divie by Zero"); }
}
class Assignment9
{
	static double divide(double a, double b) throws DivideByZeroException
	{
		if (b == 0)
			throw new DivideByZeroException();
		return (1.0*a/b);
	}
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		try
		{
			System.out.print("Enter the 2 numbers: ");
			int x = scanner.nextInt();
			int y = scanner.nextInt();

			System.out.println("The quotient of " + x + "/" + y + " = " + divide(x, y));
			scanner.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getClass().getName() + " caught");
		}
		finally
		{
			System.out.println("Inside finally block");
		}
	}
}