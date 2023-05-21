package model;

public class Album {
	
	private long albumId;
	private String albumTitle;
	
	public Album(long albumId, String albumTitle) {
		this.albumId = albumId;
		this.albumTitle = albumTitle;
	}
	
	public String getAlbumTitle() {
		return albumTitle;
	}
	
	public long getAlbumId() {
		return albumId;
	}

}
