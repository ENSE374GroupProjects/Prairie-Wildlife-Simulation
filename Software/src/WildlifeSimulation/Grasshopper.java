package WildlifeSimulation;

public class Grasshopper extends Fauna 
{
	//Default Constructor
	public Grasshopper() 
	{
		super("grasshopper", 'G');
	}
	public void getdietList(){
		System.out.println("The " + getName() + " eats leaves, corn, grass ");
	}
}
