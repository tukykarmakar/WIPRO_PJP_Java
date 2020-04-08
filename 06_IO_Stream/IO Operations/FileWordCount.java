import java.io.*;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;

class FileWordCount
{
	public static void main(String args[]) throws IOException, InputMismatchException, ArrayIndexOutOfBoundsException
	{
		FileInputStream in = null; FileOutputStream out = null;

		try
		{
			String inputFile = args[0]; in = new FileInputStream(inputFile);
			String outputFile = args[1]; out = new FileOutputStream(outputFile);
			Map<String, Integer> words = new HashMap<String, Integer>();
			String readWord = ""; int readChar = 1, value = 0;

			while (readChar != -1)
			{
				readChar = in.read();

				if ((readChar >= 'a' && readChar <= 'z') || (readChar >= 'A' && readChar <= 'Z'))
					readWord = readWord + ((char)readChar);
				if (readChar == 32 || readChar == 10 || readChar == -1)
				{
					if (words.containsKey(readWord))
					{
						value = words.get(readWord) + 1;
						words.replace(readWord, value);
					}
					else
						words.put(readWord, 1);
					
					readWord = "";
				}
				System.gc();
			}
			
			readWord = ""; System.gc(); value = 0;
			String sortedWordList[] = new String[words.size()];

			for (String word : words.keySet())
				sortedWordList[value++] = word;
			Arrays.sort(sortedWordList);

			for (String word : sortedWordList)
			{
				readWord = readWord + (word + " : " + words.get(word) + "\n");
				
				for (int character : readWord.getBytes())
					out.write(character);
				
				readWord = "";
				System.gc();
			}
		}
		catch (InputMismatchException e)
		{ System.out.println("Invalid characters!"); }
		catch (IOException e)
		{ System.out.println("File doesn't exist!"); }
		catch (ArrayIndexOutOfBoundsException e)
		{ System.out.println("Please enter the names of input and output files as shown below\n\"java <input file name> <output file name>\""); }
		catch (Exception e)
		{ System.out.println("Caught unknown Exception\n" + e.getMessage()); }
		finally
		{
			if (in != null)
				in.close();
			if (out != null)
				out.close();
		}
	}
}