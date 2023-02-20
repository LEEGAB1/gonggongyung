package GasStation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface GasStationDAO {
	
	List<GasStation> gasStationSelect(Connection conn);
	List<GasStation> gasStationSelectByStoreName(Connection conn, String storeName);
	List<String> gasStationXY(Connection conn);
	int gasStationUpdate(Connection conn, GasStation gasstation);
	int gasStationInsert(Connection conn, GasStation gasstation);
	int gasHistoryInsert(Connection conn);

}
