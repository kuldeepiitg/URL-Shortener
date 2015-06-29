package in.interview.google;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * Junit test for {@link Crawler}.
 * 
 * @author kuldeep
 */
public class CrawlerTest {

	@Test
	public void testNext() throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("urls.bkp"));
		Crawler crawler = new Crawler("https://www.google.co.in");
		long startTime = System.currentTimeMillis();
		while(crawler.hasNext() && (System.currentTimeMillis() - startTime) < 6*60*60*1000) {
			String url = crawler.next();
			bw.write(url + "\n");
		}
		
		bw.close();
	}
}
