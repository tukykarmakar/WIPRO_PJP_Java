class Assignment7
{
	static boolean presentInArray(int item, int array[])
	{
		for (int element : array)
			if (element == item)
				return true;

		return false;
	}
	static int[] removeDuplicates(int array[])
	{
		int uniqueArray[] = new int[array.length];
		int i, j = 0;

		for (i = 0; i < array.length; i++)
			if (!presentInArray(array[i], uniqueArray))
				uniqueArray[j++] = array[i];

		return uniqueArray;
	}
	public static void main(String args[])
	{
		int array[] = {12, 34, 12, 45, 67, 89};
		int uniqueArray[] = removeDuplicates(array);

		System.out.println("The original array was");
		for (int item : array)
			System.out.printf(item + " ");

		System.out.println("\nArray after removing duplicates");
		for (int item : uniqueArray)
			if (item != 0)
				System.out.printf(item + " ");
	}
}