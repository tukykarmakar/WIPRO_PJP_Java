import com.wipro.automobile.fourwheeler.Ford;
import com.wipro.automobile.fourwheeler.Logan;
public class Assignment3
{
	public static void main(String args[])
	{
		Logan logan = new Logan();
		Ford ford = new Ford();

		System.out.println("Model Name:\t" + logan.getModelName());
		System.out.println("Owner Name:\t" + logan.getOwnerName());
		System.out.println("Regn. Number:\t" + logan.getRegistrationNumber());
		System.out.println("Vehicle Speed:\t" + logan.getSpeed());
		logan.gps();

		System.out.println("Model Name:\t" + ford.getModelName());
		System.out.println("Owner Name:\t" + ford.getOwnerName());
		System.out.println("Regn. Number:\t" + ford.getRegistrationNumber());
		System.out.println("Vehicle Speed:\t" + ford.getSpeed());
		ford.tempControl();
	}
}