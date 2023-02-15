package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import GasStation.GasStation;
import GasStation.GasStationDAO;
import GasStation.GasStationDAOImpl;
import parking.ParkingDAOImpl;
import parking.Parkinglot;
import parking.ParkinglotDAO;
import zerozerotwo.dbutil.ConnectionProvider;

public class test {
	private static GasStationDAO dao;
	private static ParkinglotDAO pdao;
	private static Connection conn;
	
	public static void main(String[] args) throws SQLException {
		conn = ConnectionProvider.getConnection();
		dao = new GasStationDAOImpl();
		pdao = new ParkingDAOImpl();
		
		String location = "buk_gu";
		List<GasStation> list = dao.gasStationSelect(conn, location);
		System.out.println(list);
		
//		List<Parkinglot> list = pdao.parkinglotSelect(conn);
//		System.out.println(list);
		
		
	}
}
