import java.util.Scanner;
import java.util.Iterator;
import java.util.LinkedList;

public class TM07_Proj2
{
	static Scanner scanner = new Scanner(System.in);
	static LinkedList<String> stringList = new LinkedList<String>();
	
	static int showOptions()
	{
		int choice = 5;

		System.out.println();
		System.out.println("1. Insert");
		System.out.println("2. Search");
		System.out.println("3. Delete");
		System.out.println("4. Display");
		System.out.println("5. Exit");
		System.out.print("Enter your choice: ");

		try
		{
			choice = scanner.nextInt();
			scanner.nextLine();
		}
		catch(Exception e)
		{ System.out.println("Please enter proper choice values."); }

		return choice;
	}
	public static void main(String args[])
	{
		int choice = 0;

		while (choice != 5)
		{
			choice = showOptions();
			switch(choice)
			{
				case 1: System.out.print("Enter item to be inserted: ");
						stringList.add(scanner.nextLine());
						System.out.println("Inserted Successfully");
						break;

				case 2: System.out.print("Enter the item to be searched: ");
						if (stringList.contains(scanner.nextLine()))
							System.out.println("Item found in the list");
						else
							System.out.println("Item not found in the list");
						break;

				case 3: System.out.print("Enter the item to delete: ");
						if (stringList.remove(scanner.nextLine()))
							System.out.println("Deleted successfully");
						else
							System.out.println("Item does not exist");
						break;

				case 4: System.out.println("\nThe items in the list are:");
						for (Iterator<String> iter = stringList.iterator(); iter.hasNext(); )
							System.out.println(iter.next());
						break;

				case 5: System.out.println("");
						break;

				default:System.out.println("Invalid choice! Try again.");
						break;
			}
		}
	}
}