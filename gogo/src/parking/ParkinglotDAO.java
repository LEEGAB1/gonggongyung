package parking;

import java.sql.Connection;
import java.util.List;

public interface ParkinglotDAO {
	List<Parkinglot> parkinglotSelect(Connection conn);
	List<Parkinglot> parkinglotselectByStoreName(Connection conn, String storeName);
	int parkinglotUpdate(Connection conn, Parkinglot parkinglot);
	
}
