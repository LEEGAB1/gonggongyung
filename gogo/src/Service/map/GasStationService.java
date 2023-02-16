package Service.map;

import java.util.List;
import GasStation.GasStation;

public interface GasStationService {
	//read,update,create(리뷰)
	//주차장
	List<GasStation> readGas(String location);
	List<GasStation> readGasByStorename(String loacation, String storename);
	GasStation updateGas(GasStation gasstation, String location);
	

}
