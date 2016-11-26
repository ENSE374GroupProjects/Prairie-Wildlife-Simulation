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
	protected ArrayList<Wildlife> preyList = new ArrayList<Wildlife>();
	private String name;
	private char symbol;
	private int mobility;
	private int hungerReplenishment;
	private int totalMoves;
	private int hunger;
	private boolean moved;
	
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
		this.moved = true;
	}
	
	//Eat function - to be inherited
	public void eat(Wildlife prey, int row, int col)
	{
		System.out.println(this.name + " has eaten a " + prey.getName() + " at [" + row + "][" + col +"]");
		this.hunger = (this.hunger + prey.getHungerReplenishment() <= 100) ? (this.hunger + prey.getHungerReplenishment()) : (this.hunger = 100);
	}
	
	//Move function - to be inherited
	public void move()
	{
		this.totalMoves++;
		
		this.hunger -= this.hunger - 10;
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
	
	//Mobility getter
	public int getMobility()
	{
		return this.mobility;
	}

	// Get hungerReplenishment value
	private int getHungerReplenishment()
	{
		return this.hungerReplenishment;
	}
	
	//Hunger  getter
	public int getHunger()
	{
		return this.hunger;
	}
	
	public int getTotalMoves()
	{
		return this.totalMoves;
	}
	
	public boolean hasMoved()
	{
		return this.moved;
	}
	
	public void setMoved(boolean moved)
	{
		this.moved = moved;
	}
	
	// Check if the animal is hungry
	public boolean isHungry()
	{
		return (this.hunger < 70);
	}
	
	public boolean isDead()
	{
		return (this.hunger <= 0);
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
