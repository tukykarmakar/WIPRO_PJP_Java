class Fruit
{
	String name, taste, size;
	Fruit(String fruitName, String fruitTaste, String fruitSize)
	{
		this.name = fruitName;
		this.size = fruitSize;
		this.taste = fruitTaste;
	}
	void eat()
	{
		System.out.println("The fruit " + this.name + " is " + this.taste);
	}
}

class Apple extends Fruit
{
	Apple(String appleTaste, String appleSize)
	{
		super("Apple", appleTaste, appleSize);
	}
	void eat()
	{
		System.out.println("This " + this.name + " is " + this.taste);
	}
}

class Orange extends Fruit
{
	Orange(String orangeTaste, String orangeSize)
	{
		super("Orange", orangeTaste, orangeSize);
	}
	void eat()
	{
		System.out.println("This " + this.name + " is " + this.taste);
	}
}

class Assignment1
{
	public static void main(String args[])
	{
		Fruit fruit = new Fruit("Forbidden", "rotten", "large");
		Apple apple = new Apple("sweet", "large");
		Orange orange = new Orange("sour", "small");

		fruit.eat(); apple.eat(); orange.eat();
	}
}