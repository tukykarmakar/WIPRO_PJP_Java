import java.util.HashSet;

class CountrySet
{
	HashSet<String> H1 = new HashSet<String>();
	public HashSet saveCountryName(String countryName)
	{
		H1.add(countryName);
		return H1;
	}
	public String getCountry(String countryName)
	{
		for (String country : H1)
			if (country.equalsIgnoreCase(countryName))
				return country;
		return null;
	}
}
class Assignment1
{
	public static void main(String args[])
	{
		CountrySet countrySet = new CountrySet();

		System.out.println(countrySet.saveCountryName("India"));
		System.out.println(countrySet.saveCountryName("Spain"));
		System.out.println(countrySet.saveCountryName("Australia"));

		System.out.println(countrySet.getCountry("India"));
		System.out.println(countrySet.getCountry("Japan"));
	}
}