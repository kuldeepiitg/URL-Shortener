package org.geeksforgeeks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Store of URLs in database.
 * 
 * @author kuldeep
 */
public class URLStore {

	/**
	 * Connection to mysql server.
	 */
	private Connection connection;
	
	public URLStore() throws Exception {
		super();
		Class.forName("com.mysql.jdbc.Driver");
		this.connection = DriverManager.getConnection("jdbc:mysql://localhost/URLDB?"
	              + "user=kuldeep&password=kuldeep123");
	}

	/**
	 * Add url to database.
	 * 
	 * @param url
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	private void add(String url) throws ClassNotFoundException, Exception{
		
		PreparedStatement statement = connection.prepareStatement("INSERT INTO URLTable(url) values (?)");
		statement.setString(1, url);
		statement.execute();
	}
	
	/**
	 * @param url
	 * @return	get id for url
	 * @throws Exception
	 */
	public int getId(String url) throws Exception {
		
		int urlInstancesCount = getCount(url);
		if (urlInstancesCount == 0) {
			add(url);
		} else if (urlInstancesCount > 1) {
			throw new RuntimeException("More than one instance of " + url + " exists in database. Inconsitant.");
		}
		
		PreparedStatement statement = connection.prepareStatement("SELECT id from URLTable where url=(?)");
		statement.setString(1, url);
		ResultSet resultSet = statement.executeQuery();
		resultSet.first();
		return resultSet.getInt(1);
	}
	
	/**
	 * @param id
	 * @return	url for given id
	 * @throws Exception
	 */
	public String getURL(int id) throws Exception {
		int urlInstancesCount = getCount(id);
		if (urlInstancesCount == 0) {
			return null;
		} else if (urlInstancesCount > 1) {
			throw new RuntimeException("More than one instance of url exists in database. Inconsitant state.");
		}
		
		PreparedStatement statement = connection.prepareStatement("SELECT url from URLTable where id=(?)");
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		resultSet.first();
		return resultSet.getString(1);
	}
	
	/**
	 * @param id
	 * @return count of instances of url with given id
	 * @throws Exception
	 */
	private int getCount(int id) throws Exception {
		
		PreparedStatement statement = connection.prepareStatement("SELECT count(*) from URLTable where id=(?)");
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		resultSet.first();
		return resultSet.getInt(1);
	}
	
	/**
	 * @param url
	 * @return	count of instances of url present
	 * @throws Exception
	 */
	private int getCount(String url) throws Exception {
		
		PreparedStatement statement = connection.prepareStatement("SELECT count(*) from URLTable where url=(?)");
		statement.setString(1, url);
		ResultSet resultSet = statement.executeQuery();
		resultSet.first();
		return resultSet.getInt(1);
	}
	
}
