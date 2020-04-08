import java.util.InputMismatchException;
import java.util.Scanner;
class Assignment3
{
	public static void main(String args[])
	{
		int number = 0; Scanner scanner = new Scanner(System.in);
		
		while (number < 1 || number > 255)
		{
			try
			{
				System.out.print("Enter an integer within 1 to 255: ");
				number = Integer.parseInt(scanner.next());
			}
			catch(NumberFormatException e)
			{ System.out.println("That was not an integer. Please enter an integer."); }

			if (number < 1 || number > 255)
				System.out.println("The integer should be within 1 and 255.");
		}

		String binary = Integer.toBinaryString(number);
		System.out.println(("00000000".substring(binary.length())+binary));
		scanner.close();
	}
}