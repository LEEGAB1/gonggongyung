package GasStation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface GasStationDAO {
	
	List<GasStation> gasStationSelect(Connection conn);
	List<GasStation> gasStationSelectByRegion(Connection conn, String region);
	List<GasStation> gasStationSelectByRegionAndZone(Connection conn, String region, String zone );
	List<GasStation> gasStationSelectByStoreName(Connection conn, String storeName);
	Map<String, Integer> gasStationPrice(Connection conn, String region, String type);
	List<String> gasStationXY(Connection conn);
	int gasStationUpdate(Connection conn, GasStation gasstation, String region);
	int gasStationInsert(Connection conn, GasStation gasstation);
	int gasHistoryInsert(Connection conn);

	List<String> oneWeekPrice(Connection conn, String storeName, String type);

}
