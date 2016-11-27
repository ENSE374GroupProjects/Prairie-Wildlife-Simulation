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
	public static final int ROWS = 36;
	public static final int COLS = 100;
	 
	//Private wildlife array
	private Wildlife WildlifeGrid[][] = new Wildlife[ROWS][COLS];
	private int daysElapsed;
	
	public Grid() 
	{
		//By default, 0 days have passed
		this.daysElapsed = 0;
	}
	
	public void populateGrid(int wildlifeDensity)
	{
		//Declaring local variables
		int random;
		
		//Reset the number of days that have elapsed
		this.daysElapsed = 0;
		
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
					random = ThreadLocalRandom.current().nextInt(0, 101);
					if (random < 15) 						{ WildlifeGrid[i][j] = new Tree(); }		//15% chance of a tree	
					else if (random >= 15 && random < 35) 	{ WildlifeGrid[i][j] = new Grass(); }		//20% chance of grass
					else if (random >= 35 && random < 42) 	{ WildlifeGrid[i][j] = new Caterpillar(); }	//7% chance of a caterpillar
					else if (random >= 42 && random < 52) 	{ WildlifeGrid[i][j] = new Grasshopper(); }	//10% chance of a grasshopper
					else if (random >= 52 && random < 62) 	{ WildlifeGrid[i][j] = new Rabbit(); }		//10% chance of a rabbit
					else if (random >= 62 && random < 68) 	{ WildlifeGrid[i][j] = new Mouse(); }		//6% chance of a mouse
					else if (random >= 68 && random < 76) 	{ WildlifeGrid[i][j] = new Squirrel(); }	//8% chance of a squirrel
					else if (random >= 76 && random < 82) 	{ WildlifeGrid[i][j] = new Bluejay(); }		//6% chance of a bluejay
					else if (random >= 82 && random < 90) 	{ WildlifeGrid[i][j] = new Deer(); }		//8% chance of a deer
					else if (random >= 90 && random < 94) 	{ WildlifeGrid[i][j] = new Fox(); }			//4% chance of a fox
					else if (random >= 94 && random < 98) 	{ WildlifeGrid[i][j] = new Hawk(); }		//4% chance of a hawk
					else if (random >= 98 && random <= 100) { WildlifeGrid[i][j] = new Wolf(); }		//2% chance of a wolf
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

		System.out.println("\nDays Elapsed: " + this.daysElapsed);
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

	public void printWildlifePopulations() 
	{
		//Initialize the number of each organism as 0
		int 	numGrass = 0,
				numTrees = 0,
				numCaterpillars = 0,
				numGrasshoppers = 0,
				numBluejays = 0,
				numRabbits = 0,
				numSquirrels = 0,
				numDeer = 0,
				numWolves = 0,
				numHawks = 0,
				numFoxes = 0,
				numMice = 0;

		//Loop through each row
		for (int row = 0; row < ROWS; row++) 
		{
			//Loop through each column
			for (int col = 0; col < COLS; col++) 
			{
				//If a wildlife member is present at the current spot, increase its count by 1
				if (WildlifeGrid[row][col] != null) 
				{
					if (WildlifeGrid[row][col].getName() == "grass")			{ numGrass++; }
					else if (WildlifeGrid[row][col].getName() == "tree")		{ numTrees++; }
					else if (WildlifeGrid[row][col].getName() == "caterpillar")	{ numCaterpillars++; }
					else if (WildlifeGrid[row][col].getName() == "grasshopper")	{ numGrasshoppers++; }
					else if (WildlifeGrid[row][col].getName() == "bluejay")		{ numBluejays++; }
					else if (WildlifeGrid[row][col].getName() == "rabbit")		{ numRabbits++; }
					else if (WildlifeGrid[row][col].getName() == "squirrel")	{ numSquirrels++; }
					else if (WildlifeGrid[row][col].getName() == "deer")		{ numDeer++; }
					else if (WildlifeGrid[row][col].getName() == "wolf")		{ numWolves++; }
					else if (WildlifeGrid[row][col].getName() == "fox")			{ numFoxes++; }
					else if (WildlifeGrid[row][col].getName() == "mouse")		{ numMice++; }
					else if (WildlifeGrid[row][col].getName() == "hawk")		{ numHawks++; }
				}
			}
		}
		
		//Output the number of each wildlife member currently present in the grid
		System.out.println("\nFauna populations:");
		System.out.println("\tBluejays: \t\t" + numBluejays);
		System.out.println("\tCaterpillars: \t\t" + numCaterpillars);
		System.out.println("\tDeer: \t\t\t" + numDeer);
		System.out.println("\tFoxes: \t\t\t" + numFoxes);
		System.out.println("\tGrasshoppers: \t\t" + numGrasshoppers);
		System.out.println("\tHawks: \t\t\t" + numHawks);
		System.out.println("\tMice: \t\t\t" + numMice);
		System.out.println("\tRabbits: \t\t" + numRabbits);
		System.out.println("\tSquirrels: \t\t" + numSquirrels);		
		System.out.println("\tWolves: \t\t" + numWolves);
		System.out.println("\nFlora populations:");
		System.out.println("\tGrass: \t\t\t" + numGrass);
		System.out.println("\tTrees: \t\t\t" + numTrees);
	}

	public void advanceOneDay()
	{
		int mobility, maxRowUp, maxRowDown, maxColLeft, maxColRight;
		int preyRow, preyCol, emptyRow, emptyCol;
		int randChance;
		daysElapsed++; // daysElapsed will be used to verify against totalMoves of a Wildlife object to check if it has moved this day

		// Iterate through WildlifeGrid
		for (int row = 0; row < ROWS; row++) {
			for (int col = 0; col < COLS; col++) {
				// Check each space to see if the space is occupied
				if (WildlifeGrid[row][col] != null) {
					mobility = WildlifeGrid[row][col].getMobility();
					// Check to see if the Wildlife object has the ability to move (flora vs fauna)
					if (mobility > 0) {
						// Check to see if it has already moved this day, proceed if it has not
						if (WildlifeGrid[row][col].getTotalMoves() < daysElapsed) {
							// Get max dimensions of the Wildlife's movement zone based on its mobility
							maxRowUp = ((row - mobility) >= 0) ? (row - mobility) : 0;
							maxRowDown = ((row + mobility) < ROWS) ? (row + mobility) : (ROWS - 1);
							maxColLeft = ((col - mobility) >= 0) ? (col - mobility) : 0;
							maxColRight = ((col + mobility) < COLS) ? (col + mobility) : (COLS - 1);

							// Set temporary prey and empty space locations to -1
							preyRow = -1;
							preyCol = -1;
							emptyRow = -1;
							emptyCol = -1;

							// Check each position to see if it is a valid move
							// If the animal is not hungry (hunger >= 70), take the first valid move (open space or prey)
							// If the animal is hungry (hunger < 70), save an empty space as a temp, but only move to it if it can't find prey
							// If it does find a prey, move to it
							// Every move, the 'totalMoves' increments by 1 and 'hunger' decrements by 10
							// If moving to a prey, eat it, replenishing 'hunger' by the prey's 'hungerReplenishment' value
							for (int i = maxRowUp; i <= maxRowDown; i++) {
								for (int j = maxColLeft; j <= maxColRight; j++) {
									// If [i][j] is an empty space, temporarily store the location
									if (WildlifeGrid[i][j] == null) {
										// If there is no empty position saved, save this position
										if ((emptyRow == -1) && (emptyCol == -1)) {
											emptyRow = i;
											emptyCol = j;
										}
										// Otherwise, have a 1/12 chance of saving it
										else {
											randChance = ThreadLocalRandom.current().nextInt(1, 13); // Random int from 1-12
											if (randChance == 2) {
												emptyRow = i;
												emptyCol = j;
											}
										}
									}
									// If [i][j] is occupied, check if the current Wildlife can eat it
									else {
										if (WildlifeGrid[row][col].canEat(WildlifeGrid[i][j])) {
											// If there is no prey position saved, save this position
											if ((preyRow == -1) && (preyCol == -1)) {
												preyRow = i;
												preyCol = j;
											}
											// Otherwise, have a 1/12 chance of saving it
											else {
												randChance = ThreadLocalRandom.current().nextInt(1, 13); // Random int from 1-12
												if (randChance == 2) {
													preyRow = i;
													preyCol = j;
												}
											}
										}
									}
								}
							}
							// Check if the current Wildlife's hunger hits 0, and remove it if it has
							if (WildlifeGrid[row][col].isDead()) {
								System.out.println("A " + WildlifeGrid[row][col].getName() + " at [" + row + "][" + col + "] has died of starvation.");
								WildlifeGrid[row][col] = null;
							}
							// If the current Wildlife is hungry, move to the stored prey location if available
							else if (WildlifeGrid[row][col].isHungry() && (preyRow != -1) && (preyCol != -1)) {
								System.out.println("A " + WildlifeGrid[row][col].getName() + " ate a " + WildlifeGrid[preyRow][preyCol].getName() + " at [" + preyRow + "][" + preyCol + "].");
								WildlifeGrid[row][col].move();
								WildlifeGrid[row][col].eat(WildlifeGrid[preyRow][preyCol], preyRow, preyCol);
								WildlifeGrid[preyRow][preyCol] = WildlifeGrid[row][col];
								WildlifeGrid[row][col] = null;
							}
							// If current Wildlife isn't hungry or no prey could be found, move to an empty space if possible
							else if ((emptyRow != -1) && (emptyCol != -1)) {
								System.out.println("A " + WildlifeGrid[row][col].getName() + " moved to location [" + emptyRow + "][" + emptyCol + "].");
								WildlifeGrid[row][col].move();
								WildlifeGrid[emptyRow][emptyCol] = WildlifeGrid[row][col];
								WildlifeGrid[row][col] = null;
							}
							// If no valid move was found, wait a day
							else {
								WildlifeGrid[row][col].move();
								System.out.println("A " + WildlifeGrid[row][col].getName() + " waited at [" + row + "][" + col + "] for a day.");
							}
						}
					}
				}
			}
		}
		displayWildlife();
	}
}
