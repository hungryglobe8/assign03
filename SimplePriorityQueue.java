package assign03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Comparator;
import java.util.List;


/**
 * A class that performs functions on any collection of inputs, with or without a comparator imput.
 * 
 * @author Morgan Mischo and Casey Rand
 * @param <E>
 */
public class SimplePriorityQueue<E> implements PriorityQueue<E> {
	
	private E[] arr; 
	private int size;
	private Comparator<? super E> ourComparator; 
	

	/**
	 * Constructor for SimplePriorityQueue if no comparator is given by user.
	 */
	@SuppressWarnings("unchecked")
	public SimplePriorityQueue()
	{
		arr = (E[])new Object[16]; 
		size = 0; 
		ourComparator = null; 
	}
	
	/**
	 * Constructor for SimplePriorityQueue if a comparator is given.
	 */
	@SuppressWarnings("unchecked")
	public SimplePriorityQueue (Comparator<? super E> userComparator)
	{
		arr = (E[])new Object[16]; 
		size = 0; 
		ourComparator = userComparator; 	
	}

	@Override
	public E findMin() throws NoSuchElementException {
		if(size == 0)
		{
			throw new NoSuchElementException("No elements found.");
		}

		return arr[size - 1]; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public E deleteMin() throws NoSuchElementException {
		if(size == 0)
		{
			throw new NoSuchElementException("No elements found.");
		}

		E lastValue = arr[size - 1];
		
		E[] newArray = (E[])new Object[size - 1]; 
		
		for(int i = 0; i < size - 1; i++)
		{
				newArray[i] = arr[i]; 
		}
		
		arr = newArray;
		size--;
		return lastValue;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(E item) {
		int low = 0;
		int high = size;
		
		//Create new larger array to store values and have room for insertion.
		E[] newArray;
		
		//If array is empty, put item in first element of array.
		if(size == 0)
		{
			arr[0] = (E) item;
			size++;
			return;
		}
		
		//If array has one element, compare and insert.
		if(size == 1)
		{
			if(innerCompare(arr[0], (E) item) == 0 || innerCompare(arr[0], (E) item) > 0)
			{
				arr[1] = (E) item;
			}			
			else
			{
				arr[1] = arr[0];
				arr[0] = (E) item;
			}
			size++;
			return;
		}
		
		//If array is not full, length stays the same.
		if(size < arr.length) 
		{
			newArray = (E[])new Object[arr.length];
			for(int i = 0; i < arr.length; i++)
			{
				newArray[i] = arr[i];
			}
		}
		//Array is full, make larger array.
		else
		{
			newArray = (E[])new Object[size + 1];
			for(int i = 0; i < size; i++)
			{
				newArray[i] = arr[i];
			}
		}
		
		//If item is greater than all other elements, insert at beginning.
		if(innerCompare((E) item, arr[0]) > 0)
		{
			shiftArray(0, newArray);
			newArray[0] = (E) item;
			arr = newArray;
			size++;
			return;
		}
		
		//If item is less than all other elements, insert at end.
		if(innerCompare((E) item, arr[size - 1]) < 0)
		{
			newArray[size] = (E) item;
			arr = newArray;
			size++;
			return;
		}
		
		//Perform a binary search and insert where o1 is greater and o2 is less than item.
		E o1;
		E o2;
		
		while(low < high)
		{
			int mid = (low + high) / 2;
			o1 = newArray[mid];
			o2 = newArray[mid + 1];
			
			if(innerCompare(o1, (E) item) == 0 || innerCompare(o1, (E) item) > 0 && innerCompare(o2, (E) item) < 0)  
			{
				shiftArray(mid, newArray);
				newArray[mid] = (E) item;
				arr = newArray;
				break;
			}
			
			if(((Comparable<? super E>) o1).compareTo((E) item) > 0)
			{
				low = mid + 1;
			}
			
			else
			{
				high = mid;
			}
		}
		size++;
	}
	
	/**
	 * Makes room for new element to be inserted when the location has been found.
	 * @param count index where element will be inserted
	 * @param newArray array to preserve new values
	 */
	private void shiftArray(int count, E[] newArray)
	{
		for(int i = size; i > count; i--)
		{
			newArray[i] = newArray[i - 1];
		}
	}
	
	/**
	 * This helper method compares two E elements. If user doesn't input comparator, uses .compareTo.
	 * Else uses .compare
	 * @param o1
	 * @param o2
	 * @return 0 if equal, 1 if o1 is greater, -1 if o2 is greater
	 */
	@SuppressWarnings("unchecked")
	private int innerCompare(E o1, E o2)
	{
		if(ourComparator == null)
		{
			return ((Comparable<? super E>) o1).compareTo(o2);
		}
		return ourComparator.compare(o1, o2);
	}

	/**
	 * Returns E at specified index
	 * @param i
	 * @return
	 */
	public E getIndex(int i)
	{
		return arr[i];
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insertAll(Collection coll) {
	
		E[] myArray = (E[]) new Object[coll.size()]; 
		coll.toArray(myArray); 
		
		for(int i = 0; i < coll.size();  i++)
		{
			insert(myArray[i]);
		}
		
	}

	@Override
	public int size() {
		return size;
	}

	/**
	 * Returns true if this priority cue contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	/**
	 * Removes all of the elements from this priority queue. The queue will be empty when this call returns. 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		arr = (E[])new Object[16];
		size = 0;
	}
}
