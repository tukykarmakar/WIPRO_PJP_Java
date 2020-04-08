import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
class Assignment1
{
	public static void main(String args[]) throws IOException, InputMismatchException
	{
		FileInputStream in = null; Scanner scanner = new Scanner(System.in);
		
		try
		{
			System.out.print("Enter the file name: ");
			String filename = scanner.next();
			
			System.out.print("Enter the character to be counted: ");
			int charToCount = scanner.next().charAt(0);

			in = new FileInputStream(filename); int readChar = 1, count = 0;

			while (readChar != -1)
			{
				readChar = in.read();
				if (readChar == charToCount || readChar == charToCount - 32)
					count++;
			}

			System.out.println("File '" +filename+ "' has " +count+ " instances of '" +((char)charToCount)+ "'.");
		}
		catch (IOException e)
		{ System.out.println("File doesn't exist!"); }
		catch (InputMismatchException e)
		{ System.out.println("Invalid character!"); }
		finally
		{
			scanner.close();
			if (in != null)
				in.close();
		}
	}
}