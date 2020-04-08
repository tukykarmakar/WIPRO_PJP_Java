import java.util.Scanner;
import java.util.TreeSet;

class Box implements Comparable<Box>
{
	private double length, width, height, volume;

	Box(double boxLength, double boxWidth, double boxHeight)
	{
		this.length = boxLength;
		this.width = boxWidth;
		this.height = boxHeight;
		this.setVolume();
	}

	public void setLength(double boxLength)
	{ this.length = boxLength; this.setVolume(); }
	public void setWidth(double boxWidth)
	{ this.width = boxWidth; this.setVolume(); }
	public void setHeight(double boxHeight)
	{ this.height = boxHeight; this.setVolume(); }
	private void setVolume()
	{ this.volume = this.length * this.height * this.width; }

	public double getLength()
	{ return this.length; }
	public double getWidth()
	{ return this.width; }
	public double getHeight()
	{ return this.height; }
	public double getVolume()
	{ return this.volume; }
	public String getDimensions()
	{ return ("Length =" +this.length+ " Width =" +this.width+ " Height =" +this.height+ " Volume =" + String.format("%.3f", this.volume)); }

	@Override
	public int compareTo(Box box)
	{
		if (this.getVolume() > box.getVolume())
			return 1;
		else if (this.getVolume() < box.getVolume())
			return -1;
		else
			return 0;
	}
	@Override
	public boolean equals(Object object)
	{
		Box box = (Box)object;

		if (this.getVolume() == box.getVolume())
			return true;
		else
			return false;
	}
}

class TM07_Proj5
{
	static Scanner scanner = new Scanner(System.in);
	static TreeSet<Box> boxSet = new TreeSet<Box>();

	static void enterBoxes()
	{
		int numOfBox, i;
		double boxLength, boxWidth, boxHeight;

		System.out.println("Enter the number of Box");
		numOfBox = scanner.nextInt(); scanner.nextLine();

		for (i = 0; i < numOfBox; i++)
		{
			System.out.println("Enter the Box " +(i+1)+ " details");
			System.out.println("Enter Length"); boxLength = scanner.nextDouble();
			System.out.println("Enter Width"); boxWidth = scanner.nextDouble();
			System.out.println("Enter Height"); boxHeight = scanner.nextDouble();

			boxSet.add(new Box(boxLength, boxWidth, boxHeight));
		}
	}
	static void showBoxes()
	{
		System.out.println("Unique boxes in the set are");
		for (Box box : boxSet)
			System.out.println(box.getDimensions());
	}
	public static void main(String args[])
	{
		enterBoxes();
		showBoxes();
		scanner.close();
	}
}