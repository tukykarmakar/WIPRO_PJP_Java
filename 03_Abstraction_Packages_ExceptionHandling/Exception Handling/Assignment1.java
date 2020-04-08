import java.util.Scanner;
class Assignment1
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		try
		{
			System.out.print("Enter an integer: ");
			int input = scanner.nextInt(); scanner.close();
			System.out.println("The square value is " + (input*input));
			System.out.println("The work has been done successfully");
		}
		catch (Exception e)
		{
			System.out.println("Entered input is not a valid format for an integer.");
		}
	}
}