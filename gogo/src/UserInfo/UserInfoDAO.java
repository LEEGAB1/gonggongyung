package UserInfo;

import java.sql.Connection;
import java.util.List;

public interface UserInfoDAO {
	int UserInfoSelectId(Connection conn, String id);
	int UserInfoSelectName(Connection conn, String name);
	int InsertUserInfo(Connection conn, String id, String pw, String name);
	UserInfo selectUserInfo(Connection conn, String id);
	int deleteUserInfo(Connection conn, String id);
	String selectUserNickName(Connection conn, String id);
}
