/**
* Grasshopper.java
*
* DESCRIPTION:
* This file contains the unique characteristics of the Deer Grasshopper descendant. This class inherits from
* the Fauna abstract class.
*
* AUTHORS: 	Tristan Heisler 200351317
* 			Jonathon Wells 200328640
* 			Quinn Bast 200352973		
*/

package WildlifeSimulation;

public class Grasshopper extends Fauna 
{
	//Default Constructor
	public Grasshopper() 
	{
		super("grasshopper", 'G', 1, 50);
		preyList.add(new Grass());
	}
}
