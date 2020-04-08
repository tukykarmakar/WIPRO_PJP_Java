import java.util.Scanner;

class Assignment8
{
	static String removeStarAndNeighbours(String input)
	{
		StringBuffer stringBuffer = new StringBuffer(input);
		int start = stringBuffer.indexOf("*") - 1;
		int end = stringBuffer.indexOf("*") + 2;

		stringBuffer.delete(start, end);

		return stringBuffer.toString();
	}
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String input = scanner.nextLine();
		scanner.close();

		System.out.println(removeStarAndNeighbours(input));
	}
}