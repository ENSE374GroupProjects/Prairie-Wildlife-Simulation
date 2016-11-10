package WildlifeSimulation;

import java.util.concurrent.ThreadLocalRandom;

public class Grid 
{
	private static final int ROWS = 36;
	private static final int COLS = 100;
	private Wildlife WildlifeGrid[][] = new Wildlife[ROWS][COLS];
	
	public Grid() 
	{
	}
	
	public void populateGrid(int wildlifeDensity)
	{
		int random;
		
		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COLS; j++)
			{
				random = ThreadLocalRandom.current().nextInt(1, 101);
				if (random <= wildlifeDensity) {
					WildlifeGrid[i][j] = new Wolf();
				}
				else {
					System.out.print(" ");
				}
			}
		}
	}

	public void displayWildlife(int wildlifeDensity)
	{
		int random;
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
				random = ThreadLocalRandom.current().nextInt(1, 101);
				if (random <= wildlifeDensity) {
					System.out.print(".");
				}
				else {
					System.out.print(" ");
				}
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
