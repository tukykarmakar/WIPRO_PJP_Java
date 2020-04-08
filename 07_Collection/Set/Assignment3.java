import java.util.TreeSet;
import java.util.Iterator;

class Assignment3
{
	public static void main(String args[])
	{
		TreeSet<String> treeSet = new TreeSet<String>();

		treeSet.add("Alice"); treeSet.add("Bob");
		treeSet.add("Charles"); treeSet.add("David");
		treeSet.add("Ethan"); treeSet.add("Frederick");

		System.out.println("Items in the Tree Set are");
		for (Iterator<String> name = treeSet.iterator(); name.hasNext();)
			System.out.println(name.next());

		System.out.println("\nReversed order Tree Set");
		for (Iterator<String> name = treeSet.descendingIterator(); name.hasNext();)
			System.out.println(name.next());

		String element1 = "Alice", element2 = "Error";
		System.out.println("\nElement \"" +element1+ "\" is " +((treeSet.contains(element1)? "present" : "absent"))+ " in the Tree Set");
		System.out.println("Element \"" +element2+ "\" is " +((treeSet.contains(element2)? "present" : "absent"))+ " in the Tree Set");
	}
}