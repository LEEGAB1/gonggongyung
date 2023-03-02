package Service.map;

import java.util.List;
import java.util.Map;

import GasStation.GasStation;

public interface GasStationService {
	//read,update,create(리뷰)
	//주차장
	List<GasStation> readGas();
	List<GasStation> readGasByRegion(String region);
	List<GasStation> readGasByRegionAndZone(String region, String zone);
	List<GasStation> readGasByStorename(String storename);
	Map<String, Integer> readGasPrice(String region, String type);
	List<String> readOneWeekPrice(String storename, String type);
	GasStation updateGas(GasStation gasstation, String region);
	List<String> readGasXY();
	

}
