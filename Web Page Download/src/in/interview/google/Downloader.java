package in.interview.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 
 * 
 * @author kuldeep
 */
public class Downloader {

	public static void download(String url) throws IOException {
		
		InputStream inputStream = new URL(url).openStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
		}
		
	}
}
