/**
* Bluejay.java
*
* DESCRIPTION:
* This file contains the unique characteristics of the Bluejay Wildlife descendant. This class inherits from
* the Fauna abstract class.
*
* AUTHORS: 	Tristan Heisler 200351317
* 			Jonathon Wells 200328640
* 			Quinn Bast 200352973		
*/


package WildlifeSimulation;

public class Bluejay extends Fauna 
{
	//Default constructor
	public Bluejay()
	{
		super("bluejay", 'B', 4, 60);
		preyList.add(new Caterpillar());
		preyList.add(new Tree());
	}
}
