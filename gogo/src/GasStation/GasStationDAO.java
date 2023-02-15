package GasStation;

import java.sql.Connection;
import java.util.List;

public interface GasStationDAO {
	
	List<GasStation> gasStationSelect(Connection conn, String location);
	List<GasStation> gasStationSelectByStoreName(Connection conn, String storeName, String location);
	int gasStationUpdate(Connection conn, GasStation gasstation, String location);
	int gasStationInsert(Connection conn, GasStation gasstation, String location);

}
