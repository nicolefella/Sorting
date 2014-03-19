//CS201 Assignment4
//Nicole Fella

/**
 * This class has 4 static methods for sorting an array of Comparables.
 * Referenced API (http://docs.oracle.com/javase/7/docs/api/java/lang/Comparable.html)
 */
public class Sorter {

	/**
	 * Input: array of comparable items. Output: array, sorted.
	 * Method: split array into two parts (sorted and unsorted), 
	 * find minimum element in unsorted part and swap it with first element in that part.
	 */
	public static void selectionSort(Comparable[] array)
	{
		/**
		 * Walk across the unsorted array (separated by the marker). 
		 * After one iteration of the loop, the marker will be updated (designating start of unsorted array)
		 */
		for (int marker=0; marker<array.length; marker++)
		{
			//find the smallest value index in array -- call helper method
			int smallestIndex = findSmallestValueIndex(array, marker);
			
			//store value at that marker position into temporary variable
			Comparable tempMarkerVal = array[marker];
			
			//store value at smallest index into array[marker]
			array[marker] = array[smallestIndex];
			
			//store value stored in temporary variable into the smallestIndex slot (which is in unsorted array)
			array[smallestIndex] = tempMarkerVal;
		}
		
	}
	
	/**
	 * Helper method to find the index where the smallest value in unsorted array is located.
	 * Input: array and marker index to indicate where the beginning of the unsorted array is located
	 */
	public static int findSmallestValueIndex(Comparable[] array, int unsortIndexStart)
	{
		//create variable smallest index to store value of the smallest index
		int smallestIndex = unsortIndexStart; //initialized to the start value
		
		//walk across unsorted part of array to find smallest 
		for (int i=unsortIndexStart+1; i<array.length; i++)
		{
			//if the array is the smallest value
			if (array[i].compareTo(array[smallestIndex])<0)
			{
				//assign index value i to the smallest index variable
				smallestIndex = i;
			}
		}
		
		//return the smallestIndex
		return smallestIndex;
	}
	
	/**
	 * Input: array of comparable items. Output: array, sorted.
	 * Method: split array into two parts (sorted and unsorted), 
	 * find where each item should be inserted, and insert it
	 */
	public static void insertionSort(Comparable[] array)
	{
		/**
		 * Walk across the unsorted array (separated by the marker). 
		 * After one iteration of the loop, the marker will be updated (designating start of unsorted array)
		 */
		for (int marker=0; marker<array.length; marker++)
		{
			//find the smallest value index in array -- call helper method
			int smallestIndex = findSmallestValueIndex(array, marker);
			
			//store value of smallestIndex location into temporary array slot
			Comparable tempIndexVal = array[smallestIndex];
			
			//call helper method which will shift values from marker position to smallest index position
			array = shiftArrayVals(array, marker, smallestIndex);
			
			//assign tempIndexVal into free slot in array (array[marker])
			array[marker] = tempIndexVal;
		}
	}
	
	/**
	 * Helper method for insertion sort. 
	 * Input: array, start index , end index 
	 * Output: array with shifted values
	 */
	public static Comparable[] shiftArrayVals(Comparable[] array, int startIndex, int endIndex)
	{
		/**
		 * Walk across the shifting portion of the array, starting at end index
		 */
		for (int i = endIndex; i>startIndex; i--)
		{
			//shift the values into the end index
			array[i] = array[i-1];
		}
		return array;
	}
	
	/**
	 * Input: array of comparable items. Output: array, sorted.
	 * Method: Compare adjacent elements (pairs), and swap if they are out of order.
	 * In bubble sort, the highest values go to the top after each full iteration of evaluating pairs.
	 * The top half of the array can be seen as the sorted part 
	 */
	public static void bubbleSort(Comparable[] array)
	{
		//while the array is not sorted (iterate for-loop backwards to simulate the unsorted part of the array
		for (int endSortIndex=array.length; endSortIndex>1; endSortIndex--)
		{
			//call helped method to compare pairs of indexes for all indexes
			bubblePairs(array, endSortIndex);
		}
	}
	
	/**
	 * Helper method which compares pairs of indexes and swaps them if they are out of order.
	 * All pairs of indexes will be checked and evaluated using compareTo() method in Comparables class
	 */
	public static void bubblePairs(Comparable[] array, int endSortIndex)
	{
		for (int i=0; i<endSortIndex - 1; i++)
		{
			//compare the pairs of indexes (if the lower index is greater than the higher index)
			if (array[i].compareTo(array[i+1])>0)
			{
				//swap the indexes
				
				Comparable tempVal = array[i];
				array[i] = array[i+1];
				array[i+1] = tempVal;
				
			}
			
		}
	}
	
	/**
	 * Input: array of comparable items. Output: array, sorted.
	 * Method: recursively sort indexes 0 to length-1. Will call helper methods!
	 */
	public static void mergeSort(Comparable[] array)
	{
		//call helper method recursiveMergeSort
		recursiveMergeSort(array, 0, array.length-1);
	}
	
	/**
	 * Helper method to merge sort! 
	 * Input: array of comparable items, lo index, hi index. 
	 * Output: array with elements sorted in range [lo, hi] sorted.
	 * Method: base case does nothing & recursive case finds midpoint and sorts two new arrays.
	 * Must call helper method to merge the two sorted parts of the array 
	 */
	public static void recursiveMergeSort(Comparable[] array, int lo, int hi)
	{
		//base case, if array is length 1 or less
		if (hi-lo<1)
		{
			//base case does nothing
			return;
		}
		//recursive case
		else
		{
			//call merge sort on two halves
			int mid = (int)Math.floor((lo+hi)/2);

			//call recursive merge sort on two halves of array
			recursiveMergeSort(array, lo, mid);
			recursiveMergeSort(array, mid+1, hi);
			
			//call helper method mergeParts to merge the two halves of the array together in sorted order
			mergeParts(array, lo, hi);
		}
	}
	
	/**
	 * Helper method to recursive merge sort.
	 * Input: array of comparable items, lo index, hi index.
	 * Assumption made that [lo, mid] and [mid+1, hi] are sorted.
	 * Output: array, sorted from [lo, hi].
	 * Method:copy sorted parts into temporary array, walk over new arrays, 
	 * and store elements back into original array.
	 */
	public static void mergeParts(Comparable[] array, int lo, int hi)
	{
		//create a mid point
		int mid = (int)Math.floor((lo+hi)/2);
		
		//create temporary arrays for first half and second half of array (of size mid+1)
		Comparable[] array1 = new Comparable[mid-lo+1];
		Comparable[] array2 = new Comparable[hi-mid];
		
		//assign values in comparable array to the proper location in the new arrays
		for(int i=0; i<array1.length; i++)
			array1[i] = array[i+lo];
		
		for (int i=0; i<array2.length; i++)
			array2[i] = array[i+(mid+1)];
		
		//create indexes to reference for temporary arrays and initialize them to 0
		int array1Index = 0;
		int array2Index = 0;
		
		//begin assigning values back into original array
		for (int i=lo; i<=hi; i++)
		{
			if (array1Index < array1.length && array2Index < array2.length)
			{
				//if the index in the first array is smaller than the one in the second array
				if (array1[array1Index].compareTo(array2[array2Index])<=0)
				{
					//assign that value back into original array
					array[i]= array1[array1Index];
					//update the array1Index
					array1Index++;
					
				}
				//if the index in the second array is smaller than the first array
				else if (array2[array2Index].compareTo(array1[array1Index])<=0)
				{
					//assign that value back into original array
					array[i]= array2[array2Index];
					//update array2Index
					array2Index++;
				}
			}
			//if array2Index is out of bounds
			else if (array1Index < array1.length && array2Index>=array2.length)
			{
				//create temporary index
				int tempIndex1 = array1Index;
				//walk across remaining temporary array
				for (int j=array1Index; j<array1.length; j++)
				{
					//store smallest array value index into temporary index
					if (array1[j].compareTo(array1[array1Index])<=0)
					{
						tempIndex1 = j;
					}
				}
				//assign smallest value back into array
				array[i] = array1[tempIndex1];
				//update array1Index
				array1Index++;
			}
			//if array1Index is out of bounds
			else if (array2Index < array2.length && array1Index >= array1.length)
			{
				//create temporary index
				int tempIndex2 = array2Index;
				//walk across remaining temporary array
				for (int j=array2Index; j<array2.length; j++)
				{
					//store smallest array value index into temporary index
					if (array2[j].compareTo(array2[array2Index])<=0)
					{
						tempIndex2 = j;
					}
				}
				//assign smallest value back into array
				array[i] = array2[tempIndex2];
				//update array2Index
				array2Index++;
			}
		}
	}
	
	public static void main(String[] args)
	{
		Integer[] a = {9,4,2,1,4,6,9};
	
		mergeSort(a);
		System.out.println("\n MergeSort: ");
		for (int i=0; i<a.length; i++)
			System.out.print(a[i] + ", ");

	}
}
