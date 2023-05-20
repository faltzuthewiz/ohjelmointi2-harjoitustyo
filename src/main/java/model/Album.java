package model;

public class Album {
	
	private long albumId;
	private String albumTitle;
	private Artist artistId;
	
	public Album(long albumId, String albumTitle, Artist artistId) {
		this.albumId = albumId;
		this.albumTitle = albumTitle;
		this.artistId = artistId;
	}
	
	public String getAlbumTitle() {
		return albumTitle;
	}
	
	public long getAlbumId() {
		return albumId;
	}

}
