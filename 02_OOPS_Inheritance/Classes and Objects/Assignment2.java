class Calculator
{
	static void powerInt(int num1, int num2)
	{
		System.out.println("powerInt(int " +num1+ ", int " +num2+ ") = " + Math.pow(num1, num2));
	}
	static void powerDouble(double num1, int num2)
	{
		System.out.println("powerDouble(double " +num1+ ", int " +num2+ ") = " + Math.pow(num1, num2));
	}
}

class Assignment2
{
	public static void main(String args[])
	{
		int num1 = 4, num2 = 3;
		double num3 = 4.0;

		Calculator.powerInt(num1, num2);
		Calculator.powerDouble(num3, num2);
	}
}