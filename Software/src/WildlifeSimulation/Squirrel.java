package WildlifeSimulation;

public class Squirrel extends Fauna 
{
	//Default Constructor
	public Squirrel() 
	{
		super("squirrel", 'S');
	}
	public void getdietList(){
		System.out.println("The " + getName() + " eats nuts, fruits ");
	}
}
