package in.kuldeepyadav.webservices;

import java.net.URI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.geeksforgeeks.URLManager;

/**
 * UI shortener webservices.
 * 
 * @author kuldeep
 */
@Path("/shortener")
public class ShortenerService {

	private URLManager manager;
	
	public ShortenerService() throws Exception {
		this.manager = new URLManager();
	}

	/**
	 * @param url
	 * @return short url for given full url
	 * @throws Exception
	 */
	@GET
	@Path("/shorten")
	public String getShortURL(@QueryParam("url") String url) throws Exception{
		return manager.getShortURL(url);
	}
	
	/**
	 * @param shortURL
	 * @return original url for given short url
	 * @throws Exception
	 */
	@GET
	@Path("/expand")
	public Response getOriginalURL(@QueryParam("url") String shortURL) throws Exception{
		String url = manager.getURL(shortURL);
		return Response.temporaryRedirect(new URI(url)).build();
	}
}
