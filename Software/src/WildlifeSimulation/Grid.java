/**
* Grid.java
*
* DESCRIPTION:
* This file contains the grid implementation required by the wildlife simulation. Users are able to populate
* the grid, display the grid to the console and determine the organism present at a particular location.
* Additionally, users are able to advance the simulation by a single day.
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
	public static final int ROWS = 5;
	public static final int COLS = 10;
	 
	//Private wildlife array
	private Wildlife WildlifeGrid[][] = new Wildlife[ROWS][COLS];
	//private int daysElapsed;
	
	public Grid() 
	{
		//this.daysElapsed = 0;
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
		int mobility, maxRowUp, maxRowDown, maxColLeft, maxColRight;
		boolean moved;
		
		//daysElapsed++;
		// Iterate through rows and columns, checking every space
		for (int row = 0; row < ROWS; row++)
		{
			for (int col = 0; col < COLS; col++)
			{
				// If the space is occupied, proceed
				if (WildlifeGrid[row][col] != null)
				{
					mobility = WildlifeGrid[row][col].getMobility();
					// If the Wildlife at the current position is able to move (not a tree or grass), proceed
					if (mobility > 0)
					{
						moved = false;
						// Get the farthest bounds that the current Wildlife can move to (min and max row/column)
						maxRowUp = ((row - mobility) >= 0) ? (row - mobility) : 0;
						maxRowDown = ((row + mobility) < ROWS) ? (row + mobility) : (ROWS - 1);
						maxColLeft = ((col - mobility) >= 0) ? (col - mobility) : 0;
						maxColRight = ((col + mobility) < COLS) ? (col + mobility) : (COLS - 1);
						
						// Test coordinate - test successful
						// System.out.println(WildlifeGrid[row][col].getSymbol()+"["+row+"]["+col+"]\t : MaxUp["+maxRowUp+"] \t MaxDown["+maxRowDown+"] \t MaxLeft["+maxColLeft+"] \t MaxRight["+maxColRight+"]");
						
						// Iterate through the valid movement zone for the current Wildlife
						for (int i = maxRowUp; i <= maxRowDown && !moved; i++)
						{
							for (int j = maxColLeft; j <= maxColRight && !moved; j++)
							{
								if ((i != row) && (j != col))
								{
									// If the current Wildlife can eat the Wildlife at the potential spot, move and eat
									if (WildlifeGrid[i][j] != null)
									{
										if (WildlifeGrid[row][col].canEat(WildlifeGrid[i][j]))
										{
											WildlifeGrid[row][col].eat(WildlifeGrid[i][j], i, j);
											WildlifeGrid[row][col].move();
											WildlifeGrid[i][j] = WildlifeGrid[row][col];
											WildlifeGrid[row][col] = null;
											moved = true;
										}
									}
									// Otherwise, if the potential spot is empty, move there
									else if (WildlifeGrid[i][j] == null)
									{
										WildlifeGrid[row][col].move();
										// Check if the current Wildlife has died of starvation or not before moving
										if (WildlifeGrid[row][col].isDead())
										{
											System.out.println(WildlifeGrid[row][col].getName() + " has died of starvation");
											WildlifeGrid[row][col] = null;
											moved = true;
										}
										else
										{
											WildlifeGrid[i][j] = WildlifeGrid[row][col];
											WildlifeGrid[row][col] = null;
											moved = true;
										}
									}
								}
								
								
							}
						}
					}
				}
			}
		}
		// Display the grid after the day's moves
		displayWildlife();
	}
	
	/*public void advanceOneDay()
	{
		int maxRowUp, maxRowDown, maxColLeft, maxColRight, mobility;
		int randRow, randCol;
		int tempNullRow, tempNullCol;
		int totalPotentialMoves, currentMove;
		boolean validMove;
		
		for (int row = 0; row < ROWS; row++)
		{
			for (int col = 0; col < COLS; col++)
			{
				if (WildlifeGrid[row][col] != null)
				{
					mobility = WildlifeGrid[row][col].getMobility();
					if (mobility > 0)
					{
						validMove = false;
						// Get the farthest bounds that the current wildlife can move to (min/max row/column)
						maxRowUp = ((row - mobility) >= 0) ? (row - mobility) : 0;
						maxRowDown = ((row + mobility) < ROWS) ? (row + mobility) : (ROWS - 1);
						maxColLeft = ((col - mobility) >= 0) ? (col - mobility) : 0;
						maxColRight = ((col + mobility) < COLS) ? (col + mobility) : (COLS - 1);
						
						totalPotentialMoves = (maxRowDown - maxRowUp + 1) * (maxColRight * maxColLeft + 1) - 1;
						currentMove = 1;
						tempNullRow = -1;
						tempNullCol = -1;
						
						// Find a valid position to move to
						// If wildlife is hungry (hunger < 70), look for food, otherwise eat or move to an open space
						do 
						{
							//randRow = ThreadLocalRandom.current().nextInt(maxRowUp, maxRowDown + 1);
							//randCol = ThreadLocalRandom.current().nextInt(maxColLeft, maxColRight + 1);
							randRow = 0;
							randCol = 0;
							for (randRow = maxRowUp; randRow <= maxRowDown; randRow++)
							{
								for (randCol = maxColLeft; randCol <= maxColRight; randCol++)
								{
									// Ensure it isn't trying to move onto itself
									if ((randRow == row) && (randCol == col))
									{
										validMove = false;
									}
									// If wildlife is hungry, check if the potential spot is empty
									// If it is not, check if the spot is occupied by a valid prey
									else if (WildlifeGrid[row][col].isHungry())
									{
										if (WildlifeGrid[randRow][randCol] != null)
										{
											if (WildlifeGrid[row][col].canEat(WildlifeGrid[randRow][randCol]))
											{
												validMove = true;
											}
											else 
											{ 
												validMove = false;
												currentMove++;
											}
										}
										// Save an empty space in case valid prey cannot be found
										else 
										{
											tempNullRow = randRow;
											tempNullCol = randCol;
										}
									}
									// If not hungry, allow it to move to an empty space
									else if (WildlifeGrid[randRow][randCol] == null)
									{
										validMove = true;
									}
									else 
									{
										validMove = false;
										currentMove++;
									}
								}
							}
						} while (!validMove && currentMove <= totalPotentialMoves);
						
						if (currentMove > totalPotentialMoves)
						{
							if (tempNullRow != -1 && tempNullCol != -1)
							{
								System.out.println(WildlifeGrid[row][col].getName() + " was unable to find find and moved to [" + tempNullRow + "][" + tempNullCol +"]");
								WildlifeGrid[tempNullRow][tempNullCol] = WildlifeGrid[row][col];
								WildlifeGrid[row][col] = null;
							}
							else 
							{
								System.out.println(WildlifeGrid[row][col].getName() + " was unable to find find and stayed at [" + row + "][" + col +"]");
							}
						}
						// Move to an empty space
						else if (WildlifeGrid[randRow][randCol] == null)
						{
							WildlifeGrid[row][col].move();
							// Check if the animal has died of starvation
							if (WildlifeGrid[row][col].isDead())
							{
								WildlifeGrid[row][col] = null;
								System.out.println(WildlifeGrid[row][col].getName() + " has died of starvation");
							}
							// Otherwise, finish the move process
							else
							{
								WildlifeGrid[randRow][randCol] = WildlifeGrid[row][col];
								WildlifeGrid[row][col] = null;
							}
						}
						// Move to the location of a valid prey and eat it
						else if (WildlifeGrid[row][col].canEat(WildlifeGrid[randRow][randCol]))
						{
							WildlifeGrid[row][col].eat(WildlifeGrid[randRow][randCol], randRow, randCol);
							WildlifeGrid[row][col].move();
							WildlifeGrid[randRow][randCol] = WildlifeGrid[row][col];
							WildlifeGrid[row][col] = null;
						}
					}
				}
			}
		}
		
		displayWildlife();
	}*/
	
	//private checkPotentialSpot()
	//{
	
	//}
}
