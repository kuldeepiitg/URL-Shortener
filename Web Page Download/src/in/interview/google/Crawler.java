package in.interview.google;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Crawler to iterate over URLs.
 * 
 * @author kuldeep
 */
public class Crawler implements Iterator<String>{

	/**
	 * List of URLs to fetch HTML contents from web.
	 */
	private LinkedList<String> urlsToFetch;
	
	/**
	 * Set of unique urls.
	 */
	private HashSet<String> uniqueURLs;
	
	/**
	 * Pattern to match URL
	 */
	private Pattern pattern;
	
	/**
	 * Logger to pin down important points
	 */
	private Logger logger;
	
	public Crawler(String seedURL) {
		super();
		this.urlsToFetch = new LinkedList<String>();
		this.urlsToFetch.add(seedURL);
		this.uniqueURLs = new HashSet<String>(urlsToFetch);
		String urlRegex = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		this.pattern = Pattern.compile(urlRegex);
		this.logger = LoggerFactory.getLogger(getClass());
	}

	@Override
	public boolean hasNext() {
		return !urlsToFetch.isEmpty();
	}

	@Override
	public String next() {
		String nextURL = urlsToFetch.poll();
		urlsToFetch.addAll(extractURLs(nextURL));
		return nextURL;
	}
	
	/**
	 * @param url
	 * 		url of the HTML page
	 * @return list of all urls present in page
	 */
	@SuppressWarnings("finally")
	private List<String> extractURLs(String url) {
		List<String> urls = new LinkedList<String>();
		Downloader downloader = new Downloader();
		try {
			Iterator<String> lineIterator = downloader.download(url);
			while (lineIterator.hasNext()) {
				String nextLine = lineIterator.next();
				Matcher matcher = pattern.matcher(nextLine);
				while(matcher.find()) {
					String newURL = matcher.group();
					if (!uniqueURLs.contains(newURL)) {
						urls.add(newURL);
						uniqueURLs.add(newURL);
					}
				}
			}
		} catch (IOException e) {
			logger.debug("Couldn't get page from web to parse");
			e.printStackTrace();
		} finally {
			return urls;
		}
	}

}
