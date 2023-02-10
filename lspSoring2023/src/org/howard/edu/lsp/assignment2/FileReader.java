package org.howard.edu.lsp.assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.stream.IntStream;
import java.util.*;

/**
 * 
 * @author cesasalaam
 *
 */

public class FileReader {
	/**
	 *  This method takes in a resource string (a file path) and then returns the contents of the file.
	 * 	This method was modified from the one provided for the class to handle a case
	 * 	Where the file has empty lines. It also will lower-case the words in the file
	 * @param resource
	 * @return
	 * @throws FileNotFoundException
	 * 
	 */
	
	public String readToString(String resource) throws FileNotFoundException {
			URL url = getClass().getClassLoader().getResource(resource);
			
			if (url != null) {
				File file = new File(url.getPath());
				
				Scanner sc = null;
				
				try {
					sc = new Scanner(file);
					
					String output = "";
					
					while (sc.hasNextLine()) {
						
					String line = sc.nextLine();
					
					if (!line.isEmpty()) { //only deal with lines that aren't empty
							output = output + line + " ";
						}
					}
					
					return output.toLowerCase().trim(); // lower case the string and trim white spaces
					
				} finally {
					sc.close();
				}
			}
			throw new FileNotFoundException();
	}
	
	
	/**
	 * This method uses a set to count the occurrences of words in a string.
	 * It ignores pure integers and new lines in the counting process
	 * It also ignores words with length less than 3
	 * @param input
	 * @return String
	 */
	
	public String wordCounter(String input) {
		
		List<String> list = Arrays.asList(input.split(" "));
		//list.removeAll(Collections.singleton(" "));
		System.out.println(list);
		
		//ArrayList<String> singleWords = new ArrayList<String>();
		
		Set<String> distinct = new HashSet<>(list);
		
		String finalStr ="";
		
        for(String s: distinct){
        	
        	
        	try {
     	       Integer.parseInt(s); 
     	       //if the code made it to this line, s is an int, ignore it
     	       
     	    } catch(NumberFormatException b) {
     	    	if(s.length() > 3){
     	    		//only count words with length greater than 3
     	    		finalStr = finalStr + s + " " + Collections.frequency(list, s) + '\n';
     	    	}
     	    }
        }
		return finalStr;
	}
	
}