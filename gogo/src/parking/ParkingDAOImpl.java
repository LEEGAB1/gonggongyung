package parking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParkingDAOImpl  implements ParkinglotDAO {

	@Override
	public List<Parkinglot> parkinglotSelect(Connection conn) {
		String sql = "SELECT * FROM parkinglot";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			List<Parkinglot> list = new ArrayList<>();
			while (rs.next()) {
				list.add(resultMapping(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("주차장 총 조회 작업 중 예외 발생", e);
		}
	}

	@Override
	public List<Parkinglot> parkinglotselectByStoreName(Connection conn, String storeName) {
		String sql = "SELECT * FROM parkinglot WHERE storename LIKE ?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, "%"+ storeName +"%");
			
			try(ResultSet rs = stmt.executeQuery()) {
				List<Parkinglot> list = new ArrayList<>();
				while(rs.next()) {
					list.add(resultMapping(rs));
				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("주차장 선별조회 작업 중 예외 발생", e);
		}
	}

	@Override
	public int parkinglotUpdate(Connection conn, Parkinglot parkinglot) {
		String sql = "UPDATE parkinglot SET usenum=?, availablenum=? WHERE storename = ?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, parkinglot.getUsenum());
			stmt.setInt(2, parkinglot.getAvailablenum());
			stmt.setString(3, parkinglot.getStorename());
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("주차장 수정 작업 중 예외 발생", e);
		}
	}

	private Parkinglot resultMapping(ResultSet rs) throws SQLException{
		Parkinglot parkinglot = new Parkinglot();
		parkinglot.setStorename(rs.getString("storename"));
		parkinglot.setStoreaddress(rs.getString("storeaddress"));
		parkinglot.setTotalnum(rs.getInt("totalnum"));
		parkinglot.setUsenum(rs.getInt("usenum"));
		parkinglot.setAvailablenum(rs.getInt("availablenum"));
		parkinglot.setTenprice(rs.getInt("tenprice"));
		parkinglot.setDayprice(rs.getInt("dayprice"));
		parkinglot.setX(rs.getString("X"));
		parkinglot.setY(rs.getString("Y"));
		
		return parkinglot;
	}

	
}
