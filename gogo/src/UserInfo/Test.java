package UserInfo;

import java.sql.Connection;
import java.sql.SQLException;

import zerozerotwo.dbutil.ConnectionProvider;

public class Test {
	private static Connection conn;
	private static UserInfoDAO dao;
	private static UserInfoServiceImpl service;
	private static LogInDAO lDao;
	public static void main(String[] args) throws SQLException {
		dao = new UserInfoDAOImpl();
		service = new UserInfoServiceImpl(dao);
		lDao = new LogInDAOImpl();
		
		conn = ConnectionProvider.getConnection();
		System.out.println(lDao.inputSelect("jinju", "jinju"));
//		System.out.println(dao.UserInfoSelectId(conn, "jinj"));
		
//		System.out.println(dao.deleteUserInfo(conn, "asd"));
//		System.out.println(dao.selectUserInfo(conn, "jinju"));
//		System.out.println(dao.InsertUserInfo(conn, "chlhg1234", "123", "456456"));
		
		
		
	}
}
