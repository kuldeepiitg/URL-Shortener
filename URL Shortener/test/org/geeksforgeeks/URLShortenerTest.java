package org.geeksforgeeks;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit test for {@link URLShortener}.
 * 
 * @author kuldeep
 */
public class URLShortenerTest {

	@Test
	public void testShorten() {
	
		URLShortener urlShortener = new URLShortener(new char[]{'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F'});
		String shortURL = urlShortener.shorten(99999);
		assertEquals(Integer.toHexString(99999).toUpperCase(), shortURL);
		int id = urlShortener.elongate(shortURL);
		assertEquals(99999, id);
		
		urlShortener = new URLShortener(new char[]{'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'});
		shortURL = urlShortener.shorten(99999);
		assertEquals("255R", shortURL);
		id = urlShortener.elongate(shortURL);
		assertEquals(99999, id);
		
		urlShortener = new URLShortener(new char[]{'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'});
		shortURL = urlShortener.shorten(99999);
		assertEquals("Q0t", shortURL);
		id = urlShortener.elongate(shortURL);
		assertEquals(99999, id);
	}

}
