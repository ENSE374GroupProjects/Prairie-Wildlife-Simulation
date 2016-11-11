package WildlifeSimulation;

import java.util.concurrent.ThreadLocalRandom;

public class Grid 
{
	public static final int ROWS = 36;
	public static final int COLS = 100;
	private Wildlife WildlifeGrid[][] = new Wildlife[ROWS][COLS];
	
	public Grid() 
	{
	}
	
	private void populateGrid(int wildlifeDensity)
	{
		// Implement different chances for each specific creature to spawn
		// Base the switch case value off of wildlifeDensity 
		// eg: wildlifeDensity = 50, switch case for wolf (10%) = 0 - wildlifeDensity/10
		int random;
		
		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COLS; j++)
			{
				random = ThreadLocalRandom.current().nextInt(0, 101);
				if (random <= wildlifeDensity) {
					random = ThreadLocalRandom.current().nextInt(0, 12);
					switch (random)
					{
					case 0:		WildlifeGrid[i][j] = new Tree(); break;
					case 1: 	WildlifeGrid[i][j] = new Grass(); break;
					case 2: 	WildlifeGrid[i][j] = new Caterpillar(); break;
					case 3: 	WildlifeGrid[i][j] = new Grasshopper(); break;
					case 4: 	WildlifeGrid[i][j] = new Rabbit(); break;
					case 5: 	WildlifeGrid[i][j] = new Mouse(); break;
					case 6: 	WildlifeGrid[i][j] = new Squirrel(); break;
					case 7: 	WildlifeGrid[i][j] = new Bluejay(); break;
					case 8: 	WildlifeGrid[i][j] = new Deer(); break;
					case 9: 	WildlifeGrid[i][j] = new Fox(); break;
					case 10: 	WildlifeGrid[i][j] = new Hawk(); break;
					case 11: 	WildlifeGrid[i][j] = new Wolf(); break;
					}
				}
				else {
					WildlifeGrid[i][j] = null;
				}
			}
		}
	}

	public void displayWildlife(int wildlifeDensity)
	{
		populateGrid(wildlifeDensity);
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
				if (WildlifeGrid[i][j] != null)
				{
					System.out.print(WildlifeGrid[i][j].getSymbol());
				}
				else
				{
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
