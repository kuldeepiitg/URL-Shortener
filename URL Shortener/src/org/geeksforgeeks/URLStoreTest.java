package org.geeksforgeeks;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Junit test for {@link URLStore}.
 * 
 * @author kuldeep
 */
public class URLStoreTest {

	@Test
	public void testAdd() throws Exception {
		
		URLStore store = new URLStore();
		String url = "www.google.com";
		assertEquals(url, store.getURL(store.getId(url)));
	}

}
