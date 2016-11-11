package WildlifeSimulation;

public class Wolf extends Fauna 
{
	//Default constructor
	public Wolf()
	{
		super("wolf", 'W');
	}
	public void getdietList(){
		System.out.println("The " + getName() + " eats rabbit and deer ");
	}
}
