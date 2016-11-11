package WildlifeSimulation;

public class Bluejay extends Fauna 
{
	//Default constructor
	public Bluejay()
	{
		super("bluejay", 'B');
	}
	public void getdietList(){
		System.out.println("The " + getName() + " eats nuts, nuts ");
	}
}
