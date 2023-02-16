package Service.map;

import java.util.List;
import GasStation.GasStation;

public interface GasStationService {
	//read,update,create(리뷰)
	//주차장
	List<GasStation> readGas(String location);
	GasStation updateGas(GasStation gasstation, String location);
	

}
