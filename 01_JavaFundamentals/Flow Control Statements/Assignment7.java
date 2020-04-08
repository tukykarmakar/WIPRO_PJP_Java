import java.util.Scanner;

class Assignment7
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		char character = '0';

		while (!(character >= 65 && character <= 90) && !(character >= 97 && character <= 122))
		{
			System.out.printf("Enter an alphabetical character: ");
			character = scanner.nextLine().charAt(0);

			if (!(character >= 65 && character <= 90) && !(character >= 97 && character <= 122))
				System.out.println("That's not a character! Try again.");

			else
			{
				if (character >= 65 && character <= 90)
					System.out.println(character + "->" + ((char)(character+32)));
				else
					System.out.println(character + "->" + ((char)(character-32)));

				scanner.close();
			}
		}

	}
}