import static org.junit.Assert.*;
import org.junit.Test;

public class FDAccountTest
{
	@Test
	public void testSetInterestRate()
	{
		FDAccount testFDAccount = null;
		int i, j, k;
		int testAges[] = {40, 70};
		int testDays[] = {10, 23, 33, 53, 123, 273};
		double testRate;
		double testAmounts[] = {500, 1000, 1234.56, 10000000.00, 12345678.91};
		double seniorCitizenRates[] = {5, 5.25, 6, 7.5, 8, 8.5};
		double highAmountRates[] = {6.5, 6.75, 6.75, 8, 8.5, 10};

		for (i = 0; i < testAmounts.length; i++)
			for (j = 0; j < testDays.length; j++)
				for (k = 0; k < testAges.length; k++)
				{
					if (testAmounts[i] < 10000000.00)
					{
						if (testAges[k] < 60)
							testRate = seniorCitizenRates[j] - 0.5;
						else
							testRate = seniorCitizenRates[j];
					}
					else
						testRate = highAmountRates[j];
					try
					{
						testFDAccount = new FDAccount(testAmounts[i], testDays[j], testAges[k]);
						assertEquals(testRate, testFDAccount.interestRate, 0.001);
					}
					catch (Exception e)
					{ System.out.println(e.getMessage()); }
					finally
					{ testFDAccount = null; }
				}
	}

	@Test
	public void testFDAccount()
	{
		double testAmount = 500, testRate = 5.0;
		int testDays = 12, testAge = 83;
		
		try
		{
			FDAccount testFDAccount = new FDAccount(testAmount, testDays, testAge);
			assertEquals(testAmount, testFDAccount.amount, 0.001);
			assertEquals(testRate, testFDAccount.interestRate, 0.001);
			assertEquals(testAge, testFDAccount.ageOfACHolder);
		}
		catch (Exception e)
		{ System.out.println(e.getMessage()); }
	}

	@Test
	public void testCalculateInterest()
	{
		FDAccount testFDAccount = null;
		int i, j, k;
		int testAges[] = {40, 70};
		int testDays[] = {10, 23, 33, 53, 123, 273};
		double testRate, testInterest;
		double testAmounts[] = {500, 1000, 1234.56, 10000000.00, 12345678.91};
		double seniorCitizenRates[] = {5, 5.25, 6, 7.5, 8, 8.5};
		double highAmountRates[] = {6.5, 6.75, 6.75, 8, 8.5, 10};

		for (i = 0; i < testAmounts.length; i++)
			for (j = 0; j < testDays.length; j++)
				for (k = 0; k < testAges.length; k++)
				{
					testRate = (testAmounts[i] >= 10000000.00)?
									highAmountRates[j] : ((testAges[k] < 60)?
															seniorCitizenRates[j] - 0.5 : seniorCitizenRates[j]);
					testInterest = testRate * testAmounts[i] / 100;
					try
					{
						testFDAccount = new FDAccount(testAmounts[i], testDays[j], testAges[k]);
						assertEquals(testInterest, testFDAccount.calculateInterest(), 0.001);
					}
					catch (Exception e)
					{ System.out.println(e.getMessage()); }
					finally
					{ testFDAccount = null; }
				}
	}
}