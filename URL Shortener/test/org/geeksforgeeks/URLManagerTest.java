package org.geeksforgeeks;

import static org.junit.Assert.*;
import in.interview.google.Crawler;

import org.junit.Test;

/**
 * Junit test for {@link URLManager}.
 * 
 * @author kuldeep
 */
public class URLManagerTest {

	@Test
	public void testGetShortURL() throws Exception {
		
		URLManager manager = new URLManager();
		Crawler crawler = new Crawler("https://www.google.co.in");
		for (int i = 0; i < 100; i++) {
			String url = crawler.next();
			assertEquals(url, manager.getURL(manager.getShortURL(url)));
		}
	}

}
