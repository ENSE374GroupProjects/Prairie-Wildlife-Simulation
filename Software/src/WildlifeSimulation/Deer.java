package WildlifeSimulation;

public class Deer extends Fauna
{
	//Default Constructor
	public Deer()
	{
		super("deer", 'D');
	}
	public void getdietList(){
		System.out.println("The " + getName() + " eats grass, fruit, nuts ");
	}
}
