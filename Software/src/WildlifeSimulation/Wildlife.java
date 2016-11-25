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
import java.util.ArrayList;

public abstract class Wildlife 
{	
	private String name;
	private char symbol;
	private int mobility;

	protected ArrayList<Wildlife> preyList = new ArrayList<Wildlife>();
	private int hungerReplenishment;
	private int totalMoves;
	public int hunger;
	
	//Default constructor
	public Wildlife()
	{
		this.name = "default wildlife";
		this.symbol = '-';
	}
	
	//Initializing constructor
	public Wildlife(String name, char symbol, int mobility, int hungerReplenishment, int hunger)
	{
		this.name = name;
		this.symbol = symbol;
		this.mobility = mobility;
		this.hungerReplenishment = hungerReplenishment;
		this.totalMoves = 0;
		this.hunger = hunger;
	}
	
	//Eat function - to be inherited
	public void eat()
	{		
	}
	
	//Move function - to be inherited
	public void move()
	{
		this.totalMoves++;
	}
	
	public int getMobility()
	{
		return this.mobility;
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
	
	//Determines if an animal can eat another Wildlife instance
	public boolean canEat(Wildlife prey)
	{
		int i=0;
		//Loop through all Wildlife in the animal's prey list.
		while (i < preyList.size())
		{
			//Return true if the animal can be eaten.
			if (preyList.get(i).getName().equals(prey.getName()))
				return true;
			i++;
		}
		return false;
	}
}
