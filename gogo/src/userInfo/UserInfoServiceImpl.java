package userInfo;

import java.sql.Connection;
import java.sql.SQLException;

import zerozerotwo.dbutil.ConnectionProvider;

public class UserInfoServiceImpl implements UserInfoService{
	private UserInfoDAO dao;
	
	public UserInfoServiceImpl(UserInfoDAO dao) {
		this.dao = dao;
	}

	@Override
	public int create(String id, String pw, String name) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			int userId = dao.InsertUserInfo(conn, id, pw, name);
			conn.commit();
			
			return userId;
		} catch (RuntimeException | SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}


	@Override
	public int delete(String id) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			int userId = dao.UserInfoSelectId(conn, id);
			if (userId != 0) {
				dao.deleteUserInfo(conn, id);
			}
			conn.commit();
			
			return 1;
		} catch (RuntimeException | SQLException e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return 0;
	}

}
