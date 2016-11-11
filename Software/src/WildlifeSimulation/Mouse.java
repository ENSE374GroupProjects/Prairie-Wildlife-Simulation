package WildlifeSimulation;

public class Mouse extends Fauna 
{
	//Default Constructor
	public Mouse() 
	{
		super("mouse", 'M');
	}
	public void getdietList(){
		System.out.println("The " + getName() + " eats grass, trees ");
	}
}
