/**
* Wolf.java
*
* DESCRIPTION:
* This file contains the unique characteristics of the Wolf Wildlife descendant. This class inherits from
* the Fauna abstract class.
*
* AUTHORS: 	Tristan Heisler 200351317
* 			Jonathon Wells 200328640
* 			Quinn Bast 200352973		
*/

package WildlifeSimulation;

public class Wolf extends Fauna 
{
	//Default constructor
	public Wolf()
	{
		super("wolf", 'W');
		preyList.add(new Rabbit());
		preyList.add(new Deer());
	}
}
