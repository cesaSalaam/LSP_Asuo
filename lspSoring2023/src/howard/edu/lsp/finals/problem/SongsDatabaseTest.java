package howard.edu.lsp.finals.problem;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.howard.edu.lsp.assignment5.IntegerSet;
import org.howard.edu.lsp.assignment5.IntegerSetException;
/**
 * 
 * @author cesasalaam
 *
 */
public class SongsDatabaseTest {
	private SongsDatabase db = new SongsDatabase();
	
	public SongsDatabaseTest(){
		db.addSong("Rap", "Gin and Juice");
		db.addSong("Jazz", "Always There");
		db.addSong("Rap", "Knuck if you buck");
	};
	@Test
	public void testAddSong(){
		Set<String> s = new HashSet<String>();
		s.add("Gin and Juice");
		s.add("Knuck if you buck");
		assertEquals(db.getSongs("Rap"),s);
	};
	
	@Test
	public void testGetGenreOfSong(){
		assertSame(db.getGenreOfSong("Gin and Juice"),"Rap");
	};
	
	@Test
	public void testGetGenreOfSongForSongNotInDB(){
		assertSame(db.getGenreOfSong("Gin"),"");
	};
	
	@Test
	public void testGetSong(){
		Set<String> s = new HashSet<String>();
		s.add("Always There");
		assertEquals(db.getSongs("Jazz"),s);
	};
	@Test
	public void testGetSongForGenreNotInDB(){
		Set<String> s = new HashSet<String>();
		assertEquals(db.getSongs("Punk"),s);
	};
}
