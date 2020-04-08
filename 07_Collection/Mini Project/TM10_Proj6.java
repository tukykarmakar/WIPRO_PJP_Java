import java.util.ArrayList;
import java.util.Scanner;

class TM07_Proj6
{
	static ArrayList<String> outputStringList = new ArrayList<String>();
	static Scanner scanner = new Scanner(System.in);

	static void operation1(String s1, String s2)
	{
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 1; i < s1.length(); i = i + 2)
		{
			stringBuffer.append(s2);
			stringBuffer.append(s1.charAt(i));
		}
		outputStringList.add(stringBuffer.toString());
	}
	static void operation2(String s1, String s2)
	{
		int s2Occurrence = s1.split(s2, -1).length - 1;
		if (s2Occurrence > 1)
			outputStringList.add(s1.substring(0, s1.lastIndexOf(s2)) + new StringBuffer(s2).reverse());
		else
			outputStringList.add(s1 + s2);
	}
	static void operation3(String s1, String s2)
	{
		int s2Occurrence = s1.split(s2, -1).length - 1;
		if (s2Occurrence > 1)
			outputStringList.add(s1.substring(0, s1.indexOf(s2)) + s1.substring(s1.indexOf(s2) + s2.length(), s1.length()));
		else
			outputStringList.add(s1);
	}
	static void operation4(String s1, String s2)
	{
		int partition = (s2.length() % 2 == 0)? s2.length()/2 : 1 + s2.length()/2;
		outputStringList.add(s2.substring(0, partition) + s1 + s2.substring(partition, s2.length()));
	}
	static void operation5(String s1, String s2)
	{
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < s1.length(); i++)
		{
			if (s2.indexOf(s1.charAt(i)) != -1)
				stringBuffer.append('*');
			else
				stringBuffer.append(s1.charAt(i));
		}
		outputStringList.add(stringBuffer.toString());
	}
	public static void main(String args[])
	{
		String input1, input2, s1, s2;

		System.out.print("Enter first string(S1): "); input1 = scanner.nextLine();
		System.out.print("Enter second string(S2): "); input2 = scanner.nextLine();

		s1 = (input1.length() > input2.length())? input1 : input2;
		s2 = (input1.length() < input2.length())? input1 : input2;

		operation1(s1, s2);
		operation2(s1, s2);
		operation3(s1, s2);
		operation4(s1, s2);
		operation5(s1, s2);
		
		System.out.println(outputStringList);
	}
}