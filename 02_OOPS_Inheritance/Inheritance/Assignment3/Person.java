class Person
{
	private String name, dateOfBirth;

	Person(String personName, String personDOB)
	{
		this.setName(personName);
		this.setDOB(personDOB);
	}

	public void setName(String personName)
	{	this.name = personName;			}
	public void setDOB(String personDOB)
	{	this.dateOfBirth = personDOB;	}

	public String getName()
	{	return this.name;				}
	public String getDOB()
	{	return this.dateOfBirth;		}
}