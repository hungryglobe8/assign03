package assign03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * Test class for SimplePriorityQueue
 * 
 * @author Casey Rand and Morgan Mischo
 *
 */
class SimplePriorityQueueTests {

	private SimplePriorityQueue simpleString, simpleInt, simpleDouble, simpleGeneric; 
	private List someStrings, someInts, someGenerics;   
	
	@BeforeEach
	void setup () throws Exception {
	someStrings = new ArrayList<String>(); 
	someStrings.add("Cat"); 
	someStrings.add("Dog"); 
	someStrings.add("Mouse"); 
	
	someInts = new ArrayList<Integer>();
	someInts.add(1); 
	someInts.add(2); 
	someInts.add(3); 
	
	someGenerics = new ArrayList<Object>();
	someGenerics.add(1); 
	someGenerics.add(2.3); 
	someGenerics.add(3); 
		
	simpleString  = new SimplePriorityQueue<String>();
	simpleString.insertAll(someStrings);
	
	simpleInt = new SimplePriorityQueue<Integer>(); 
	simpleInt.insertAll(someInts);
		
	simpleGeneric = new SimplePriorityQueue<>();
	simpleGeneric.insertAll(someGenerics);
	
	}
	
	//Tests for finding min
	@Test
	void testFindMinSimpleString() {
		Object expected = "Cat"; 
		Object actual = simpleString.findMin(); 
		
		assertEquals(expected, actual); 
	}
	
	@Test
	void testFindMinSimpleInt() {
		Object expected = 1; 
		Object actual = simpleInt.findMin(); 
		
		assertEquals(expected, actual); 	
	}
	
	@Test
	void testFindMinSimpleGenerics() {
		Object expected = 1; 
		Object actual = simpleGeneric.findMin(); 
		
		assertEquals(expected, actual); 
	}
	
	

}
