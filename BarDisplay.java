//CS201 Assignment 4
//Nicole Fella

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * 
 */
public class BarDisplay extends JComponent 
{
	//instance field of a new Integer array (which is compatible with sorting methods)
	public Integer[] array;
	
	public BarDisplay(Integer[] arrayParam)
	{
		//assign the parameter to the instance field 
		this.array = arrayParam;
		//always remember to repaint!!!
		repaint();
	}
	
	public void paint(Graphics g)
	{
		//made this condition (array != null) to avoid "AWT-EventQueue-0" error which 
		//I was getting before --> related to null pointer exception error
		if(this.array != null)
		{
			//develop a working width for the bars -- with given array length
			int width = getWidth()/array.length;
			//iterate over the array of integers --> will draw the bars
			for (int i=0; i<this.array.length; i++)
			{
				//call the function to draw each of the bars
				drawBars(g, this.array[i], (int)(width*0.9), width*i);
			}
		}
	}
	/**
	 * Method which will draw each bar and label it with the array value the integer array contains 
	 */
	public void drawBars(Graphics g, int arrayVal, int width, int startX)
	{
		//draw outline of rectangle bars
		//getHeight()-arrayVal means the arrayVal will actually be how tall the bar will go
		g.setColor(Color.BLACK);
		g.drawRect(startX, getHeight()-arrayVal, width, arrayVal);
		//fill in rectangle bars
		g.setColor(Color.PINK);
		g.fillRect(startX, getHeight()-arrayVal, width, arrayVal);
		//label rectanble bars
		g.setColor(Color.DARK_GRAY);
		//set bar values to be near the top of the bar (15 pixels down)
		g.drawString(Integer.toString(arrayVal), startX, getHeight()-arrayVal+15);
	}
	
	public void setArray(Integer[] arrayParam)
	{
		this.array = arrayParam;
	}
}
