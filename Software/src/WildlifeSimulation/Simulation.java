package WildlifeSimulation;

public class Simulation 
{
	
	public static void main(String[] args) 
	{
		//Show that the grass class is accessible
		System.out.println("\nCreating an instance of Grass.");
		Grass grass = new Grass();
		System.out.println("The symbol for grass is " + grass.getSymbol() + ".");		
		grass.eat();
		grass.move();
		
		//Show that the wolf class is accessible
		System.out.println("\nCreating an instance of Wolf.");
		Wolf wolf = new Wolf();
		System.out.println("The symbol for a wolf is " + wolf.getSymbol() + ".");	
		wolf.eat();
		wolf.move();
	}
}
