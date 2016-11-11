package WildlifeSimulation;

public class Caterpillar extends Fauna 
{
	//Default constructor
	public Caterpillar()
	{
		super("caterpillar", 'C');
	}
	public void getdietList(){
		System.out.println("The " + getName() + " plants ");
	}    
}
