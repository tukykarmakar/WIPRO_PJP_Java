import java.util.HashMap;
import java.util.Iterator;

class Assignment2
{
	public static void main(String args[])
	{
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "One"); map.put(2, "Two"); map.put(3, "Three");
		map.put(4, "Four"); map.put(5, "Five"); map.put(6, "Six");

		int key1 = 5, key2 = 69;
		System.out.println("\nKey \"" +key1+ "\" is " +((map.containsKey(key1)? "present" : "absent"))+ " in the Map");
		System.out.println("Key \"" +key2+ "\" is " +((map.containsKey(key2)? "present" : "absent"))+ " in the Map");
		
		String value1 = "Three", value2 = "Error";
		System.out.println("\nValue \"" +value1+ "\" is " +((map.containsValue(value1)? "present" : "absent"))+ " in the Map");
		System.out.println("Value \"" +value2+ "\" is " +((map.containsValue(value2)? "present" : "absent"))+ " in the Map");

		System.out.println("\nThe values in the map are"); int k;
		for (Iterator<Integer> mapKey = map.keySet().iterator(); mapKey.hasNext();)
		{
			k = mapKey.next();
			System.out.println(k +"\t:\t"+ map.get(k));
		}
	}
}