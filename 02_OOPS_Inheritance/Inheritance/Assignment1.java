class Animal
{
	void eat()
	{	System.out.println("Animal is eating...");	}
	void sleep()
	{	System.out.println("Animal is sleeping...");	}
}
class Bird extends Animal
{
	void eat()
	{	System.out.println("Bird is eating...");	}
	void sleep()
	{	System.out.println("Bird is sleeping...");	}
	void fly()
	{	System.out.println("Bird is flying...");	}
}

class Assignment1
{
	public static void main(String args[])
	{
		Animal animal = new Animal();
		Bird bird = new Bird();

		animal.eat(); animal.sleep();
		bird.eat(); bird.sleep(); bird.fly();
	}
}