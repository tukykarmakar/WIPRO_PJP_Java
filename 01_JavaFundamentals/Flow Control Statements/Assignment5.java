import java.util.Scanner;

class Assignment5
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		String type;

		System.out.printf("Enter any character: ");
		char character = scanner.next().charAt(0);
		scanner.close();

		if (character >= 48 && character <= 57)
			type = "Digit";
		else if ((character >= 65 && character <= 90) || (character >= 97 && character <= 122))
			type = "Alphabet";
		else
			type = "Special Character";

		System.out.println("'" + character + "'" + " is " + type);
	}
}