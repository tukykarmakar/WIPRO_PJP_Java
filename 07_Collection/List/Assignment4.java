import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;

class Assignment4
{
	static void printAll(ArrayList list)
	{
		Iterator iter = list.iterator();
		System.out.println("\nThe items in the list are:");
		while (iter.hasNext())
			System.out.println(iter.next());
	}
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		ArrayList<Number> list = new ArrayList<Number>();

		try
		{
			System.out.print("Enter the size of the list: ");
			int size = scanner.nextInt(); scanner.nextLine();

			for (int i = 0; i < size; i++)
			{
				System.out.print("Enter list item " + (i+1) + ": ");
				list.add(scanner.nextLine());
			}

			printAll(list);
		}
		catch (Exception e)
		{ System.out.println(e.getMessage()); }
		finally
		{ scanner.close(); }
	}
}