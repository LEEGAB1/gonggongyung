package UserInfo;

public class LoginUer {
	String id;
	String password;
	String nickName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	@Override
	public String toString() {
		return "LoginUer [id=" + id + ", password=" + password + ", nickName=" + nickName + "]";
	}
	
	
	

}
