package assign03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Comparator;
import java.util.List;


/**
 * 
 * @author Morgan Mischo and Casey Rand
 *
 * @param <E>
 */
public class SimplePriorityQueue<E> implements PriorityQueue {
	
	private E[] arr; 
	private int size;
	private Comparator<? super E> ourComparator; 
	

	/**
	 * Constructor for SimplePriorityQueue w/out params
	 */
	public SimplePriorityQueue()
	{
		arr = (E[])new Object[16]; 
		size = 0; 
		ourComparator = null; 
	}
	
	/**
	 * Constructor for SimplePriorityQueue w/ params
	 */
	
	public SimplePriorityQueue (Comparator<? super E> userComparator)
	{
		arr = (E[])new Object[16]; 
		size = 0; 
		ourComparator = userComparator; 	
	}

	@Override
	public Object findMin() throws NoSuchElementException {
		if(size == 0)
		{
			throw new NoSuchElementException("No elements found.");
		}

		return arr[size - 1]; 
	}

	@Override
	public Object deleteMin() throws NoSuchElementException {
		if(size == 0)
		{
			throw new NoSuchElementException("No elements found.");
		}

		Object lastValue = arr[size - 1];
		
		E[] newArray = (E[])new Object[size - 1]; 
		
		for(int i = 0; i < size - 2; i++)
		{
				newArray[i] = arr[i]; 
		}
		
		arr = newArray;
		size--;
		return lastValue;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(Object item) {
		
		int low = 0;
		int high = size;
		
		//Create new larger array to store values and have roomfor insertion.
		E[] newArray = (E[])new Object[size +1];
		for(int i = 0; i < size; i++)
		{
			newArray[i] = arr[i];
		}
		
		Object o1;
		Object o2;
		
		while(low < high)
		{
			int mid = (low + high) / 2;
			o1 = newArray[mid];
			o2 = newArray[mid + 1];
			
			if(((Comparable<? super E>) arr[mid]).compareTo((E) item) == 0 || (((Comparable<? super E>) o1).compareTo((E) item) > 0) && ((Comparable<? super E>) o2).compareTo((E) item) < 0)  
			{
				shiftArray(mid, newArray);
				arr[mid] = (E) item; 
			}
			
			if(((Comparable<? super E>) o1).compareTo((E) item) < 0)
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
	
	private void shiftArray(int count, E[] newArray)
	{
		for(int i = size; i >= count; i--)
		{
			newArray[i + 1] = newArray[i];
		}
	}

	@Override
	public void insertAll(Collection coll) {
	
		Object[] myArray = new Object[coll.size()]; 
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
