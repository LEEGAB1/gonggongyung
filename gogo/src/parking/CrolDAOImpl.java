package parking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CrolDAOImpl implements CrolDAO {

	@Override
	public List<Crollotcrol> crol(Connection conn, List<String> list) {
		String sql = "UPDATE `zerozerotwo`.`parkinglot` SET `usenum` = ?, `availablenum` = ? WHERE (`storename` = ?)";
		
		
		try (PreparedStatement stmt = conn.prepareStatement(sql);
			) {
			for (int i = 0; i < list.size(); i+=4) {
				String a = String.valueOf(list.get(i));
				String B = String.valueOf(list.get(i+1));
				int b= Integer.valueOf(B);
				String C = String.valueOf(list.get(i+2));
				int c= Integer.valueOf(C);
				String D = String.valueOf(list.get(i+3));
				int d= Integer.valueOf(D);
				
				stmt.setInt(1,c);
				stmt.setInt(2,d);
				stmt.setString(3,a);
				
				stmt.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}