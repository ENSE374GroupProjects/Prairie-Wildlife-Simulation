/**
* Mouse.java
*
* DESCRIPTION:
* This file contains the unique characteristics of the Mouse Wildlife descendant. This class inherits from
* the Fauna abstract class.
*
* AUTHORS: 	Tristan Heisler 200351317
* 			Jonathon Wells 200328640
* 			Quinn Bast 200352973		
*/

package WildlifeSimulation;

public class Mouse extends Fauna 
{
	//Default Constructor
	public Mouse() 
	{
		//Pass along specific mouse information to the super constructor
		super("mouse", 'M', 1, 50);
		
		//Instantiate the mouse's prey list
		preyList.add(new Grass());
		preyList.add(new Tree());
	}
}
