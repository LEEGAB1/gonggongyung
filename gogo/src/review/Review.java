package review;

public class Review {
	private int pk;
	private String storename;
	private String nickname;
	private String grade;
	private String userreview;

	public Review() {
		super();
	}

	public Review(int pk, String storename, String nickname, String grade, String userreview) {
		super();
		this.pk = pk;
		this.storename = storename;
		this.nickname = nickname;
		this.grade = grade;
		this.userreview = userreview;
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getUserreview() {
		return userreview;
	}

	public void setUserreview(String userreview) {
		this.userreview = userreview;
	}

	@Override
	public String toString() {
		return "review [pk=" + pk + ", storename=" + storename + ", nickname=" + nickname + ", grade=" + grade
				+ ", userreview=" + userreview + "]";
	}
	
	
}
