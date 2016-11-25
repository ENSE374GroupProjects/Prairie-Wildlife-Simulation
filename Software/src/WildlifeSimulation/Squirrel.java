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
		super("squirrel", 'S');
		preyList.add(new Tree());
	}
}
