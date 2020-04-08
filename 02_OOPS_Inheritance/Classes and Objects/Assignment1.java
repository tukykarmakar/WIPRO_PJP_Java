class Box
{
	double height, width, depth, volume;

	Box(double height, double width, double depth)
	{
		this.height = height;
		this.width = width;
		this.depth = depth;

		System.out.println("The dimensions(H x W x D) of the Box are " +this.height+ " x " +this.width+ " x " +this.depth+ " units");
	}

	double calculateVolume()
	{
		this.volume = this.height * this.width * this.depth;
		return this.volume;
	}
}

class Assignment1
{
	public static void main(String args[])
	{
		Box box = new Box(15.3, 8.4, 3.25);
		System.out.println("The volume of the box is " + box.calculateVolume() + " cubic units");
	}
}