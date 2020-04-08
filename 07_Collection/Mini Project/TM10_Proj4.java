import java.util.Scanner;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.ArrayList;

class Card
{
	private char symbol;
	private int number;

	Card(char cardSymbol, int cardNumber)
	{
		this.setSymbol(cardSymbol);
		this.setNumber(cardNumber);
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
class TM07_Proj4
{
	static Scanner scanner = new Scanner(System.in);
	static TreeMap<Character, ArrayList> cardMap = new TreeMap<Character, ArrayList>();
	
	static void enterCards()
	{
		ArrayList<Card> cardList = null;
		char cardSymbol; int cardNumber, cardCount, i;
		System.out.println("Enter Number of Cards: ");
		cardCount = scanner.nextInt(); scanner.nextLine();

		for (i = 0; i < cardCount; i++)
		{
			System.out.println("Enter card " +(i+1)+ ": ");
			cardSymbol = scanner.next().charAt(0);
			cardNumber = scanner.nextInt(); scanner.nextLine();

			if (cardMap.containsKey(cardSymbol))
			{
				cardList = cardMap.get(cardSymbol);
				cardList.add(new Card(cardSymbol, cardNumber));
				cardMap.replace(cardSymbol, cardList);
				cardList = null;
			}
			else
			{
				cardList = new ArrayList<Card>();
				cardList.add(new Card(cardSymbol, cardNumber));
				cardMap.put(cardSymbol, cardList);
				cardList = null;
			}
		}

	}
	static void displayCards()
	{
		ArrayList<Card> cardList = null;
		char symbol; int symbolSum = 0;

		System.out.println("Distinct symbols are");
		for (char symbols : cardMap.keySet())
			System.out.print(symbols + " ");

		System.out.println();
		for (Iterator<Character> iter = cardMap.keySet().iterator(); iter.hasNext(); )	
		{
			symbolSum = 0;
			symbol = iter.next();
			cardList = (ArrayList<Card>)cardMap.get(symbol);

			System.out.println("Cards in " +symbol+ " Symbol");
			for (Card card : cardList)
			{
				System.out.println(card.getSymbol() +" "+ card.getNumber());
				symbolSum = symbolSum + card.getNumber();
			}
			System.out.println("Number of cards : " + cardList.size());
			System.out.println("Sum of Numbers : " + symbolSum);
		}
	}
	public static void main(String args[])
	{
		enterCards();
		displayCards();
		scanner.close();
	}
}