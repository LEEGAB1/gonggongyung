package GasStation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


public class GasStationDAOImpl implements GasStationDAO {

	@Override
	public List<GasStation> gasStationSelect(Connection conn) {
		String sql = "SELECT * FROM gas_station";
		
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
	public List<GasStation> gasStationSelectByRegion(Connection conn, String region) {
		String sql = "SELECT * FROM gas_station WHERE region = ?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, region);
			
			try(ResultSet rs = stmt.executeQuery()) {
				List<GasStation> list = new ArrayList<>();
				while(rs.next()) {
					list.add(resultMapping(rs));
				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("주유소 지역별 선별조회 작업 중 예외 발생", e);
		}
	}
	
	@Override
	public List<GasStation> gasStationSelectByStoreName(Connection conn, String storeName) {
		String sql = "SELECT * FROM gas_station WHERE storename LIKE ?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, "%" + storeName + "%");
			
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
	public Map<String, Integer> gasStationPrice(Connection conn, String region, String type) {
		String sql = "SELECT storename, dense_rank() over (order by " + type + " asc) "
				+ "as ranking FROM gas_station WHERE region = ?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, region);
			
			try(ResultSet rs = stmt.executeQuery()) {
				Map<String, Integer> map = new HashMap<>();
				while(rs.next()) {
					map.put(rs.getString(1), rs.getInt(2));
				}
				return map;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("주유소 가격조회 작업 중 예외 발생", e);
		}
	}

	@Override
	public int gasStationUpdate(Connection conn, GasStation gasstation, String region) {
		String sql = "UPDATE gas_station SET p_gasoline=?, gasoline=?, diesel =? WHERE storename=? and region=?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setString(1, gasstation.getP_gasoline());
			stmt.setString(2, gasstation.getGasoline());
			stmt.setString(3, gasstation.getDiesel());
			stmt.setString(4, gasstation.getStorename());
			stmt.setNString(5, region);
			
			return stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("주유소 수정 작업 중 예외 발생", e);
		}
	}
	
	@Override
	public int gasStationInsert(Connection conn, GasStation gasstation) {
		String sql = "INSERT INTO gas_station "
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
		gasstation.setRegion(rs.getString("region"));
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


	@Override
	public int gasHistoryInsert(Connection conn) { // 복사해서 history에 넣기 
		String sql = "INSERT INTO gas_history (storename, storeaddress,p_gasoline, gasoline, diesel,`date` ) SELECT storename, storeaddress,p_gasoline, gasoline ,diesel, ?  FROM gas_station";
		LocalDate now = LocalDate.now();
		String toDay = String.valueOf(now);
	   
	      
	     
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1,toDay );
			
			
			return stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("주유소 넣기 작업 중 예외 발생", e);
		}
		
	  
		
		
	}


	@Override
	public List<String> gasStationXY(Connection conn) {
		String sql = "SELECT X,Y FROM gas_station";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			
			
			try(ResultSet rs = stmt.executeQuery()) {
				List<String> list = new ArrayList();
				
				while(rs.next()) {
					 String X = rs.getString("X");
					 String Y = rs.getString("Y");
					 
					 list.add(X);
					 list.add(Y);
					 
					
				}
				System.out.println(list);
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("주유소 선별조회 작업 중 예외 발생", e);
		}
	}

	@Override
	public List<String> oneWeekPrice(Connection conn, String storeName, String type) {
		String sql = "SELECT date, " + type +" FROM gas_history where storename = ? ORDER BY date desc limit 7" ;
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setNString(1, storeName);
			
			try(ResultSet rs = stmt.executeQuery()) {
				List<String> list = new ArrayList<>();
				while(rs.next()) {
//					 String date = rs.getString("date");
					 String typeprice = rs.getString(type);

					 list.add(typeprice);
				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("주유소 선별조회 작업 중 예외 발생", e);
		}
	}

	@Override
	public List<GasStation> gasStationSelectByRegionAndZone(Connection conn, String region, String zone) {
	String sql = "SELECT * FROM gas_station WHERE region = ? AND zone = ?";
		
		try(PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, region);
			stmt.setString(2, zone);
			
			try(ResultSet rs = stmt.executeQuery()) {
				List<GasStation> list = new ArrayList<>();
				while(rs.next()) {
					list.add(resultMapping(rs));
				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("주유소 지역별 선별조회 작업 중 예외 발생", e);
		}
	}


		
	}



		
	




