package org.howard.edu.lsp.assignment5;

import java.io.FileNotFoundException;
import java.util.List;

public class Driver3 {

	public static void main(String[] args) {
		
		IntegerSet is = new IntegerSet();
		System.out.println("Creating first set");
		is.add(0);
		is.add(90);
		is.add(12);
		is.add(1);
		is.add(3);
		is.add(0);
		is.add(1);
		System.out.println("This is the first set: " + is.toString());
		System.out.println("This is the current length of the first set:"  + is.length());
		int temp = 13;
		System.out.println("It is " + is.contains(temp) + " that your set contains: " + temp);
		try {
			System.out.println("The largest value in the set is: " + is.largest());
		} catch (IntegerSetException e) {
			e.printStackTrace();
		}
		try {
			System.out.println("The largest value in the set is: " + is.smallest());
		} catch (IntegerSetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IntegerSet second = new IntegerSet();
		System.out.println("Creating second set");
		second.add(1);
		second.add(20);
		second.add(0);
		second.add(90);
		second.add(8);
		System.out.println("This is the second set: " + second.toString());
		is.union(second);
		is.remove(90);
		is.intersect(second);
		System.out.println("This is the current set: " + is.toString());
		is.diff(second);
		System.out.println("It is " + is.equals(second) + " that set: " + is.toString() + " and set: " + second.toString() + " are equal");
		is.remove(90);
		if (is.isEmpty()){
			System.out.println("Your set is empty");
		}else {
			System.out.println("Your set is not empty");
		}
		is.clear();
		
	}
}