import java.util.Scanner;

class Video
{
	String videoName;
	boolean checkout;
	int rating;

	Video(String name)
	{ this.videoName = name; }

	public String getName()
	{ return this.videoName; }
	public boolean getCheckout()
	{ return this.checkout; }
	public int getRating()
	{ return this.rating; }

	void doCheckout()
	{ this.checkout = true; }
	void doReturn()
	{ this.checkout = false; }
	void receiveRating(int rating)
	{ this.rating = rating; }
}

class VideoStore
{
	Video store[] = new Video[10];
	private int emptyIndex = 0;

	int findIndexOf(Video[] collection, String name)
	{
		for (int i = 0; i < collection.length; i++)
			if (name.equals(collection[i].getName()))
				return i;

		return -1;
	}

	void addVideo(String name)
	{
		if (emptyIndex < this.store.length)
		{
			store[emptyIndex++] = new Video(name);
			System.out.println("Video \"" + name + "\" added successfully.");
		}

		if (emptyIndex >= this.store.length)
			System.out.println("Inventory is full!");
	}
	void doCheckout(String name)
	{
		int index = findIndexOf(this.store, name);

		if (index < 0)
			System.out.println("No video named \"" + name + "\" was found.");
		else
		{
			store[index].doCheckout();
			System.out.println("Video \"" + name + "\" checked out successfully.");
		}
	}
	void doReturn(String name)
	{
		int index = findIndexOf(this.store, name);

		if (index < 0)
			System.out.println("No video named \"" + name + "\" was found.");
		else
		{
			store[index].doReturn();
			System.out.println("Video \"" + name + "\" returned successfully.");
		}
	}
	void receiveRating(String name, int rating)
	{
		int index = findIndexOf(this.store, name);

		if (index < 0)
			System.out.println("No video named \"" + name + "\" was found.");
		else
		{
			store[index].receiveRating(rating);
			System.out.println("Rating \"" + rating + "\" has been mapped to the video \"" + name + "\"");
		}
	}
	void listInventory()
	{
		int i;

		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("Video Name\t\t|\t\tCheckout Status\t\t|\t\tRating");
		for (i = 0; i < this.store.length; i++)
		{
			try
			{
				System.out.println(this.store[i].getName() +"\t\t|\t\t"+ this.store[i].getCheckout() +"\t\t|\t\t"+ this.store[i].getRating());
			}
			catch (Exception e)
			{ break; }
		}
		System.out.println("--------------------------------------------------------------------------------------------");
		if (i == 0)
			System.out.println("Inventory is empty!");
	}
}

public class VideoLauncher
{
	static int showOptions()
	{
		int choice = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.println("MAIN MENU");
		System.out.println("=========");
		System.out.println("1. Add Videos : ");
		System.out.println("2. Check out videos : ");
		System.out.println("3. Return Video : ");
		System.out.println("4. Receive Rating : ");
		System.out.println("5. List Inventory : ");
		System.out.println("6. Exit : ");
		System.out.print("Enter your choice (1..6) : ");
		choice = scanner.nextInt();

		scanner.close();
		return choice;
	}
	public static void main(String args[])
	{
		int choice = 0, rating; String name;
		Scanner scanner = new Scanner(System.in);
		VideoStore videoStore = new VideoStore();

		while(choice != 6)
		{
			choice = showOptions();

			switch (choice)
			{
				case 1: System.out.print("Enter the name of the video you want to add: ");
						name = scanner.nextLine(); videoStore.addVideo(name);
						break;
				
				case 2: System.out.print("Enter the name of the video you want to check out: ");
						name = scanner.nextLine(); videoStore.doCheckout(name);
						break;
				
				case 3: System.out.print("Enter the name of the video you want to Return: ");
						name = scanner.nextLine(); videoStore.doReturn(name);
						break;
				
				case 4: System.out.print("Enter the name of the video you want to Rate: ");
						name = scanner.nextLine();
						System.out.print("Enter the rating for this video: ");
						rating = scanner.nextInt();
						videoStore.receiveRating(name, rating);
						break;
				
				case 5: videoStore.listInventory();
						break;

				case 6: System.out.print("Exiting...!! Thanks for using the application.");
						break;

				default: System.out.println("Invalid Choice! Try Again...");
						break;
			}
		}

		scanner.close();
	}
}