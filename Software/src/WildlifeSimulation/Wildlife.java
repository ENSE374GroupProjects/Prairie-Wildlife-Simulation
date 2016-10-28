package WildlifeSimulation;

public class Wildlife 
{	
	private String name;
	private char symbol;
	
	//Default constructor
	public Wildlife()
	{
		this.name = "default wildlife";
		this.symbol = '-';
	}
	
	//Initializing constructor
	public Wildlife(String name, char symbol)
	{
		this.name = name;
		this.symbol = symbol;
	}
	
	//Eat function - to be inherited
	public void eat()
	{		
	}
	
	//Move function - to be inherited
	public void move()
	{
	}
	
	//Name getter
	public String getName()
	{
		return this.name;
	}
	
	//Symbol getter
	public char getSymbol()
	{
		return this.symbol;
	}
}
