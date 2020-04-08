class Assignment1
{
	public static void main(String args[])
	{
		int array[] = {1, 2, 3, 4, 5};
		int i, sum = 0, arrayLength = array.length;

		for (i = 0; i < arrayLength; i++)
			sum = sum + array[i];

		System.out.println("The sum of the elements in the array is " + sum);
		System.out.println("The average of the elements in the array is " + (1.0 * sum / arrayLength));
	}
}