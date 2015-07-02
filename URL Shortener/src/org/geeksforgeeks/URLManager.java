package org.geeksforgeeks;

/**
 * The URL manager.
 * 
 * @author kuldeep
 */
public class URLManager {

	/**
	 * URL shortener and retriever
	 */
	private URLShortener shortener;
	
	/**
	 * Store to save URLs and id
	 */
	private URLStore store;
	
	/**
	 * @param url
	 * 			original URL
	 * @return	short url for given URL
	 * @throws Exception
	 */
	public String getShortURL(String url) throws Exception {
		
		int id = store.getId(url);
		String shortURL = shortener.shorten(id);
		return shortURL;
	}
	
	/**
	 * @param shortURL
	 * 			short representation url
	 * @return	original url
	 * @throws Exception
	 */
	public String getURL(String shortURL) throws Exception {
		
		int id = shortener.elongate(shortURL);
		return store.getURL(id);
	}
	
}
