package assign03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

public class SimplePriorityQueue<E> implements PriorityQueue<E> {

	
	
	private ArrayList<E> arr;

	@Override
	public Object findMin() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object deleteMin() throws NoSuchElementException {
		// TODO Auto-generated method stub
		return null;
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
			
			if(arr[mid] < item)
			{
				low = mid + 1;
			}
			
			else
			{
				high = mid;
			}
		}
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertAll(Collection coll) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
