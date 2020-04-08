class Assignment2
{
	public static void main(String args[])
	{
		int array[] = {1, 2, 3, 4, 5};
		int i, max = array[0], min = max;

		for (i = 0; i < array.length; i++)
		{
			if (max < array[i]) max = array[i];
			
			if (min > array[i]) min = array[i];
		}

		System.out.println("The maximum of the elements in the array is " + max);
		System.out.println("The minimum of the elements in the array is " + min);
	}
}