import java.util.Scanner;

class Assignment11
{
	static String formNewString(String input1, String input2)
	{
		StringBuffer output = new StringBuffer("");
		int i = 0, input1Length = input1.length(), input2Length = input2.length();

		while(true)
		{
			i = input1.indexOf(input2, i);

			if (i > 0)
				output.append(input1.charAt(i-1));
			if (i >= 0 && i+input2Length <= input1Length-1)
				output.append(input1.charAt(i+input2Length));
			if (i < 0)
				break;

			i++;
		}

		return output.toString();
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