package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import GasStation.GasStation;
import GasStation.GasStationDAO;
import GasStation.GasStationDAOImpl;
import Service.map.GasStationServiceImpl;
import Service.map.ParkinglotServiceImpl;
import Service.review.reviewServiceImpl;
import parking.Crollotcrol;
import parking.ParkingDAOImpl;
import parking.Parkinglot;
import parking.ParkinglotDAO;
import review.ReviewDAOImpl;
import zerozerotwo.dbutil.ConnectionProvider;

public class test {
	private static GasStationDAO dao;
	private static ParkinglotDAO pdao;
	private static Connection conn;
	
	public static void main(String[] args) throws SQLException {
		
		conn = ConnectionProvider.getConnection();
		dao = new GasStationDAOImpl();
		pdao = new ParkingDAOImpl();
		
//		GasStationServiceImpl gservice = new GasStationServiceImpl(new GasStationDAOImpl());
//		ParkinglotServiceImpl pservice = new ParkinglotServiceImpl(new ParkingDAOImpl());
//		reviewServiceImpl rservice = new reviewServiceImpl(new ReviewDAOImpl());
		GasStationDAOImpl gas = new GasStationDAOImpl ();
		gas.gasHistoryInsert(conn);
		
//		System.out.println(service.readGas("buk_gu"));
//		System.out.println(gservice.readGasByStorename("buk_gu","경덕주유소"));
//		System.out.println(pservice.readPark());
//		System.out.println(pservice.readParkByStoreName("구서역"));
		
		
		
//		String location = "buk_gu";
//		String storeName = "경덕주유소";
//		List<GasStation> list = dao.gasStationSelectByStoreName(conn, storeName, location);
//		System.out.println(list);
//		
//		String storeName = "구서역";
//		List<Parkinglot> list = pdao.parkinglotSelect(conn);
//		List<Parkinglot> list = pdao.parkinglotselectByStoreName(conn, storeName);
//		System.out.println(list);
		
		
	}
}
