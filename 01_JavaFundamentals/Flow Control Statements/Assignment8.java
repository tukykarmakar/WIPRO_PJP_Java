import java.util.Scanner;

class Assignment8
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Enter a colour code: ");
		char code = scanner.nextLine().charAt(0);
		scanner.close();

		switch (code)
		{
			case 'B': System.out.println("Blue");
			break;

			case 'G': System.out.println("Green");
			break;

			case 'O': System.out.println("Orange");
			break;

			case 'R': System.out.println("Red");
			break;

			case 'W': System.out.println("White");
			break;

			case 'Y': System.out.println("Yellow");
			break;

			default: System.out.println("Invalid Code");
			break;
		}

	}
}