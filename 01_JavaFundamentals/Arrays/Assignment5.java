class Assignment5
{
	public static void main(String args[])
	{
		int array[] = {1, 2, 3, 4, 5};
		int i, max1 = array[0], min1 = max1, max2 = max1, min2 = min1+1;

		for (i = 0; i < array.length; i++)
		{
			if (max1 < array[i])
			{
				max2 = max1;
				max1 = array[i];
			}
			else if (max2 < array[i])
				max2 = array[i];
			
			if (min1 > array[i])
			{
				min2 = min1;
				min1 = array[i];
			}
			else if (min2 > array[i] && min1 != array[i])
				min2 = array[i];
		}

		System.out.println("The largest two elements in the array " + max1 + " and " + max2);
		System.out.println("The smallest two elements in the array " + min1 + " and " + min2);
	}
}