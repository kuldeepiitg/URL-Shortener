package in.interview.google;

import java.io.IOException;

import org.junit.Test;

public class DownloaderTest {

	@Test
	public void testDownload() throws IOException {
		
		Downloader.download("https://en.wikipedia.org/wiki/World_War_II");
	}

}
