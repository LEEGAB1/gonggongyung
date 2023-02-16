package Service.map;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import GasStation.GasStation;
import GasStation.GasStationDAO;
import zerozerotwo.dbutil.ConnectionProvider;

public class GasStationServiceImpl implements GasStationService{
	private GasStationDAO dao;
	
	public GasStationServiceImpl(GasStationDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<GasStation> readGas(String location) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.gasStationSelect(conn, location);
		} catch (RuntimeException | SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public GasStation updateGas(GasStation gasstation, String location) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			dao.gasStationUpdate(conn, gasstation, location);
			conn.commit();
			return gasstation;
		} catch (RuntimeException | SQLException e) {
			if(conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
