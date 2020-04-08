import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
class Assignment2
{
	public static void main(String args[]) throws IOException, InputMismatchException
	{
		FileInputStream in = null; FileOutputStream out = null;
		Scanner scanner = new Scanner(System.in);
		
		try
		{
			System.out.print("Enter the input file name: ");
			String inputFile = scanner.next();

			System.out.print("Enter the output file name: ");
			String outputFile = scanner.next();

			in = new FileInputStream(inputFile); out = new FileOutputStream(outputFile);
			int readChar = 1;

			while ((readChar = in.read()) != -1)
				out.write(readChar);

			System.out.println("File is copied");
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
			if (out != null)
				out.close();
		}
	}
}