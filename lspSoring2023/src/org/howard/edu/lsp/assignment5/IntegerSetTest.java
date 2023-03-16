package org.howard.edu.lsp.assignment5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {
	private IntegerSet set;
	
	@BeforeEach
	void setup(){
		set = new IntegerSet();
		set.add(0);
		set.add(5);
		set.add(90);
		set.add(354);
	};
	
	@Test
	@DisplayName("Test Length")
	public void legnthTest() {
		assertEquals(4,set.length());
	};
	
	
	@Test
	@DisplayName("Test equals same size and elements")
	public void equalsTest() {
		IntegerSet temp = new IntegerSet();
		temp.add(0);
		temp.add(5);
		temp.add(90);
		temp.add(354);
		
		assertEquals(true,set.equals(temp));
	};
	
	@Test
	@DisplayName("Test equals sets of different size")
	public void testEqualsIntegerSet2() {
		// sets of different size
		IntegerSet set1 = new IntegerSet();
		set1.add(10);
		set1.add(20);
		IntegerSet set2 = new IntegerSet();
		set2.add(10);
		set2.add(20);
		set2.add(30);
	
		assertEquals(false, set1.equals(set2));
	
	}
	
	@Test
	@DisplayName("Test equals sets of different elements")
	public void testEqualsIntegerSet3() {
	// sets of different elements
		IntegerSet set1 = new IntegerSet();
		set1.add(10);
		set1.add(20);
		set1.add(30);
		IntegerSet set2 = new IntegerSet();
		set2.add(50);
		set2.add(70);
		set2.add(80);
	
		assertEquals(false, set1.equals(set2));
	}
	
	@Test
	@DisplayName("Test contains true")
	public void containsTest() {
		assertEquals(true,set.contains(354));
	};
	@Test
	@DisplayName("Test contains false")
	
	public void testContains2() {
		assertEquals(false, set.contains(50));

	}
	
	@Test
	@DisplayName("Test add")
	public void addTest() {
		set.add(6);
		IntegerSet temp = new IntegerSet();
		temp.add(0);
		temp.add(5);
		temp.add(90);
		temp.add(354);
		temp.add(6);
		assertEquals(temp.toString(),set.toString());
	};

	@Test
	@DisplayName("testing largest with full set")
	public void testLargest() {
		IntegerSet set1 = new IntegerSet();
		set1.add(10);
		set1.add(20);
		set1.add(30);
		set1.add(5);
		int expectedValue = 0;
		try {
			expectedValue = set1.largest();
		} catch (IntegerSetException e) {
			e.printStackTrace();
		}
		assertEquals(30, expectedValue);
	} 
	
	@Test
	@DisplayName("testing largest with empty set")
	public void testLargest2() {
	
		IntegerSet set1 = new IntegerSet();
		int expectedValue = 0;
		try {
			expectedValue = set1.largest();
		} catch (IntegerSetException e) {
			assertNull(e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Test Union")
	public void testUnion() {
		IntegerSet set1 = new IntegerSet();
		set1.add(10);
		set1.add(20);
		set1.add(30);
		set1.add(5);
		set1.add(0);
		String t = "[0, 354, 20, 5, 90, 10, 30]";
		assertEquals(t,set.union(set1).toString());
	};
	
	@Test
	@DisplayName("Test intersection")
	public void testIntersect() {
		IntegerSet set1 = new IntegerSet();
		set1.add(10);
		set1.add(20);
		set1.add(30);
		set1.add(5);
		set1.add(0);
		String t = "[5, 0]";
		assertEquals(t,set.intersect(set1).toString());
	};
	
	
	@Test
	@DisplayName("Test diff")
	public void testDiff() {
		IntegerSet set1 = new IntegerSet();
		set1.add(10);
		set1.add(20);
		set1.add(30);
		set1.add(5);
		set1.add(0);
		String t = "[90, 354]";
		assertEquals(t,set.diff(set1).toString());
	};
	
	@Test
	@DisplayName("testing smallest with full set")
	public void testSmallest() {
		int expectedValue = 0;
		try {
			expectedValue = set.smallest();
		} catch (IntegerSetException e) {
			e.printStackTrace();
		}
		assertEquals(0, expectedValue);
	}

	@Test
	@DisplayName("testing smallest with empty set")
	public void testSmallest2() {
	// when set is empty
		IntegerSet set1 = new IntegerSet();
		int expectedValue = 0;
		try {
			expectedValue = set1.smallest();
		} catch (IntegerSetException e) {
			assertNull(e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Test remove")
	public void removeTest(){
		set.remove(6);
		String expectedValue = "[0, 5, 90, 354]";
		assertEquals(expectedValue, set.toString());
	}


	@Test
	@DisplayName("Test is empty for true")
	public void testIsEmpty() {
		IntegerSet set1 = new IntegerSet();
		assertTrue(set1.isEmpty());
	}
	@Test
	@DisplayName("Test is empty for false")
	public void testIsEmpty2() {
		assertFalse(set.isEmpty());
	}
	@Test
	@DisplayName("Test toString")
	public void testToString() {
		String expectedValue = "[0, 5, 90, 354]";
		assertEquals(expectedValue, set.toString());
	}
	
	@Test
	@DisplayName("Test Clear")
	public void clearTest(){
		set.clear();
		assertTrue(set.isEmpty());
	};
	
	
}