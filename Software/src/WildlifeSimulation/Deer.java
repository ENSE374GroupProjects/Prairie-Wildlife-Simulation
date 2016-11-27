/**
* Deer.java
*
* DESCRIPTION:
* This file contains the unique characteristics of the Deer Wildlife descendant. This class inherits from
* the Fauna abstract class.
*
* AUTHORS: 	Tristan Heisler 200351317
* 			Jonathon Wells 200328640
* 			Quinn Bast 200352973		
*/

package WildlifeSimulation;

public class Deer extends Fauna
{
	//Default Constructor
	public Deer()
	{
		//Pass along specific deer information to the super constructor
		super("deer", 'D', 3, 100);
		
		//Instantiate the deer's prey list
		preyList.add(new Grass());
		preyList.add(new Tree());
	}
}
