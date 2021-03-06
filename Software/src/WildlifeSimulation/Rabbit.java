/**
* Rabbit.java
*
* DESCRIPTION:
* This file contains the unique characteristics of the Rabbit Wildlife descendant. This class inherits from
* the Fauna abstract class.
*
* AUTHORS: 	Tristan Heisler 200351317
* 			Jonathon Wells 200328640
* 			Quinn Bast 200352973		
*/

package WildlifeSimulation;

public class Rabbit extends Fauna 
{
	//Default Constructor
	public Rabbit() 
	{
		//Pass along specific rabbit information to the super constructor
		super("rabbit", 'R', 2, 75);
		
		//Instantiate the rabbit's prey list
		preyList.add(new Grass());
	}
}
