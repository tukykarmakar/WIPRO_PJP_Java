class Assignment4
{
	public static void main(String args[])
	{
		char asciiChars[] = new char[256];
		int i = 0;

		for (i = 0; i < asciiChars.length; i++)
		{
			asciiChars[i] = (char)i;
			System.out.println(i + " " + asciiChars[i]);
		}
	}
}