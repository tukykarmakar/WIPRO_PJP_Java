package com.wipro.automobile.fourwheeler;
import com.wipro.automobile.Vehicle;
public class Logan extends Vehicle
{
	public int getSpeed()
	{ return 30; }
	public void gps()
	{ System.out.println("GPS Service"); }
	public String getModelName()
	{ return "Logan"; }
	public String getRegistrationNumber()
	{ return "9101"; }
	public String getOwnerName()
	{ return "Daniel Doe"; }
}