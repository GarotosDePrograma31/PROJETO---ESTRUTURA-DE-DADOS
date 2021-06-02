package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import source.ArrayIndexList;

class ArrayIndexListTest {

	@Test
	void test() {
		ArrayIndexList<Integer> A = new ArrayIndexList<Integer>();
		assertEquals("()", A.toString());		
		A.add(0, 7);		
		assertEquals("(7)", A.toString());		
		A.add(0, 4);		
		assertEquals("(4, 7)", A.toString());		
		assertEquals(7, A.get(1));		
		A.add(2, 2);		
		assertEquals("(4, 7, 2)", A.toString());		
		assertThrows(IndexOutOfBoundsException.class, () -> { A.get(3);});		
		assertEquals(7, A.remove(1));		
		assertEquals("(4, 2)", A.toString());		
		A.add(1, 5);		
		assertEquals("(4, 5, 2)", A.toString());		
		A.add(1, 3);		
		assertEquals("(4, 3, 5, 2)", A.toString());		
		A.add(4, 9);		
		assertEquals("(4, 3, 5, 2, 9)", A.toString());		
		assertEquals(5, A.get(2));		
		assertEquals("(4, 3, 5, 2, 9)", A.toString());		
		assertEquals(2, A.set(3, 8));		
		assertEquals("(4, 3, 5, 8, 9)", A.toString());
	}
}
