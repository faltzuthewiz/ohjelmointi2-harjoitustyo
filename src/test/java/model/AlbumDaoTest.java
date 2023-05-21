package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import database.AlbumDao;

class AlbumDaoTest {
	
	private AlbumDao dao = new AlbumDao();

	@Test
	void testGettingAlbumsFromFiftArtist() {
		
		List<Album> albums = this.dao.getAllAlbumsFromArtist(5);
		
		assertTrue(albums.size() > 0);
		
	}

}
