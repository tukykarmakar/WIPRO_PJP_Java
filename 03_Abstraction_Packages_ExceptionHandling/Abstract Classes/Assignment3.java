import java.util.Random;

class Instrument
{
	public void play();
}
class Piano extends Instrument
{
	public void play()
	{ System.out.println("Piano is playing tan tan tan "); }
}
class Flute extends Instrument
{
	public void play()
	{ System.out.println("Flute is playing toot toot toot "); }
}
class Guitar extends Instrument
{
	public void play()
	{ System.out.println("Guitar is playing tin tin tin "); }
}

class Assignment3
{
	public static void main(String args[])
	{
		int instrumentType, i, arraySize = 5;
		Random random = new Random();
		Instrument instrument[] = new Instrument[arraySize];

		for (i = 0; i < instrument.length; i++)
		{
			instrumentType = random.nextInt(3) + 1;
			switch(instrumentType)
			{
				case 1: instrument[i] = new Piano();
				break;
				case 2: instrument[i] = new Guitar();
				break;
				case 3: instrument[i] = new Flute();
				break;
			}
			instrument[i].play();

			if (instrument[i] instanceof Piano)
				System.out.println("Index " +i+ " is Piano\n");
			if (instrument[i] instanceof Flute)
				System.out.println("Index " +i+ " is Flute\n");
			if (instrument[i] instanceof Guitar)
				System.out.println("Index " +i+ " is Guitar\n");
		}
	}
}