class Assignment8
{
	static int[] successive6and7(int array[])
	{
		int i, avoidIndex[] = new int[2];

		for (i = 0; i < array.length; i++)
			if (array[i] == 6)
			{
				avoidIndex[0] = i; break;
			}
		for (i = 0; i < array.length; i++)
			if (array[i] == 7)
			{
				avoidIndex[1] = i; break;
			}

		if (avoidIndex[0] < avoidIndex[1])
			return avoidIndex;

		avoidIndex[0] = array.length;
		avoidIndex[1] = -1;
		return avoidIndex;
	}
	static void specialSum(int array[])
	{
		int i, sum = 0, avoidIndex[] = successive6and7(array);

		System.out.println("The array is");
		for (i = 0; i < array.length; i++)
		{
			System.out.printf(array[i] + " ");
			if (i < avoidIndex[0] || i > avoidIndex[1])
				sum = sum + array[i];
		}
		System.out.println("\nThe sum is " + sum);
	}
	public static void main(String args[])
	{
		int array1[] = {10, 3, 6, 1, 2, 7, 9};
		int array2[] = {7, 1, 2, 3, 6};

		specialSum(array1);
		specialSum(array2);
	}
}