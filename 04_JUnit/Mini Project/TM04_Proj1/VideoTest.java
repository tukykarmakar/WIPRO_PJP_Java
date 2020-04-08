import static org.junit.Assert.*;
import org.junit.Test;

public class VideoTest
{
	@Test
	public void testGetName()
	{
		String testVideoName = "The Test Video";
		Video testVideo = new Video(testVideoName);

		assertEquals(testVideoName, testVideo.getName());
	}

	@Test
	public void testGetCheckout()
	{
		String testVideoName = "The Test Video";
		boolean testVideoCheckout = true;
		Video testVideo = new Video(testVideoName);

		testVideo.doCheckout();
		assertEquals(testVideoCheckout, testVideo.getCheckout());
	}

	@Test
	public void testDoReturn()
	{
		String testVideoName = "The Test Video";
		boolean testVideoCheckout = false;
		Video testVideo = new Video(testVideoName);

		testVideo.doReturn();
		assertEquals(testVideoCheckout, testVideo.getCheckout());
	}

	@Test
	public void testGetRating()
	{
		int testVideoRating = 8;
		String testVideoName = "The Test Video";
		Video testVideo = new Video(testVideoName);

		testVideo.receiveRating(testVideoRating);
		assertEquals(testVideoRating, testVideo.getRating());
	}
}