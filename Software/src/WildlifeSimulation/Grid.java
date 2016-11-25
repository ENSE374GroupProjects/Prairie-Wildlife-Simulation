/**
* Grid.java
*
* DESCRIPTION:
* This file contains the grid implementation required by the wildlife simulation. Users are able to populate
* the grid, display the grid to the console and determine the organism present at a particular location.
*
* AUTHORS: 	Tristan Heisler 200351317
* 			Jonathon Wells 200328640
* 			Quinn Bast 200352973		
*/

package WildlifeSimulation;
import java.util.concurrent.ThreadLocalRandom;

public class Grid 
{
	//Public constants
	public static final int ROWS = 36;
	public static final int COLS = 100;
	 
	//Private wildlife array
	private Wildlife WildlifeGrid[][] = new Wildlife[ROWS][COLS];
	
	public Grid() 
	{
	}
	
	public void populateGrid(int wildlifeDensity)
	{
		// Future plan: Implement different chances for each specific creature to spawn
		// eg: wildlifeDensity = 50, switch case for wolf (10%) = 0 - wildlifeDensity/10
		int random;
		
		//Loop through each row
		for (int i = 0; i < ROWS; i++)
		{
			//Loop through each column
			for (int j = 0; j < COLS; j++)
			{
				//Generate a random number from 1 to 100 inclusive
				random = ThreadLocalRandom.current().nextInt(1, 101);
				
				//If the number is smaller than the percentage, add a wildlife member at this location
				if (random <= wildlifeDensity) 
				{
					//Randomly generate a number to determine which wildlife to spawn
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
				//If the number is larger than the percentage, do not add a new wildlife member
				else 
				{
					WildlifeGrid[i][j] = null;
				}
			}
		}
	}

	public void displayWildlife()
	{
		// Print top bar
		System.out.print("\n/");
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
	
	public void getWildlifeAtLocation(int row, int col)
	{
		// If there is something at the entered location, print the name of the object, otherwise say it is empty
		if (WildlifeGrid[row][col] != null) {
			System.out.println("Location [" + row + "][" + col + "] contains a " + WildlifeGrid[row][col].getName() + ".");
		}
		else {
			System.out.println("Location [" + row + "][" + col + "] is empty.");
		}
	}
	
	public void advanceOneDay()
	{
		//int maxLeft, maxRight, maxUp, maxDown, mobility;
		int maxRowUp, maxRowDown, maxColLeft, maxColRight, mobility;
		int randStartRow, randStartCol;
		for (int row = 0; row < ROWS; row++)
		{
			for (int col = 0; col < COLS; col++)
			{
				if (WildlifeGrid[row][col] != null)
				{
					// Find the max positions that the current wildlife can move to linearly
					mobility = WildlifeGrid[row][col].getMobility();
					if (mobility > 0)
					{
						maxRowUp = ((row - mobility) >= 0) ? (row - mobility) : 0;
						maxRowDown = ((row + mobility) < ROWS) ? (row + mobility) : (ROWS - 1);
						maxColLeft = ((col - mobility) >= 0) ? (col - mobility) : 0;
						maxColRight = ((col + mobility) < COLS) ? (col + mobility) : (COLS - 1);
						
						// Choose a random row and column to start at within -1 and +1
						//randStartRow = ThreadLocalRandom.current().nextInt(-1, 2); // Random number from -1 to +1
						//randStartCol = ThreadLocalRandom.current().nextInt(-1, 2);
						
						randStartRow = ThreadLocalRandom.current().nextInt(maxRowUp, maxRowDown + 1);
						randStartCol = ThreadLocalRandom.current().nextInt(maxColLeft, maxColRight + 1);
						
						// Testing, just move to initial random square within grid
						WildlifeGrid[randStartRow][randStartCol] = WildlifeGrid[row][col];
						WildlifeGrid[row][col] = null;
						
						// for (int i = row + randStartRow; i <= maxRowDown && i >= maxRowUp; i++)
//						int i = row + randStartRow;
//						int j = col + randStartCol;
//						while (i >= maxRowUp && i <= maxRowDown)
//						{
							
//						}
					}
				}
			}
		}
		
		displayWildlife();
	}
	
	//private checkPotentialSpot()
	//{
	
	//}
}
