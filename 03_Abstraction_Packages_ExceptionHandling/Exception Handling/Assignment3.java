import java.util.Scanner;
class Assignment3
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		try
		{
			System.out.print("Enter the number of elements in the array: ");
			int arraySize = scanner.nextInt();
			int array[] = new int[arraySize];

			System.out.println("Enter the elements in the array");
			for (int i = 0; i < array.length; i++)
				array[i] = scanner.nextInt();

			System.out.print("Enter the index of the array element you want to access: ");
			int index = scanner.nextInt(); scanner.close();
		
			System.out.println("The array element at index " + index + " = " + array[index]);
			System.out.println("The array element successfully accessed");
		}
		catch (Exception e)
		{
			System.out.println(e.getClass().getName());
		}
	}
}