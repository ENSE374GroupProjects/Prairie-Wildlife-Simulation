/**
* Fauna.java
*
* DESCRIPTION:
* This file contains the unique characteristics of the Fauna Wildlife descendant. This abstract class inherits from
* the Wildlife abstract class and contains additional properties utilized by its descendants.
*
* AUTHORS: 	Tristan Heisler 200351317
* 			Jonathon Wells 200328640
* 			Quinn Bast 200352973		
*/

package WildlifeSimulation;

public abstract class Fauna extends Wildlife 
{
	//Initializing constructor
	public Fauna(String name, char symbol, int mobility, int hungerReplenishment)
	{
		//Pass along specific fauna information as well as a default hunger of 100 to the super constructor
		super(name, symbol, mobility, hungerReplenishment, 100);
	}
	
	//Eat function stub
	public void eat(Wildlife prey)
	{
		super.eat(prey);
	}
	
	//Move function stub
	public void move()
	{
		super.move();
	}
}
