package userInfo;


public interface UserInfoService {
	int create(String id, String pw, String name);
	int delete(String id);
}
