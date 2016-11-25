/**
* Fox.java
*
* DESCRIPTION:
* This file contains the unique characteristics of the Fox Wildlife descendant. This class inherits from
* the Fauna abstract class.
*
* AUTHORS: 	Tristan Heisler 200351317
* 			Jonathon Wells 200328640
* 			Quinn Bast 200352973		
*/

package WildlifeSimulation;

public class Fox extends Fauna 
{
	//Default Constructor
	public Fox() 
	{
		//Pass along specific fox information to the super constructor
		super("fox", 'F', 3, 100);
		
		//Instantiate the fox's prey list
		preyList.add(new Rabbit());
		preyList.add(new Squirrel());
		preyList.add(new Mouse());
	}
}
