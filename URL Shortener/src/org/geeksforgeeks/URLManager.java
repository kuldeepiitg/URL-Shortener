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
	
	public URLManager() throws Exception {
		super();
		this.shortener = new URLShortener(new char[]{'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'});
		this.store = new URLStore();
	}

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
