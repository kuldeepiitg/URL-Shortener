package in.interview.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;

/**
 * Download related utilities for web crawler.
 * 
 * @author kuldeep
 */
public class Downloader {

	/**
	 * @param url
	 * 			url of a web page to download
	 * @return {@link Iterator} over lines in file.
	 * @throws IOException
	 */
	public Iterator<String> download(String url) throws IOException {
		
		InputStream inputStream = new URL(url).openStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		
		return new LineIterator<String>(bufferedReader);
	}
	
	/**
	 * Iterator over lines in {@link BufferedReader}.
	 * 
	 * @author kuldeep
	 *
	 * @param <String>
	 */
	@SuppressWarnings("hiding")
	private class LineIterator<String> implements Iterator<String> {

		/**
		 * Look ahead string.
		 */
		private String lookAhead;
		
		/**
		 * Buffered reader to get strings.
		 */
		private BufferedReader reader;
		
		public LineIterator(BufferedReader reader) throws IOException {
			this.reader = reader;
			loadLookAhead();
		}
		
		/**
		 * Load next string.
		 * 
		 * @throws IOException
		 */
		@SuppressWarnings("unchecked")
		private void loadLookAhead() throws IOException {
			this.lookAhead = (String) reader.readLine();
		}
		
		@Override
		public boolean hasNext() {
			return lookAhead != null;
		}

		@Override
		public String next() {
			String toReturn = lookAhead;
			try {
				loadLookAhead();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return toReturn;
		}
		
	}
}
