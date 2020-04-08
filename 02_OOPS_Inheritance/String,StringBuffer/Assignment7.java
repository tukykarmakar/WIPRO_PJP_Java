import java.util.Scanner;

class Assignment7
{
	static String removeTerminalX(String input)
	{
		StringBuffer stringBuffer = new StringBuffer(input);

		if (stringBuffer.charAt(0) == 'x')
			stringBuffer.deleteCharAt(0);
		if (stringBuffer.charAt(stringBuffer.length()-1) == 'x')
			stringBuffer.deleteCharAt(stringBuffer.length()-1);

		return stringBuffer.toString();
	}
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = scanner.nextLine();
		scanner.close();

		System.out.println(removeTerminalX(input));
	}
}