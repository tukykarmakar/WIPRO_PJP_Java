package com.wipro.automobile.twowheeler;
import com.wipro.automobile.Vehicle;
public class Hero extends Vehicle
{
	public int getSpeed()
	{ return 20; }
	public void radio()
	{ System.out.println("Radio Controls"); }
	public String getModelName()
	{ return "Hero"; }
	public String getRegistrationNumber()
	{ return "1234"; }
	public String getOwnerName()
	{ return "Bob Doe"; }
}