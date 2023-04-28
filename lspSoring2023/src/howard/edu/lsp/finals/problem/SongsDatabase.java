package howard.edu.lsp.finals.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/***
 * 
 * @author cesasalaam
 *
 */
public class SongsDatabase {
	/* Key is the genre, HashSet contains associated songs */
	private Map<String, HashSet<String>> map = new HashMap<String, HashSet<String>>();

	/**
	 * Add a song title to a genre
	 * @param genre
	 * @param songTitle
	 */
	public void addSong(String genre, String songTitle) {
		HashSet<String> songs = map.getOrDefault(genre,new HashSet<String>());
        
        //adding songTitle into the set
        songs.add(songTitle);
        
        //putting that updated set into the map again
        map.put(genre,songs);
        System.out.println("Song " + songTitle + " has been added into " + genre);
		}

	/**
	 * Return the Set that contains all songs for a genre 
	 * @param genre
	 * @return Set<String>
	 */
	public Set<String> getSongs(String genre) {
		//getting the set of songs if it is there in the map already other wise initializing it with new HashSet as Set is the abstract class
        return map.getOrDefault(genre,new HashSet<String>());
	}

	/**
	 * Return genre, i.e., jazz, given a song title
	 * @param songTitle
	 * @return String
	 */
	public String getGenreOfSong(String songTitle) {
		String result = "";
	       
	       //iterating over each genre if any one have the songTitle then return that genre
	        for(String genre : map.keySet()){
	            if(map.get(genre).contains(songTitle)){
	                result =  genre;
	                break;
	            }
	        }
	        return result;
	}

}
