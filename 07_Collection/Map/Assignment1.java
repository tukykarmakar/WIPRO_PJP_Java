import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

class CountryAndCapital
{
	private HashMap<String, String> M1 = new HashMap<String, String>();

	public HashMap saveCountryCapital(String countryName, String capital)
	{
		M1.put(countryName, capital);
		return this.M1;
	}
	public String getCapital(String countryName)
	{
		return this.M1.get(countryName);
	}
	public HashMap capitalKey_countryValue()
	{
		HashMap<String, String> M2 = new HashMap<String, String>();
		String country;
		
		for (Iterator<String> iter = M1.keySet().iterator(); iter.hasNext(); )
		{
			country = iter.next();
			M2.put(M1.get(country), country);
		}

		return M2;
	}
	public ArrayList getKeyArrayList()
	{
		ArrayList<String> keyList = new ArrayList<String>();

		for (Iterator<String> iter = M1.keySet().iterator(); iter.hasNext(); )
			keyList.add(iter.next());
		
		return keyList;
	}
}
class Assignment1
{
	public static void main(String args[])
	{
		CountryAndCapital country_capital_list = new CountryAndCapital();
		String capital, country;

		System.out.println("Adding country India, capital Delhi - List-> " + (country_capital_list.saveCountryCapital("India", "Delhi")));
		System.out.println("Adding country Japan, capital Tokyo - List-> " + (country_capital_list.saveCountryCapital("Japan", "Tokyo")));
		System.out.println("Adding country Canada, capital Ottawa - List-> " + (country_capital_list.saveCountryCapital("Canada", "Ottawa")));

		System.out.println("\nGetting capitals of countries");
		country = "Japan"; capital = country_capital_list.getCapital(country);
		if (capital == null)
			System.out.println("No country found with name \"" +country+ "\"");
		else
			System.out.println("Capital of \"" +country+ "\" is: " + capital);

		country = "Australia"; capital = country_capital_list.getCapital(country);
		if (capital == null)
			System.out.println("No country found with name \"" +country+ "\"");
		else
			System.out.println("Capital of \"" +country+ "\" is: " + capital);

		System.out.println("\nList with Capital as Keys and Country as Value");
		System.out.println(country_capital_list.capitalKey_countryValue());

		System.out.println("\nGetting the country keys as Array List");
		System.out.println(country_capital_list.getKeyArrayList());
	}
}