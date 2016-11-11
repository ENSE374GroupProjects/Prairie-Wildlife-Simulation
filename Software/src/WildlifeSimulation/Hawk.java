package WildlifeSimulation;

public class Hawk extends Fauna 
{
	//Default constructor
	public Hawk()
	{
		super("hawk", 'H');
	}
	public void getdietList(){
		System.out.println("The " + getName() + " eats squirrel, birds, grasshopper ");
	}
}
