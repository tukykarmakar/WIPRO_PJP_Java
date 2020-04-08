class GeneralBank
{
	GeneralBank()
	{
		this.getSavingsInterestRate();
		this.getFixedDepositInterestRate();
	}
	public void getSavingsInterestRate();
	public void getFixedDepositInterestRate();
}
class ICICIBank extends GeneralBank
{
	ICICIBank()
	{ super(); }
	public void getSavingsInterestRate()
	{ System.out.println(4.0); }
	public void getFixedDepositInterestRate()
	{ System.out.println(8.5); }
}
class KotMBank extends GeneralBank
{
	KotMBank()
	{ super(); }
	public void getSavingsInterestRate()
	{ System.out.println(6.0); }
	public void getFixedDepositInterestRate()
	{ System.out.println(9.0); }
}

class Assignment1
{
	public static void main(String args[])
	{
		ICICIBank i=new ICICIBank();
		KotMBank k=new KotMBank();
		GeneralBank g1=new KotMBank();
		GeneralBank g2=new ICICIBank();
	}
}