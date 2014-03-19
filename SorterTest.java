//CS201 Assignment 4
//Nicole Fella


import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tester that tests each of the sorting methods
 */
public class SorterTest 
{
	//testing array
	Integer[] testInts;
	String[] testStrings;
	
	/**
	 * Randomly create a list or array of n random numbers between lo and hi
	 */
	@Before
	public void createIntArray(){
		//create random length for array and assign length to testInts
		int arrayLength = (int)(Math.random()*22);
		testInts = new Integer[arrayLength];
		
		//create random lo and hi bounds for array
		for (int i=0; i<testInts.length; i++)
		{
			testInts[i] = (int)(Math.random()*360);
		}
	}
	
	/**
	 * Create a list of strings to sort
	 */
	@Before 
	public void createStringArray(){
		//create an array of strings 
		String[] createString = {"Poop", "Reflexology", "English", "Circuits",
									"Aurora", "Shower", "Algorithm"};
		//assign the list of strings created above to our testing array
		testStrings = createString;
	}

	/**
	 * Create test method for EACH sort implementations to sort list or array.
	 * Check that it is in sorted order and that assertEquals that the test comes out true
	 */
	@Test
	public void selectionSortTest() {
		Arrays.sort(testStrings); 
		String[] expected = testStrings;
		//re-randomize global variable
		createStringArray();
		Sorter.selectionSort(testStrings);
		String[] actual = testStrings;
		//Assert Equals -- tests of sorting worked out correctly
		assertEquals("Checking if method of sorting works properly", expected, actual);
	}
	
	@Test
	public void insertionSortTest(){
		Arrays.sort(testStrings); //should return true if sorts correctly
		String[] expected = testStrings;
		//re-randomize global variable
		createStringArray();
		Sorter.insertionSort(testStrings);
		String[] actual = testStrings;
		//Assert Equals -- tests out if sorting worked correctly
		assertEquals("Checking if method of sorting works properly", expected, actual);
	}
	
	@Test
	public void bubbleSortTest(){
		Arrays.sort(testStrings); //should return true if sorts correctly
		String[] expected = testStrings;
		//re-randomize global variable
		createStringArray();
		Sorter.bubbleSort(testStrings);
		String[] actual = testStrings;
		//Assert Equals -- tests out if sorting worked correctly
		assertEquals("Checking if method of sorting works properly", expected, actual);
	}
	
	@Test
	public void mergeSortTest(){
		Arrays.sort(testStrings); //should return true if sorts correctly
		String[] expected = testStrings;
		//re-randomize global variable
		createStringArray();
		Sorter.mergeSort(testStrings);
		String[] actual = testStrings;
		//Assert Equals -- tests our if sorting worked correctly
		assertEquals("Checking if method of sorting works properly", expected, actual);
	}

}
