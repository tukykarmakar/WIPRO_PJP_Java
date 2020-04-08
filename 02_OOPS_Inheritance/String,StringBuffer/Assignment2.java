import java.util.Scanner;
class Assignment2
{
	static String concatenateStrings(String input1, String input2)
	{
		StringBuffer stringBuffer1 = new StringBuffer(input1);
		StringBuffer stringBuffer2 = new StringBuffer(input2);

		if (stringBuffer1.charAt(stringBuffer1.length()-1) == stringBuffer2.charAt(0))
			stringBuffer2.deleteCharAt(0);

		stringBuffer1.append(stringBuffer2);

		return stringBuffer1.toString().toLowerCase();
	}
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter any two strings separated by comma: ");
		String input[] = scanner.nextLine().split(",");
		scanner.close();

		System.out.println("New string is: " + concatenateStrings(input[0], input[1]));
	}
}