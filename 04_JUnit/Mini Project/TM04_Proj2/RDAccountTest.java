import static org.junit.Assert.*;
import org.junit.Test;

public class RDAccountTest
{
	@Test
	public void testSetInterestRate()
	{
		RDAccount testRDAccount = null;
		int i, j, k, numberOfRates = 6;
		int testAges[] = {40, 70};
		int testMonths[] = {6, 9, 12, 15, 18, 21};
		double value, testRate;
		double testAmounts[] = {500, 1000, 1234.56};
		double seniorCitizenRates[] = new double[numberOfRates];

		for (value = 8.0, i = 0; i < seniorCitizenRates.length; value = value + 0.25, i++)
			seniorCitizenRates[i] = value;

		for (i = 0; i < testAmounts.length; i++)
			for (j = 0; j < testMonths.length; j++)
				for (k = 0; k < testAges.length; k++)
				{
					testRate = (testAges[k] > 60)? seniorCitizenRates[j] : seniorCitizenRates[j] - 0.5;
					try
					{
						testRDAccount = new RDAccount(testAmounts[i], testMonths[j], testAges[k]);
						assertEquals(testRate, testRDAccount.interestRate, 0.001);
					}
					catch (Exception e)
					{ System.out.println(e.getMessage()); }
					finally
					{ testRDAccount = null; }
				}
	}

	@Test
	public void testRDAccount()
	{
		double testAmount = 500, testRate = 8.0;
		int testMonths = 12, testAge = 33;
		
		try
		{
			RDAccount testRDAccount = new RDAccount(testAmount, testMonths, testAge);
			assertEquals(testAmount, testRDAccount.amount, 0.001);
			assertEquals(testRate, testRDAccount.interestRate, 0.001);
			assertEquals(testAge, testRDAccount.ageOfACHolder);
		}
		catch (Exception e)
		{ System.out.println(e.getMessage()); }
	}

	@Test
	public void testCalculateInterest()
	{
		RDAccount testRDAccount = null;
		int i, j, k, numberOfRates = 6;
		int testAges[] = {40, 70};
		int testMonths[] = {6, 9, 12, 15, 18, 21};
		double value, testRate, testInterest;
		double testAmounts[] = {500, 1000, 1234.56};
		double seniorCitizenRates[] = new double[numberOfRates];

		for (value = 8.0, i = 0; i < seniorCitizenRates.length; value = value + 0.25, i++)
			seniorCitizenRates[i] = value;

		for (i = 0; i < testAmounts.length; i++)
			for (j = 0; j < testMonths.length; j++)
				for (k = 0; k < testAges.length; k++)
				{
					testRate = (testAges[k] > 60)? seniorCitizenRates[j] : seniorCitizenRates[j] - 0.5;
					testInterest = testAmounts[i] * testRate / 100;
					try
					{
						testRDAccount = new RDAccount(testAmounts[i], testMonths[j], testAges[k]);
						assertEquals(testInterest, testRDAccount.calculateInterest(), 0.0001);
					}
					catch (Exception e)
					{ System.out.println(e.getMessage()); }
					finally
					{ testRDAccount = null; }
				}
	}
}