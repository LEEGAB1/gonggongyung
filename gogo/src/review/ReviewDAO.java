package review;

import java.sql.Connection;
import java.util.List;

public interface ReviewDAO {
	// 파라미터값 생각해보기
	List<Review> reviewSelect(Connection conn);
	List<Review> reviewSelectByStoreName(Connection conn, String storeName);
	List<Review> reviewSelectBynickname(Connection conn, String nickname);
	Review reviewSelectByPk(Connection conn, int pk);
	int reviewdelete(Connection conn, int pk);
	int reviewInsert(Connection conn, Review review);
	
}
