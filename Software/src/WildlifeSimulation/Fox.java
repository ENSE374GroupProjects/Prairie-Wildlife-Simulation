package WildlifeSimulation;

public class Fox extends Fauna 
{
	//Default Constructor
	public Fox() 
	{
		super("fox", 'F');
	}
	public void getdietList(){
		System.out.println("The " + getName() + " eats catepillar, mouse, hawk, rabbit, squirrel ");
	}    
}
