package services;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;


public class DBPool {

	public final static String url = "jdbc:mysql://localhost:3306/shs_online_library";
	public final static String username = "root";
	public final static String password = "root";
	public final static String driver = "com.mysql.jdbc.Driver";
	
	//an instance of itself
	private static DBPool dbpool;
	private static BasicDataSource basicDataSource;
	//private Constructor
	private DBPool(){
		//we want to initialize the driver which will connect to db
		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
	}
	
	//method getInstance
	public static DBPool getInstance(){
		if(dbpool == null)
			dbpool = new DBPool();
		return dbpool;
	}
	
	public Connection getConnection(){
		try {
			return basicDataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
