class Assignment10
{
	public static void main(String args[])
	{
		try
		{
			int max = Integer.parseInt(args[8]);
			int i, j, k = 0, row = 3, col = 3;
			int array[][] = new int[row][col];

			for (i = 0; i < row; i++)
			{
				for (j = 0; j < col; j++)
				{
					array[i][j] = Integer.parseInt(args[k++]);
					System.out.printf(array[i][j] + " ");

					if (max < array[i][j]) max = array[i][j];
				}
				System.out.println();
			}

			System.out.println("The biggest number in the given array is " + max);
		}
		catch (Exception e)
		{
			System.out.println("Please enter 9 integer numbers");
		}
	}
}