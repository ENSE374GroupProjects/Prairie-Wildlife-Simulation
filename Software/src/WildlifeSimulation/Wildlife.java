/**
* Fauna.java
*
* DESCRIPTION:
* This file contains the characteristics shared by all wildlife. This abstract class provides the structures of the
* functions to be utilized uniquely by all wildlife, including eating and moving.
*
* AUTHORS: 	Tristan Heisler 200351317
* 			Jonathon Wells 200328640
* 			Quinn Bast 200352973		
*/

package WildlifeSimulation;

public abstract class Wildlife 
{	
	private String name;
	private char symbol;
	
	//Default constructor
	public Wildlife()
	{
		this.name = "default wildlife";
		this.symbol = '-';
	}
	
	//Initializing constructor
	public Wildlife(String name, char symbol)
	{
		this.name = name;
		this.symbol = symbol;
	}
	
	//Eat function - to be inherited
	public void eat()
	{		
	}
	
	//Move function - to be inherited
	public void move()
	{
	}
	
	//Name getter
	public String getName()
	{
		return this.name;
	}
	
	//Symbol getter
	public char getSymbol()
	{
		return this.symbol;
	}
}
