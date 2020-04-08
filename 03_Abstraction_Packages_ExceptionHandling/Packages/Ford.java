package com.wipro.automobile.fourwheeler;
import com.wipro.automobile.Vehicle;
public class Ford extends Vehicle
{
	public int getSpeed()
	{ return 50; }
	public void tempControl()
	{ System.out.println("Temperature Control"); }
	public String getModelName()
	{ return "Ford"; }
	public String getRegistrationNumber()
	{ return "1121"; }
	public String getOwnerName()
	{ return "Ethan Doe"; }
}