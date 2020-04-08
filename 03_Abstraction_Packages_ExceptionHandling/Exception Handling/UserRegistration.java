import java.util.Scanner;
class InvalidCountryException extends Exception
{
	InvalidCountryException()
	{ super("User Outside India cannot be registered"); }
}

class UserRegistration
{
	public static void main(String args[]) throws InvalidCountryException
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name and coutnry respectively, separated by a comma");
		String input[] = scanner.next().split(","); scanner.close();

		try
		{
			if (input[1].equalsIgnoreCase("India"))
				System.out.println("User registration done successfully");
			else
				throw new InvalidCountryException();
		}
		catch(Exception e)
		{ System.out.println(e.getMessage()); }
	}
}