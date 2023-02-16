package userInfo;

import java.util.List;

public interface UserInfoService {
	int create(String id, String pw, String name);
	int idCheck(String id);
	int nameCheck(String name);
	List<userInfo> read(String id);
	int delete(String id);
}
