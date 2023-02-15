package zerozerotwo.dbutil;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionProvider {
	private static DataSource dataSource;

	static {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("jdbc:mysql://192.168.0.109/zerozerotwo");
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("user1");
		ds.setPassword("user1");
		//1
		
		dataSource = ds;
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}
