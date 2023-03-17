package org.howard.edu.lsp.midterm.problem51;

/**
 * 
 * @author cesasalaam
 *
 */
public class IntegerRange implements Range {
	private int lower;
	private int upper;

// Hint: implement getters for lower and upper
	 
	 IntegerRange(int lower, int upper) { 	// Constructor
    		this.lower = lower;
    		this.upper = upper;
	 }
	 public IntegerRange() {
		// TODO Auto-generated constructor stub
	}
	public int getLower() {return lower;};
	 public int getUpper() {return upper;};
	 
	 public boolean contains(int value) {
		 return ( value >= lower && value <= upper);
	 }
	 @Override
	 public boolean overlaps(IntegerRange other) throws EmptyRangeException {
		 if (other == null) {
	            throw new EmptyRangeException();
	        }
		 boolean lowerIn = (other.getLower() >= this.lower) || (other.getLower() <= this.upper);
		 boolean upperIn = (other.getUpper() >= this.lower) || (other.getUpper() <= this.upper);
		 return ( lowerIn || upperIn);
	 }
	 
	 /**
	 * this returns the number of elements between an upper and lower integer bound
	 * 
	 * @return int
	 */

	public int size()  {
		return (upper - lower);
	}
	
}
