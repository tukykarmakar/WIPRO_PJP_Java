class Assignment9
{
	public static void main(String args[])
	{
		try
		{
			String array[][] = {{args[0], args[1]}, {args[2], args[3]}};
			String reversedArray[][] = new String[array[0].length][array.length];
			int i, j;

			System.out.println("The given array is :");
			for (i = 0; i < array.length; i++)
			{
				for (j = 0; j < array[0].length; j++)
				{
					System.out.printf(array[i][j] + " ");

					if (i != j) reversedArray[j][i] = array[i][j];
					else reversedArray[i][j] = array[(i+array[0].length-1)%array[0].length][(j+array.length-1)%array.length];
				}
				System.out.println();
			}

			System.out.println("The reverse of the array is :");
			for (i = 0; i < reversedArray.length; i++)
			{
				for (j = 0; j < reversedArray[0].length; j++)
					System.out.printf(reversedArray[i][j] + " ");

				System.out.println();
			}
		}
		catch (Exception e)
		{
			System.out.println("Please enter 4 integer numbers");
		}
	}
}