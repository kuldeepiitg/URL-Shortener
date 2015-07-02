package org.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;


/**
 * URL Shortener.
 * 
 * @author kuldeep
 */
public class URLShortener {

	/**
	 * Set of characters to be used in short url
	 */
	private char[] charSet;
	
	/**
	 * Map of character to it's index in set
	 */
	private Map<Character, Integer> charMap;
	
	public URLShortener(char[] charSet) {
		super();
		this.charSet = charSet;
		this.charMap = new HashMap<Character, Integer>();
		for(int i = 0; i < charSet.length; i++) {
			charMap.put(charSet[i], i);
		}
	}

	/**
	 * @param id
	 * 		numerical id of a url.
	 * @return	short url for given url id
	 */
	public String shorten(int id) {
		String url = "";
		int charSetSize = charSet.length;
		while (id > 0) {
			int remainder = id%charSetSize;
			url = charSet[remainder] + url;
			id /= charSetSize;
		}
		
		return url;
	}
	
	/**
	 * @param shortURL
	 * 		short url
	 * @return	id of the short url
	 */
	public int elongate(String shortURL) {
		
		int charSetSize = charSet.length;
		char[] array = shortURL.toCharArray();
		int exponent = 0;
		int id = 0;
		for (int i = array.length - 1; i >= 0; i--, exponent++) {
			id += (charMap.get(array[i]) * Math.pow(charSetSize, exponent));
		}
		return id;
	}
}
