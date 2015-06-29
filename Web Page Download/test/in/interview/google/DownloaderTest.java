package in.interview.google;

import java.io.IOException;
import java.util.Iterator;

import org.junit.Test;

/**
 * Junit test for {@link Downloader}.
 * 
 * @author kuldeep
 *
 */
public class DownloaderTest {

	@Test
	public void testDownload() throws IOException {
		
		Downloader downloader = new Downloader();
		Iterator<String> itr = downloader.download("https://en.wikipedia.org/wiki/Main_Page");
		while (itr.hasNext()) {
			String string = itr.next();
			System.out.println(string);
		}
	}

}
