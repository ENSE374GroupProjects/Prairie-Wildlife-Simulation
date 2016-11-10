package WildlifeSimulation;

public class Grid 
{
	public static final int ROWS = 36;
	public static final int COLS = 100;
	private Wildlife WildlifeGrid[][] = new Wildlife[ROWS][COLS];
	
	public Grid() 
	{
	}
	
	public void populateGrid()
	{
	}

	public void displayWildlife()
	{
		// Print top bar
		System.out.print("/");
		for (int i = 0; i < COLS; i++)
		{
			System.out.print("=");
		}
		System.out.println("\\");
		
		// Print internal rows with border
		for (int i = 0; i < ROWS; i++)
		{
			System.out.print("|");
			for (int j = 0; j < COLS; j++)
			{
				System.out.print(".");
			}
			System.out.println("|");
		}
		
		// Print bottom bar
		System.out.print("\\");
		for (int i = 0; i < COLS; i++)
		{
			System.out.print("=");
		}
		System.out.println("/");
	}
}
