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
	
	//Function for obtaining a wildlife density from the user
	public int determineDensity()
	{
		//Declaring local variables
		String inputString;
		int density = 0;
		boolean validChoice = false;
		
		//Inform the user what density represents and how to enter their choice
		System.out.println("Wildlife density, expressed as a percentage, indicates the likelihood of wildlife spawning in a given grid space.");
		
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
			
	public static void main(String[] args) 
	{
		//Declaring local variables
		Simulation userInterface = new Simulation();
		int wildlifeDensity;
		
		//Welcome the user to the program and inform them of its purpose
		System.out.println("Welcome to the Saskatchewan Wildlife Lifecycle Model!");
		System.out.println("This application allows you to generate a grid of wildlife and observe its inhabitants!\n");
		
		//Allow the user to determine the density of the grid
		wildlifeDensity = userInterface.determineDensity();
		System.out.println(wildlifeDensity);
		
		//Utilize the density level to populate the wildlife grid
		
		Grid grid = new Grid();
		grid.displayWildlife();
	}
}
