package Service.map;

import java.util.List;
import parking.Parkinglot;

public interface ParkinglotService {
	//주유소
	List<Parkinglot> readPark();
	List<Parkinglot> readParkByStoreName(String storename);
	Parkinglot updatePark(Parkinglot parkinglot);
}
