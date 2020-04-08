import java.util.InputMismatchException;
import java.util.Scanner;
class NegativeValueException extends Exception
{
	NegativeValueException(String message)
	{ super(message); }
}
class ValueNotIntegerException extends Exception
{
	ValueNotIntegerException(String message)
	{ super(message); }
}
class ValueOutOfRangeException extends Exception
{
	ValueOutOfRangeException(String message)
	{ super(message); }
}

abstract class Account
{
	double interestRate, amount;
	abstract double calculateInterest();
}
class FDAccount extends Account
{
	int noOfDays, ageOfACHolder;
	void setInterestRate(double amountInAC, int days, int age) 
	{
		if (amountInAC < 10000000.00)
		{
			if (days >= 7 && days <= 14)
				this.interestRate = (age > 59)? 5.0 : 4.5;
			else if (days >= 15 && days <= 29)
				this.interestRate = (age > 59)? 5.25 : 4.75;
			else if (days >= 30 && days <= 44)
				this.interestRate = (age > 59)? 6.0 : 5.5;
			else if (days >= 45 && days <= 60)
				this.interestRate = (age > 59)? 7.5 : 7.0;
			else if (days >= 61 && days <= 184)
				this.interestRate = (age > 59)? 8.0 : 7.5;
			else if (days >= 185 && days <= 365)
				this.interestRate = (age > 59)? 8.5 : 8.0;
		}
		else
		{
			if (days >= 7 && days <= 14)
				this.interestRate = 6.5;
			else if (days >= 15 && days <= 44)
				this.interestRate = 6.75;
			else if (days >= 45 && days <= 60)
				this.interestRate = 8.0;
			else if (days >= 61 && days <= 184)
				this.interestRate = 8.5;
			else if (days >= 185 && days <= 365)
				this.interestRate = 10.0;
		}
	}
	FDAccount(double amountInAC, int days, int age)
	{
		this.ageOfACHolder = age;
		this.noOfDays = days;
		this.amount = amountInAC;
		this.setInterestRate(amountInAC, days, age);
	}
	double calculateInterest()
	{ return (this.amount * this.interestRate / 100); }
}
class SBAccount extends Account
{
	char isNRI;
	void setInterestRate(char NRIStatus)
	{
		if(NRIStatus == 'y' || NRIStatus == 'Y')
			this.interestRate = 6.0;
		else
			this.interestRate = 4.0;
	}
	SBAccount(double amountInAC, char NRIStatus)
	{
		this.amount = amountInAC;
		this.isNRI = NRIStatus;
		this.setInterestRate(NRIStatus);
	}
	double calculateInterest()
	{ return (this.amount * this.interestRate / 100); }
}
class RDAccount extends Account
{
	int noOfMonths, ageOfACHolder; double monthlyAmount;
	void setInterestRate(int months, int age) throws ValueOutOfRangeException
	{
		switch(months)
		{
			case 6: this.interestRate = (age < 60)? 7.5 : 8.0;
			break;
			case 9: this.interestRate = (age < 60)? 7.75 : 8.25;
			break;
			case 12: this.interestRate = (age < 60)? 8.0 : 8.5;
			break;
			case 15: this.interestRate = (age < 60)? 8.25 : 8.75;
			break;
			case 18: this.interestRate = (age < 60)? 8.5 : 9.0;
			break;
			case 21: this.interestRate = (age < 60)? 8.75 : 9.25;
			break;
			default: throw new ValueOutOfRangeException("Number of months should be 6/9/12/15/18/21 months.");
		}
	}
	RDAccount(double amountInAC, int months, int age) throws ValueOutOfRangeException
	{
		this.amount = amountInAC;
		this.ageOfACHolder = age;
		this.noOfMonths = months;
		this.setInterestRate(months, age);
	}
	double calculateInterest()
	{ return (this.amount * this.interestRate / 100); }
}

class InterestCalculator
{
	static int showOptions(Scanner scanner)
	{
		int choice = 4;
		try
		{
			System.out.println("\nMAIN MENU");
			System.out.println("---------");
			System.out.println("\t1. Interest Calculator - SB");
			System.out.println("\t2. Interest Calculator - FD");
			System.out.println("\t3. Interest Calculator - RD");
			System.out.println("\t4. Exit");
			System.out.print("Enter your option (1..4): ");
			choice = (scanner.nextInt());
		}
		catch(InputMismatchException e)
		{ System.out.println("Please enter proper values as specified."); }
		return choice;
	}
	public static void main(String args[]) throws NegativeValueException, ValueNotIntegerException, ValueOutOfRangeException
	{
		FDAccount fdAccount; RDAccount rdAccount; SBAccount sbAccount;
		Scanner scanner = new Scanner(System.in);
		String negativeValueMessage = " Please enter non-negative values.";
		int choice = 0, days, months, age; double amount; char isNRI;

		while(choice != 4)
		{
			choice = showOptions(scanner);
			try
			{
				switch(choice)
				{
					case 1: System.out.print("Enter the Average amount in your account: "); amount = scanner.nextDouble();
							if (amount < 0)
								throw new NegativeValueException("Invalid Amount."+negativeValueMessage);

							System.out.print("Are you an NRI?(y/n): "); isNRI = scanner.next().charAt(0);
							if (isNRI != 'n' && isNRI != 'N' && isNRI != 'y' && isNRI != 'Y')
								throw new InputMismatchException();

							sbAccount = new SBAccount(amount, isNRI);
							System.out.println("Interest gained is: " + sbAccount.calculateInterest());
					break;

					case 2: System.out.print("Enter the FD amount: "); amount = scanner.nextDouble();
							if (amount < 0)
								throw new NegativeValueException("Invalid Amount."+negativeValueMessage);

							System.out.print("Enter the number of days: "); days = scanner.nextInt();
							if (days < 0)
								throw new NegativeValueException("Invalid Number of days."+negativeValueMessage);
							if (days < 7 || days > 365)
								throw new ValueOutOfRangeException("Number of days should be within the range of 7 to 365 days.");

							System.out.print("Enter your age: "); age = scanner.nextInt();
							if (age < 0)
								throw new NegativeValueException("Invalid Age."+negativeValueMessage);

							fdAccount = new FDAccount(amount, days, age);
							System.out.println("Interest gained is: " + fdAccount.calculateInterest());
					break;

					case 3: System.out.print("Enter the RD amount: "); amount = scanner.nextDouble();
							if (amount < 0)
								throw new NegativeValueException("Invalid Amount."+negativeValueMessage);

							System.out.print("Enter the number of months: "); months = scanner.nextInt();
							if (months < 0)
								throw new NegativeValueException("Invalid Number of months."+negativeValueMessage);
							if (months < 6 || months > 21)
								throw new ValueOutOfRangeException("Number of months should be 6/9/12/15/18/21 months.");

							System.out.print("Enter your age: "); age = scanner.nextInt();
							if (age < 0)
								throw new NegativeValueException("Invalid Age."+negativeValueMessage);

							rdAccount = new RDAccount(amount, months, age);
							System.out.println("Interest gained is: " + rdAccount.calculateInterest());
					break;

					case 4: System.out.println("Exiting... Good Bye.");
					break;

					default: System.out.println("Invalid choice! Please try again...");
					break;
				}
			}
			catch (InputMismatchException e)
			{ System.out.println("Please enter proper values as specified."); }
			catch (Exception e)
			{ System.out.println(e.getMessage()); }
			
			System.gc();
		}
		scanner.close();
	}
}