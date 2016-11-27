/**
* Flora.java
*
* DESCRIPTION:
* This file contains the unique characteristics of the Flora Wildlife descendant. This abstract class inherits from
* the Wildlife abstract class and contains additional properties utilized by its descendants.
*
* AUTHORS: 	Tristan Heisler 200351317
* 			Jonathon Wells 200328640
* 			Quinn Bast 200352973		
*/

package WildlifeSimulation;

public abstract class Flora extends Wildlife 
{
	//This abstract class will eventually be used to store flora-specific members and methods. 
	//Potential examples include plant growth.
	
	//Initializing constructor
	public Flora(String name, char symbol, int mobility, int hungerReplenishment)
	{
		//Pass along specific fauna information as well as a default hunger of 0 to the super constructor
		super(name, symbol, mobility, hungerReplenishment, 0);
	}
	
	//Eat function stub
	public void eat()
	{
		System.out.println("The " + getName() + " is absorbing nutrients.");
	}
	
	//Move function stub
	public void move()
	{
		System.out.println("The " + getName() + " cannot move.");
	}
}
