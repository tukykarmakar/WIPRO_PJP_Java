import java.util.Arrays;
class Assignment6
{
	public static void main(String args[])
	{
		int array[] = {12, 34, 12, 45, 67, 89};

		System.out.println("Array before sorting:-");
		for (int item : array)
			System.out.printf(item + " ");

		Arrays.sort(array);

		System.out.println("\nArray before sorting:-");
		for (int item : array)
			System.out.printf(item + " ");
		
	}
}