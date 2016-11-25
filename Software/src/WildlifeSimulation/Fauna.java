package WildlifeSimulation;

public class Fauna extends Wildlife 
{
	//This abstract class will eventually be used to store fauna-specific members and methods.
	//Potential examples include movement, eating and a list of the fauna's prey.
	
	//Initializing constructor
	public Fauna(String name, char symbol, int mobility, int hungerReplenishment)
	{
		super(name, symbol, mobility, hungerReplenishment);
	}
	
	//Eat function stub
	public void eat()
	{
		System.out.println("The " + getName() + " is eating.");
	}
	
	//Move function stub
	public void move()
	{
		System.out.println("The " + getName() + " is moving.");
	}
}
