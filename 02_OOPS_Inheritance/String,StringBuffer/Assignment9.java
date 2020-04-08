import java.util.Scanner;

class Assignment9
{
	static String formNewString(String input1, String input2)
	{
		StringBuffer stringBuffer = new StringBuffer("");
		StringBuffer stringBuffer1 = new StringBuffer(input1);
		StringBuffer stringBuffer2 = new StringBuffer(input2);
		int end = (stringBuffer1.length() < stringBuffer2.length())? stringBuffer1.length() : stringBuffer2.length();

		for (int i = 0; i < end; i++)
		{
			stringBuffer.append(stringBuffer1.charAt(0));
			stringBuffer1.deleteCharAt(0);

			stringBuffer.append(stringBuffer2.charAt(0));
			stringBuffer2.deleteCharAt(0);
		}
		stringBuffer.append(stringBuffer1);
		stringBuffer.append(stringBuffer2);

		return stringBuffer.toString();
	}
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter two strings separated by comma: ");
		String input[] = scanner.nextLine().split(",");
		scanner.close();

		System.out.println(formNewString(input[0], input[1]));
	}
}