package GasStation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GasStationDAOImpl implements GasStationDAO{

	@Override
	public List<GasStation> gasStationSelect(Connection conn, String location) {
		String sql = "SELECT * FROM " + location +"_gas_station";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			
			List<GasStation> list = new ArrayList<>();
			while (rs.next()) {
				list.add(resultMapping(rs));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("주유소 총 조회 작업 중 예외 발생", e);
		}
	}


	@Override
	public List<GasStation> gasStationSelectByStoreName(Connection conn, String storeName, String location) {
		String sql = "SELECT * FROM " + location + "_gas_station WHERE storename LIKE '%?%'";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, storeName);
			
			try(ResultSet rs = stmt.executeQuery()) {
				List<GasStation> list = new ArrayList<>();
				while(rs.next()) {
					list.add(resultMapping(rs));
				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("주유소 선별조회 작업 중 예외 발생", e);
		}
	}

	@Override
	public int gasStationUpdate(Connection conn, GasStation gasstation, String location) {
		String sql = "UPDATE " + location + "_gas_station SET p_gasoline=?, gasoline=?, diesel =?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, gasstation.getP_gasoline());
			stmt.setString(2, gasstation.getGasoline());
			stmt.setString(3, gasstation.getDiesel());
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("주유소 수정 작업 중 예외 발생", e);
		}
	}
	
	@Override
	public int gasStationInsert(Connection conn, GasStation gasstation, String location) {
		String sql = "INSERT INTO " + location + "_gas_station "
				+ "(storename, storeaddress, storenumber, storebrand, self, p_gasoline, gasoline, diesel) "
				+ "values (?,?,?,?,?,?,?,?)";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, gasstation.getStorename());
			stmt.setString(2, gasstation.getStoreaddress());
			stmt.setString(3, gasstation.getStorenumber());
			stmt.setString(4, gasstation.getStorebrand());
			stmt.setString(5, gasstation.getSelf());
			stmt.setString(6, gasstation.getP_gasoline());
			stmt.setString(7, gasstation.getGasoline());
			stmt.setString(8, gasstation.getDiesel());
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("주유소 넣기 작업 중 예외 발생", e);
		}
	}

	
	private GasStation resultMapping(ResultSet rs) throws SQLException{
		GasStation gasstation = new GasStation();
		gasstation.setStorename(rs.getString("storename"));
		gasstation.setStoreaddress(rs.getString("storeaddress"));
		gasstation.setStorebrand(rs.getString("storebrand"));
		gasstation.setStorenumber(rs.getString("storenumber"));
		gasstation.setSelf(rs.getString("self"));
		gasstation.setP_gasoline(rs.getString("p_gasoline"));
		gasstation.setGasoline(rs.getString("gasoline"));
		gasstation.setDiesel(rs.getString("diesel"));
		gasstation.setX(rs.getString("X"));
		gasstation.setY(rs.getString("Y"));
		
		return gasstation;
		
	}



}
