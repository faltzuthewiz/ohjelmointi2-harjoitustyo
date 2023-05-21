package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AlbumDao;
import database.ArtistDao;
import model.Album;
import model.Artist;

@WebServlet ("/albums")
public class AlbumServlet extends HttpServlet {
	
	private AlbumDao dao = new AlbumDao();
	private ArtistDao aDao = new ArtistDao();

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		long artistId = Integer.parseInt(req.getParameter("ArtistId"));
		
		Artist artist = this.aDao.getArtist(artistId);
		
		List<Album> albums = this.dao.getAllAlbumsFromArtist(artistId);
		
		
		req.setAttribute("albums", albums);
		req.setAttribute("artistname", artist);
		req.getRequestDispatcher("/WEB-INF/albums.jsp").forward(req, resp);
		
	}
}
