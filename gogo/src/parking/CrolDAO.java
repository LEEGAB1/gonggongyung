package parking;


import java.sql.Connection;
import java.util.List;

public interface CrolDAO {
	

	List<Crollotcrol> crol(Connection conn, List<String> list);
	
}
