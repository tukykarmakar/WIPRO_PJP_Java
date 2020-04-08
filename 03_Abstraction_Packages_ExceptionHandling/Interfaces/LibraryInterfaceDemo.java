import java.util.Scanner;

interface LibraryUser
{
	void registerAccount();
	void requestBook();
}
class KidUser implements LibraryUser
{
	int age, returnWithin = 10; String bookType = "Kids";

	public void registerAccount()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your age: ");
		int ageInput = scanner.nextInt();

		if (ageInput <= 12)
		{
			System.out.println("You have successfully registered under a Kids Account");
			this.age = ageInput;
		}
		else
			System.out.println("Sorry, Age must be less than 12 to register as a kid");
	}
	public void requestBook()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the type of book you want: ");
		String bookTypeInput = scanner.nextLine();
		
		if (bookTypeInput.equalsIgnoreCase(this.bookType))
			System.out.println("Book Issued successfully, please return the book within " + this.returnWithin + " days");
		else
			System.out.println("Oops, you are allowed to take only kids books");
	}
}
class AdultUser implements LibraryUser
{
	int age, returnWithin = 7; String bookType = "Fiction";

	public void registerAccount()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your age: ");
		int ageInput = scanner.nextInt();

		if (ageInput > 12)
		{
			System.out.println("You have successfully registered under an Adult Account");
			this.age = ageInput;
		}
		else
			System.out.println("Sorry, Age must be greater than 12 to register as an adult");
	}
	public void requestBook()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the type of book you want: ");
		String bookTypeInput = scanner.nextLine();
		
		if (bookTypeInput.equalsIgnoreCase(this.bookType))
			System.out.println("Book Issued successfully, please return the book within " + this.returnWithin + " days");
		else
			System.out.println("Oops, you are allowed to take only adult Fiction books");
	}
}
public class LibraryInterfaceDemo
{
	public static void main(String args[])
	{
		KidUser kid = new KidUser();
		AdultUser adult = new AdultUser();

		kid.registerAccount();
		kid.requestBook();
		
		adult.registerAccount();
		adult.requestBook();
	}
}