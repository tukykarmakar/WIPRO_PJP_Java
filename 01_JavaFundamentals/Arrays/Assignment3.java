class Assignment3
{
	static int search(int array[], int element)
	{
		for (int i = 0; i < array.length; i++)
			if (array[i] == element)
			{
				return i;
			}
		return -1;
	}
	public static void main(String args[])
	{
		int array[] = {1, 4, 34, 56, 7};
		int toSearch = 56;

		System.out.println(search(array, toSearch));
	}
}