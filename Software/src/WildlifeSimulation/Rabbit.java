package WildlifeSimulation;

public class Rabbit extends Fauna 
{
	//Default Constructor
	public Rabbit() 
	{
		super("rabbit", 'R');
	}
	public void getdietList(){
		System.out.println("The " + getName() + " eats grass ");
	}
}
