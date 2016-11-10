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
			
	public static void main(String[] args) 
	{
		//Welcome the user to the program and inform them of its purpose
		System.out.println("Welcome to the Saskatchewan Wildlife Lifecycle Model!");
		System.out.println("This application allows you to generate a grid of wildlife and observe its inhabitants!\n");
		
		Grid grid = new Grid();
		
		grid.displayWildlife();
	}
}
