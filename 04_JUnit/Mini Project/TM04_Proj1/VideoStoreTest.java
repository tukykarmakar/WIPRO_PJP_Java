import static org.junit.Assert.*;
import org.junit.Test;

public class VideoStoreTest
{
	@Test
	public void testFindIndexOf()
	{
		int i, testIndex, maxListSize = 10;
		String testVideoName = "The Test Video ";
		Video testVideoList[] = new Video[maxListSize];
		VideoStore testVideoStore = new VideoStore();

		for (i = 0; i < maxListSize; i++)
		{
			testVideoList[i] = new Video(testVideoName + i);
			testVideoStore.addVideo(testVideoName + i);
		}

		try
		{
			for (i = 0; i < maxListSize; i++)
			{
				testIndex = testVideoStore.findIndexOf(testVideoStore.store, testVideoName + i);
				assertEquals(testVideoList[i], testVideoList[testIndex]);
			}
		}
		catch(Exception e)
		{
			System.out.println("Stopped at " + testVideoName + i);
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testAddVideo()
	{
		String testVideoName = "The Test Video ";
		VideoStore testVideoStore = new VideoStore();

		testVideoStore.addVideo(testVideoName);
		try
		{
			assertEquals(null, testVideoStore.store[1]);
			assertNotEquals(null, testVideoStore.store[0]);
			assertNotEquals(-1, testVideoStore.findIndexOf(testVideoStore.store, testVideoName));
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testDoCheckout()
	{
		int testIndex;
		Video testVideo = null;
		String testVideoName = "The Test Video ";
		VideoStore testVideoStore = new VideoStore();

		testVideoStore.addVideo(testVideoName);
		testVideoStore.doCheckout(testVideoName);
		testIndex = testVideoStore.findIndexOf(testVideoStore.store, testVideoName);
		testVideo = testVideoStore.store[testIndex];
		try
		{
			assertNotEquals(null, testVideo);
			assertNotEquals(-1, testIndex);
			assertEquals(testVideoName, testVideo.getName());
			assertTrue(testVideo.getCheckout());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testDoReturn()
	{
		int testIndex;
		Video testVideo = null;
		String testVideoName = "The Test Video ";
		VideoStore testVideoStore = new VideoStore();

		testVideoStore.addVideo(testVideoName);
		testVideoStore.doCheckout(testVideoName);
		testVideoStore.doReturn(testVideoName);
		testIndex = testVideoStore.findIndexOf(testVideoStore.store, testVideoName);
		testVideo = testVideoStore.store[testIndex];
		try
		{
			assertNotEquals(null, testVideo);
			assertNotEquals(-1, testIndex);
			assertEquals(testVideoName, testVideo.getName());
			assertFalse(testVideo.getCheckout());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testReceiveRating()
	{
		int testIndex, testRating = 8;
		Video testVideo = null;
		String testVideoName = "The Test Video ";
		VideoStore testVideoStore = new VideoStore();

		testVideoStore.addVideo(testVideoName);
		testVideoStore.receiveRating(testVideoName, testRating);
		testIndex = testVideoStore.findIndexOf(testVideoStore.store, testVideoName);
		testVideo = testVideoStore.store[testIndex];
		try
		{
			assertNotEquals(null, testVideo);
			assertNotEquals(-1, testIndex);
			assertEquals(testVideoName, testVideo.getName());
			assertEquals(testRating, testVideo.getRating());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testListInventory()
	{
		int i, maxListSize = 10;
		String testVideoName = "The Test Video ";
		Video testVideoList[] = new Video[maxListSize];
		VideoStore testVideoStore = new VideoStore();

		for (i = 0; i < testVideoList.length; i++)
		{
			testVideoList[i] = new Video(testVideoName + i);
			testVideoStore.addVideo(testVideoName + i);

			testVideoList[i].receiveRating(i);
			testVideoStore.receiveRating(testVideoName + i, i);

			if (i % 2 == 0)
			{
				testVideoList[i].doCheckout();
				testVideoStore.doCheckout(testVideoName + i);
			}
			else
			{
				testVideoList[i].doReturn();
				testVideoStore.doReturn(testVideoName + i);
			}
			System.out.println();
		}

		System.out.println("\nExpected Result");
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("Video Name\t\t|\t\tCheckout Status\t\t|\t\tRating");
		for (i = 0; i < testVideoList.length; i++)
			System.out.println(testVideoList[i].getName() +"\t\t|\t\t"+ testVideoList[i].getCheckout() +"\t\t|\t\t"+ testVideoList[i].getRating());
		System.out.println("--------------------------------------------------------------------------------------------");

		System.out.println("\nActual Result");
		testVideoStore.listInventory();
	}
}