package WildlifeSimulation;

public class Flora extends Wildlife 
{
	//This abstract class will eventually be used to store flora-specific members and methods. 
	//Potential examples include plant growth.
	
	//Initializing constructor
	public Flora(String name, char symbol, int mobility, int hungerReplenishment)
	{
		super(name, symbol, mobility, hungerReplenishment);
	}
	
	//Eat function stub
	public void eat()
	{
		System.out.println("The " + getName() + " is absorbing nutrients.");
	}
	
	//Move function stub
	public void move()
	{
		System.out.println("The " + getName() + " cannot move.");
	}
}
