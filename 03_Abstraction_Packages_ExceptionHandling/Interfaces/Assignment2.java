import music.Playable;
import music.string.Veena;
import music.wind.Saxophone;
public class Assignment2
{
	public static void main(String args[])
	{
		Veena veena = new Veena();
		Saxophone saxophone = new Saxophone();

		veena.play(); saxophone.play();

		Playable playable1 = veena;
		Playable playable2 = saxophone;
		playable1.play(); playable2.play();
	}
}