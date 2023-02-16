package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import GasStation.GasStation;
import GasStation.GasStationDAO;
import GasStation.GasStationDAOImpl;
import Service.map.GasStationServiceImpl;
import parking.Crollotcrol;
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
		
		GasStationServiceImpl service = new GasStationServiceImpl(new GasStationDAOImpl());
		
//		System.out.println(service.readGas("buk_gu"));
//		System.out.println(service.readGasByStorename("buk_gu","경덕주유소"));
		
		
		
		
//		String location = "buk_gu";
//		String storeName = "경덕주유소";
//		List<GasStation> list = dao.gasStationSelectByStoreName(conn, storeName, location);
//		System.out.println(list);
//		
		String storeName = "구서역";
//		List<Parkinglot> list = pdao.parkinglotSelect(conn);
		List<Parkinglot> list = pdao.parkinglotselectByStoreName(conn, storeName);
		System.out.println(list);
		
		
	}
}
