package userInfo;

import java.sql.Connection;
import java.util.List;

public interface UserInfoDAO {
	int UserInfoSelectId(Connection conn, String id);
	int UserInfoSelectName(Connection conn, String name);
	int InsertUserInfo(Connection conn, String id, String pw, String name);
	List<userInfo> selectUserInfo(Connection conn, String id);
	int deleteUserInfo(Connection conn, String id);
}
