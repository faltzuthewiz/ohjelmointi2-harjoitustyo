package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;

public class AlbumDao {
	
	private Database db = new Database();
	
	public List<Album> getAllAlbumsFromArtist(long artistId) {
		
		String selectAlbums = "SELECT AlbumId, Title FROM Album WHERE ArtistId = ?;";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Album> albumsFromArtist = new ArrayList<>();
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectAlbums);
			statement.setLong(1, artistId);
			results = statement.executeQuery();
			
			while (results.next()) {
				long id = results.getLong("AlbumId");
				String title = results.getString("Title");
				
				Album album = new Album(id, title);
				albumsFromArtist.add(album);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return albumsFromArtist;
	}

}
