import java.util.HashSet;
import java.util.Iterator;

class Assignment2
{
	public static void main(String args[])
	{
		HashSet<String> employeeNames = new HashSet<String>();

		employeeNames.add("Alice"); employeeNames.add("Bob");
		employeeNames.add("Charles"); employeeNames.add("David");
		employeeNames.add("Ethan"); employeeNames.add("Frederick");

		for (Iterator<String> name = employeeNames.iterator(); name.hasNext();)
			System.out.println(name.next());
	}
}