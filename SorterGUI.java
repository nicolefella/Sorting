//CS201 Assignment 4
//Nicole Fella

import javax.swing.JFrame;

/**
 * This class creates a GUI which demonstrates various sorting implementations.
 * Idea from Audrey's sample: generate visual unsorted array, then sort it (two buttons)
 */
public class SorterGUI 
{
	/**
	 * Main Method to start the GUI
	 */
	public static void main(String[] args)
	{
		//create a frame
		JFrame sortingGUI = new JFrame("Sorting at Work");
		//set the parameters of the frame (size and close operation)
		sortingGUI.setSize(600,400);
		sortingGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//add the sorting panel to the frame
		sortingGUI.add(new SortingPanel());
		//make the frame visible!!!
		sortingGUI.setVisible(true);
	}
}
