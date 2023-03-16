package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.HashSet;
/**
 * 
 * @author cesasalaam
 *
 */

public class IntegerSet  {
	
	
	// Hint: probably best to use an array list.  You will need to do a little research
	private List<Integer> set = new ArrayList<Integer>();
	
	/**
	 * default constructor for the class IntegerSet
	 */
	public IntegerSet() {
	};

	/**
	 * This function clears the set
	 */
	public void clear() {
		set.clear();
		System.out.println("Your set has been cleared. This is the current value of the set: " + set.toString());
	};
	
	/**
	 * This function returns the length of the set
	 * @return int (the size of the set)
	 */
	public int length(){
		return set.size();
	}; // returns the length
	
	
	/**
	 * Returns true if the 2 sets are equal, false otherwise;
	 * Two sets are equal if they contain all of the same values in ANY order.
	 * @param b of type IntegerSet
	 * @return boolean
	 */
	public boolean equals(IntegerSet b) {
		return set.equals(b.set);
		}; 
	
	/**
	 * Returns true if the set contains the value, otherwise false
	 * @param value of type int
	 * @return boolean
	 */
	public boolean contains(int value) {
		return set.contains(value);
		};    
	
	/**
	 * Returns the largest item in the set; Throws a IntegerSetException if the set is empty
	 * @return integer
	 * @throws IntegerSetException if the set is empty
	 */
	public int largest() throws IntegerSetException{
		if(set.size()==0) {
			IntegerSetException e = new IntegerSetException();
			throw e;
		}
		return(Collections.max(set));
	}; 
	
	/**
	 * Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
	 * @return integer
	 * @throws IntegerSetException if the set is empty
	 */
	public int smallest() throws IntegerSetException {
		if(set.size()==0) {
			IntegerSetException e = new IntegerSetException();
			throw e;
		}
		
		System.out.println("This is the smallest value in your set: ");
		return Collections.min(set);
	};
	
	/**
	 * Adds an item to the set or does nothing it already there	
	 * @param item of type integer
	 */
	public void add(int item) {
		if (set.contains(item)) {
			System.out.println("This item ("  + item + ") is already in the integer set");
		}else {
			set.add(item);
		}
		
	}; 
	
	
	/**
	 * Removes an item from the set or does nothing if not there
	 * @param item of type integer
	 */
	public void remove(int item) {
		set.remove(Integer.valueOf(item));
		System.out.println("We have removed the item " + item + " from the set");
	}; 
	
	/**
	 * This function find the union of the set in the class and another set that is pass in the params
	 * @param intSetb of type IntegerSet
	 */
	public HashSet<Integer> union(IntegerSet intSetb) {
		HashSet<Integer> hs = new HashSet<>();
		 
        for (int i = 0; i < set.size(); i++) {
            hs.add((Integer) set.toArray()[i]);
            }
        for (int i = 0; i < intSetb.length(); i++) {
        	hs.add((Integer) intSetb.set.toArray()[i]);
           }
        HashSet<Integer> set_2 = hs;
        
        System.out.println("The union of set: " + set.toString() + " and set: " + intSetb.toString() + " is: "+ set_2.toString());
        return set_2;
	};
	
	/**
	 * This function finds the intersection of two sets 
	 * @param intSetb of type IntegerSet
	 * @return 
	 */
	public List<Integer> intersect(IntegerSet intSetb) {
		HashSet<Integer> hs = new HashSet<>();
		List<Integer> temp = new ArrayList<Integer>();
	    for (int i = 0; i < set.size(); i++)
	    	hs.add((Integer) set.toArray()[i]);
	 
	        for (int i = 0; i < intSetb.set.size(); i++)
	            if (hs.contains(intSetb.set.toArray()[i]))
	                temp.add((Integer) intSetb.set.toArray()[i]);
	    System.out.println("The Intersection of set: " + set.toString() + " and set: " + intSetb.toString() + " is: "+ temp.toString());
	    return temp;
	}; 
	
	/**
	 * This function find the difference between two sets (i.e., s1 – s2)
	 * @param intSetb of type IntegerSet
	 * @return 
	 */
	
	public List<Integer> diff(IntegerSet intSetb){
		List<Integer> diff = new ArrayList<>(set);
		diff.removeAll(intSetb.set);
		System.out.println("The difference between set: " + set.toString() + " and set: " + intSetb.toString() + " is: " + diff);
		return diff;
	};
	
	/**
	 * Function to check is the set is empty. Returns true if the set is empty, false otherwise
	 * @return boolean
	 */
	boolean isEmpty(){return set.isEmpty();}; 
	
	/**
	 * Function to return the string representation of the set
	 * @return string which is the string representation of the set
	 */
	public String toString(){return set.toString();};
		
}
