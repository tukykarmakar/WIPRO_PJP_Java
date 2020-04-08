import java.util.Scanner;
class Assignment1
{
	static boolean checkPalindrome(String input)
	{
		StringBuffer stringBuffer = new StringBuffer(input);

		return input.equalsIgnoreCase(stringBuffer.reverse().toString());
	}
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter any string: ");
		String input = scanner.nextLine();
		scanner.close();
		
		if (checkPalindrome(input))
			System.out.println(input + " is a Palindrome");
		else
			System.out.println(input + " is not a Palindrome");
	}
}