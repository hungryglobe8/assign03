
package assign03;



import static org.junit.jupiter.api.Assertions.*;



import java.util.ArrayList;

import java.util.Collection;

import java.util.List;



import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;



import assign02.LibraryBook;

import assign02.LibraryGeneric;







/**

 * Test class for SimplePriorityQueue

 * 

 * @author Casey Rand and Morgan Mischo
 * @param <E>

 *

 */

class SimplePriorityQueueTests<E> {

	

	private SimplePriorityQueue<E> simpleString = new SimplePriorityQueue<E>();

	private SimplePriorityQueue<E> simpleInt = new SimplePriorityQueue<E>();

	private SimplePriorityQueue<E> simpleGeneric = new SimplePriorityQueue<E>();

	

	private List<String> someStrings = new ArrayList<String>();	

	

	@Test

	void insertSingleElement()

	{

		String[] expected = new String[]{"Cat"};

		

		simpleString.insert("Cat");

		

		assertTrue(simpleString.getIndex(0).equals(expected[0]));

	}



	@Test

	void insertThreeElements()

	{

		simpleInt.insert(1);

		simpleInt.insert(5);

		simpleInt.insert(7);

		

		assertTrue(simpleInt.getIndex(2).equals(1));

	}

	

	@Test

	void mixedThreeElements()

	{

		SimplePriorityQueue<Integer> simpleInt = new SimplePriorityQueue<Integer>();

		

		simpleInt.insert(5);

		simpleInt.insert(1);

		simpleInt.insert(7);

		

		assertTrue(simpleInt.getIndex(1).equals(5));

		assertTrue(simpleInt.getIndex(0).equals(7));

	}

	

	@Test

	void finalValueSort()

	{	

		simpleInt.insert(3);

		simpleInt.insert(15);

		simpleInt.insert(7);

		simpleInt.insert(34);

		simpleInt.insert(-3);

		simpleInt.insert(8);

		

		assertTrue(simpleInt.getIndex(0).equals(34));

		assertTrue(simpleInt.getIndex(2).equals(8));

		assertTrue(simpleInt.getIndex(5).equals(-3));

	}

	

	@Test

	void testFindMinSimpleString() 

	{

		simpleString.insert("Cat");

		Object expected = "Cat"; 

		

		Object actual = simpleString.findMin(); 

		

		assertEquals(expected, actual); 

	}

	

	@Test

	void testFindMinSimpleInt() 

	{

		simpleInt.insert(1);

		simpleInt.insert(-4);

		simpleInt.insert(8);

		Object expected = -4;

		

		Object actual = simpleInt.findMin(); 

		

		assertEquals(expected, actual); 	

	}

	

	@Test

	void insertGeneric() 

	{

		Object grape = new Object();

		simpleGeneric.insert(grape);

		

		Object expected = grape; 

		Object actual = simpleGeneric.getIndex(0);

		

		assertEquals(expected, actual); 

	}

	

	@Test

	void insertStringList() 

	{

		someStrings = new ArrayList<String>();

		someStrings.add("Pig");

		someStrings.add("Cat");

		someStrings.add("Turkey");

		simpleString.insertAll(someStrings);

		

		assertEquals(simpleString.getIndex(2), "Cat");

	}

	

	@Test

	void removeMin()

	{

		someStrings = new ArrayList<String>();

		someStrings.add("Pig");

		someStrings.add("Cat");

		someStrings.add("Turkey");

		simpleString.insertAll(someStrings);

		

		simpleString.deleteMin();

		

		assertEquals(simpleString.getIndex(1), "Pig");

		assertTrue(simpleString.size() == 2);

	}

	

	@Test

	void clearStrings()

	{

		someStrings = new ArrayList<String>();

		someStrings.add("Pig");

		someStrings.add("Cat");

		someStrings.add("Turkey");

		SimplePriorityQueue<E> blankString = simpleString;

		simpleString.insertAll(someStrings);

		

		simpleString.clear();

		assertEquals(blankString, simpleString);

	}

	

	@Test

	void removeUntilClear()

	{

		someStrings = new ArrayList<String>();

		someStrings.add("Pig");

		someStrings.add("Cat");

		someStrings.add("Turkey");

		simpleString.insertAll(someStrings);

		

		//This method deletes the min 3 times to clear.

		SimplePriorityQueue<E> removeString = simpleString;

		removeString.deleteMin();

		removeString.deleteMin();

		removeString.deleteMin();

		

		//This is the normal clear method.

		simpleString.clear();



		

		assertEquals(removeString, simpleString);

	}

	

	@Test

	void clearIsEmpty()

	{

		someStrings = new ArrayList<String>();

		someStrings.add("Pig");

		someStrings.add("Cat");

		someStrings.add("Turkey");

		simpleString.insertAll(someStrings);

		

		simpleString.clear();

		

		assertTrue(simpleString.isEmpty());

	}
	
	@Test
	void isEmpty_Incorrect ()
	{

		someStrings = new ArrayList<String>();

		someStrings.add("Pig");

		someStrings.add("Cat");

		someStrings.add("Turkey");

		simpleString.insertAll(someStrings);
		
		
		assertFalse(simpleString.isEmpty()); 
	}
	
	@Test
	void size_IsCorrect ()
	{
		
		someStrings = new ArrayList<String>();

		someStrings.add("Pig");

		someStrings.add("Cat");

		someStrings.add("Turkey");

		simpleString.insertAll(someStrings);
		
		int expected = 3; 
		
		assertEquals(simpleString.size(), expected); 
		
	}
	
	@Test
	void size_IsIncorrect ()
	{
		
		someStrings = new ArrayList<String>();

		someStrings.add("Pig");

		someStrings.add("Cat");

		someStrings.add("Turkey");

		simpleString.insertAll(someStrings);
		
		int unexpected = 12; 
		
		assertFalse(simpleString.size() == unexpected); 
	}
	

}
