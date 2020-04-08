import static org.junit.Assert.*;
import org.junit.Test;

public class SBAccountTest
{
	@Test
	public void testSetInterestRate()
	{
		SBAccount testSBAccount = null;
		char testNRIStatus[] = {'y', 'n'};

		for (int i = 0; i < testNRIStatus.length; i++)
		{
			testSBAccount = new SBAccount(1000, testNRIStatus[i]);
			try
			{
				assertEquals(testNRIStatus[i], testSBAccount.isNRI);
				assertEquals((testNRIStatus[i] == 'y')? 6.0 : 4.0, testSBAccount.interestRate, 0.001);
			}
			catch (Exception e)
			{ System.out.println(e.getMessage()); }
			finally
			{ testSBAccount = null; }
		}
	}

	@Test
	public void testSBAccount()
	{
		double testAmount = 500, testRate = 6.0;
		char testNRIStatus = 'y';
		SBAccount testSBAccount = new SBAccount(testAmount, testNRIStatus);

		try
		{
			assertEquals(testAmount, testSBAccount.amount, 0.001);
			assertEquals(testRate, testSBAccount.interestRate, 0.001);
			assertEquals(testNRIStatus, testSBAccount.isNRI);
		}
		catch (Exception e)
		{ System.out.println(e.getMessage()); }
	}

	@Test
	public void testCalculateInterest()
	{
		SBAccount testSBAccount = null;
		double testAmount[] = {500, 1000, 125.65};
		char testNRIStatus[] = {'y', 'n'};
		double testInterest;
		int i, j;

		for (i = 0; i < testAmount.length; i++)
			for (j = 0; j < testNRIStatus.length; j++)
			{
				testSBAccount = new SBAccount(testAmount[i], testNRIStatus[j]);
				testInterest = testAmount[i] * ((testNRIStatus[j] == 'y')? 6.0 : 4.0) / 100;
				try
				{ assertEquals(testInterest, testSBAccount.calculateInterest(), 0.0001); }
				catch (Exception e)
				{ System.out.println(e.getMessage()); }
				finally
				{ testSBAccount = null; }
			}
	}
}