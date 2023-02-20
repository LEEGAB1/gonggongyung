package UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDAOImpl implements UserInfoDAO{

	// id�ִ��� ��ȸ
	@Override
	public int UserInfoSelectId(Connection conn, String id) {
		String sql = "select count(*) from user_info where id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return count;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return 0;
	}

	// �г��� �ִ��� ��ȸ
	@Override
	public int UserInfoSelectName(Connection conn, String name) {
		String sql = "select count(*) from user_info where nickname = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt(1);
				return count;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// ������ ���
	@Override
	public int InsertUserInfo(Connection conn, String id, String pw, String name) {
		String sql = "insert into user_info (id, password, nickname) " + "values(?, ?, ?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			stmt.setString(2, pw);
			stmt.setString(3, name);
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// ������ ��ȸ
	@Override
	public UserInfo selectUserInfo(Connection conn, String userId) {
		String sql = "SELECT * FROM user_info WHERE id = '" + userId +"'" ;
		UserInfo Userinfo = new UserInfo();
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Userinfo.setId(rs.getString("id"));
				Userinfo.setPassword(rs.getString("password"));
				Userinfo.setName(rs.getString("nickname"));				

				return Userinfo;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	// ������ ���� 
	@Override
	public int deleteUserInfo(Connection conn, String id) {
		String sql = "DELETE FROM user_info WHERE id = '" + id + "'";
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public String selectUserNickName(Connection conn, String id) {
		
		String sql = "SELECT nickname FROM user_info WHERE id = '" + id +"'" ;
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				
				 String userNickname = rs.getString("nickname");				

				return userNickname;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	


}
