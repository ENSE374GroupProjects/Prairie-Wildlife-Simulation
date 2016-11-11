package WildlifeSimulation;

public class Fauna extends Wildlife 
{
	 int hunger;
	 String dietList[] = new String[10];
	//This abstract class will eventually be used to store fauna-specific members and methods.
	//Potential examples include movement, eating and a list of the fauna's prey.
	
	//Initializing constructor
	public Fauna(String name, char symbol)
	{
		super(name, symbol);
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
