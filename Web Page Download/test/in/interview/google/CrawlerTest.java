package in.interview.google;

import org.junit.Test;

/**
 * Junit test for {@link Crawler}.
 * 
 * @author kuldeep
 */
public class CrawlerTest {

	@Test
	public void testNext() {
		
//		Crawler crawler = new Crawler("https://en.wikipedia.org/wiki/Main_Page");
		Crawler crawler = new Crawler("https://www.google.co.in");
		for (int i = 0; i < 1000 && crawler.hasNext(); i++) {
			System.out.println(crawler.next());
		}
	}
}
