/**
* Simulation.java
*
* DESCRIPTION:
* This file is the main file for the ENSE 374 Lab 5 assignment in the Fall 2016
* semester at the University of Regina. By following the provided prompts, the user is able
* to add wildlife to a grid and observe the creatures living in their simulation.
*
* AUTHORS: 	Tristan Heisler 200351317
* 			Jonathon Wells 200328640
* 			Quinn Bast 200352973		
*/

package WildlifeSimulation;
import java.util.Scanner;

public class Simulation 
{	
	public Scanner input;
	
	//Default constructor to open a Scanner object
	public Simulation()
	{
		input = new Scanner(System.in);
	}
	
	//Function for obtaining a valid wildlife density from the user
	public int determineDensity()
	{
		//Declaring local variables
		String inputString;
		int density = 0;
		boolean validChoice = false;		
		
		//Create a loop to obtain a valid percentage value
		do
		{
			//Prompt the user and store their input
			System.out.print("Please enter your desired density: ");
			inputString = input.nextLine();
						
			try
			{
				//Try to convert the string to an integer
				density = Integer.parseInt(inputString);
				
				//If no exception was thrown, determine if the chosen density is in the acceptable range
				if(density < 0 || density > 100)
				{
					System.out.print("Density percentage must be in the range of 0 to 100. ");
					continue;
				}
				
				//If the density is reasonable, exit the loop
				validChoice = true;
			}
			catch(NumberFormatException ex)
			{
				//If the input cannot be expressed as an integer, inform the user and prompt them again
				System.out.print("Invalid density format. ");
			}	
		}while(!validChoice);
		
		//Return the valid result
		return density;
	}
	
	//Function for obtaining a valid menu choice from the user
	public char obtainMenuChoice()
	{
		//Declaring local variables
		String inputString;
		char choice;
		boolean validChoice = false;

		//Present the possible choices to the user in a menu
		System.out.print("\n/~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\\\n"
			+ "|Please indicate what you would like to do next:              |\n"
			+ "|\t1. Display the wildlife grid to the console           |\n"
			+ "|\t2. Determine the wildlife present at a given location |\n"
			+ "|\t3. Enter a new wildlife density                       |\n"
			+ "|\t4. Exit the program                                   |\n"
			+ "\\~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~/\n\n");
		
		//Create a loop that will run until the user enters a valid choice
		do
		{
			//Obtain the first character of the input string and ignore the rest of the string
			System.out.print("Please enter your selection: ");
			inputString = input.nextLine();
			choice = inputString.charAt(0);	
			
			//Evaluate the choice that was made
			switch(choice)
			{
				//If the given choice is permitted, exit the loop
				case '1':
				case '2':
				case '3':
				case '4':
					validChoice = true;
					break;
				//If the given choice is not permitted, inform the user and prompt them again
				default:
					System.out.print("Invalid selection. ");
					break;
			}			
		}while(!validChoice);		
		
		//Return the user's valid choice		
		return choice;
	}
	
	//Function for obtaining a valid row or column number from the user
	public int determineRowOrColumn(String prompt, int maxValue)
	{
		//Declaring local variables
		String inputString;
		int index = 0;
		boolean validChoice = false;		
		
		//Inform the user of permissible values
		System.out.print("The acceptable range of " + prompt + "s is 0 to " + maxValue + ". ");
		
		//Create a loop to obtain a valid percentage value
		do
		{
			//Prompt the user and store their input
			System.out.print("Please enter your desired " + prompt + ": ");
			inputString = input.nextLine();
						
			try
			{
				//Try to convert the string to an integer
				index = Integer.parseInt(inputString);
				
				//If no exception was thrown, determine if the chosen index is in the acceptable range
				if(index < 0 || index > maxValue)
				{
					System.out.print("The given " + prompt + " lies outside the permitted bounds. ");
					continue;
				}
				
				//If the density is reasonable, exit the loop
				validChoice = true;
			}
			catch(NumberFormatException ex)
			{
				//If the input cannot be expressed as an integer, inform the user and prompt them again
				System.out.print("Invalid " + prompt + " format. ");
			}	
		}while(!validChoice);
		
		//Return the valid result
		return index;
	}
	
	public static void main(String[] args) 
	{
		//Declaring local variables
		Simulation userInterface = new Simulation();
		Grid wildlifeGrid = new Grid();
		int wildlifeDensity;
		char menuChoice;
		int row, column;
		boolean anotherSelection = true;
		
		Fox fox = new Fox();
		fox.getdietList();
		Mouse mouse = new Mouse();
		mouse.getdietList();
		Hawk hawk = new Hawk();
		hawk.getdietList();
		Wolf wolf = new Wolf();
		wolf.getdietList();
		Rabbit rabbit = new Rabbit();
		rabbit.getdietList();
		Squirrel squirrel = new Squirrel();
		squirrel.getdietList();
		Deer deer = new Deer();
		deer.getdietList();
		Grasshopper grasshopper = new Grasshopper();
		grasshopper.getdietList();
		Caterpillar caterpillar = new Caterpillar();
		caterpillar.getdietList();
		
		//Welcome the user to the program and inform them of its purpose
		System.out.println("Welcome to the Saskatchewan Wildlife Lifecycle Model!");
		System.out.println("This application allows you to generate a grid of wildlife and observe its inhabitants!\n");
	
		
		//Allow the user to determine the density of the grid
		//Inform the user what density represents and how to enter their choice
		System.out.println("Wildlife density, expressed as a percentage, indicates the likelihood of wildlife spawning in a given grid space.");
		wildlifeDensity = userInterface.determineDensity();
		
		

		//Utilize the density level to populate the wildlife grid
		wildlifeGrid.populateGrid(wildlifeDensity);
				
		//Create a loop that will allow the user to interact with the application for as long as they require
		do
		{			
			//Present a menu of options to the user and obtain the result
			menuChoice = userInterface.obtainMenuChoice();
					
			//Call the appropriate function based on the user's response
			switch(menuChoice)
			{
				//Display the wildlife grid to the console
				case '1':	
					wildlifeGrid.displayWildlife();
					break;					
					
				case '2':
					//Obtain a row from the user
					row = userInterface.determineRowOrColumn("row", Grid.ROWS - 1);
					
					//Obtain a column from the user
					column = userInterface.determineRowOrColumn("column", Grid.COLS - 1);
					
					//Verify the user's selection
					System.out.println("You selected the location [" + row + "][" + column + "].");
					break;					
					
				//Enter a new wildlife density
				case '3':
					wildlifeDensity = userInterface.determineDensity();
					wildlifeGrid.populateGrid(wildlifeDensity);
					break;
					
				//Exit the program
				case '4':
					System.out.println("Goodbye!");
					anotherSelection = false;
					break;
			}
		}while(anotherSelection);		

	}
}
