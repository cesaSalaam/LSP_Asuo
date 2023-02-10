package org.howard.edu.lsp.assignment2;

import java.io.FileNotFoundException;

public class Driver {

	public static void main(String[] args) {
		FileReader fr = new FileReader();
		try {
			
			System.out.println(fr.wordCounter(fr.readToString("main/java/resources/words.txt")));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open resource");
		}
	}
}