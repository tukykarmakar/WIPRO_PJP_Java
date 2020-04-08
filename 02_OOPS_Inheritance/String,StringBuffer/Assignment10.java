import java.util.Scanner;

class Assignment10
{
	static String makeNewString(String input, int n)
	{
		StringBuffer stringBuffer = new StringBuffer("");
		int start = input.length() - n;

		for (int i = 0; i < n; i++)
			stringBuffer.append(input.substring(start));

		return stringBuffer.toString();
	}
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string and number of characters from the end, respectively, separated by comma: ");
		String input[] = scanner.nextLine().split(",");
		scanner.close();

		System.out.println(makeNewString(input[0], Integer.parseInt(input[1])));
	}
}