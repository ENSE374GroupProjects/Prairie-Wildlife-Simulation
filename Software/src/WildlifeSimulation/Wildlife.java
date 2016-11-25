package WildlifeSimulation;

public class Wildlife 
{	
	private String name;
	private char symbol;
	private int mobility;
	private int hungerReplenishment;
	//private int move;
	
	//Default constructor
	public Wildlife()
	{
		this.name = "default wildlife";
		this.symbol = '-';
	}
	
	//Initializing constructor
	public Wildlife(String name, char symbol, int mobility, int hungerReplenishment)
	{
		this.name = name;
		this.symbol = symbol;
		this.mobility = mobility;
		this.hungerReplenishment = hungerReplenishment;
		//this.move = 0;
	}
	
	//Eat function - to be inherited
	public void eat()
	{		
	}
	
	//Move function - to be inherited
	public void move()
	{
	}
	
	public int getMobility()
	{
		return this.mobility;
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
