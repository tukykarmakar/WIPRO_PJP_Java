package junit.assignment1;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;

class EmployeeTest
{
	@Test
	void testFindName()
	{
		ArrayList<String> employeeList1 = new ArrayList<>();
		employeeList1.add("A"); employeeList1.add("B"); employeeList1.add("C");
		Employee employee = new Employee();
		assertEquals("Result", "FOUND", employee.findName(employeeList1, "A"));
		fail("Not yet implemented");
	}
}