import java.util.HashMap;
import java.util.Iterator;

class Properties
{
	HashMap<String, String> statesAndCapitals = new HashMap<String, String>();
	Properties()
	{
		statesAndCapitals.put("Andhra Pradesh","Hyderabad"); statesAndCapitals.put("Arunachal Pradesh","Itanagar"); statesAndCapitals.put("Assam","Dispur"); statesAndCapitals.put("Bihar","Patna");
		statesAndCapitals.put("Chhattisgarh","Raipur"); statesAndCapitals.put("Goa","Panaji"); statesAndCapitals.put("Gujarat","Gandhinagar"); statesAndCapitals.put("Haryana","Chandigarh");
		statesAndCapitals.put("Himachal Pradesh","Shimla"); statesAndCapitals.put("Jharkhand","Ranchi"); statesAndCapitals.put("Karnataka","Bangalore"); statesAndCapitals.put("Kerala","Thiruvananthapuram");
		statesAndCapitals.put("Madhya Pradesh","Bhopal"); statesAndCapitals.put("Maharashtra","Mumbai"); statesAndCapitals.put("Manipur","Imphal"); statesAndCapitals.put("Meghalaya","Shillong");
		statesAndCapitals.put("Mizoram","Aizawl"); statesAndCapitals.put("Nagaland","Kohima"); statesAndCapitals.put("Odisha","Bhubaneswar"); statesAndCapitals.put("Punjab","Chandigarh");
		statesAndCapitals.put("Rajasthan","Jaipur"); statesAndCapitals.put("Sikkim","Gangtok"); statesAndCapitals.put("Tamil Nadu","Chennai"); statesAndCapitals.put("Telangana","Hyderabad");
		statesAndCapitals.put("Tripura","Agartala"); statesAndCapitals.put("Uttar Pradesh","Lucknow"); statesAndCapitals.put("Uttarakhand","Dehradun"); statesAndCapitals.put("West Bengal","Kolkata");
	}
}
class Assignment3
{
	public static void main(String args[])
	{
		Properties properties = new Properties(); String s;

		for (Iterator<String> state = properties.statesAndCapitals.keySet().iterator(); state.hasNext();)
		{
			s = state.next();
			System.out.println("State:\t\t" +s+ "\nCapital:\t" +properties.statesAndCapitals.get(s)+ "\n");
		}
	}
}