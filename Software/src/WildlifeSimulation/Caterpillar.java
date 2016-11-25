/**
* Caterpillar.java
*
* DESCRIPTION:
* This file contains the unique characteristics of the Caterpillar Wildlife descendant. This class inherits from
* the Fauna abstract class.
*
* AUTHORS: 	Tristan Heisler 200351317
* 			Jonathon Wells 200328640
* 			Quinn Bast 200352973		
*/

package WildlifeSimulation;

public class Caterpillar extends Fauna 
{
	//Default constructor
	public Caterpillar()
	{
		//Pass along specific caterpillar information to the super constructor
		super("caterpillar", 'C', 1, 50);
		
		//Instantiate the caterpillar's prey list
		preyList.add(new Tree());
	}
}
