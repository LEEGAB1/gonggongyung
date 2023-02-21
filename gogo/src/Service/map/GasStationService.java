package Service.map;

import java.util.List;
import GasStation.GasStation;

public interface GasStationService {
	//read,update,create(리뷰)
	//주차장
	List<GasStation> readGas();
	List<GasStation> readGasByRegion(String region);
	List<GasStation> readGasByStorename(String storename);
	GasStation updateGas(GasStation gasstation, String region);
	List<String> readGasXY();
	

}
