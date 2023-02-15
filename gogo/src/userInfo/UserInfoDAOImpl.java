package userInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserInfoDAOImpl implements UserInfoDAO{

	// id있는지 조회
	@Override
	public int UserInfoSelectId(Connection conn, String id) {
		String sql = "select * from user_info where id = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, id);
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("DB id 조회중에 오류가 발생했습니다.", e);
		}
		
	}

	// 닉네임 있는지 조회
	@Override
	public int UserInfoSelectName(Connection conn, String name) {
		String sql = "select * from user_info where nickname = ?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, name);
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("DB nickname 조회중에 오류가 발생했습니다.", e);
		}
	}

	// 고객정보 등록
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
			throw new RuntimeException("userinfo 등록중에 오류가 발생했습니다.", e);
		}
	}

	// 고객정보 조회
	@Override
	public List<userInfo> selectUserInfo(Connection conn, String userId) {
		String sql = "SELECT * FROM user_info WHERE id = '" + userId +"'" ;
		List<userInfo> list = new ArrayList<>();
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
				ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String password = rs.getString("password");
				String name = rs.getString("nickname");
				
				list.add(new userInfo(id, password, name));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 고객정보 삭제 
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
	
	


}
