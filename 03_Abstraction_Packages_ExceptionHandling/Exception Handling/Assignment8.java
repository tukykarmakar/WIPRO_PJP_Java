class AgeNotInRangeException extends Exception
{
	AgeNotInRangeException()
	{ super("Age must be within the range of 18-60 years."); }
}
class ImproperArgumentPassedException extends Exception
{
	ImproperArgumentPassedException()
	{ super("Arguments should be passed like this -> \"java Assignment8 <Name> <Age>\""); }
}

class Assignment8
{
	public static void main(String args[]) throws AgeNotInRangeException, ImproperArgumentPassedException
	{
		try
		{
			if (args.length != 2)
				throw new ImproperArgumentPassedException();
			
			int age = Integer.parseInt(args[1]);
			String name = args[0];

			if (age < 18 || age > 60)
				throw new AgeNotInRangeException();

			System.out.println("Name:\t" + name);
			System.out.println("Age:\t" + age);
		}
		catch(NumberFormatException e)
		{ System.out.println("Please enter age as an Integer."); }
		catch(Exception e)
		{ System.out.println(e.getMessage()); }
	}
}