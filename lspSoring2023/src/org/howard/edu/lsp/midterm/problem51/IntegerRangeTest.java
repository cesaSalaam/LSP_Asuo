package org.howard.edu.lsp.midterm.problem51;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

import org.howard.edu.lsp.assignment5.IntegerSet;
import org.howard.edu.lsp.assignment5.IntegerSetException;

/**
 * 
 * @author cesasalaam
 *
 */

public class IntegerRangeTest {
	
	private IntegerRange myRange = new IntegerRange(5, 10);
	
    @Test
    public void testContains() {
        assertTrue(myRange.contains(7));
        assertTrue(myRange.contains(5));
        assertTrue(myRange.contains(10));
        assertFalse(myRange.contains(3));
        assertFalse(myRange.contains(12));
    }
    
    @Test
    public void testOverlap() {
        IntegerRange range = new IntegerRange(5, 10);
        boolean expectedValue =true;
        try {
			expectedValue = this.myRange.overlaps(range);
		} catch (EmptyRangeException e) {
			e.printStackTrace();
		}
        assertTrue(expectedValue);
    }
    
    @Test
    public void testOverlap2() {
    	IntegerRange range = null;
    	boolean expectedValue = true;
    	try {
    		expectedValue = myRange.overlaps(range);
    	}catch (EmptyRangeException e) {
    		assertSame("Empty Range Exception",e.getMessage());
		}
    }
    
    @Test
    public void testSize(){
    	assertSame(5,myRange.size());
    };
    

}