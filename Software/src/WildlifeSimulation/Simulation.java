package WildlifeSimulation;

public class Simulation 
{	
	public static void main(String[] args) 
	{
		//Show that the bluejay class is accessible
		System.out.println("Creating an instance of Bluejay.");
		Bluejay bluejay = new Bluejay();
		System.out.println("The symbol for a bluejay is " + bluejay.getSymbol() + ".");	
		bluejay.eat();
		bluejay.move();
		
		//Show that the caterpillar class is accessible
		System.out.println("\nCreating an instance of Caterpillar.");
		Caterpillar caterpillar = new Caterpillar();
		System.out.println("The symbol for a deer is " + caterpillar.getSymbol() + ".");	
		caterpillar.eat();
		caterpillar.move();
		
		//Show that the deer class is accessible
		System.out.println("\nCreating an instance of Deer.");
		Deer deer = new Deer();
		System.out.println("The symbol for a deer is " + deer.getSymbol() + ".");	
		deer.eat();
		deer.move();
		
		//Show that the fox class is accessible
		System.out.println("\nCreating an instance of Fox.");
		Fox fox = new Fox();
		System.out.println("The symbol for a fox is " + fox.getSymbol() + ".");	
		fox.eat();
		fox.move();
		
		//Show that the grass class is accessible
		System.out.println("\nCreating an instance of Grass.");
		Grass grass = new Grass();
		System.out.println("The symbol for grass is " + grass.getSymbol() + ".");		
		grass.eat();
		grass.move();
		
		//Show that the grasshopper class is accessible
		System.out.println("\nCreating an instance of Grasshopper.");
		Grasshopper grasshopper = new Grasshopper();
		System.out.println("The symbol for a grasshopper is " + grasshopper.getSymbol() + ".");	
		grasshopper.eat();
		grasshopper.move();
		
		//Show that the hawk class is accessible
		System.out.println("\nCreating an instance of Hawk.");
		Hawk hawk = new Hawk();
		System.out.println("The symbol for a hawk is " + hawk.getSymbol() + ".");	
		hawk.eat();
		hawk.move();
		
		//Show that the mouse class is accessible
		System.out.println("\nCreating an instance of Mouse.");
		Mouse mouse = new Mouse();
		System.out.println("The symbol for a mouse is " + mouse.getSymbol() + ".");	
		mouse.eat();
		mouse.move();
		
		//Show that the rabbit class is accessible
		System.out.println("\nCreating an instance of Rabbit.");
		Rabbit rabbit = new Rabbit();
		System.out.println("The symbol for a rabbit is " + rabbit.getSymbol() + ".");	
		rabbit.eat();
		rabbit.move();
		
		//Show that the grass class is accessible
		System.out.println("\nCreating an instance of Tree.");
		Tree tree = new Tree();
		System.out.println("The symbol for a tree is " + tree.getSymbol() + ".");		
		tree.eat();
		tree.move();
		
		//Show that the squirrel class is accessible
		System.out.println("\nCreating an instance of Squirrel.");
		Squirrel squirrel = new Squirrel();
		System.out.println("The symbol for a squirrel is " + squirrel.getSymbol() + ".");	
		squirrel.eat();
		squirrel.move();
		
		//Show that the wolf class is accessible
		System.out.println("\nCreating an instance of Wolf.");
		Wolf wolf = new Wolf();
		System.out.println("The symbol for a wolf is " + wolf.getSymbol() + ".");	
		wolf.eat();
		wolf.move();
	}
}
