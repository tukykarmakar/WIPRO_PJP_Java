import java.util.Random;

abstract class Compartment
{
	public abstract String notice();
}
class FirstClass extends Compartment
{
	public String notice()
	{ return "First Class Compartment"; }
}
class Ladies extends Compartment
{
	public String notice()
	{ return "Ladies Compartment"; }
}
class General extends Compartment
{
	public String notice()
	{ return "General Compartment"; }
}
class Luggage extends Compartment
{
	public String notice()
	{ return "Luggage Compartment"; }
}

class Assignment2
{
	public static void main(String args[])
	{
		int compartmentType, i, arraySize = 10;
		Random random = new Random();
		Compartment compartment[] = new Compartment[arraySize];

		for (i = 0; i < compartment.length; i++)
		{
			compartmentType = random.nextInt(4) + 1;
			switch(compartmentType)
			{
				case 1: compartment[i] = new FirstClass();
				break;
				case 2: compartment[i] = new General();
				break;
				case 3: compartment[i] = new Ladies();
				break;
				case 4: compartment[i] = new Luggage();
			}
			System.out.println(compartment[i].notice());
		}
	}
}