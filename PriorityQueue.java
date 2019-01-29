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
		if(arr.isEmpty())
			throw new NoSuchElementException("No elements found.");

		return arr.indexOf(arr.size()-1);
	}

	@Override
	public Object deleteMin() throws NoSuchElementException {
		if(arr.isEmpty())
			throw new NoSuchElementException("No elements found.");

		Object lastValue = arr.get(size()-1);
		arr.remove(lastValue);
		return lastValue;
	}

	@Override
	public void insert(Object item) {
		int low = 0;
		int high = arr.size();
		
		while(low < high)
		{
			int mid = (low + high) / 2;
			
			if(arr.get(mid) == item)
			{
				arr.add(mid, (E) item);
			}
			
			if(((Object) arr.get(mid)).compareTo(item))
			{
				low = mid + 1;
			}
			
			else
			{
				high = mid;
			}
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
		//Maybe not array
		return arr.size();
	}

	/**
	 * Returns true if this priority cue contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		return (arr.size() == 0);
	}

	@Override
	public void clear() {
		//Not array list while loop 
		arr.clear();		
	}
}
