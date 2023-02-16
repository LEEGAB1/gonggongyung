package Service.map;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import parking.Parkinglot;
import parking.ParkinglotDAO;
import zerozerotwo.dbutil.ConnectionProvider;

public class ParkinglotServiceImpl implements ParkinglotService{
	private ParkinglotDAO dao;
	
	public ParkinglotServiceImpl(ParkinglotDAO dao) {
		super();
		this.dao =dao;
	}

	@Override
	public List<Parkinglot> readPark() {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.parkinglotSelect(conn);
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
	public List<Parkinglot> readParkByStoreName(String storename) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.parkinglotselectByStoreName(conn, storename);
		} catch (RuntimeException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
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
	public Parkinglot updatePark(Parkinglot parkinglot) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			dao.parkinglotUpdate(conn, parkinglot);
			conn.commit();
			return parkinglot;
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
