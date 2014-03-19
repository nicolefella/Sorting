//CS201 Assignment4
//Nicole Fella

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SortingPanel extends JPanel
{
	public Integer[] array;
	public BarDisplay barDisplay;
	public JTextArea sortText;
	/**
	 * Constructor
	 */
	public SortingPanel()
	{
		//set the layout for the panel
		setLayout(new BorderLayout());

		//make new bar display and add it to panel
		this.barDisplay = new BarDisplay(this.array);
		add(this.barDisplay, "Center");
		
		//add buttons panel to south
		add(buttonsPanel(), "South");
		
		//add text panel North
		add(textPanel(), "North");
	}
	
	/**
	 * Buttons Panel for random array button and sort button
	 */
	public JPanel buttonsPanel()
	{
		//create a jpanel called buttonpanel
		JPanel buttonPanel = new JPanel();
		//add random button to the panel
		buttonPanel.add(randomButton(), "West");
		//add sorting button to the panel
		buttonPanel.add(sortButton(), "East");
		//return the panel
		return buttonPanel;
	}
	
	/**
	 * creates random button 
	 */
	public JButton randomButton()
	{
		//create a new jbutton and give it the label "Click for new random array :)"
		JButton randButton = new JButton("Click for new random array :)");
		//add actionlistener to the button which will randomize array when clicked
		randButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SortingPanel.this.randomizeArray();
			}
		});
		//return button
		return randButton;
	}
	
	public JButton sortButton()
	{
		//create a new jbutton and give it the label "click to sort :)"
		JButton sortButton = new JButton("Click to Sort :)");
		//add a actionlistener to the button which will sort the array when clicked
		sortButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				SortingPanel.this.sort();
			}
		});
		//return button
		return sortButton;
		
	}
	
	public void randomizeArray()
	{
		//create random array
		this.array = createIntArray();
		//set array to be the array in the bard display
		this.barDisplay.setArray(this.array);
		//REPAINT!!!
		repaint();
	}
	
	public Integer[] createIntArray(){
		//create random length for array and assign length to testInts (between 15 and 25 index values)
		int arrayLength = (int)(Math.random()*10)+15;
		Integer[] tempArray = new Integer[arrayLength];
		
		//create random lo bound (25) and hi bound (300) for array
		for (int i=0; i<tempArray.length; i++)
		{
			
			tempArray[i] = (int)(Math.random()*275)+25;
		}
		return tempArray;
	}
	public void sort()
	{
		//create a random number to base which sort of sorting method to use
		int rand = (int)(Math.random()*4);
		
		//each sorting method should have 25% chance of being chosen
		if (rand<1)
		{
			Sorter.selectionSort(this.array);
			sortText.setText("Sorting type: selection sort");
		}
		else if (rand<2)
		{
			Sorter.insertionSort(this.array);
			sortText.setText("Sorting type: insertion sort");
		}
		else if (rand<3)
		{
			Sorter.bubbleSort(this.array);
			sortText.setText("Sorting type: bubble sort");
		}
		else
		{
			Sorter.mergeSort(this.array);
			sortText.setText("Sorting type: merge sort");
		}
		
		//REPAINT REPAINT REPAINT
		this.barDisplay.repaint();
		repaint();
	}
	
	/**
	 * Method used to create text Panel which will be updated by which type of sort
	 */
	public JTextArea textPanel()
	{
		sortText = new JTextArea("Sorting type will be randomly selected to be either: "
				+ "selection sort, insertion sort, bubble sort or merge sort");
		
		return sortText;
	}
}
