package UserInfo;


public interface UserInfoService {
	int create(String id, String pw, String name);
	int idCheck(String id);
	int nameCheck(String name);
	UserInfo read(String id);
	int delete(String id);
	String selectNickname(String id);
}
