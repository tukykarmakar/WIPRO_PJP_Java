import java.util.Scanner;
class Patient
{
	String patientName;
	double height;
	double weight;

	Patient()
	{
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter patient's name: ");
		this.patientName = scanner.nextLine();

		System.out.print("Enter patient's height (in metres): ");
		this.height = scanner.nextDouble();

		System.out.print("Enter patient's weight (in kilogram): ");
		this.weight = scanner.nextDouble();

		scanner.close();
	}

	double computeBMI()
	{
		double bmi = this.weight / (this.height * this.height);
		return bmi;
	}
}

class Assignment3
{
	public static void main(String args[])
	{
		Patient patient = new Patient();
		System.out.println("The BMI of the patient is " + patient.computeBMI());
	}
}