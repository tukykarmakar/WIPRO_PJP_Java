import java.util.Scanner;
class Assignment3
{
	static String makeNewString(String input)
	{
		StringBuffer stringBuffer = new StringBuffer("");

		for (int i = 0; i < input.length(); i++)
			stringBuffer.append(input.substring(0, 2));

		return stringBuffer.toString();
	}
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter any string: ");
		String input = scanner.nextLine();
		scanner.close();
		
		System.out.println("New string is: " + makeNewString(input));
	}
}