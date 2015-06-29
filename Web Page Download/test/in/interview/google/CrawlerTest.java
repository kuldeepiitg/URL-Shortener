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
		int count = 0;
		while(crawler.hasNext() && (System.currentTimeMillis() - startTime) < 6*60*60*1000) {
			String url = crawler.next();
			bw.write(url + "\n");
			if (count % 1000 == 0) {
				bw.flush();
			}
		}
		
		bw.close();
	}
}
