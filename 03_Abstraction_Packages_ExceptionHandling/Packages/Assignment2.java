import com.wipro.automobile.twowheeler.Hero;
public class Assignment2
{
	public static void main(String args[])
	{
		Hero hero = new Hero();
		Honda honda = new Honda();

		System.out.println("Model Name:\t" + hero.getModelName());
		System.out.println("Owner Name:\t" + hero.getOwnerName());
		System.out.println("Regn. Number:\t" + hero.getRegistrationNumber());
		System.out.println("Vehicle Speed:\t" + hero.getSpeed());
		hero.radio();

		System.out.println("Model Name:\t" + honda.getModelName());
		System.out.println("Owner Name:\t" + honda.getOwnerName());
		System.out.println("Regn. Number:\t" + honda.getRegistrationNumber());
		System.out.println("Vehicle Speed:\t" + honda.getSpeed());
		honda.cdplayer();
	}
}