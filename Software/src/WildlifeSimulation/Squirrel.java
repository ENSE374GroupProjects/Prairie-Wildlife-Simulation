/**
* Squirrel.java
*
* DESCRIPTION:
* This file contains the unique characteristics of the Squirrel Wildlife descendant. This class inherits from
* the Fauna abstract class.
*
* AUTHORS: 	Tristan Heisler 200351317
* 			Jonathon Wells 200328640
* 			Quinn Bast 200352973		
*/

package WildlifeSimulation;

public class Squirrel extends Fauna 
{
	//Default Constructor
	public Squirrel() 
	{
		//Pass along specific squirrel information to the super constructor
		super("squirrel", 'S', 2, 60);
		
		//Instantiate the squirrel's prey list
		preyList.add(new Tree());
	}
}
