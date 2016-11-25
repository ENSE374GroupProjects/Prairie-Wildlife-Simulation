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
		super("caterpillar", 'C', 1, 50);
		preyList.add(new Tree());
	}
}
