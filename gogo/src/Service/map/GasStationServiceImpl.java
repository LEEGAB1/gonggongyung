package Service.map;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
	public List<GasStation> readGas() {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.gasStationSelect(conn);
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
	public List<GasStation> readGasByRegion(String region) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.gasStationSelectByRegion(conn, region);
		} catch(RuntimeException | SQLException e) {
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
	public List<GasStation> readGasByStorename(String storename) {
		Connection conn = null;
		try {
			conn= ConnectionProvider.getConnection();
			return dao.gasStationSelectByStoreName(conn, storename);
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
	public Map<String, Integer> readGasPrice(String region, String type) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.gasStationPrice(conn, region, type);
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
	public List<String> readOneWeekPrice(String storename, String type) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.oneWeekPrice(conn, storename, type);
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
	public GasStation updateGas(GasStation gasstation, String region) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			dao.gasStationUpdate(conn, gasstation, region);
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

	@Override
	public List<String> readGasXY() {
		Connection conn = null;
		try {
			conn= ConnectionProvider.getConnection();
			return dao.gasStationXY(conn);
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
	public List<GasStation> readGasByRegionAndZone(String region, String zone) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			return dao.gasStationSelectByRegionAndZone(conn, region, zone);
		} catch(RuntimeException | SQLException e) {
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







}
