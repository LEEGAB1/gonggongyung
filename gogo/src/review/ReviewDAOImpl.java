package review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImpl implements ReviewDAO{

	@Override
	public List<Review> reviewSelect(Connection conn) {
		String sql ="SELECT * FROM review";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			List<Review> list = new ArrayList<>();
			while(rs.next()) {
				list.add(resultMapping(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("리뷰 총 조회 작업 중 예외 발생", e);
		}
	}

	@Override
	public List<Review> reviewSelectByStoreName(Connection conn, String storeName) {
		String sql = "SELECT * FROM review WHERE storeName LIKE ?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, "%" + storeName + "%");
			
			try(ResultSet rs = stmt.executeQuery()) {
				List<Review> list = new ArrayList<>();
				while(rs.next()) {
					list.add(resultMapping(rs));
				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("리뷰 주차장이름 조회 작업 중 예외 발생", e);
		}
	}

	@Override
	public List<Review> reviewSelectBynickname(Connection conn, String nickname) {
		String sql ="SELECT * FROM review WHERE nickname LIKE ?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, "%" + nickname + "%");
			
			try(ResultSet rs = stmt.executeQuery()) {
				List<Review> list = new ArrayList<>();
				while(rs.next()) {
					list.add(resultMapping(rs));
				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("리뷰 닉네임 조회 작업 중 예외 발생", e);
		}
	}

	@Override
	public int reviewdelete(Connection conn, int pk) {
		String sql = "DELETE FROM review WHERE pk = ?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, pk);
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("리뷰 삭제 작업 중 예외 발생", e);
		}
	}

	@Override
	public int reviewInsert(Connection conn, Review review) {
		String sql = "INSERT INTO review (storename, nickname, grade, userreview) values (?,?,?,?)";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
			stmt.setString(1, review.getStorename());
			stmt.setString(2, review.getNickname());
			stmt.setString(3, review.getGrade());
			stmt.setString(4, review.getUserreview());
			
			int result = stmt.executeUpdate();
			if(result == 1) {
				try(ResultSet rs = stmt.getGeneratedKeys()) {
					rs.next();
					return rs.getInt(1);
				}
			} else {
				throw new RuntimeException("행이 생성되지 않았습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("리뷰 추가 작업 중 예외 발생", e);
		}
	}

	private Review resultMapping(ResultSet rs) throws SQLException {
		Review review = new Review();
		review.setPk(rs.getInt("pk"));
		review.setStorename(rs.getString("storename"));
		review.setNickname(rs.getString("nickname"));
		review.setGrade(rs.getString("grade"));
		review.setUserreview(rs.getString("userreview"));
		
		return review;
	}

	@Override
	public Review reviewSelectByPk(Connection conn, int pk) {
		String sql = "SELECT * FROM review WHERE pk=?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, pk);
			
			try (ResultSet rs = stmt.executeQuery()){
				if(rs.next()) {
					return resultMapping(rs);
				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("리뷰 pk조회 작업중 예외 발생", e);
		}
		return null;
	}

}
