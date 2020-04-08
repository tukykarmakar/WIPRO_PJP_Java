import java.util.HashMap;
import java.util.Iterator;

class Assignment4
{
	public static void main(String args[])
	{
		HashMap<String, Long> contactList = new HashMap<String, Long>();

		contactList.put("Alice", 9876543210L); contactList.put("Bob", 9876543211L); contactList.put("Charles", 9876543212L);
		contactList.put("David", 9876543213L); contactList.put("Ethan", 9876543214L); contactList.put("Freddy", 9876543215L);

		String key1 = "Ethan", key2 = "Error";
		System.out.println("\nKey \"" +key1+ "\" is " +((contactList.containsKey(key1)? "present" : "absent"))+ " in the Contact List");
		System.out.println("Key \"" +key2+ "\" is " +((contactList.containsKey(key2)? "present" : "absent"))+ " in the Contact List");
		
		long value1 = 9876543212L, value2 = 91169420L;
		System.out.println("\nValue \"" +value1+ "\" is " +((contactList.containsValue(value1)? "present" : "absent"))+ " in the Contact List");
		System.out.println("Value \"" +value2+ "\" is " +((contactList.containsValue(value2)? "present" : "absent"))+ " in the Contact List");

		System.out.println("\nThe values in the Contact List are"); String k;
		for (Iterator<String> contactName = contactList.keySet().iterator(); contactName.hasNext();)
		{
			k = contactName.next();
			System.out.println(k +"\t:\t"+ contactList.get(k));
		}
	}
}