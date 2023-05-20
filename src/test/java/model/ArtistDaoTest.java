package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import database.ArtistDao;

public class ArtistDaoTest {
	
	private ArtistDao dao = new ArtistDao();

	@Test
	public void testFirstItemIsACorDoSom() {
		List<Artist> artists = this.dao.getAllArtists();
		
		assertEquals("A Cor Do Som", artists.get(0).getName());
		
		
	}

	@Test
	public void testLastItemIsZecaPagodinho() {
		List<Artist> artists = this.dao.getAllArtists();
		
		assertEquals("Zeca Pagodinho", artists.get(artists.size() - 1).getName());
	}
	
	@Test
	public void testNewArtistIsAdded() {
		Artist newArtist = new Artist("Kissa");
		boolean success = this.dao.addArtist(newArtist);
		
		assertTrue(success);
	}

	@Test
	public void testNewArtistIdIsSet() {
		Artist newArtist = new Artist("The Beatles");
		this.dao.addArtist(newArtist);
		
		assertTrue(newArtist.getId() > 0);
	}
	

}
