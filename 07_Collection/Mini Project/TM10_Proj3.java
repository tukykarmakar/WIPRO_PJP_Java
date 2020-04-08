import java.util.Scanner;
import java.util.TreeSet;
import java.util.ArrayList;

class Card implements Comparable<Card>
{
	private char symbol;
	private int number;

	Card(char cardSymbol, int cardNumber)
	{
		this.setSymbol(cardSymbol);
		this.setNumber(cardNumber);
	}
	@Override
	public int compareTo(Card cardObject)
	{
		if (this.symbol < cardObject.getSymbol())
			return -1;
		else
			return 1;
	}
	@Override
	public boolean equals(Object object)
	{
		if (object instanceof Card)
		{
			Card card = (Card)object;
			return (this.symbol == card.getSymbol());
		}
		else
			return false;
	}

	public void setSymbol(char cardSymbol)
	{ this.symbol = cardSymbol; }
	public void setNumber(int cardNumber)
	{ this.number = cardNumber; }

	public char getSymbol()
	{ return this.symbol; }
	public int getNumber()
	{ return this.number; }
}
class TM07_Proj3
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		TreeSet<Card> cardSet = new TreeSet<Card>();
		ArrayList<Character> symbolsFound = new ArrayList<Character>();

		char cardSymbol; int cardNumber, cardCount = 0;

		while (true)
		{
			System.out.println("Enter a card");
			cardSymbol = scanner.next().charAt(0);
			cardNumber = scanner.nextInt(); scanner.nextLine();

			if (!symbolsFound.contains(cardSymbol))
			{
				symbolsFound.add(cardSymbol);
				cardSet.add(new Card(cardSymbol, cardNumber));
				cardCount++;
			}

			if (symbolsFound.size() == 4)
			{
				System.out.println("Four symbols gathered in " +cardCount+ " cards");

				System.out.println("Cards in Set are");
				for (Card card : cardSet)
					System.out.println(card.getSymbol() +" "+ card.getNumber());
				
				break;
			}
		}

		scanner.close();
	}
}