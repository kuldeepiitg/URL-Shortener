package in.interview.google;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * Junit test for {@link Downloader}.
 * 
 * @author kuldeep
 *
 */
public class DownloaderTest {

	@Test
	public void testDownload() {
		
		Downloader downloader = new Downloader();
		Iterator<String> itr = null;
		
		String regex = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		Pattern pattern = Pattern.compile(regex);
		
		LinkedList<String> list = new LinkedList<String>();
		list.add("https://en.wikipedia.org/wiki/Main_Page");
		list.add("https://www.google.co.in");
		int count = 1000;
		
		outerloop:
		while (!list.isEmpty()) {
			try {
				itr = downloader.download(list.poll());
			} catch (IOException e) {
				continue;
			}
			while (itr.hasNext()) {
				String line = itr.next();
				Matcher matcher = pattern.matcher(line);
				while (matcher.find()) {
					String url = matcher.group();
					System.out.println(count + "\t" + url);
					list.add(url);
					count--;
					if (count <= 0) {
						break outerloop;
					}
				}
			}
		}
	}

}
